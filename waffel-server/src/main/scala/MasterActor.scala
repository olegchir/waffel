import akka.actor.{ActorLogging, Actor}
import com.waffel.MessageClass

/**
 * Created by olegchir on 09.02.14.
 */
class MasterActor extends Actor with ActorLogging {
  import context.system

  def receive = {
    case x: String => sender() ! new MessageClass("hello, Earth!")
  }
}
