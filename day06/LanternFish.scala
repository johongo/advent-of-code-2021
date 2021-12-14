import scala.io.Source

object LanternFish {
  def solution(fishes: Array[Int], days: Int) = {
    var count = Array.fill(9)(0L)
    fishes.foreach(fish => {
      count(fish) = count(fish) + 1
    })
    for (day <- 1 to days) {
      val fish0 = count(0)
      for (i <- 1 to count.length - 1) {
        count(i - 1) = count(i)
      }
      count(6) += fish0
      count(8) = fish0
    }
    println(count.sum)
  }

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("input.txt")
    val line = source.getLines().toList(0)
    val fishes = line.split(",").map(_.toInt)
    solution(fishes, 80) // 5934
    solution(fishes, 256) // 26984457539
  }
}
