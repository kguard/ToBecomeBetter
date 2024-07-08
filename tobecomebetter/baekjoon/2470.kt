package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*

// 골드 5 두 용액
// 정렬, 이분 탐색, 투 포인터
// 0 과 가까운 수를 찾는 과정이기 때문에 절대 값으로 찾기
fun main(){
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toLong() }.sorted()
    var start = 0
    var end = n-1
    var count = Pair(0,0)
    var min = 2000000000L // 최대 값으로 설정
    while(start < end){
        if(min > abs(list[start]+list[end])){ // 절대 값이 min보다 작으면 -> 0에 더 가까워질수록
            min = abs(list[start] + list[end]) // 숫자 변경
            count = Pair(start, end) // 인덱스 추가
        }
        if(list[start] + list[end] <= 0L) start++
        else end--
    }
    print("${list[count.first]} ${list[count.second]}")
}