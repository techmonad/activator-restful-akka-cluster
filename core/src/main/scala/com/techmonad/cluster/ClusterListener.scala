package com.techmonad.cluster

import akka.cluster.Cluster
import akka.cluster.ClusterEvent._
import akka.actor.Actor
import com.techmonad.logger.Logging

class ClusterListener extends Actor with Logging {

  val cluster = Cluster(context.system)


  override def preStart(): Unit = {
    cluster.subscribe(self, initialStateMode = InitialStateAsEvents,
      classOf[MemberEvent], classOf[UnreachableMember])
  }

  override def postStop(): Unit = cluster.unsubscribe(self)

  def receive = {
    case MemberUp(member) =>
      info(s"Member is Up: ${member.address}")
    case UnreachableMember(member) =>
      info(s"Member detected as unreachable: $member")
    case MemberRemoved(member, previousStatus) =>
      info(s"Member is Removed: ${member.address} after ${previousStatus}")
    case _: MemberEvent => // ignore
  }
}