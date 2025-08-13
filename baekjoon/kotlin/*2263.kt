package com.kguard.tobecomebetter.baekjoon

// 골드 1 트리의 순회
// 트리, 분할 정복, 재귀
// 트리에서 순회
// 인오더(중위 순회) : 왼쪽 -> 루트 -> 오른쪽
// 프리오더(전위 순회) : 루트 -> 왼쪽 -> 오른쪽
// 포스트오더(후위 순회) : 왼쪽 -> 오른쪽 -> 루트
// 인오더와 포스트오더를 통해 프리오더를 구하는 문제
// 중간 값만을 계속해서 찾으면 되기 때문에 인오더에서는
// 시간 초과
//fun main() {
//    val n = readln().toInt()
//    val inOrder = readln().split(" ").map { it.toInt() }
//    val postOrder = readln().split(" ").map { it.toInt() }
//    val preOrder = mutableListOf<Int>()
//    fun solve(inS: Int, inE: Int, PostS: Int, PostE: Int) {
//        if (inE < inS || PostE < PostS) return
//        for (i in 0 until inE - inS) {
//            if (inOrder[inS + i] == postOrder[PostE - 1]) {// 제일 마지막의 값이 트리의 루트 노드
//                preOrder.add(postOrder[PostE-1])
//                solve(inS, inS + i, PostS, PostS + i) // i 를 기준으로 왼쪽만 나눔
//                solve(inS + i + 1, inE, PostS + i, PostE - 1)
//            }
//        }
//    }
//    solve(0, n, 0, n)
//    for(i in preOrder)
//        print("$i ")
//}

// postOrder로 루트 노드를 찾고, inOrder와 inOrderIndex를 사용해서 왼족 노드와 오른쪽 노드의 길이를 정해서 나누는 방식으로 문제 해결
fun main() {
    val n = readln().toInt()
    val inOrder = readln().split(" ").map { it.toInt() }
    val postOrder = readln().split(" ").map { it.toInt() }
    val inOrderIndex = MutableList(n+1){0} // index가  inOrder에서 어디 위치인지 알려주는 리스트 ex) inOrderIndex[1] = 5 이면 1이라는 숫자는 inOrder에 5번 위치에 있다는것
    for(i in 0 until n)
        inOrderIndex[inOrder[i]] = i
    fun solve(inS: Int, inE: Int, postS: Int, postE: Int) {
        if (inE < inS || postE < postS) return
        val root = postOrder[postE] // postOrder의 마지막 값은 루트 노드
        print("$root ")
        val rootIndex = inOrderIndex[root] // 루트 노드가 inOrder에서 어디에 위치에 있는지
        val leftLength = rootIndex - inS // inOrder에서의 왼쪽 노드 길이
        // 왼쪽노드를 구할 때는 inOrder는 중간에 루트 노드가 있기 때문에 inS에서 시작하여 rootIndex-1까지, postOrder는 마지막에 루트 노드가 있어 inOrder의 왼쪽 길이를 따라 가기 때문에 postS부터 PostS+leftLength-1까지 실행
        solve(inS, rootIndex-1, postS, postS+leftLength-1)
        // 오른쪽 노드를 구할 때는 inOrder는 중간에 루트 노드가 있기 때문에 irootIndex+1에서 시작하여 inE까지, postOrder는 마지막에 루트 노드가 있어서 postS+leftLength 부터 postE-1까지 실행
        solve(rootIndex+1, inE,postS+leftLength,postE-1)
    }
    solve(0, n-1, 0, n-1)
}