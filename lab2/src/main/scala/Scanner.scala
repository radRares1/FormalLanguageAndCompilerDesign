import java.io.{BufferedWriter, File, FileWriter}

import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex

case class Scanner(operators:List[String], separators:List[String], reservedWords:List[String]) {


  val st:SymbolTable = SymbolTable(ListBuffer.empty)
  val pif:ProgramInternalForm = ProgramInternalForm()


  def isIdentifier(token: String): Boolean = {
    //enforces that the string begins with a letter and can have 0 or more letters/numbers
    new Regex("^[A-Za-z]*(?:_[A-Za-z0-9]+)*{1,256}$").matches(token)
  }

  def isConstant(token: String): Boolean = {

    //check if bool constant
    if(token == "false" || token == "true"){
      true
    }
    //check if number
      //schimba
    else if(new Regex("^\\d+$").matches(token)){
      true
    }
    //check if string between ""
    else if(new Regex("^\"[a-zA-Z0-9]{1,256}\"$").matches(token)){
      true
    }
    else{
    false
    }
  }


  //splits the string by the given regex and returns the list of tokens
  def getTokens(lineContent: String):List[String] = {
    //translates in select an empty character before each `delimiter` or after each `delimiter`.
    //got it from @stackoverflow not gonna lie
    lineContent.split("((?<=;)|(?=;))|" +
      "((?<=\\s)|(?=\\s))|" +
      "((?<=,)|(?=,))|" +
      "((?<=\\()|(?=\\())|((?<=\\))|(?=\\)))|" +
      "((?<=\\{)|(?=\\{))|((?<=\\})|(?=\\}))|" +
      "((?<=\\[)|(?=\\[))|((?<=\\])|(?=\\]))").toList
  }

  def readFile(lines:ListBuffer[String]):Unit =
  {
    //we zip with index in order to keep the line number
    //line is actually Tuple(lineContent,lineNumber)
    //for each line we get the content
    lines.zipWithIndex.foreach(line => {

      //println(line._1)

      //detect
      getTokens(line._1).foreach(token => {

        //classify and codify
        if(this.reservedWords.contains(token) || this.operators.contains(token) || this.separators.contains(token)){
          pif.add(token,0)
        }
        else if(isIdentifier(token)){

          val index = st.add(token)

          pif.add("1",index)

        }
        else if(isConstant(token)){

          val index = st.add(token)
          pif.add("0",index)
        }
        else
        {
          val lineNumber = line._2
          throw new RuntimeException(s"Lexical error at line $lineNumber")
        }
      })
    })

    printf("Lexically correct!")
  }


  def writeSymbolTable():Unit = {

      val file = new File("src/main/resources/output/ST.out")
      val bw = new BufferedWriter(new FileWriter(file))
      for (line <- st.table) {
        bw.write(line._1 + ", " + line._2 + "\n")
      }
      bw.close()

  }

  def writeProgramInternalForm():Unit = {

    val file = new File("src/main/resources/output/PIF.out")
    val bw = new BufferedWriter(new FileWriter(file))
    for (line <- pif.content) {
      bw.write(line._1 + ", " + line._2 + "\n")
    }
    bw.close()

  }

}
