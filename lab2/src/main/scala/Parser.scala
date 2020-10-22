import scala.collection.mutable.ListBuffer
import scala.io.Source

object Parser extends App{

  val identifiers = List("int")
  val constants = List("b")

  val reservedWords = List("number", "truth ", "array ", "if", "else", "repeat", "read", "write", "is", "iterate")
  val operators = List("<", "<=", ">", " >=", "is", "isNot", "=", "+", "-", "*", "%", "/")
  val separators = List("(", ")", ",", ";"," ","\t","\n" , "{", "}")
  val input:ListBuffer[String] = ListBuffer.empty
  val st:SymbolTable = SymbolTable(ListBuffer.empty)
  val pif:ProgramInternalForm = ProgramInternalForm()


  val bufferedSource = Source.fromFile("p1.txt")
  for (line <- bufferedSource.getLines) {
    input += line

  }

  bufferedSource.close

  println(input)
//
//  val identifierSt = SymbolTable(ListBuffer.empty)
//  val constantSt = SymbolTable(ListBuffer.empty)
//
//
//  /**
//   * split the data into their respective ST if it's not a identifier or a constant throw an exception
//   */
//  input.foreach(e => {
//    if(identifiers.contains(e)) {
//      identifierSt.add(e)
//    }
//    else if(constants.contains(e)) {
//      constantSt.add(e)
//    }
//    else
//      throw new RuntimeException("Lexical error")
//  })


}
