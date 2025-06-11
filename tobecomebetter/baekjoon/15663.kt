package com.kguard.tobecomebetter.baekjoon

// 실버 2 N과 M (9)
// 백트래킹
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.sorted()
    val answer = mutableListOf<Int>()
    val result = mutableSetOf<List<Int>>()
    fun backtracking(depth: Int) {
        if (depth == m) {
            result.add(answer.map { list[it] }.toList()) // 인덱스를 저장해 놨기 때문에 result에 들어갈 떄는 바꿔줌
            return
        }
        for (i in 0 until n)
            if (i !in answer) {
                answer.add(i) // list 내에 같은 숫자가 있을 수 있어서 구분하기 위해 인덱스를 사용
                backtracking(depth + 1)
                answer.removeAt(answer.lastIndex)
            }
    }
    backtracking(0)
    result.forEach {
        it.forEach { print("$it ") }
        println()
    }
}
