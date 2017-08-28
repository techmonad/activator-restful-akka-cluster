import sbt._

object Dependencies {

  val akkaVersion = "2.5.4"
  val akkaHttpVersion = "10.0.9"


  /**
    * Dependencies
    *
    */
  val akkaCluster = "com.typesafe.akka" %% "akka-cluster" % akkaVersion
  val akkaHttp = "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
  val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"
  val json4s = "org.json4s" %% "json4s-native" % "3.5.3"



  /**
    * Testing dependencies
    *
    */

  val akkaTestKit = "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test

  val akkaHttpTestKit = "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test

  val scalaTest = "org.scalatest" %% "scalatest" % "3.0.4" % Test

}
