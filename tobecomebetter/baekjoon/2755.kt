package com.kguard.tobecomebetter.baekjoon

// 브론즈 1 이번학기 평점은 몇점?
// 수학, 구현, 사칙연산
fun main() {
    val n = readln().toInt()
    var sum = 0.0
    var all = 0
    repeat(n) {
        val (a, b, c) = readln().split(" ")
        sum += b.toInt() * grade(c)
        all += b.toInt()
    }
    println(String.format("%.2f", sum / all))
}


private fun grade(n: String): Double {
    when (n) {
        "A+" -> {
            return 4.3
        }

        "A0" -> {
            return 4.0
        }

        "A-" -> {
            return 3.7
        }

        "B+" -> {
            return 3.3
        }

        "B0" -> {
            return 3.0
        }

        "B-" -> {
            return 2.7
        }

        "C+" -> {
            return 2.3
        }

        "C0" -> {
            return 2.0
        }

        "C-" -> {
            return 1.7
        }

        "D+" -> {
            return 1.3
        }

        "D0" -> {
            return 1.0
        }

        "D-" -> {
            return 0.7
        }

        "F" -> {
            return 0.0
        }

        else -> {
            return -1.0
        }
    }
}