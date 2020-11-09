
object Automata extends App {

  val FA = new FiniteAutomata()
  FA.readAutomata("src/main/resources/input/FA.txt")
  //FA.verifyAll("src/main/resources/input/sequence.txt")



  while(true) {
    println("\n1.Print States\n2.Print Alphabet\n3.Print Transition\n5.Print Final States\n5.Print Inital State \n6.Verify all\n")
    var consoleInput = scala.io.StdIn.readInt()
    consoleInput match {
      case 1 => FA.printStates()
      case 2 => FA.printAlphabet()
      case 3 => FA.printTransitions()
      case 4 => FA.printFinalStates()
      case 5 => FA.printInitState()
      case 6 => FA.verifyAll("src/main/resources/input/sequence.txt")
      case _ => System.exit(0)
    }
  }
}
