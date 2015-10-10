name := "expense_tracker"

version := "1.0"

scalaVersion := "2.11.7"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= Seq(
    "org.hsqldb" % "hsqldb" % "2.3.1",
    "ch.qos.logback" % "logback-classic" % "1.0.13",
    "joda-time" % "joda-time" % "2.8.1",
    "org.joda" % "joda-convert" % "1.7",
    "com.github.tototoshi" %% "slick-joda-mapper" % "2.0.0",
    "com.typesafe.akka" % "akka-actor_2.11" % "2.3.12",
    "org.scala-lang.modules" %% "scala-xml" % "1.0.2",
    "com.typesafe.slick" %% "slick" % "3.0.2",
    "com.typesafe" % "config" % "1.3.0",
    "c3p0" % "c3p0" % "0.9.0.4"
)

// Spray dependencies
libraryDependencies ++= Seq(
    "io.spray" % "spray-can_2.11" % "1.3.3",
    "io.spray" % "spray-http_2.11" % "1.3.3",
    "io.spray" % "spray-routing_2.11" % "1.3.3",
    "io.spray" % "spray-json_2.11" % "1.3.2"
)

resolvers ++= Seq(
    "Spray repository" at "http://repo.spray.io",
    "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)
