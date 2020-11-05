
object Automata extends App {

  val FA = new FiniteAutomata()
  FA.readAutomata("exampleFileName")
  FA.verifyInput("secondFileName")


  while(true) {
    var consoleInput = scala.io.StdIn.readInt()
    consoleInput match {
      case 1 => FA.printStates()
      case 2 => FA.printAlphabet()
      case 3 => FA.printTransitions()
      case 4 => FA.printFinalStates()
      case _ => System.exit(0)
    }
  }
}
