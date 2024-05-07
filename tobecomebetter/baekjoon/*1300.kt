package com.kguard.tobecomebetter.baekjoon

// 골드 1
// 이분 탐색, 매개 변수 탐색
// 각 배열의 열은 각 인덱스의 단(구구단)을 나타 내는 것
// 구하려는 수보다 작거나 같은 원소의 갯수가 두번째 숫자를 의미
// 우리가 구해야할 수 / 각 단의 합 = 두번째 숫자를 의미
// 두번째 숫자(인덱스)가 의미하는 바는 우리가 구해야 하는 수보다 작은 숫자의 갯수를 의미
// 우리가 구해야 하는 수는 첫번째 숫자의 제곱을 넘지 못함 -> 어쩌피 마지막이 첫번째 숫자의 제곱 이기 때문

// upperBound : 찾으려는 값 보다 (초과한 값) 큰 값이 처음 나오는 위치 반환
// lowerBound : 찾으려는 값 보다 (이상의 값) 크거나 같은 값이 처음 나오는 위치 반환
// lowerBound
fun main() {
    val n = readln().toInt()
    val k = readln().toInt()
    var left = 1
    var right = k
    var mid: Int
    while (left < right) {
        mid = (left + right) / 2
        var count = 0L // 구해야 할 수 보다 작거나 같은 수의 총 갯수
        for (i in 1..n)
            count += if (mid / i > n) n else mid / i
        if (count < k) // 구해야 할 수 보다 작거나 같은 수가 원하는 수보다 적을 경우 -> 인덱스가 작다 -> 숫자의 갯수가 부족하다는 의미 -> 구해야할 수를 높여야됨
            left = mid + 1
        else // 구해야 할 수 보다 크거나 같은 경우 -> 인덱스가 크거나 같다 -> 숫자의 갯수가 많거나 같은 경우 -> 구해야 할 수를 줄여야됨
            right = mid
        println("count: $count left: $left right: $right")
    }
    println(right)
}