import sbt._

object Dependencies {

  // Versions
  val scalaVersionNo = "2.11.7"

  // Test Versions
  val scalaPlusPlayTestVersion = "1.4.0-M3"

  // Libraries

  val scalaPlusPlay = "org.scalatestplus" %% "play" % scalaPlusPlayTestVersion % Test

  //Repositories
  val playRepositories = Seq(
    "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases")

  // Projects Dependencies

  val helloDependancies =  Seq()

  val userDependencies =  Seq()

  val testDependencies =  Seq()

  val utilitiesDependencies = Seq()

}
