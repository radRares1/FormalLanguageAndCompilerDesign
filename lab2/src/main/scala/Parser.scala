import scala.collection.mutable.ListBuffer
import scala.io.Source

object Parser extends App{

  val identifiers = List("int")
  val constants = List("b")

  val input:ListBuffer[String] = ListBuffer.empty
  val reservedWords = List("number", "truth ", "array ", "if", "else", "repeat", "read", "write", "is", "iterate")
  val operators = List("<", "<=", ">", " >=", "is", "isNot", "=", "+", "-", "*", "%", "/")
  val separators = List("(", ")", ",", ";"," ","\t","\n" , "{", "}","[","]")

  val bufferedSource = Source.fromFile("src/main/resources/input/p2.txt")
  for (line <- bufferedSource.getLines) {
    input += line

  }
  bufferedSource.close

  val scanner:Scanner = Scanner(operators,separators,reservedWords)
  scanner.readFile(input.filter(_ >= " "))

  scanner.writeSymbolTable()
  scanner.writeProgramInternalForm()
  
}
