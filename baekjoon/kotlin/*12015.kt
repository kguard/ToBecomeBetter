package com.kguard.tobecomebetter.baekjoon

// 골드 2
// 이분 탐색, 가장 긴 증가하는 부분 수열 2
// 이분 탐색을 배열에서 숫자 대치 하는데에서 사용함
// 길이만 구하는데 사용할 수 있음
// lis가 비어 있으면 맨 처음 숫자를 추가, 그 다음에 각 값을 lis와 비교 하는데
// 이분 탐색을 통하여 값을 비교하여 lis에서 찾는 값보다 같거나 큰 숫자가 나오는 위치에 찾는 값을 대치함
fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val lis = mutableListOf<Int>() // 제일 긴 수열
    lis.add(list[0]) // 처음에는 비어 있으니 추가
    for (i in 1 until n) { // 1 부터 끝까지
        if (list[i] > lis.last()) lis.add(list[i]) // lis의 마지막 값보다 크면 마지막에 추가
        else { // 작으면 lis에서 찾는 값보다 같거나 큰 숫자가 나오는 위치에 찾는 값을 대치 -> 이분 탐색 사용
            var left = 0
            var right = lis.size
            var mid: Int
            while (left < right) {
                mid = (left + right) / 2
                if (lis[mid] < list[i]) // lowerBound를 사용
                    left = mid + 1
                else
                    right = mid  //찾는 값보다 큰 가장 가까운 값을 찾아야 해서 -> 같거나 큰 값
            }
            lis[right] = list[i] // 숫자 대치
        }
    }
    println(lis.size)
}