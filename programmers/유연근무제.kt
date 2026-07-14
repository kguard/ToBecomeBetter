package com.kguard.tobecomebetter.programmers

class Solution_유연근무제 {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer: Int = 0
        val limit = schedules.map {
            var n = it + 10
            if (n % 100 >= 60) {
                n = ((n / 100 + 1) * 100) + (n % 100 - 60)
            }
            n
        }

        val sunday = 7 - startday
        val saturday = (sunday - 1 + 7) % 7

        timelogs.forEachIndexed { index, array ->
            var check = true
            for (i in array.indices) {
                if (i == sunday || i == saturday)
                    continue
                if (limit[index] < array[i]) {
                    check = false
                    break
                }
            }
            if (check)
                answer++
        }

        return answer
    }
}