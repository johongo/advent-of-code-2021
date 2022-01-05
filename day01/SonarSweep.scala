import scala.io.Source

object SonarSweep {
  def solution(depths: List[Int], window: Int) = {
    val result: Int = depths
      .sliding(window)
      .count(pair => {
        pair(window - 1) > pair(0)
      })
    println(result)
  }

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("input2.txt")
    val depths: List[Int] = source.getLines().map(_.toInt).toList
    solution(depths, 2) // 1692
    solution(depths, 4) // 1724
  }
}
