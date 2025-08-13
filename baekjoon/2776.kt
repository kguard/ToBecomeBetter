package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 실버 4 암기왕
// 자료 구조, 정렬, 이분 탐색, 해시를 사용한 집합과 맵
// lowerBound : 찾으려는 값 보다 (이상의 값) 크거나 같은 값이 처음 나오는 위치 반환
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    repeat(t) {
        val stringBuilder = StringBuilder()
        val n = br.readLine().toInt()
        val note1 = br.readLine().split(" ").map { it.toInt() }.sorted()
        val m = br.readLine().toInt()
        val note2 = br.readLine().split(" ").map { it.toInt() }
        for (i in note2) {
            stringBuilder.append(lowerBound(note1, i)).append("\n")
        }
        bw.write(stringBuilder.toString())
    }
    bw.flush()
    bw.close()
}

private fun lowerBound(arr: List<Int>, search: Int): Int {
    var left = 0 // 초기 값
    var right = arr.size - 1// 마지막 값
    var mid: Int
    while (left < right) {
        mid = (left + right) / 2 // 중간 구하기
        if (arr[mid] < search) // 중간 값이 찾는 값 보다 작으면 -> 같은 값을 찾아도 되기 때문에 그만 진행
            left = mid + 1 // 왼쪽의 작은 값을 중간값 바로 다음으로 이동
        else // 중간 값이 찾는 값보다 크거나 같으면 search >= arr[mid]
            right = mid //오른쪽 값을 중간 값으로 이동
    }
    return if (arr[right] == search) 1 else 0
//    return right //오른쪽 값 반환
}
