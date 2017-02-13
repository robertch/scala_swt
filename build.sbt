name := """swt-rc"""

version := "1.0"

scalaVersion := "2.11.7"

resolvers += "swt-repo" at "http://maven-eclipse.github.io/maven"

libraryDependencies ++= Seq(
   "org.scalatest" %% "scalatest" % "2.2.4" % "test",
   "org.eclipse.swt" % "org.eclipse.swt.gtk.linux.x86_64" % "4.6.1"
)

