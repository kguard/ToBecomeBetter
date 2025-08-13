package com.kguard.tobecomebetter.baekjoon

import kotlin.math.min

// 골드 4 부분합
// 누적 합, 투 포인터
// start와 end를 같은 값으로 설정한 다음
// 주어진 값보다 커질 때 까지 end를 증가 한 후
// 주어진 값보다 커지면 길이를 구하고, 부분 합에서 시작의 값을 제거하는 식으로 start의 위치를 변경
fun main(){
    val (n,s) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    var end = 0
    var count = n+1
    var sum = 0
    for(i in 0 until n){ // start 부분을 오른쪽으로 무조건 움직임
        while(sum < s && end < n){ // 합이 주어진 수 보다 작고, end가 끝을 넘지 않을때 까지 반복
            sum += list[end] // 숫자 다 더하기
            end++
        }
        if(sum >= s)
            count = min(count, end-i) // 합이 주어진 수보다 크거나 같으면, 부분합의 길이 구해서 최소값 비교
        sum -= list[i] // start를 옮기기 위하여 부분 합에서 처음 값을 제거하여 start 움직임
    }
    if(count > n)
        println(0)
    else
        println(count)
}