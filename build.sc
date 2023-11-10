import mill._
import scalalib._

val chiselVersion     = "6.0.0-M3"
val chiseltestVersion = "5.0.2"

object %NAME% extends SbtModule with scalafmt.ScalafmtModule {
  def millSourcePath = os.pwd

  def scalaVersion = "2.13.10"

  def scalacOptions = Seq(
    "-language:reflectiveCalls",
    "-deprecation",
    "-feature",
    "-Xcheckinit"
  )

  def ivyDeps = Agg(
    ivy"org.chipsalliance::chisel:$chiselVersion"
  )

  def scalacPluginIvyDeps = Agg(
    ivy"org.chipsalliance:::chisel-plugin:$chiselVersion"
  )

  object test extends ScalaTests with TestModule.ScalaTest {
    def ivyDeps = super.ivyDeps() ++ Agg(
      ivy"edu.berkeley.cs::chiseltest:$chiseltestVersion"
    )
  }
}
