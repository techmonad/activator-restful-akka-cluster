import sbt.Keys._

object BuildSettings {

  lazy val commonSettings =
    Seq(
      version := "1.0",
      scalaVersion := "2.12.3",
      organization := "com.techmonad"
    )

}
