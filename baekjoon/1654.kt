package com.kguard.tobecomebetter.baekjoon

// 실버 2
// 이분 탐색, 매개 변수 탐색
fun main() {
    val (k, n) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<Long>()
    repeat(k) {
        list.add(readln().toLong())
    }
    println(parametricSearch(list, n))
}
// upperBound - 1 을 이용해서 문제 풀기
private fun parametricSearch(list: List<Long>, search: Int): Long {
    var left = 0L
    var right = list.max() + 1 // 최대 길이가 1일때 mid가 0 이 되어 버리는 경우의 수를 막기 위해서 +1 !!!
    var mid: Long
    var sum: Long
    while (left < right) {
        mid = (left + right) / 2
        sum = 0
        for (i in list)
            sum += i / mid
        if (sum >= search) // 갯수가 n개 보다 많을 때 길이를 늘려 봐야함
            left = mid + 1
        else // 갯수가 n개 보다 적을 때 길이를 줄여봐야 함
            right = mid
    }
    return right - 1
}