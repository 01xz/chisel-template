import mill._
import mill.scalalib._
import mill.scalalib.scalafmt.ScalafmtModule

val chiselVersion = "5.0.0"

object %NAME% extends SbtModule with ScalafmtModule {
  def scalaVersion = "2.13.10"
  def scalacOptions = Seq(
    "-language:reflectiveCalls",
    "-deprecation",
    "-feature",
    "-Xcheckinit",
    "-P:chiselplugin:genBundleElements"
  )
  def ivyDeps = Agg(
    ivy"org.chipsalliance::chisel::$chiselVersion"
  )
  def scalacPluginIvyDeps = Agg(
    ivy"org.chipsalliance:::chisel-plugin::$chiselVersion"
  )
  override def millSourcePath = os.pwd
}
