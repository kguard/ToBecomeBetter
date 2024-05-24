package com.kguard.tobecomebetter.baekjoon

// 골드 5 동전1
// 다이나믹 프로그래밍
// 순서대로 동전의 가짓수가 늘어날때 마다 하나 씩 추가하는 방식
// dp[n] = dp[n] + dp[n - 현재 사용하는 동전의 종류 ] -> 점화식
// 현재 만들려는 값 에서 동전의 종류를 뺀 인덱스를 구하면, 그 값에서 현재 사용하는 동전의 종류를 하나씩 더한 값이 나옴 + 원래 만들 수 있었던 경우의 수
// 예를 들어 1,2 종류에서 4를 만들려고 할때 , 4 - 2 = 2로 2를 만들수 있는 경우의 수는 1+1, 2 2개에 모두 2를 더하면 4가 됨 -> 1+1+2, 2+2 로 두 가지
// 기존에 1로 4를 만드는 경우의 수는 1+1+1+1로 한가지
// 2+1로 3가지 경우의 수 생성
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<Int>()
    repeat(n) {
        list.add(readln().toInt())
    }
    list.sort()
    val dp = Array(k + 1) { 0 }
    dp[0] = 1
    for (i in 0 until n) // 가짓수를 뜻함
        for (j in list[i]..k) { // 어쩌피 list[i] 보다 작은 값은 기존 값이랑 같으니 list[i] 번째 부터 시작
            dp[j] += dp[j - list[i]] // dp[j] = dp[j](기존의 만들수 있는 경우의 수)  + dp[j - 현재 사용하는 동전의 종류 -> list[i]] 를 뜻함 ( 원하는 값 - 현재 사용하는 동전의 종류 에서 현재 사용하는 동전의 종류를 하나씩 더하면 됨)
        }
    println(dp[k])
}