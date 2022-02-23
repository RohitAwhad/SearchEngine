name := "SearchEngine"
version := "0.1"
scalaVersion := "2.11.12"

resolvers ++= Seq(
  "Artima Maven Repository" at "https://repo.artima.com/releases",
  "bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven",
  "Typesafe Simple Repository" at "https://repo.typesafe.com/typesafe/simple/maven-releases",
  "MavenRepository" at "https://mvnrepository.com"
)
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.3.0-SNAP2" % Test,
  "org.mockito" %% "mockito-scala" % "1.16.23" % Test
)
