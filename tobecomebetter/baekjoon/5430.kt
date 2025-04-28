package com.kguard.tobecomebetter.baekjoon

// 골드 5 AC
// 구현, 자료 구조, 문자열, 파싱, 덱
// R이 나올 때 실제로 뒤집지 않고, count로 뒤집기가 나오는 횟수를 구한 다음에 마지막에만 실행
fun main() {
    val t = readln().toInt()
    loop@ for (i in 0 until t) {
        val p = readln()
        val n = readln().toInt()
        val read = readln()
        val slice = read.substring(1 until read.lastIndex)
//        val slice = read.substring(1 until read.lastIndex).split(",").toMutableList()
//        slice.removeAll(listOf(""))
//        val x = slice.map { it.toInt() }.toMutableList()
        val x = ArrayDeque<Int>()
        if (slice.isNotEmpty())
            slice.split(",").forEach { x.addLast(it.toInt()) }
        var count = 0 // R이 두번이면 리스트가 원래대로 돌아옴
        for (i in p) {
            when (i) {
                'R' -> {
                    count++ // 뒤집는 횟수 추가
                }

                'D' -> {
                    if (x.isEmpty()) {
                        println("error")
                        continue@loop
                    } else {
                        if (count % 2 == 0) // count가 홀수이면 뒤에서 하나 빼고, 짝수면 앞에서 하나 뺌
                            x.removeFirst()
                        else
                            x.removeLast()
                    }
                }
            }
        }
        if (count % 2 == 1) // 홀수이면 리스트 뒤집어 주기
            x.reverse()
        println(x.joinToString(",", "[", "]"))
    }
}