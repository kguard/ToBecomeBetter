package com.kguard.tobecomebetter.baekjoon

// 실버 5 주사위 피라미드
// 수학, 애드 혹, 사칙연산
fun main() {
    val n = readln().toInt();
    var max = 0
    var min = 0
    for (i in 1..n) {
        if (i == 1) {
            // 맨 위에 1개 (5면이 나옴)
            max += 20
            min += 15
        }
        if (i >= 2) {
            // 뒷면 가운데 1개 (2면만 나옴)
            max += 11
            min += 3
            // 앞면 맨 마지막 2개 (4면이 나옴)
            max += 18 * 2
            min += 10 * 2
            // 뒷면 중간들 (1면만 나옴)
            max += 6 * (i - 2) * 2
            min += 1 * (i - 2) * 2
            // 앞면 중간들 (3면만 나옴)
            max += 15 * (i - 2)
            min += 6 * (i - 2)
        }
    }
    // 점화식을 구해서 푼 것
    println(35 * (n * (n + 1)) / 2)
    println(max + min)
}