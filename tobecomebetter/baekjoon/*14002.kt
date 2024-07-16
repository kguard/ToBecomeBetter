package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 골드 4 가장 긴 증가하는 부분 수열 4
// 다이나믹 프로그래밍(dp)
// 11053과 같은 방식으로 풀지만 뒤에 출력하는 부분만 추가
// 리스트를 뒤에서 부터 확인하면서 제일 큰 dp에서 하나씩 감소하는 식으로 진행
fun main(){
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val dp = MutableList(n){1}
    for (i in 0 until n) { // 마지막 값일때 기준
        for (j in 0 until i) { // 마지막 값일때 이니 작을때 까지
            if (list[i] > list[j]) // 마지막 값이 이전 값보다 클때 -> 갯수가 늘어야함
            {
                dp[i] = max(dp[i], dp[j] + 1) // 이미 포함된 숫자들을 포함 시키지 않기 위해서 길이 비교
            }
        }
    }
    var result = dp.max()
    val rlist = mutableListOf<Int>() // 가장 긴 증가하는 부분 수열이 들어갈 리스트
    for(i in n-1 downTo 0){ // dp를 마지막부터 확인
        if(result == dp[i]) { // result가 dp 값과 일치하는지 확인
            rlist.add(list[i]) // 맞으면 숫자 추가
            result-- // result - 1
        }
    }
    println(dp.max())
    for(i in rlist.reversed())
        print("$i ")
}