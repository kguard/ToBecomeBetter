package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

// 실버 2 에디터
// 자료 구조, 스택, 연결 리스트
// 연결리스트와 반복자 Iterator를 이용해서 문제를 해결
// 다른 방식은 시간 초과
// 기본 Iterator 는 next() 만 존재하며, 초기값은 0
// ListIterator 는 커서처럼 움직이며 previous()로 앞으로 움직이고, next()로 뒤로 이동하며 has~~()로 확인도 가능
// MutableListIterator 는 remove()와 add() 가능
// 반복자는 컬렉션의 기본 구조를 노출하지 않고도 요소에 순차적으로 액세스할 수 있는 객체입니다. 반복자는 컬렉션의 모든 요소를 하나씩 처리해야 할 때 유용합니다. 예를 들어 값을 인쇄하거나 비슷한 업데이트를 합니다.

// 25.10.10 다시 풀기
fun main() {
    val list = LinkedList<String>()
    val start = readln().forEach { list.add(it.toString()) }
    val cursor = list.listIterator(list.size)
    val n = readln().toInt()
    repeat(n) {
        val r = readln().split(" ")
        when (r[0]) {
            "L" -> {
                if (cursor.hasPrevious()) cursor.previous()
            }

            "D" -> {
                if (cursor.hasNext()) cursor.next()
            }

            "B" -> {
                if (cursor.hasPrevious()) {
                    cursor.previous()
                    cursor.remove()
                }
            }

            "P" -> {cursor.add(r[1])}
        }
    }
    println(list.joinToString(""))
}
/*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val a = br.readLine()
    val list = LinkedList<String>() // 연결리스트 사용
    a.forEach { list.add(it.toString()) }
    val cursor = list.listIterator(list.size) // Iterator 초기값 설정
    val m = br.readLine().toInt()
    repeat(m) {
        val r = br.readLine().split(" ")
        when (r[0]) {
            "L" -> {
                if (cursor.hasPrevious())
                    cursor.previous()
            }

            "D" -> {
                if (cursor.hasNext())
                    cursor.next()
            }

            "B" -> {
                if (cursor.hasPrevious()) {
                    cursor.previous()
                    cursor.remove()
                }
            }

            "P" -> {
                cursor.add(r[1])
            }
        }
    }
    bw.write(list.joinToString(""))
    bw.flush()
    bw.close()
}*/
