package com.kguard.tobecomebetter.baekjoon

fun main() {
//    while (true) {
//        val line = readln().split(" ").map { it.toInt() }.toMutableList()
//        if (line[0] == 0)
//            break
//        val max = line.max()
//        line.remove(max)
//        if (max >= line.sum()) {
//            println("Invalid")
//            continue
//        }
//        line.add(max)
//        when (line.toMutableSet().size) {
//            1 -> println("Equilateral")
//            2 -> println("Isosceles")
//            3 -> println("Scalene")
//        }
//    }
    while (true) {
        val line = readln().split(" ").map { it.toInt() }.toMutableList()
        line.sortDescending()
        if (line[0] == 0)
            break
        if (line[0] >= line[1] + line[2]) {
            println("Invalid")
            continue
        }
        when (line.toMutableSet().size) {
            1 -> println("Equilateral")
            2 -> println("Isosceles")
            3 -> println("Scalene")
        }
    }
}