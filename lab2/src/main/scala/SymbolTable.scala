import scala.collection.mutable.ListBuffer

/**
 * needs to be changed completely, this is so bad I'm pretty sure it's not what we need to do but life is life
 * I initally wanted to make a hashtable but I do not understand exactly what the hashtable should contain
 * gotta look into it
 *
 * @param table the list which keeps the pairs
 */
case class SymbolTable(var table: ListBuffer[Tuple2[Integer,String]]) {



  def getSize:Integer ={
    table.length
  }

  /**
   *
   * @param value value to be hashed to the sum of the ascii chars from each char in the string
   * @return the ascii sum
   */
  def hash(value:String):Integer = {
    value.map(e => e.toInt).sum
  }

  /**
   *
   * @param entry the string which we add as Tuple(hash(entry),entry)
   * @return if the string does not exist in the table we add it
   *         else we return it's position
   */
  def add(entry:String): Integer = {
    if(!table.map(_._2).contains(entry)){

      table :+= Tuple2(hash(entry),entry)
      hash(entry)
    }
    else{
      hash(entry)
    }

  }

  /**
   * filters the table for the tuples that do not have the given hashCode and returns its value
   * @param hashCode the code of the needed string
   * @return the value of the code
   */
  def getValue(hashCode:Integer):String = {
    val value = table.filter(e => e._1==hashCode).head._2
    value
  }

}
