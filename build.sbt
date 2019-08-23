ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "sbt-plugin-test",
    sbtPlugin := true,
    // when using gigahorse we get java.net.SocketException: Broken pipe (Write failed)
    // https://github.com/sbt/sbt/issues/3570
    updateOptions := updateOptions.value.withGigahorse(false)
  )

publishTo := {
  val nexus = "http://167.71.68.47:8081/repository"
  if (isSnapshot.value)
    Some("test snapshot repo" at nexus + "/maven-snapshots")
  else
    Some("test releases repo" at nexus + "/maven-releases")
}
