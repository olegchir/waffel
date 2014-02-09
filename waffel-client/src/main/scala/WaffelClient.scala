import scala.concurrent.duration.DurationInt
import akka.actor.{ActorDSL, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object WaffelClient extends App {
  import ActorDSL._

  val config = ConfigFactory.load()

  implicit val system = ActorSystem("WaffelClientSystem", config.getConfig("WaffelClient"))

  val localNode = system.actorOf(Props[WaffelClientActor], "WaffelClient")

  while (true) {
    localNode ! "Hello World"
    Thread.sleep(1000)
  }

  system.shutdown()
}
