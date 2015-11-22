name := "notary"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

resolvers += "Scalaz Bintray Repo" at "https://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
 "org.scalatestplus" %% "play" % "1.4.0-M3" % Test
)     

//routesGenerator := InjectedRoutesGenerator
