package com.kguard.tobecomebetter.baekjoon

// 실버 2 수열의 합
// 수학
// 계속된 식으로 규칙성과 일반식을 찾아서 풀어야 하는 문제
// (숫자 개수) * (맨 처음 시작될 숫자) + (숫자 개수 -1 까지의 합) == 원하는 값 이 나와야 성립이 됨
fun main() {
    val (n, l) = readln().split(" ").map { it.toInt() }
    for (i in l..100) { // 문제에서 l의 범위는 2 부터 100 까지임
        val list = mutableListOf<Int>() // 연속된 숫자가 들어갈 리스트
        var sigma = 0
        repeat(i) { // 숫자 개수 -1 까지의 합
            sigma += it
        }
        val start = (n - sigma) / i // 맨 처음 시작될 숫자
        var find = 0 // 맨 처음 시작될 숫자부터 i의 개수 만큼 더했을 때의 결과를 볼 변수
        if (start < 0) { // 처음 시작이 음수가 나왔으면 그 이후도 계속해서 음수가 나올 것이기 때문에 처음 숫자가 0보다 작으면 -1 출력
            println(-1)
            return
        }
        repeat(i) { // 맨 처음 시작될 숫자 부터 i개의 숫자를 더하는 과정
            list.add(start + it)
            find += start + it
        }
        if (find == n) { // 더했던 결과와 원하는 숫자가 같으면 출력
            list.forEach { print("$it ") }
            return
        }
        if (i == 100) // 마지막 100번째 까지 왔는데 만족하는 처음 숫자가 없으면 -1 출력
            println(-1)
    }
}
