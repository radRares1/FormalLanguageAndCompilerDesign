object Parser extends App{

  val identifiers = List("int")
  val constants = List("b")

  val input = List("int","b","=","2;");

  val identifierSt = SymbolTable(List.empty)
  val constantSt = SymbolTable(List.empty)


  /**
   * split the data into their respective ST if it's not a identifier or a constant throw an exception
   */
  input.foreach(e => {
    if(identifiers.contains(e)) {
      identifierSt.add(e)
    }
    else if(constants.contains(e)) {
      constantSt.add(e)
    }
    else
      throw new RuntimeException("Lexical error")
  })


}
