package com.kguard.tobecomebetter.baekjoon

// 실버 4
// 자료 구조, 정렬, 이분 탐색
fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()
    val m = readln().toInt()
    val check = readln().split(" ").map { it.toInt() }
    for (i in check)
        println(binarySearch(list, i))


    /*    for(i in check) { 시간 초과
            if (i in list)
                println(1)
            else
                println(0)
        }*/
}

private fun binarySearch(list: List<Int>, search: Int): Int {
    var left = 0
    var right = list.size
    var mid: Int
    var result = 0
    while (left < right) {
        mid = (left + right) / 2
        if (list[mid] == search) {
            result = 1
            break
        }
        if (list[mid] < search)
            left = mid + 1
        else
            right = mid
    }
    return result
}