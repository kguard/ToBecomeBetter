package com.kguard.tobecomebetter.baekjoon

// 실버 4 주몽
// 정렬, 두 포인터(투 포인터)
// 양 끝을 투 포인터로 생성해서 m과 같아질 떄를 확인, 고유한 번호이기 떄문에 겹치지 않음
fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()
    var start = 0
    var end = n - 1
    var count = 0
    while (start < end) {
        if (list[start] + list[end] == m) { // m하고 같으면 count++ 하고 start를 올려서 다음으로 넘어감
            count++
            start++
        } else if (list[start] + list[end] < m) // m보다 작으면 start를 올려서 m과 비슷하도록 조정
            start++
        else // m보다 크면 end를 줄여서 m과 비슷하도록 조정
            end--
    }
    println(count)
}