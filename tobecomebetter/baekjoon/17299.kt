package com.kguard.tobecomebetter.baekjoon

import java.util.Stack

// 골드 3 오등큰수
// 자료구조, 스택
// 17298과 같은 방식으로 작동
// 갯수를 세어놓은 리스트 따로 작성
// 스택의 인덱스를 저장하는 방식을 사용
fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.toMutableList()
    val count = list.groupingBy { it }.eachCount() // 각 별로 갯수를 세어서 놓음 map
    val stack = Stack<Int>()
    for (i in 0 until n) {
        while (stack.isNotEmpty() && count[list[stack.peek()]]!! < count[list[i]]!!) // 스택이 비어 있지 않고, 스택의 마지막 값에 해당하는 list 값의 갯수 보다 현재 값에 해당하는 list 값의 갯수가 많으면 반복
            list[stack.pop()] = list[i] // 스택의 마지막 값에 해당하는 list 값을 변경
        stack.push(i) // 스택에 현재 인덱스 추가
    }
    while (stack.isNotEmpty()) // 스택이 빌 때까지 인덱스에 해당되는 list 값 -1로 변경
        list[stack.pop()] = -1
    val sb = StringBuilder()
    for (i in list)
        sb.append("$i ")
    println(sb)
}