import scala.io.Source

object SonarSweep {
  def solution(depths: List[Int], window: Int) = {
    val result: Int = depths
      .sliding(window + 1)
      .count(pair => {
        pair(window) > pair(0)
      })
    println(result)
  }

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("input2.txt")
    val depths: List[Int] = source.getLines().map(_.toInt).toList
    solution(depths, 1) // 1692
    solution(depths, 3) // 1724
  }
}
