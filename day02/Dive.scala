import scala.io.Source

object Dive {
  def solution1(instructions: List[String]) = {
    var x = 0; var y = 0
    instructions.foreach(instruction => {
      val parts = instruction.split(" ")
      val direction = parts(0)
      val units = parts(1).toInt
      direction match {
        case "up"      => y -= units
        case "down"    => y += units
        case "forward" => x += units
      }
    })
    println(x * y)
  }

  def solution2(instructions: List[String]) = {
    var x = 0; var y = 0; var aim = 0
    instructions.foreach(instruction => {
      val parts = instruction.split(" ")
      val direction = parts(0)
      val units = parts(1).toInt
      direction match {
        case "up"   => aim -= units
        case "down" => aim += units
        case "forward" => {
          x += units
          y += aim * units
        }
      }
    })
    println(x * y)
  }

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("input2.txt")
    val instructions = source.getLines().toList
    solution1(instructions) // 1692075
    solution2(instructions) // 1749524700
  }
}
