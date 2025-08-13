package com.kguard.tobecomebetter.baekjoon


// 실버 4 요세푸스 문제
// 구현, 자료 구조, 큐
fun main(){
    val (n, k) = readln().split(" ").map { it.toInt() }
    val list = MutableList(n){it+1}
    val check = mutableListOf<Int>()
    var index = k - 1 // 인덱스가 0 부터 시작하기 때문에 k-1
    while(list.isNotEmpty()){
        while(index < list.size){
            check.add(list.removeAt(index))
            index += k - 1 // 위에서 하나를 삭제했으니 다음 k-1번째를 삭제 해야됨
        }
        index -= list.size // 위에 while문을 벗어나는 경우는 list사이즈 보다 index가 클때 이니 초기화를 위해서는 index - list.size를 해줘야 됨
    }
    // 문제에서 원하는 출력 방식을 사용
    println(check.joinToString ( ", ","<",">" )) // joinToString() 함수 이용
}