name := "waffel-client"

version := "1.0"

scalaVersion := "2.10.3"

resolvers += "Typesafe Repository Releases" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Typesafe Repository Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"

resolvers += "Akka Snapshots" at "http://repo.akka.io/snapshots/com/typesafe/akka/"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3-SNAPSHOT",
  "com.typesafe.akka" %% "akka-remote" % "2.3-SNAPSHOT",
  "com.github.romix.akka" %% "akka-kryo-serialization" % "0.3-SNAPSHOT"
)

resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.7.0-SNAPSHOT")