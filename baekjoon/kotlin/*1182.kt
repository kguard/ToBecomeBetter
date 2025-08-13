package com.kguard.tobecomebetter.baekjoon

// 실버 2 부분수열의 합
// 브루트포스 알고리즘, 백트래킹
// 부분수열을 구해서 문제를 해결하기 보다는 각 인덱스에 해당하는 수를 넣는지 넣지 않는지로 생각해서 문제를 해결해야 됨
// 숫자를 넣느냐 안 녛느냐로 생각한거에 있어서 다른 시각으로 문제를 봤어야 함
fun main() {
    val (n, s) = readln().split(" ").map { it.toInt() }
    val num = readln().split(" ").map { it.toInt() }
    println(backtracking1(num, n, s))
    println(dfs(num, n, s))
}


// 해당 숫자를 하나씩 넣었다 빼며 부분 수열을 구하며 문제를 푸는 방법
// 모든 숫자를 넣았다가 하나씩 지우는 방식으로 돌아감
private fun backtracking1(num: List<Int>, n: Int, s: Int): Int {
    var cnt = 0
    val answer = mutableListOf<Int>()
    fun solve(start: Int) {
        if (answer.sum() == s && answer.isNotEmpty())
            cnt++
        for (i in start until n) {
            answer.add(num[i])
            solve(i + 1)
            answer.removeAt(answer.lastIndex)
        }
    }
    solve(0)
    return cnt
}

// 각 숫자를 넣었을 경우, 안 넣었을 경우를 바로바로 구하여 문제를 푸는 방법
// 가지 뻣기 느낌으로 경우의 수가 퍼저 나감
// 예로 5개로는 32개의 결과가 생김
// 백트래킹보다는 dfs의 느낌
private fun dfs(num: List<Int>, n: Int, s: Int): Int {
    var cnt = 0
    fun dfs1(depth: Int, sum: Int) {
        if (depth == n) {
            if (sum == s) // 끝까지 도달했는데 숫자를 만족하면 추가
                cnt++
            return // 끝까지 도달하면 return
        }
        dfs1(depth + 1, sum + num[depth]) // 해당 위치의 숫자를 넣은 경우
        dfs1(depth + 1, sum) // 해당 위치의 숫자를 넣지 않은 경우
    }
    dfs1(0, 0)
    if (s == 0) cnt-- // 아무것도 안넣은 경우는 세면 안되기 때문에 -> 부분 수열의 크기는 문제에서 양수라고 함, s가 0이면 아무것도 안들어갔을 때도 만족함
    return cnt
}