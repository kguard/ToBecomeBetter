package com.kguard.tobecomebetter.baekjoon

// 실버 2 과자 나눠주기
// 이분 탐색, 매개 변수 탐색
fun main(){
    val (m,n) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toLong() }
    println(parametricSearch(list,m))
}
private fun parametricSearch(list: List<Long>, search: Int): Long {
    var left = 1L // 막대 과자 길이의 최소값은 1 임
    var right = list.max()+1 // 최대 길이는 막대 과자가 제일 긴 경우
    var mid: Long
    var sum: Long
    while (left < right) {
        mid = (left + right) / 2
        sum = 0
        for (i in list)
            sum += i/mid
        if (sum >= search) // 갯수가 n개 보다 많을 때 길이를 늘려 봐야함 -> 제시하는 숫자를 만족하여도 최대 길이를 구해야하니 제시하는 숫자 보다 하나클때의 길이 -1 을 구하면 됨
            left = mid + 1
        else // 갯수가 n개 보다 적을 때 길이를 줄여봐야 함
            right = mid
    }
    return  right-1
}