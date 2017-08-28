import Dependencies._
import BuildSettings._

lazy val restfulAkkaCluster = Project("restful-akka-cluster", file("."))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= Seq(akkaCluster, akkaHttp, logback, json4s))
  .dependsOn(core, rest)
  .aggregate(utility, core, rest)


lazy val core = Project("core", file("core"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= Seq(akkaCluster, akkaTestKit))
  .dependsOn(utility)

lazy val rest = Project("rest", file("rest"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= Seq(akkaHttp, akkaHttpTestKit))
  .dependsOn(utility)


lazy val utility = Project("utility", file("utility"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= Seq(logback))
