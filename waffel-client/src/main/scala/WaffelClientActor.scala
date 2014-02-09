import akka.actor.{ActorSelection, ActorLogging, Actor}
import com.waffel.MessageClass
import scala.concurrent.Await
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._

class WaffelClientActor extends Actor with ActorLogging {
  implicit val timeout = Timeout(5.seconds)

  var master: ActorSelection = context.actorSelection("akka.tcp://WaffelServer@127.0.0.1:2552/user/master")

  log.info("actor created")

  def receive = {
    case msg: String => {
      log.info("New message!")
      val future = master ? msg
      log.info("New message sent!")
      val result = Await.result(future, timeout.duration).asInstanceOf[MessageClass]
      log.info("New message result: "+result.getMessage)
    }
  }
}
