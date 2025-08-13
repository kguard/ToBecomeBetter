package ToBecomeBetter.tobecomebetter.baekjoon

import kotlin.math.abs

// 실버 3 세그먼트 트리보다도 바･로･너･♡
// 구현, 자료 구조, 문자열, 정렬, 집합과 맵
fun main() {

    val n = readln().toInt()
    val algo = mutableListOf<Pair<String, Int>>()
    repeat(n) {
        val (a, b) = readln().split(" ")
        algo.add(Pair(a, b.toInt()))
    }
    val m = readln().toInt()
    val people = HashMap<String, Int>()
    repeat(m) {
        val (a, b) = readln().split(" ")
        people.put(a, b.toInt())
    }
    val total = HashMap<String, List<Pair<String, Int>>>()
    for (p in people) {
        total.put(
            p.key,
            algo.sortedWith(compareBy<Pair<String, Int>> { abs(it.second - p.value) }.thenBy { it.first }.thenBy { it.first.length })
        )
    }
    val q = readln().toInt()
    var name = readln().split(" ")[0]
    println("hai!")
    repeat(q - 1) {
        val rd = readln()
        if (rd == "nani ga suki?")
            println("${total[name]?.get(1)?.first} yori mo ${total[name]?.get(0)?.first}")
        else {
            println("hai!")
            name = rd.split(" ")[0]
        }
    }

}