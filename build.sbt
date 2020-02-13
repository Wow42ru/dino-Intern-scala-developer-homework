name := "dino Intern scala developer homework"

version := "0.1"

scalaVersion := "2.12.7"
libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.8.3" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")

libraryDependencies += "org.specs2" %% "specs2-scalacheck" % "4.8.3" % Test
