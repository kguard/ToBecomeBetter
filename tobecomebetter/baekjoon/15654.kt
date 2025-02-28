package com.kguard.tobecomebetter.baekjoon

// 실버 3 N과 M (5)
// 백트래킹(끝까지 내려갔다가 하나씩 다시 올라오는 재귀 과정 dfs)

//fun main() {  // 내가 푼 방식 -> visit 배열을 만들어서 넣었다고 판단하면 true로 바꿔서 중복 안되게 함
//    val (n, m) = readln().split(" ").map { it.toInt() }
//    val list = readln().split(" ").map { it.toInt() }.sorted()
//    val visit = MutableList(n) { false }
//    var answer = mutableListOf<Int>()
//    fun dfs(now: Int, depth: Int) {
//        answer.add(now)
//        if (depth == m) {
//            answer.forEach { print("$it ") }
//            println()
//            return
//        }
//        for(i in 0 until n) {
//            if (visit[i])
//                continue
//            visit[i] = true
//            dfs(list[i],depth+1)
//            visit[i] = false
//            answer.removeAt(answer.lastIndex)
//        }
//    }
//    for(i in list.indices) {
//        answer = mutableListOf()
//        visit[i] = true
//        dfs(list[i],1)
//        visit[i] = false
//    }
//}

// 검색한 방법 -> answer 리스트 자체에서 중복된 숫자가 있는지 검색후 리스트에서 숫자를 넣었다 빼는식으로 작동
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.sorted()
    val answer = mutableListOf<Int>()

    fun backtracking(depth: Int) {
        if (depth == m) {
            answer.forEach { print("$it ") }
            println()
            return
        }
        for (i in 0 until n) {
            if (list[i] in answer)
                continue
            answer.add(list[i])
            backtracking(depth + 1)
            answer.removeAt(answer.lastIndex)
        }
    }
    backtracking(0)
}