package com.kguard.tobecomebetter.baekjoon

// 실버 4 Sort 마스터 배지훈의 후계자
// 자료 구조, 정렬, 이분 탐색
// 숫자가 존재하는지에 대한 여부는 이분 탐색에서 마지막에 구한 인덱스의 수가 찾는 수와 같은지 확인으로 판단
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val a = mutableListOf<Int>()
    repeat(n) { a.add(readln().toInt()) }
    a.sort()
    repeat(m) { println(lowerBound(readln().toInt(), a)) }
}

private fun lowerBound(now: Int, list: List<Int>): Int {
    var leftIndex = 0
    var rightIndex = list.lastIndex
    var midIndex: Int
    while (leftIndex < rightIndex) {
        midIndex = (leftIndex + rightIndex) / 2
        if (now > list[midIndex])
            leftIndex = midIndex + 1
        else
            rightIndex = midIndex
    }
    if (now == list[rightIndex]) return rightIndex
    return -1
}

 // 문제 해결 시간을 줄일 수 있는 방식
//import java.io.BufferedReader
//import java.io.BufferedWriter
//import java.io.InputStreamReader
//import java.io.OutputStreamWriter
//
//fun main() {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val bw = BufferedWriter(OutputStreamWriter(System.out))
//    val (n, m) = br.readLine().split(" ").map { it.toInt() }
//    val a = mutableListOf<Int>()
//    a.add(br.readLine().toInt())
//    repeat(n - 1) {
//        val now = br.readLine().toInt()
//        a.add(now)
//    }
//    a.sort()
//    repeat(m) {
//        val now = br.readLine().toInt()
//        bw.write("${lowerBound(now,a)}\n")
//    }
//    bw.flush()
//    bw.close()
//}
//
