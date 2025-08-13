package com.kguard.tobecomebetter.baekjoon

// 살버 2
// 이분 탐색, 매개 변수 탐색
// 1654번과 같은 방식으로 문제 해결
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toLong() }
    println(parametricSearch(list, m))
}

private fun parametricSearch(list: List<Long>, search: Int): Long {
    var left = 0L
    var right = list.max()
    var mid: Long
    var sum: Long
    while (left < right) {
        mid = (left + right) / 2
        sum = 0
        for (i in list)
            if (i >= mid)
                sum += i - mid
        if (sum >= search)
            left = mid + 1 // 총 길이가 원하는 숫자보다 크거나 같을 떄 -> 나무의 높이가 최대 길이로 남아야하기 때문에 갯수를 딱 맞춰야 함
        else // 총 길이가 원하는 숫자 보다 작을 때 -> 총 필요한 길이가 더 필요하므로 자르는 높이를 더 줄여야 함 
            right = mid
    }
    return right - 1
}