import scala.collection.mutable
import scala.collection.mutable.ListBuffer

case class ProgramInternalForm(){
//PIF looks ok
  val content:mutable.HashMap[String,Int] = mutable.HashMap.empty

  def add(entry:String,stPosition:Integer):Unit = {
    content(entry) = stPosition
  }

}
