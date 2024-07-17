package com.kguard.tobecomebetter.baekjoon

// 플래티넘 5 가장 긴 증가하는 부분 수열 5
// 이분 탐색, 가장 긴 증가하는 부분 수열: o(n log n)
// 12015 같은 방식으로 풀지만 뒤에 출력하는 부분만 추가
// 가장 긴 증가하는 부분 수열에 위치 index를 저장하는 함수를 만들어서 인덱스 역순으로 출력
fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val divide = mutableListOf<Int>()
    val index = mutableListOf<Int>()
    divide.add(list[0]) // 실제 값이 들어갈 리스트
    index.add(0)
    for (i in 1 until n) {
        if (divide.last() < list[i]) { // 마지막 값보다 크면 넣고, 위치 인덱스를 추가
            divide.add(list[i]) // 리스트에 추가
            index.add(divide.size - 1) // 위치 인덱스 추가
        } else { // 아니면 새로운 값이 들어 갈 부분에 대한 이분 탐색
            var left = 0
            var right = divide.size
            var mid: Int
            while (left < right) {
                mid = (left + right) / 2
                if (divide[mid] < list[i])
                    left = mid + 1
                else
                    right = mid
            }
            divide[right] = list[i] // 새로운 값을 위치에 대치
            index.add(right)  // 위치 인덱스 추가
        }
    }
    var result = divide.size - 1 // 마지막 인덱스 값
    val ans = mutableListOf<Int>()
    for (i in n - 1 downTo 0) { // 기존 리스트를 역순으로 탐색
        if (result == index[i]) { // 마지막 인덱스 값과 위치 인덱스 값 비교
            ans.add(list[i]) // 그 부분의 실제 값 추가
            result-- // 마지막 인덱스 값 감소
        }
    }
    println(divide.size)
    ans.reversed().forEach { print("$it ") }
}