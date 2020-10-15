
/**
 * needs to be changed completely, this is so bad I'm pretty sure it's not what we need to do but life is life
 * I initally wanted to make a hashtable but I do not understand exactly what the hashtable should contain
 * gotta look into it
 * @param table
 */
case class SymbolTable(table:List[String]) {

  def getSize:Integer ={
    table.length
  }

  def add(entry:String): Boolean = {
    if(!table.contains(entry)){
      table :+ entry;
      return true
    }
    false
  }

  def search(entry:String):String = {
    if(table.contains(entry)){
      entry
    }
    else
      "null"
  }

}
