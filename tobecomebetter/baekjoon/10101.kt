package com.kguard.tobecomebetter.baekjoon

fun main() {
    val angle = mutableListOf<Int>()
    repeat(3)
    {
        angle.add(readln().toInt())
    }
    if (angle.sum() == 180) {
        when (angle.toMutableSet().size) {
            1 -> print("Equilateral")
            2 -> print("Isosceles")
            3 -> print("Scalene")
        }
    } else
        print("Error")
}