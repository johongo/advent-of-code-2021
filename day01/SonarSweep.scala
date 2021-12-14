import scala.io.Source

object SonarSweep {
  def solution(list: List[Int], window: Int) = {
    val result: Int = list
      .sliding(window)
      .count(pair => {
        pair(window - 1) > pair(0)
      })
    println(result)
  }

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("input2.txt")
    val list: List[Int] = source.getLines().map(_.toInt).toList
    solution(list, 2) // 1692
    solution(list, 4) // 1724
  }
}
