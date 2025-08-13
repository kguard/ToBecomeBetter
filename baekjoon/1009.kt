package com.kguard.tobecomebetter.baekjoon


// 브론즈 2
// 밑이 거듭 제곱될 때 마다 일의 자리가 반복되는 주기가 존재하기 때문에 이를 이용해서 문제 해결
fun main() {
    val list2 = listOf(2, 4, 8, 6)
    val list3 = listOf(3, 9, 7, 1)
    val list4 = listOf(4, 6)
    val list7 = listOf(7, 9, 3, 1)
    val list8 = listOf(8, 4, 2, 6)
    val list9 = listOf(9, 1)
    repeat(readln().toInt())
    {
        val a = readln().split(" ").map { it.toInt() }
        when (a[0] % 10) {
            0 -> {
                println(10)
            }

            1 -> {
                println(1)
            }

            2 -> {
                println(list2[(a[1]-1) % list2.size])
            }

            3 -> {
                println(list3[(a[1]-1) % list3.size])
            }

            4 -> {
                println(list4[(a[1]-1) % list4.size])
            }

            5 -> {
                println(5)
            }

            6 -> {
                println(6)
            }

            7 -> {
                println(list7[(a[1]-1) % list7.size])
            }

            8 -> {
                println(list8[(a[1]-1) % list8.size])
            }

            9 -> {
                println(list9[(a[1]-1) % list9.size])
            }
        }
    }
}