import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

//SETTINGS

lazy val commonSettings = Seq(
  exportJars := true
)

lazy val assemblySettings = Seq(
  assemblyJarName in assembly := name.value + "-assembly.jar",
)

//DEPENDENCIES

lazy val dependencies =
  new {
    val scalatest = "org.scalatest" %% "scalatest" % "3.0.5" % "test"
    val slick_pg = "com.github.tminglei" %% "slick-pg" % "0.16.3"
    val slick = "com.typesafe.slick" %% "slick" % "3.2.3"
  }

lazy val commonDependencies = Seq(
  dependencies.scalatest
)

lazy val rootDependencies = commonDependencies ++ Seq(
  dependencies.slick_pg,
  dependencies.slick,
)

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    assemblySettings,
    name := "Project-with-example",
    libraryDependencies ++= rootDependencies
  )
  .aggregate(child)
  .dependsOn(child % "compile->compile;test->test")

lazy val child  = Project("child", file("child"))
  .settings(
    commonSettings,
    assemblySettings,
    name := "Child-project",
    libraryDependencies ++= commonDependencies,
    //publishTo := Some("Artifactory Realm" at "https://where-your-artifactory-is/jar-name;build.timestamp=" + new java.util.Date().getTime),
    //credentials += Credentials("Artifactory Realm", "where-your-artifactory-is", ${USER}, ${PWD}),
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
