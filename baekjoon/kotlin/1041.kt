import kotlin.math.min

// 골드 5 주사위
// 각 양끝의 8개는  3면만 나오고, 나머지는 2면 씩 나옴
// 외부 위치 -> 1개는 1개, 2개는  8 개, 3개는 27개중 9+9+3+3 24개 , 4는 16+16+8+8, 5는 25+25+5*3+5*3
// 3면 짜리, 2면까리, 1면 짜리 0 면짜리
// 2-> 3면 짜리 8개, 3 -> 3면짜리 8개, 2면짜리 8*1개, 1면짜리 6개, 4 -> 3면짜리 8개, 2면짜리 8*2개, 1면 짜리 2*2*6개, 5 -> 3면짜리 8개, 2면짜리 24개, 1면짜리 3*3*6
// 주사위를 정할 때, 푱행인 면은 사용되면 안되니까
fun main() {
    val n = readln().toLong()
    val dice = readln().split(" ").map { it.toInt() }
    val one = dice.min()
    val mins = mutableListOf<Int>()
    for(i in 0 until 3){
        mins.add(min(dice[i], dice[5-i]))
    }
    mins.sort()
    val two = mins[0]+mins[1]
    val three = mins.sum()
    println(
        when (n) {
            1L -> {
               dice.sum() - dice.max()
            }
            else -> {
                (three * 4) + (two * ((n - 2) * 8 + 4)) + (one * ((n - 2) * (n - 2) * 5 + (n - 2) * 4))
            }

        }
    )
}
