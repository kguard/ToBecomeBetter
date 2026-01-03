package com.kguard.tobecomebetter.baekjoon.kotlin

// 골드 5 다이어트
// 수학적으로 문제를 품
fun main() {
    val g = readln().toInt() // G: (현재 몸무게^2) - (이전 몸무게^2)
    val set = mutableSetOf<Int>()

    // G = (현재 + 이전) * (현재 - 이전)
    // 여기서 i는 (현재 - 이전), 즉 '두 몸무게의 차이'라고 가정하고 탐색
    for (i in 1..g / 2) { // 중간 까지만 탐색하면 됨 (약수 찾기 범위)
        if (g % i == 0) { // i가 G의 약수라면 (즉, i가 유효한 '차이' 후보라면)
            val t = g / i // t = (현재 + 이전), 즉 '두 몸무게의 합' (나머지 인수)

            // 두 몸무게(자연수)가 존재하려면 합(t)과 차(i)의 홀짝성이 같아야 함
            // 즉, (합 - 차)가 짝수여야 2로 나누어 떨어짐
            // 수식: (x+y) - (x-y) = 2y => t - i = 2y
            if ((t - i) % 2 == 0) {
                val sb = (t - i) / 2 // sb: 이전 몸무게 (y)

                // 이전 몸무게는 0이 아니어야 함 (문제 조건상 살이 찐 상태)
                if (sb != 0)
                // t(합) - sb(이전) = 현재 몸무게(x)
                    set.add(t - sb)
            }
        }

    }
    if (set.isEmpty())
        println(-1)
    else
        set.toList().sorted().forEach { println(it) }
}