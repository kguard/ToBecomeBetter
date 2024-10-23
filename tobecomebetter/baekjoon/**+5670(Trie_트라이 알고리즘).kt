package com.kguard.tobecomebetter.baekjoon

import java.util.Scanner

// 플래티넘 4 휴대폰 자판
// 자료 구조, 문자열, 트리, 트라이
// 최소한의 입력으로 단어를 완성 할 수 있는 경우의 수
// 트라이를 이용해서 트리를 만든 다음에 자식의 사이즈가 2개이상 이면 카운트를 늘려주고, 마지막이 있으면 하나 늘려줌
private data class Node5670( // 트리를 구성하기 위한 노드
    var name: String, // 노드의 이름
    var end: Boolean, // 단어의 마지막이 될 수 있는 문자는 true
    var children: Array<Node5670> // 자식 노드들
) {
    private fun getChild(name: String): Node5670 { // 원하는 자식으로 이동하는 함수
        return this.children[this.children.map { it.name }.indexOf(name)] // 인덱스를 찾아서 그 인덱스에 접근
    }

    fun add(word: String){ // 한 글자씩 추가 하는 함수
        var parent = this // 현재 위치를 나타내기 위한 변수
        for (i in word.indices) { // 한 글자 씩 진행
            if (word[i].toString() !in parent.children.map { it.name }) // 부모의 자식리스트에 본인이 없으면
                parent.children += Node5670(word[i].toString(), false, arrayOf())// 본인을 부모에 추가
            if (i == word.length - 1) parent.getChild(word[i].toString()).end = true // 단어의 마지막이 될 수 있는 글자는 true로 변경
            parent.children.sortBy { it.name } // 정렬
            parent = parent.getChild(word[i].toString()) // 부모를 본인으로 변경 -> 본인의 인덱스를 찾아서 인덱스로 본인 서치 -> 다음 단어로 이동
        }
    }

    fun find(word: String): Int{ // 최소한의 입력을 세는 함수
        var count = 1 // 처음에 한번은 무조건 눌러야 하니 1로 시작
        var node = this.getChild(word[0].toString()) // 맨 처음 단어로 이동
        for (i in 1 until word.length) {
            if (node.children.size > 1 || node.end) // 자식 리스트의 사이즈가 2 이상이거나, 그 글자가 마지막이 될 수 있으면 카운트 증가
                count++
            node = node.getChild(word[i].toString()) // 다음 단어로 이동
        }
        return count
    }

}
fun main() {
    val input = Scanner(System.`in`)
    while (input.hasNext()) {
        val n = input.nextInt()
        val root = Node5670("", false, arrayOf())
        val wordList = mutableListOf<String>()
        val searchCount = mutableListOf<Int>()
        repeat(n) {
            wordList.add(input.next())
        }
        for (word in wordList) { // 트리에 단어 추가
           root.add(word)
        }
        for (word in wordList) { // 최소한의 입력을 모은 리스트에 추가
            searchCount.add(root.find(word))
        }
        println(String.format("%.2f", searchCount.average())) // 평균을 소수점 둘째 자리 까지만 
    }
}