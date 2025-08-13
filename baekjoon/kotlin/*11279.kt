package com.kguard.tobecomebetter.baekjoon

import java.util.PriorityQueue

// 실버 2
// 우선 순위 큐, 자료 구조
// 최대 힙은 완전 이진 트리로 루트 노드가 제일 큰 값 이다
// 삽입 시에는 제일 마지막에 넣어서 위의 노드와 비교하며 자리를 바꿈
// 삭제시에는 루트 노드를 삭제하고 마지막 노트 값을 루트 노드로 이동, 두 자식 노드중 큰 값과 루트 노드와 비교해서 자리를 바꾸는 과정 반복
// 리스트로 표현시 부모 노트는 i 이고, 왼쪽 자식 노드는 i*2, 오른쪽 자식 노드는 i*2+1로 진행
fun main() {
    val n = readln().toInt()
    val queue = PriorityQueue<Int>(reverseOrder()) // 최대 힙이므로 우선순위 큐에서 내림차순으로 정리
    repeat(n) {
        val a = readln().toInt()
        if (a > 0) queue.add(a)
        else {
            if (queue.isEmpty())
                println(0)
            else
                println(queue.poll())
        }
    }
    /*val list = mutableListOf<Int>()
    repeat(n) {
        val a = readln().toInt()
        if (a > 0) list.add(a) else {
            if (list.isEmpty())
                println(0)
            else {
                list.sort()
                println(list.removeLast())
            }
        }
    }*/
}