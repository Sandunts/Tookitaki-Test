
name := "PlayTest"

version := "0.1"

scalaVersion := "2.12.7"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies += guice
libraryDependencies += jdbc

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.6.11",
  "mysql" % "mysql-connector-java" % "5.1.41",
  "org.json" % "json" % "20180130",
  "org.clapper" %% "grizzled-slf4j" % "1.3.0",
  "com.typesafe" % "config" % "1.3.1"
)