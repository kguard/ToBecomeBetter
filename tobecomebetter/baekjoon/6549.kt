package com.kguard.tobecomebetter.baekjoon

import kotlin.math.*

// 플레티넘 5
// 분할 정복, 세그먼트 트리, 자료구조, 스택
// 1. 문제를 분할 정복으로 푸는 방법
// 2. 스택을 이용해서 푸는 방법
fun main() {
    while (true) {
        val n = readln().split(" ").map { it.toLong() }.toMutableList()
        if (n[0] == 0L) return
        val size = n.removeFirst().toInt()
        println(divideSol(n,0, size-1))
    }
}

// 1. 분할 정복을 이용해서 문제 해결
private fun divideSol(list: List<Long>, left: Int, right: Int): Long {
    if (right == left)
        return list[right] // 왼쪽과 오른쪽이 같으면 넓이는 1이니 높이만 리턴
    val mid = (left + right) / 2 // 리스트에서 중간 값을 구하기
    val leftArea = divideSol(list, left, mid) // 왼쪽 부분의 최대 넓이 구하기
    val rightArea = divideSol(list, mid + 1, right) // 오른쪽 부분의 최대 넓이 구하기
    var max = max(leftArea, rightArea) // 둘중 큰 값 구하기
    max = max(max, divideSolMid(left, right, mid, list))  // 각 부분의 최대 값과 범위 내에서 이어진 부분끼리의 최대값 구하기
    return max
}
// 높이를 중간부터 시작하여서 왼족과 오른쪽을 비교해서 더 큰 높이로 이동한다음, 이동한 높이와 기존의 높이중 더 작은 높이를 선택
// 왼쪽이나 오른쪽 끝으로 가게되면 최대 넓이 구하기
// 남은 한쪽의 끝까지 가서 전체 너비를 이용해서 구한 넓이와 비교
private fun divideSolMid(left: Int, right: Int, mid: Int, list: List<Long>): Long { // 중간 지점에서 시작하여 최대 넓이 구하기
    var height: Long = list[mid] // 초기 높이는 중간값
    var max = height // 초반에 최대 넓이
    var toLeft = mid // 왼쪽으로 이동할 변수
    var toRight = mid // 오른쪽으로 이동할 변
    while (left < toLeft && toRight < right) { // 왼쪽 끝이나 오른쪽 끝까지 갈때 까지 반복
        if (list[toLeft - 1] < list[toRight + 1]) { // 오른쪽의 높이가 더 큰 경우
            toRight++ // 오른쪽으로 한칸 이동
            height = min(height, list[toRight]) // 기존 높이와 새로운 높이중 더 작은거 선택
        } else { // 왼쪽의 높이가 더 큰 경우
            toLeft-- // 왼쪽으로 한칸이동
            height = min(height, list[toLeft]) // 기존 높이와 새로운 높이중 더 작은거 선택
        }
        max = max(max, height * (toRight - toLeft + 1)) // 왼쪽 끝이나 오른쪽 끝으로 도달했을경우 최대 넓이 구하기
    }
    while (toRight < right) { // 오른쪽으로 도달하지 않았을 때
        toRight++ // 오른쪽으로 한칸 이동
        height = min(height, list[toRight]) // 기존 높이와 새로운 높이중 더 작은거 선택
        max = max(max, height * (toRight - toLeft + 1)) // 한칸 이동후 최대 넓이 구해서 비교
    }
    while (left < toLeft) { // 왼쪽으로 도달하지 않았을 때
        toLeft-- // 왼쪽으로 한칸 이동
        height = min(height, list[toLeft]) // 기존 높이와 새로운 높이중 더 작은거 선택
        max = max(max, height * (toRight - toLeft + 1)) // 한칸 이동후 최대 넓이 구해서 비교
    }
    return max
}

