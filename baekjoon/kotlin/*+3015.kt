package com.kguard.tobecomebetter.baekjoon

import java.util.Stack

// 플래티넘 5 오아시스 재결합
// 자료 구조, 스택
// 스택에 내림차순으로 저장을 하는 방식으로 진행
// 입력값이 스택에 맨 위에 값보다 크거나 같으면 어쩌피 뒤로는 보지 못하니 입력값보다 큰 값이 나올 때 까지 pop을 하면서 갯수 증가
// 같은 값이 나올 경우 같은 값은 볼 수 있으니 범위 안에서의 중복 갯수 체크
data class Pair2(var first:Int, var second: Int)
fun main() {
    val n = readln().toInt()
    val stack = Stack<Pair2>()
    var count = 0L
    for (i in 0 until n) {
        val pair = Pair2(readln().toInt(), 1) // 처음에는 중복이 없으니 1개
        while (stack.isNotEmpty() && stack.peek().first <= pair.first){ // 입력값이 스택의 맨 위의 값보다 크거나 같으면 진행
            val p = stack.pop() // 스택의 맨위에 값 제거
            count += p.second // 같은 값이 나올 수 있기 때문에 체크 하면서 같은 값 제거, 중복된 값으로 더해줌
            if(p.first == pair.first) // 같은 값이 나올 경우
                pair.second += p.second // 중복된 값을 더 해줌 이후에 들어갈 값에다가
        }
        if (stack.isNotEmpty()) // 비어져 있지 않으면 현재 값과 남아 있는 값의 쌍이 하나 생김
            count++
        stack.add(pair) // 현재 값 스택에 추가
    }
    println(count)
}


// 시간 초과
//fun main() {
//    val n = readln().toInt()
//    val list = mutableListOf<Int>()
//    var count = 0
//    repeat(n) {
//        list.add(readln().toInt())
//    }
//    for(i in 0 until n-1) {
//        for (j in i + 1 until n) {
//            var a = true
//            for (t in i+1 until j)
//                if (list[t] > list[i] || list[t] > list[j])
//                    a = false
//            if(a)
//                count++
//        }
//    }
//    println(count)
//}