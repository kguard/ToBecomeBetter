package com.kguard.tobecomebetter.baekjoon

// 실버 3 두 수의 합
// 정렬, 투 포인터
// 1차원 배열의 두 지점을 정해 놓고 움직이면서 원하는 결과를 얻을 때 까지 반
// 리스트에 순차적으로 접근
// 리스트의 시작과 끝을 정해 놓고
// 1. 두 값을 더해서 원하는 값이면 count++
// 2-1. 두 값을 더했을때 원하는 값과 같거나 작으면 시작을 오른쪽으로 이동
// 2-2. 두 값을 더했을때 원하는 값보다 크면 마지막을 왼쪽으로 이동
// 시작과 끝이 같거나 작을때 까지 반복
fun main(){
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()
    val x = readln().toInt()
    var count = 0
    var start = 0
    var end = n-1
    while(start < end){
        if(list[start]+list[end] == x) count++
        if(list[start] + list[end] <= x) start++
        else end--
    }
    println(count)
}