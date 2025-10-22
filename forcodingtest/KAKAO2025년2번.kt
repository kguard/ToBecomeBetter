/*
package com.kguard.tobecomebetter.forcodingtest


   private fun solution(signals: Array<IntArray>): Int {
        if (signals.isEmpty()) {
            return -1
        }

        // 1. 모든 신호등 주기의 최소공배수를 계산하여, 우리가 탐색해야 할 정확한 상한선을 구합니다.
        // "모든 패턴이 처음으로 다시 반복되는 시간까지만 확인하면 된다."
        var searchLimit = 1
        for (signal in signals) {
            val cycle = signal[0] + signal[1] + signal[2]
            // lcm(1, cycle)은 cycle이므로, 초기값 1로 시작하면 모든 주기의 lcm을 구할 수 있습니다.
            searchLimit = lcm(searchLimit, cycle)
        }

        // 2. 1초부터 계산된 상한선까지만, 가장 확실한 방법으로 시뮬레이션합니다.
        for (t in 1..searchLimit) {
            var allLightsAreYellow = true

            // 현재 시간 t에서 모든 신호등의 상태를 확인합니다.
            for (signal in signals) {
                val green = signal[0]
                val yellow = signal[1]
                val cycle = signal[0] + signal[1] + signal[2]

                val timeInCycle = (t - 1) % cycle
                val isYellow = timeInCycle in green until (green + yellow)

                // 하나라도 노란불이 아니라면, 현재 시간 t는 정답이 아닙니다.
                if (!isYellow) {
                    allLightsAreYellow = false
                    break // 더 볼 필요 없이 다음 시간으로 넘어갑니다.
                }
            }

            // 모든 신호등이 노란불이었다면, t가 바로 가장 빠른 시간이므로 반환합니다.
            if (allLightsAreYellow) {
                return t
            }
        }

        // 상한선까지 확인했는데도 답을 찾지 못했다면, 그런 순간은 없는 것입니다.
        return -1
    }

    */
/** 두 수의 최대공약수(GCD)를 구하는 함수 *//*

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    */
/** 두 수의 최소공배수(LCM)를 구하는 함수 (오버플로우 방지) *//*

    private fun lcm(a: Int, b: Int): Int {
        if (a == 0 || b == 0) return 0
        // (a * b)가 Int 범위를 넘을 수 있으므로, 나눗셈을 먼저 수행합니다.
        return (a / gcd(a, b)) * b
    }


*/
