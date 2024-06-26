package com.kguard.tobecomebetter.baekjoon

//실버 1

private data class Node1991(
    val root: String,
    var left: Node1991? = null,
    var right: Node1991? = null
)

fun main() {
    val size = readln().toInt()
    val tree = mutableListOf<Node1991>()
    repeat(size)
    {
        tree.add(Node1991((it + 65).toChar().toString())) // 알파벳 순으로 노드 생성
    }
    repeat(size)
    {
        val n = readln().split(' ').map { it.single() } // 아스키 코드를 사용하기 위해 single()
        if (n[1] != '.')
            tree[n[0].code - 65].left = tree[n[1].code - 65] // 입력(첫번째) 값의 왼쪽 노드를 두번째 노드로 변경
        if (n[2] != '.')
            tree[n[0].code - 65].right = tree[n[2].code - 65] // 입력(첫번쨰) 값의 오른쪽 노드를 세번째 노드로 변경
    }
    preorder(tree[0])
    println()
    inorder(tree[0])
    println()
    postorder(tree[0])
}

private fun preorder(node: Node1991) {
    print(node.root) // 중간 값 출력
    if (node.left != null) preorder(node.left!!) // 왼쪽 자식
    if (node.right != null) preorder(node.right!!) // 오른쪽 자식
}

private fun inorder(node: Node1991) {
    if (node.left != null) inorder(node.left!!) // 왼쪽 자식
    print(node.root) // 중간 값 출력
    if (node.right != null) inorder(node.right!!) // 오른쪽 자식
}

private fun postorder(node: Node1991) {
    if (node.left != null) postorder(node.left!!) // 왼쪽 자식
    if (node.right != null) postorder(node.right!!) // 오른쪽 자식
    print(node.root) // 중간 값 출력
}
