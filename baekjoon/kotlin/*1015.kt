package com.kguard.tobecomebetter.baekjoon

// 실버 4 수열 정열
// 정렬
// 입력 받은 숫자의 순서를 입력 받은 순으로  저장 해야 되는 문제

// B[P[0]] = A[0] -> B[1] = 2
// B[P[1]] = A[1] -> B[2] = 3
// B[P[2]] = A[2] -> B[0] = 1
// B를 나열하면 1 2 3 이 됨

// P 수열은 A 수열의 각 숫자가 몇번째로 작은지를 0부터 정리한 수열임
// 예를 들면, 3 7 2 1 5가 A 수열로 주어진다고 할 때, P 수열은 2 4 1 0 3이 됨

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() } // 일력받은 a
    val aSort = a.sorted().toMutableList() // a를 정렬한것 -> 인덱스를 통하여 각 숫자에 대한 순서를 알 수 있음
    val p = mutableListOf<Int>()
    a.forEach { // a의 각각의 수에 대해서
        p.add(aSort.indexOf(it)) // 숫자에 대한 순서를 추가
        aSort[aSort.indexOf(it)] = -1 // 순서를 추가한 숫자는 -1로 바꾸어 중복되지 않게 만듬 (중복된 숫자가 존재하기 때문에)
    }
    p.forEach { print("$it ") }
}