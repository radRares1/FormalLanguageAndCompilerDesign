import scala.collection.mutable.ListBuffer

case class ProgramInternalForm(){

  val content:ListBuffer[(Int,Int)] = ListBuffer.empty

  def add(entryHash:Int,stPosition:Integer):Unit = {
    content.addOne((entryHash,stPosition))
  }

}
