package com.kguard.tobecomebetter.baekjoon.kotlin

import java.util.Stack
// 골드 4 압축
// 스택을 이용해서 괄호를 풀어내기 -> 한번에 풀지 말고 한글자씩 인식함
fun main() {
    val n = readln()
    val stack = Stack<Pair<Int, Int>>() // 현재 저장된 글자의 길이 , 마지막 반복할 횟수 (한자리)
    var currentLength = 0 // 현재 저장된 글자의 길이
    for (i in n.indices) { // 하나의 글자를 하나씩 조회
        when (n[i]) { // 각 글자에 대해서
            '(' -> {
                stack.push(currentLength - 1 to n[i - 1].digitToInt()) // (현제 저장된 글자 -1, '(' 바로 전 숫자 ) -> 마지막 글자는 반복해야할 숫자 이기 때문에
                currentLength = 0 // 글자 수 초기화
            }

            ')' -> {
                val pop = stack.pop() // 뽑기
                currentLength = currentLength * pop.second + pop.first // 현재 저장된 글자 수 * 마지막 숫자 + 그 앞에있는 글자수들
            }

            else -> { // 숫자가 나오면
                currentLength++ // 길이 추가
            }
        }
    }
    println(currentLength)
}

