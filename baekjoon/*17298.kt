package com.kguard.tobecomebetter.baekjoon

import java.util.Stack

// 골드 4 오큰수
// 자료구조, 스택
// 인덱스를 스택에 저장하여 문제 해결

// 이중 for문으로 해결 하였을 경우에는 시간 초과
//fun main() {
//    val n = readln().toInt()
//    val list = readln().split(" ").map { it.toInt() }
//    for (i in 0 until n) {
//        for (j in i  until n) {
//            if (list[i] < list[j]) {
//                print("${list[j]} ")
//                break
//            }
//            if(j == n-1)
//                print("-1 ")
//        }
//    }
//}

// 스택을 사용해서 문제 해결
// 스택에 인덱스들을 저장하는 방식으로 사용
// 스택이 비어 있지 않고 스택의 마지막 값에 대단 list 값이 현재 list 값 보다 작으면
// 스택 값을 빼면서 list의 값을 현재 값으로 변경
fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.toIntArray()
    val stack = Stack<Int>()
    for (i in 0 until n) {
        while (stack.isNotEmpty() && list[stack.peek()] < list[i]) {  // 스택이 비어있지 않고, 스택의 마지막 값에 대한 list 값과 현재 인덱스의 list 값 비교
            list[stack.pop()] = list[i] // 마지막 인덱스 값을 제거 한 후, 인덱스 값에 해당되는 list 값을 현재의 값으로 변경
        }
        stack.push(i) // 인덱스 저장
    }
    while (stack.isNotEmpty()) // 다 돈후에도 스택이 비워져 있지 않으면 그 위치에 list 값들은 -1로 변경
        list[stack.pop()] = -1
    val sb = StringBuilder()
    for (i in list)
        sb.append("$i ")
    println(sb)
}
