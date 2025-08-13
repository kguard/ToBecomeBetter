package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 임스의 일일 퀘스트
// 구현, 많은 조건 분기
// 1. 정석으로 푼 느낌 (생각을 못했음)
fun main() {
    val lv = readln().toInt()
    val arcaneLV = listOf(200, 210, 220, 225, 230, 235, 245, 250)
    var grandisLV = 260
    val arcane = MutableList(6) { 0 }
    val grandis = MutableList(7) { 0 }
    for (i in 0 .. 6) {
        if (grandisLV + 10 <= lv)
            grandis[i] = 100
        else if (grandisLV + 5 <= lv)
            grandis[i] = 300
        else if (grandisLV <= lv)
            grandis[i] = 500
        grandisLV += 5
    }
    for (i in 0..5) {
        if (arcaneLV[i + 2] <= lv)
            arcane[i] = 100
        else if (arcaneLV[i + 1] <= lv)
            arcane[i] = 300
        else if (arcaneLV[i] <= lv)
            arcane[i] = 500
    }
    arcane.forEach { print("$it ") }
    println()
    grandis.forEach { print("$it ") }
}
// 2. 260을 전후로 나눠서 푼 문제
//fun main() {
//    val lv = readln().toInt()
//    val arcaneLV = listOf(200, 210, 220, 225, 230, 235, 245, 250)
//    var grandisLV = 260
//    val arcane = mutableListOf<Int>()
//    val grandis = mutableListOf<Int>()
//    if (lv >= 260) {
//        arcane.addAll(List(6) { 100 })
//        repeat(7) {
//            if (grandisLV + 10 <= lv)
//                grandis.add(100)
//            else if (grandisLV + 5 <= lv)
//                grandis.add(300)
//            else if (grandisLV <= lv)
//                grandis.add(500)
//            else
//                grandis.add(0)
//            grandisLV += 5
//        }
//
//    } else {
//        grandis.addAll(List(7) { 0 })
//        for (i in 0..5) {
//            if (arcaneLV[i + 2] <= lv)
//                arcane.add(100)
//            else if (arcaneLV[i + 1] <= lv)
//                arcane.add(300)
//            else if (arcaneLV[i] <= lv)
//                arcane.add(500)
//            else arcane.add(0)
//        }
//    }
//    arcane.forEach { print("$it ") }
//    println()
//    grandis.forEach { print("$it ") }
//}

// 3. 모든 분기를 따져서 푼 문제 (노가다)
//fun main() {
//    val lv = readln().toInt()
//    val acane = mutableListOf<Int>()
//    val grandise = mutableListOf<Int>()
//    if (lv >= 260) {
//        acane.addAll(List(6) { 100 })
//        when (lv) {
//            in 260 until 265 -> {
//                grandise.addAll(listOf(500, 0, 0, 0, 0, 0, 0))
//            }
//
//            in 265 until 270 -> {
//                grandise.addAll(listOf(300, 500, 0, 0, 0, 0, 0))
//            }
//
//            in 270 until 275 -> {
//                grandise.addAll(listOf(100, 300, 500, 0, 0, 0, 0))
//            }
//
//            in 275 until 280 -> {
//                grandise.addAll(listOf(100, 100, 300, 500, 0, 0, 0))
//            }
//
//            in 280 until 285 -> {
//                grandise.addAll(listOf(100, 100, 100, 300, 500, 0, 0))
//            }
//
//            in 285 until 290 -> {
//                grandise.addAll(listOf(100, 100, 100, 100, 300, 500, 0))
//            }
//
//            in 290 until 295 -> {
//                grandise.addAll(listOf(100, 100, 100, 100, 100, 300, 500))
//            }
//
//            in 295 until 300 -> {
//                grandise.addAll(listOf(100, 100, 100, 100, 100, 100, 300))
//            }
//
//            else -> acane.addAll(listOf(100, 100, 100, 100, 100, 100, 100))
//        }
//    } else {
//        grandise.addAll(List(7) { 0 })
//        when (lv) {
//            in 200 until 210 -> {
//                acane.addAll(listOf(500, 0, 0, 0, 0, 0))
//            }
//
//            in 210 until 220 -> {
//                acane.addAll(listOf(300, 500, 0, 0, 0, 0))
//            }
//
//            in 220 until 225 -> {
//                acane.addAll(listOf(100, 300, 500, 0, 0, 0))
//            }
//
//            in 225 until 230 -> {
//                acane.addAll(listOf(100, 100, 300, 500, 0, 0))
//            }
//
//            in 230 until 235 -> {
//                acane.addAll(listOf(100, 100, 100, 300, 500, 0))
//            }
//
//            in 235 until 245 -> {
//                acane.addAll(listOf(100, 100, 100, 100, 300, 500))
//            }
//
//            in 245 until 250 -> {
//                acane.addAll(listOf(100, 100, 100, 100, 100, 300))
//            }
//
//            else -> acane.addAll(listOf(100, 100, 100, 100, 100, 100))
//        }
//    }
//    acane.forEach { print("$it ") }
//    println()
//    grandise.forEach { print("$it ") }
//}