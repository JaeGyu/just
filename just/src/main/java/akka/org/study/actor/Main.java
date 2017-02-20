package akka.org.study.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {
	public static void main(String[] args) {
		ActorSystem actorSystem = ActorSystem.create("TestSystem");
		ActorRef ping = actorSystem.actorOf(Props.create(PingActor.class), "pingActor");
		ping.tell("start", ActorRef.noSender());

		ActorSystem as = ActorSystem.create("TEST-KEJ");
		as.actorOf(Props.create(PingActor.class), "pingActor").tell("start-KEJ", ActorRef.noSender());

	}
}
