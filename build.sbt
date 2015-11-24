import Dependencies._

lazy val commonSettings = Seq(
  version := "0.1.0",
  scalaVersion := scalaVersionNo,
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
  javaOptions ++= Seq("-Xmx4G", "-XX:+UseConcMarkSweepGC"),
  resolvers ++= playRepositories,
  libraryDependencies += scalaPlusPlay
)

lazy val root = (project in file(".")). 
                settings(commonSettings: _*).
                enablePlugins(PlayScala).
                dependsOn( user, hello, utilities).
				aggregate( user, hello, utilities)
				  
lazy val user = (project in file("module/user")).
                settings(commonSettings: _*).
                settings(
				    libraryDependencies ++= userDependencies
				  ).enablePlugins(PlayScala).
				  dependsOn(utilities)
				  
lazy val hello = (project in file("module/hello")).
                settings(commonSettings: _*).
                settings(
				    libraryDependencies ++= helloDependancies
				  ).enablePlugins(PlayScala).
				  dependsOn(utilities)

lazy val utilities = (project in file("module/utilities")).
                settings(commonSettings: _*).
                settings(
				    libraryDependencies ++= utilitiesDependencies
				  ).enablePlugins(PlayScala)
			  
//routesGenerator := InjectedRoutesGenerator
