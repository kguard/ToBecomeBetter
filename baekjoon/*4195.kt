package com.kguard.tobecomebetter.baekjoon

// 골드 2 친구 네트워크
// 자료 구조, 해시를 사용한 집합과 맵, 분리 집합
// String 타입으로 구별해야 하니 map<String, Int>를 사용해서 문자별로 구분하도록함
// 루트 노드를 저장해 놓는 Int 값과 친구 수를 저장하는 Int값을 Pair로 만들어서 해결
data class Pair4195(var first: Int, var second: Int)
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val map = mutableMapOf<String, Int>()
        val friend = MutableList(n * 2) { Pair4195(it, 1) }
        fun find(x: Int): Int { // 루트 노드 찾기
            return if (friend[x].first == x) x // 루트 노드가 자기 자신일때
            else {
                friend[x].first = find(friend[x].first) // 루트 노드를 찾아서 계속해서 이동
                friend[x].first // 변경된 루트노드 반환
            }
        }

        fun union(x: Int, y: Int): Int { // 합치기 -> 루트 노드가 같아짐
            val nx = find(x) // x의 루트 노드
            val ny = find(y) // y의 루트 노드
            if (nx != ny) {
                friend[ny].first = nx // ny의 루트 노드를 nx로 변경
                friend[nx].second += friend[ny].second // nx의 친구 수에 ny의 친구 수를 더함
            }
            return friend[nx].second // nx의 친구 수 반환 -> 루트 노드의 친구 수
        }

        var count = 0
        repeat(n) {
            val (a, b) = readln().split(" ")
            // 중복된 값을 넣지 않기 위해서 검사
            if (a !in map.keys) {
                map[a] = count
                count += 1
            }
            if (b !in map.keys) {
                map[b] = count
                count += 1
            }
            println(union(map[a]!!, map[b]!!))
        }
    }
}