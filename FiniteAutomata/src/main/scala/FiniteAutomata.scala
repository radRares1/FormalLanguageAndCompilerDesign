import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.util.control.Breaks._

case class FiniteAutomata() {


  var Qstates: ListBuffer[String] = ListBuffer.empty;
  var Ealphabet: ListBuffer[String] = ListBuffer.empty;
  var InitState: String = ""
  var FinalStates: ListBuffer[String] = ListBuffer.empty;
  var Transitions: ListBuffer[Tuple3[String, String, String]] = ListBuffer.empty;

  def readAutomata(fileName: String): Unit = {

    var rawInput: ListBuffer[String] = ListBuffer.empty

    val bufferedSource = Source.fromFile(fileName)

    for (line <- bufferedSource.getLines) {
      rawInput += line
    }
    bufferedSource.close
    Qstates = ListBuffer.from(rawInput.head.split(","))
    Ealphabet = ListBuffer.from(rawInput(1).split(","))
    InitState = rawInput(2)
    FinalStates = ListBuffer.from(rawInput(3).split(","))
    Transitions = ListBuffer.from(rawInput(4).split(";")
      .map(e => e.split(",").map(i => i.replace(")", "")).map(i => i.replace("(", "")))
      .map(i => Tuple3(i(0), i(1), i(2))))
    //    val a = rawInput(4).split(";").map(e => e.split(",").map(i => i.replace(")","")).map(i => i.replace("(","")).toList
    //      ).toList
    //    println(a)
  }

  def printInitState(): Unit = println(InitState)

  def printStates(): Unit = {
    println("The States:")
    println(Qstates.mkString(","))
  }

  def printAlphabet(): Unit = {
    println("Soup:")
    println(Ealphabet.mkString(","))
  }

  def printTransitions(): Unit = {
    println("Transitions:")
    println(Transitions.mkString(";"))
  }

  def printFinalStates(): Unit = {
    println("Final States:")
    println(FinalStates.mkString(","))
  }

  def verifySequence(sequence: String): Unit = {

    var currentState = InitState
    var isAccepted = true
    var nextState: Option[String] = Option.empty
    var i = 0
//    while (value <- sequence) {
//      println(value, currentState)
//      println(Transitions.filter(e => e._1 == currentState && e._2 == value.toString))
//      if (Ealphabet.contains(value.toString)) {
//        if (Transitions.exists(e => e._1 == currentState && e._2 == value.toString)) {
//          nextState = Option(Transitions.filter(e => e._1 == currentState && e._2 == value.toString).head._3)
//        }
//        currentState = nextState.getOrElse("false")
//      }
//      else
//        break
//
//    }
    while(i<sequence.length && isAccepted)
      {

        var value = sequence(i)
        println(s"we are at " + sequence.slice(i,sequence.length))
        println(s"current value: $value, current state: $currentState")

        if (Ealphabet.contains(value.toString)) {
          if (Transitions.exists(e => e._1 == currentState && e._2 == value.toString)) {
            nextState = Option(Transitions.filter(e => e._1 == currentState && e._2 == value.toString).head._3)
          }
          currentState = nextState.getOrElse("nowhere")
          println(s"we can go with value $value to state $currentState \n")
        }
        else
          isAccepted = false

        i+=1
      }


    println(s"Is sequence $sequence accepted? " + (isAccepted&&FinalStates.contains(nextState.getOrElse("false"))) + "\n")

  }

  def verifyAll(fileName: String): Unit = {
    var sequences: ListBuffer[String] = ListBuffer.empty

    val bufferedSource = Source.fromFile(fileName)

    for (line <- bufferedSource.getLines) {
      sequences += line
    }
    bufferedSource.close
    println("sequences to check are: " + sequences.mkString(", ") + "\n")

    for (sequence <- sequences) {
      try {
        println(s"Test for sequence $sequence: \n")
        verifySequence(sequence)
      }
      catch {
        case e: Exception => println(e.getMessage)
      }
    }

  }


}
