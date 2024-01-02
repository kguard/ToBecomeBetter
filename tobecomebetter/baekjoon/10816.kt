package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 정렬된 상태에서만 가능
// upperBound : 찾으려는 값 보다 큰 값이 처음 나오는 위치 반환
// lowerBound : 찾으려는 값 보다 크거나 같은 값이 처음 나오는 위치 반환
fun lowerBound(arr: List<Int>, search: Int): Int {
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

fun upperBound(arr: List<Int>, search: Int): Int {
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

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    br.readLine()
    val numCard =  br.readLine().split(" ").map { it.toInt() }.sorted()
    br.readLine()
    val numCheck =  br.readLine().split(" ").map { it.toInt() }
    for (i in numCheck) {
        bw.write("${upperBound(numCard,i)- lowerBound(numCard,i)} ") // numCheck의 값이 numCard에 있는 값보다 큰 위치 - 크거나 같은 위치 -> 갯수 출력 가능
    }
    bw.flush()
    bw.close()
}