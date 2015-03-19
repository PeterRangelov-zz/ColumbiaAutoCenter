name := "columbiaautocenter"

version := "1.0"

lazy val `columbiaautocenter` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( javaJdbc , javaEbean , cache , javaWs )

libraryDependencies += "org.projectlombok" % "lombok" % "1.16.2"

libraryDependencies += "com.sendgrid" % "sendgrid-java" % "2.1.0"


unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  