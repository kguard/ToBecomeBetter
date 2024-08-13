package com.kguard.tobecomebetter.baekjoon

// 골드 5 집합의 표현
// 자료 구조, 분리 집합
// 분리 집합은 트리로 표현되며, 각 노드의 값은 부모의 값을 저장 -> 최상위 노드가 같을 경우 같은 집합으로 간주
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val parent = MutableList(n + 1) { it } // 각 인덱스에 해당하는 값은 부모의 값을 뜻함
    // 원소의 부모를 찾는 과정
    // x와 x의 부모가 다름 -> x의 부모를 매개변수로 재귀적으로 수행
    fun find(x: Int): Int {
        return if (parent[x] == x) x // 찾는 값에 대한 부모가 같음 -> 자기 자신
        else {
            parent[x] = find(parent[x]) // 찾는 값이 부모와 다를때 -> 내 위에 거를 계속해서 찾으면서 값을 넣음 -> 재귀 사용
            parent[x]  // 부모값 리턴
        }
    }
    fun union(x: Int, y: Int) {
        val nx = find(x)
        val ny = find(y)
        if (nx != ny) parent[nx] = ny
    }
    repeat(m) {
        val (check, a, b) = readln().split(" ").map { it.toInt() }
        if (check == 0) union(a, b)
        else {
            if (find(a) == find(b))
                println("YES")
            else
                println("NO")
        }
//        println(parent)
    }
}