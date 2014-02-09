import akka.actor.ActorDSL._
import scala.concurrent.duration.DurationInt
import akka.actor.{ActorDSL, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

/**
 * Created by olegchir on 09.02.14.
 */
object WaffelServer extends App {

  val config = ConfigFactory.load()
  implicit val system = ActorSystem("WaffelServer", config.getConfig("master"))

  try run()
  finally system.shutdown()

  def run(): Unit = {
    val watcher = inbox()
    watcher.watch(system.actorOf(Props[MasterActor], "master"))
    infiniteReceive(inbox)
  }

  def infiniteReceive(watcher: ActorDSL.Inbox) = {
    while(true) {
      try {
        watcher.receive()
      } catch {
        case e: Throwable => println("timeout!")
      }
    }
  }

}
