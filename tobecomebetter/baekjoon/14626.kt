package com.kguard.tobecomebetter.baekjoon

// 브론즈 1 ISBN
// 수학, 구현, 브루트포스 알고리즘, 사칙연산
// 마지막에 i를 for문을 이용해서 구함 -> 수학적으로 계산한게 아니라 노가다 함
fun main() {
    val list = readln()
    var sum = 0
    var weight = 0
    for (i in list.indices) {
        if (list[i] != '*') {
            sum += if (i % 2 == 0)
                list[i].toString().toInt() * 1
            else
                list[i].toString().toInt() * 3
        } else {
            weight = if (i % 2 == 0)
                1
            else
                3
        }
    }
    sum %= 10
    for (i in 0..9)
        if ((sum + i * weight % 10) % 10 == 0) {
            print(i)
            break
        }
}