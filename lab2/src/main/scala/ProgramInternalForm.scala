import scala.collection.mutable
import scala.collection.mutable.ListBuffer

case class ProgramInternalForm(){


  val content:ListBuffer[Tuple2[String,Int]] = ListBuffer.empty

  
  
  def add(entry:String,stPosition:Integer):Unit = {
    content.addOne((entry,stPosition))
  }

}
