import org.scalatest.funsuite.AnyFunSuite

import scala.collection.mutable.ListBuffer

class Test extends AnyFunSuite {

  test("test fold") {
    assert("test".map(e => e.toInt).sum == 448)
  }

  test("test size table") {
    val testTable = SymbolTable(ListBuffer.empty)
    testTable.add("BC")
    assert(testTable.getSize==1)
  }

  test("test add to table"){
    val testTable = SymbolTable(ListBuffer.empty)
    assert(testTable.add("AB")==131)
    testTable.add("BC")
    assert(testTable.add("AB")==131)
  }

  test("test get from table"){
    val testTable = SymbolTable(ListBuffer.empty)
    testTable.add("AB")
    assert(testTable.getValue(131) == "AB")
  }

  test("readfile"){
    val reservedWords = List("number", "truth ", "array ", "if", "else", "repeat", "read", "write", "is", "iterate")
    val operators = List("<", "<=", ">", " >=", "is", "isNot", "=", "+", "-", "*", "%", "/")
    val separators = List("(", ")", ",", ";"," ","\t","\n" , "{", "}")
    val scanner:Scanner = Scanner(operators,separators,reservedWords)
    scanner.readFile(ListBuffer("number",",","<","a","0","a1","1","\"a21\""))
  }

}
