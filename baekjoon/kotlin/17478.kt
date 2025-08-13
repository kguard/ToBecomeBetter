package com.kguard.tobecomebetter.baekjoon

// 실버 5 재귀함수가 뭔가요?
// 구현, 재귀
fun main(){
    val n = readln().toInt()
    println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.")
    recursion(n,0)
}
private fun recursion(n: Int, now: Int){
    repeat(now){ print("____") }
    println("\"재귀함수가 뭔가요?\"")
    if(n == now){
        repeat(n){ print("____") }
        println("\"재귀함수는 자기 자신을 호출하는 함수라네\"")
        repeat(now){ print("____") }
        println("라고 답변하였지.")
        return
    }
    repeat(now){ print("____") }
    println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.")
    repeat(now){ print("____") }
    println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.")
    repeat(now){ print("____") }
    println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"")
    recursion(n, now+1)
    repeat(now){ print("____") }
    println("라고 답변하였지.")
}