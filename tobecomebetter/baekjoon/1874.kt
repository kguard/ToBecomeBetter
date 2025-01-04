package com.kguard.tobecomebetter.baekjoon

import java.util.Stack

// 실버 2 스택 수열
// 자료 구조, 스택
// 내가 해결한 방식
// 1. 스택에서 추가한 최대 숫자를 하나 지정해서 주어진 숫자 보다 작으면 스택에 숫자 push
// 2. 스택 맨위 숫자 - 주어진 숫자 + 1 만큼 반복하는 과정에서 주어진 숫자가 나올때 까지 pop
// 0. 주어진 숫자가 최대 숫자 보다 작은데, 스택안에 없으면 NO
// 찾아본 더 쉬운 방법
// 1. 스택에서 추가한 최대 숫자를 하나 지정해서 주어진 숫자 보다 작으면 스택에 숫자 push
// 2. 맨위 숫자를 확인해서 주어진 숫자면 pop, 아니면 NO 리턴 (주어진 수열이 성립되기 위해서는 이미 push된 상태에서 맨위의 숫자가 주어진 숫자여야 됨)

// 내가 해결한 방식
//fun main() {
//    val n = readln().toInt()
//    val stack = Stack<Int>()
//    val answer = mutableListOf<String>()
//    var up = 0
//    repeat(n) {
//        val a = readln().toInt()
//        if (up > a && stack.search(a) == -1) {
//            println("NO")
//            return
//        }
//        if (up < a) {
//            for (i in up + 1..a) {
//                stack.add(i)
//                answer.add("+")
//            }
//            up = a
//        }
//        for(i in 0 until stack.peek() - a + 1){
//            val t = stack.pop()
//            answer.add("-")
//            if(t == a) break
//        }
//    }
//    answer.forEach { println(it) }
//}

// 찾아본 더 쉬운 방법
fun main() {
    val n = readln().toInt()
    val stack = Stack<Int>()
    val answer = mutableListOf<String>()
    var up = 0
    repeat(n) {
        val a = readln().toInt()
        if (up < a) {
            for (i in up + 1..a) {
                stack.add(i)
                answer.add("+")
            }
            up = a
        }
        if (stack.peek() == a) { // 위에서 push를 했기 떄문에 맨위 숫자가 주어진 숫자여야 수열이 성립됨
            stack.pop()
            answer.add("-")
        } else {
            println("NO")
            return
        }
    }
    answer.forEach { println(it) }
}

