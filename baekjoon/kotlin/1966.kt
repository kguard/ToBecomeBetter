package com.kguard.tobecomebetter.baekjoon

// 실버 3 프린터 큐
// 구현, 자료 구조, 시뮬레이션, 큐

// 다른 사람 참고해서 수정한 부분
fun main() {
    val t = readln().toInt()
    repeat(t) {
        var (n, m) = readln().split(" ").map { it.toInt() }
        val queue = readln().split(" ").map { it.toInt() }.toMutableList()
        var count = 0
        while (queue.isNotEmpty()) {
            if (queue[0] < queue.max())
                queue.add(queue.removeAt(0))
            else {
                queue.removeAt(0)
                count++
                if (m == 0) break
            }
            if (m > 0)
                m--
            else
                m = queue.size - 1
        }
        println(count)
    }
}

// 기존
//fun main() {
//    val t = readln().toInt()
//    repeat(t) {
//        var (n, m) = readln().split(" ").map { it.toInt() }
//        val queue = readln().split(" ").map { it.toInt() }.toMutableList()
//        var count = 0
//        var max = queue.max()
//        while (m >= 0) {
//            if (queue[0] < max) {
//                if (m == 0)
//                    m = queue.size - 1
//                else
//                    m--
//                queue.add(queue.removeAt(0))
//            } else {
//                m--
//                queue.removeAt(0)
//                count++
//            }
//            if (queue.isEmpty())
//                break
//            max = queue.max()
//        }
//        println(count)
//    }
//}
