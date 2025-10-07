package com.kguard.tobecomebetter.baekjoon.kotlin

// * 골드 4 전화번호 목록
// 문자열 정렬을 이용해서 이웃 되는 것 끼리만 비교 -> 문자열 정렬은 사전순이기 떄문에 접두사가 비슷해짐
/*
fun main(){
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val list = mutableListOf<String>()
        var check = true
        repeat(n) {
            list.add(readln())
        }
        list.sort()
        for(i in 1 until n)
            if(list[i].startsWith(list[i-1])) {
                check = false
                break
            }
        println(if(check) "YES" else "NO")
    }
}
*/

// 트라이 알고리즘을 사용 (접두사이기 때문에)
private class Trie {
    private class Node {
        val children = Array<Node?>(10) { null }
        var isEndOfWord = false
    }

    private val root = Node()

    fun insert(word: String): Boolean {
        var current = root

        for (char in word) { // 1. 집어넣기
            if (current.isEndOfWord) // 현재 위치가 접두사인 경우 -> 여태까지 단어를 따라서 내려왔는데 끝나는 경우의 수가 있으면
                return false

            val index = char - '0'

            var next = current.children[index] // 다음 위치

            if (next == null) {
                next = Node()
                current.children[index] = next
            }
            current = next

        }

        if (current.isEndOfWord) // 2.  마지막 위치로 끝나는 경우가 있는 경우
            return false

        if (current.children.any { it != null }) // 3.  마지막 위치인데 자식 노드가 존재하면 현재의 word가 다른 문자의 접두사가 되어버림
            return false

        current.isEndOfWord = true // 마지막 위치에 끝난다는 것을 표시
        return true
    }

}

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val trie = Trie()
        val check = run {
            repeat(n) { // 입력을 n 번 바
                val number = readln()
                if (!trie.insert(number)) { // 접두사 인것으로 확인하면
                    repeat(n - 1 - it) { readln() } // return을 위해서 나머지 모두 readln()
                    return@run false // false 반환
                }
            }
            return@run true
        }
        println(if (check) "YES" else "NO")
    }
}