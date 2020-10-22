import scala.collection.mutable.ListBuffer

case class Scanner(operators:List[String], separators:List[String], reservedWords:List[String]) {


  val st:SymbolTable = SymbolTable(ListBuffer.empty)
  val pif:ProgramInternalForm = ProgramInternalForm()



}
