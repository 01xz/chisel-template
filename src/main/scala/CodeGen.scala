package %NAME%

import chisel3._
import circt.stage.ChiselStage

object CodeGen {
  def main(args: Array[String]): Unit = {
    ChiselStage.emitSystemVerilogFile(
      gen = new Foo(),
      args = Array("--target-dir", "rtl"),
      firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
    )
  }
}
