package com.kguard.tobecomebetter.baekjoon

// 실버 3 선분 위의 점
// 정렬, 이분 탐색
// (선분 제일 마지막값 보다 큰값이 처음 나오는 위치) - (선분 제일 처음값과 같거나 큰 값이 처음 나오는 위치) = 선분위에 있는 점의 갯수
// upperBound : 찾으려는 값 보다 (초과한 값) 큰 값이 처음 나오는 위치 반환
// lowerBound : 찾으려는 값 보다 (이상의 값) 크거나 같은 값이 처음 나오는 위치 반환
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val spots = readln().split(" ").map { it.toInt() }.sorted()
    repeat(m) {
        val (start, last) = readln().split(" ").map { it.toInt() }
        println(upperBound(spots,last) - lowerBound(spots,start))
    }
}

private fun lowerBound(arr: List<Int>, search: Int): Int {
    var left = 0 // 초기 값
    var right = arr.size // 마지막 값
    var mid: Int
    while (left < right) {
        mid = (left + right) / 2 // 중간 구하기
        if (arr[mid] < search) // 중간 값이 찾는 값 보다 작으면 -> 같은 값을 찾아도 되기 때문에 그만 진행
            left = mid + 1 // 왼쪽의 작은 값을 중간값 바로 다음으로 이동
        else // 중간 값이 찾는 값보다 크거나 같으면 search >= arr[mid]
            right = mid //오른쪽 값을 중간 값으로 이동

    }
    return right //오른쪽 값 반환
}

private fun upperBound(arr: List<Int>, search: Int): Int {
    var left = 0
    var right = arr.size // 중간 구하기
    var mid: Int
    while (left < right) {
        mid = (left + right) / 2
        if (arr[mid] <= search) // 중간 값이 찾는 값 보다 작거나 같으면 -> 큰 값을 찾아야 되기 때문에 한번더 진행
            left = mid + 1 // 왼쪽의 작은 값을 중간값 바로 다음으로 이동
        else // 중간 값이 찾는 값보다 크면 search > arr[mid]
            right = mid  //오른쪽 값을 중간 값으로 이동
    }
    return right  //오른쪽 값 반환
}