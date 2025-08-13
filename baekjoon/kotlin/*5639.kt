package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

// 골드 4 이진 검색 트리
// 그래프 이론, 그래프 탐색, 트리, 재귀
// 2263, 1991과 비슷
// 전위 순위는 루트 -> 왼쪽 -> 오른쪽 순이니
// 리스트 맨 앞 값을 기준으로 작으면 왼족 서브트리, 크면 오른쪽 서브트리에 속해 있는거
// 루트 값을 기준으로 왼쪽과 오른쪽의 서브트리르 나누는 값을 구해서 각각 재귀 함수를 이용해서 왼쪽 부터 출력
fun main() {
    val preOrder = mutableListOf<Int>()
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val n = br.readLine() ?: break
        if (n == "") break
        preOrder.add(n.toInt())
    }
    fun postOrder(startIndex: Int, endIndex: Int) {
        if (startIndex >= endIndex) return
        if (startIndex == endIndex - 1) { // 마지막 서브 트리 인지 확인
            println(preOrder[startIndex])
            return
        }
        var middleIndex = startIndex + 1 // 오른쪽 서브트리의 시작점을 찾기 위한 변수
        while (middleIndex < endIndex) { // 오른쪽 서브트리의 시작점을 구하기 위해서 루트 노드 보다 큰 값이 나올때 까지 시작점 ++
            if (preOrder[startIndex] < preOrder[middleIndex]) break
            middleIndex++
        }
        // 후위 순회는 왼쪽 -> 오른쪽 -> 루트 순으로 출력 됨
        postOrder(startIndex + 1, middleIndex) // 왼쪽, 첫번재 값은 루트 노드이니 그 다음부터 오른쪽 서브 트리 시작 까지 재귀
        postOrder(middleIndex, endIndex) // 오른쪽, 오른쪽 서브 트리 시작 부터 마지막 까지 재귀
        println(preOrder[startIndex]) // 마지막 루트 출력
    }
    postOrder(0, preOrder.size)
}