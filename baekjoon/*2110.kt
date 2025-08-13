package com.kguard.tobecomebetter.baekjoon

//골드 4
// 이분탐색, 매개변수 탐색
fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<Long>()
    repeat(n) {
        list.add(readln().toLong())
    }
    list.sort()
    println(parametricSearch(list, c))
}
// 거리를 이용한 이분 탐색을 진행
// 최소 거리는 1 최대 거리는 리스트의 처음과 마지막 차 + 1 로 계산하여
// 거리마다 설치할 수 있는 공유기의 갯수를 검색하여 구하기
private fun parametricSearch(list: List<Long>, search: Int): Long {
    var left = 1L // 두 집 사이의 최소 거리
    var right = list.last() - list.first() + 1// 두 집 사이의 최대 거리
    var mid: Long
    while (left < right) {
        mid = (left + right) / 2
        var prev = list[0] // 공유기가 설치된 이전 집 -> 맨 처음 위치에 공유기 설치
        var count = 1 // 공유기 갯수
        for (i in 1 until list.size) {
            if (list[i] - prev >= mid) {  // 두개의 집 사이의 거리가 설정했던 거리보다 클 경우 -> 공유기 설치 가능
                count++ // 공유기 설치
                prev = list[i] // 공유기가 설치된 이전 집 변경
            }
        }
        if (count >= search) { // 주어진 공유기 개수보다 같거나 더 많이 사용한 경우 -> 설정한 거리가 맞거나 짧은 상황
            left = mid + 1 // 거리를 늘리기 위하여 왼쪽 값을 중간 값 다음으로 이동
        } else { // 주어진 공유기 갯수보다 더 적게 공유기를 사용한 경우 -> 설정한 거리가 너무 긴 경우
            right = mid // 거릴르 줄이기 위하여 오른쪽 값을 중간 값으로 이동
        }
    }
    return right - 1
}