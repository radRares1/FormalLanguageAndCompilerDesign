import scala.collection.mutable.ListBuffer
import scala.io.Source

case class FiniteAutomata() {


  val Qstates:ListBuffer[String] = ListBuffer.empty
  val Ealphabet:ListBuffer[String] = ListBuffer.empty
  var InitState:String = ""
  val FinalStates:ListBuffer[String] = ListBuffer.empty
  val Transitions:ListBuffer[Tuple3[String,String,String]] = ListBuffer.empty

  def readAutomata(fileName:String):Unit = {

//    var rawInput:ListBuffer[String] = ListBuffer.empty
//
//    val bufferedSource = Source.fromFile("fileName")
//
//    for (line <- bufferedSource.getLines) {
//      rawInput += line
//    }
//    bufferedSource.close
      println("yes")
  }

  def printStates():Unit = {
    println("The States")
  }

  def printAlphabet():Unit = {
    println("Soup")
  }

  def printTransitions():Unit = {
    println("Transitions")
  }

  def printFinalStates():Unit = {
    println("Final States")
  }

  def verifyInput(str: String):Boolean ={
    true
  }


}
