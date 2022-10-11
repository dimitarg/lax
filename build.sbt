ThisBuild / scalaVersion     := "2.13.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "io.github.dimitarg"


val commonSettings = Seq(
  libraryDependencies ++= Seq(
    "io.github.dimitarg" %% "weaver-test-extra" % "0.4.6" % "test",
    "org.typelevel" %% "cats-core" % "2.8.0",
  ),
  testFrameworks += new TestFramework("weaver.framework.CatsEffect"),
  addCompilerPlugin("org.typelevel" %% "kind-projector"     % "0.13.2" cross CrossVersion.full),
  addCompilerPlugin("com.olegpy"    %% "better-monadic-for" % "0.3.1"),
  scalacOptions ++= Seq(
    "-Xsource:3",
    //needed for @CirceCodec semiauto macros and for @newtype
    "-Ymacro-annotations",
  )
)
lazy val core = (project in file("modules/lax-core"))
  .settings(
    name := "Lax Core",
  )
  .settings(commonSettings)

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
