package com.kguard.tobecomebetter.baekjoon

// 실버 3 풍선 떠뜨리기
// 자료 구조, 덱
import kotlin.math.absoluteValue

fun main() {
    readln()
    val deque = ArrayList<Pair<Int, Int>>()
    readln().split(" ").forEachIndexed { index, s ->
        deque.add(Pair(index + 1, s.toInt()))
    }
    while (true) {
        val count = deque.removeFirst()
        print("${count.first} ")
        if (deque.isEmpty())
            break
        if (count.second > 0)
            for (i in 1 until count.second) // 위에서 removeFirst를 하기 때문에
                deque.add(deque.removeFirst())
        else
            for (i in 1..count.second.absoluteValue) //절대값
                deque.add(0,deque.removeLast())
    }
}
//fun main() {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val bw = BufferedWriter(OutputStreamWriter(System.out))
//    val str = StringBuilder()
//    br.readLine()
//    val deque = ArrayList<Pair<Int, Int>>()
//    br.readLine().split(" ").forEachIndexed { index, s ->
//        deque.add(Pair(index + 1, s.toInt()))
//    }
//    while (true) {
//        val count = deque.removeFirst()
//        str.append("${count.first} ")
//        if (deque.isEmpty())
//            break
//        if (count.second > 0)
//            for (i in 1 until count.second) // 위에서 removeFirst를 하기 때문에
//                deque.add(deque.removeFirst())
//        else
//            for (i in 1..count.second.absoluteValue) //절대값
//                deque.add(0,deque.removeLast())
//    }
//    bw.write(str.toString())
//    bw.flush()
//    bw.close()
//}