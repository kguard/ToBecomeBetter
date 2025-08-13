package com.kguard.tobecomebetter.baekjoon

// 골드 3 개미굴
// 자료 구조, 문자열, 트리, 트라이
// 1. 트리를 만들어서 문자열을 저장
// 2. dfs를 통하여 문자열을 출력
// 기본적인 풀이 방법만 검색 후, 구현은 스스로 할 수 있었음
private data class Node14725( // 노드를 데이터 클래스로 구현
    var name : String,
    var children : MutableList<Node14725>
)
fun main(){
    val n = readln().toInt()
    val root = Node14725("", mutableListOf())
    repeat(n){ // 트리를 만들기 위한 반복문
        val k = readln().split(" ")
        var parent = root // 처음 위치는 루트
        for(i in 1 .. k[0].toInt()){
            if(k[i] !in parent.children.map { it.name }) // 부모의 자식리스트에 본인이 없으면
                parent.children.add(Node14725(k[i], mutableListOf())) // 본인을 부모에 추가하고
            parent = parent.children[parent.children.map { it.name }.indexOf(k[i])] // 부모를 본인으로 변경 -> 본인의 인덱스를 찾아서 인덱스로 본인 서치
        }
    }
    fun dfs(t: Node14725, depth: Int){ // 출력하기 위한 dfs 노드와 깊이가 들어있음
        if(t.children.isEmpty()) return // 만약 자식이 없다면 return
        for(i in t.children.sortedBy { it.name }) { // 알파벳 순으로 정렬한 자식 노드들 출력
            repeat(depth){ // 깊이 만큼 -- 출력
                print("--")
            }
            print(i.name) //자식 이름 출력 후
            println()
            dfs(i,depth+1) // dfs를 통하여 자식 노드에 접근
        }
    }
    dfs(root,0)
}