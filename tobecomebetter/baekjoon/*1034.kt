package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 골드 4 램프
// 브루트포스 알고리즘, 애드 혹(입력에 따른 해결 방법이 다른 것)
// 행별로 0의 갯수를 따져야됨 -> 열로 껏다 키는건 함정 -> 어쩌피 행이 다 켜져 있어야 켜지는 것이기 때문에
// 각 행에 있는 0의 개수와 k의 홀짝 여부를 사용
// 각 행에 0의 갯수가 k보다 작아야 하며, 각 행에 0의 개수가 짝수면 K도 짝수, 홀수 이면 K도 홀수 여야 됨
// 그 행에 맞게 버튼을 껏다 켤거기 떄문에 그 행과 배열이 같은 다른 행을 찾기
// 그 행이 다 켜지는 조건이면 같은 다른 행도 다 켜질수 있음
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<List<Int>>()
    repeat(n) {
        val a = readln().split("").toMutableList()
        a.removeAt(0)
        a.removeAt(a.lastIndex)
        list.add(a.map { it.toInt() })
    }
    val k = readln().toInt()
    var answer = 0
    for (i in 0 until n) { // 전체 행
        val zero = list[i].count { it == 0 } // 그 행의 0의 개수
        var count = 0
        if (zero <= k && zero % 2 == k % 2) // i번째 행이 다 켜졌을 때 -> 0의 개수가 k보다 작고, 0의 개수와 k의 홀짝 관계가 같은 경우
            for (j in 0 until n) // 다른 행들 비교
                if (list[i] == list[j]) { // i번째 행과 배열이 같은 행이 있으면
                    count++ // 하나씩 증가

                }
        answer = max(answer, count) // 최대 개수 찾기
    }
    println(answer)
}