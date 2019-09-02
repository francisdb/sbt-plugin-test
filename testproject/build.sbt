import Dependencies._

ThisBuild / scalaVersion     := "2.13.0"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .enablePlugins(HelloPlugin)
  .settings(
    name := "testproject",
    libraryDependencies ++= Seq(
      "com.example" %% "libproject" % "0.1.0-SNAPSHOT",
      scalaTest % Test
    )
  )

resolvers += "test repository" at "http://167.71.68.47:8081/repository/maven-snapshots"
