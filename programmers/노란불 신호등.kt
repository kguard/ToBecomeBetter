package com.kguard.tobecomebetter.programmers

// 유클리드 호제법을 사용
// 나눗셈과 나머지를 이용해서 문제를 푸는 법 -> 주기를 사용
class YSolution {
    fun solution(signals: Array<IntArray>): Int {
        val sums = signals.map { it.sum() }
        val yellows = signals.map { (start, end, _) ->
            start to (start + end - 1)
        }

        var max = sums[0]
        for (i in 1 until sums.size)
            max = lcm(max, sums[i])

        for (i in 1..max) {
            var check = true
            for (j in yellows.indices) {
                if ((i - 1) % sums[j] !in yellows[j].first..yellows[j].second) {
                    check = false
                    break
                }
            }
            if (check)
                return i
        }
        return -1
    }

    fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val r = x % y
            x = y
            y = r
        }
        return x
    }

    fun lcm(a: Int, b: Int): Int {
        return (a * b) / gcd(a, b)
    }
}
