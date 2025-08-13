package com.kguard.tobecomebetter.baekjoon

// 실버 4 수들의 합2
// 브루트포스 알고리즘, 누적 합, 두 포인터(투 포인터)
fun main() {
    val (n, m) = readln().split(" ").map { it.toLong() }
    val list = readln().split(" ").map { it.toInt() }
    var start = 0
    var end = 0
    var sum = 0L
    var count = 0
    while (start < n) {
        if (sum <= m && end < n) {
            sum += list[end]
            end++
        } else {
            sum -= list[start]
            start++
        }
        if (sum == m)
            count++
    }
//    순서가 다른 풀이
//    var start = -1
//    var end = 0
//    var sum = list[0].toLong()
//    var count = 0
//    while(start < n){
//        if(sum == m)
//            count++
//        if(sum <= m && end < n - 1) {
//            end++
//            sum += list[end]
//        }
//        else {
//            start++
//            if(start < n)
//                sum -= list[start]
//        }
//    }
    print(count)
}