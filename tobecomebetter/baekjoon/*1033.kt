package com.kguard.tobecomebetter.baekjoon

// 골드 2 칵테일
// 수학, 그래프 이론, 그래프 탐색, 정수론, 유클리드 호제법
// 유클리드 호제법 : a, b (a>b)에서 나머지가 0일 될때까지 b, a%b를 해서 a%b==0 일때 나온 b 가 최대공약수
// a, b (a>b)에서 a*b == (a,b의 최소공배수) * (a,b의 최대공약수)
// a:b = p:q 이면 aq = bp, a = bp/q, b = aq/p 으로 계산할 수 있음
// 최소공배수, 최대공약수, bfs를 이용해서 문제 해결
fun main() {
    val n = readln().toInt()
    val list = MutableList(n) { mutableListOf<Triple<Int,Int,Int>>() }
    val answer = MutableList<Long>(n) {0}
    var lcm = 1L
    repeat(n - 1) {
        val (a, b, p, q) = readln().split(" ").map { it.toInt() }
        list[a].add(Triple(b,p,q)) // 연결해서 저장
        list[b].add(Triple(a,q,p)) // 연결해서 저장
        lcm *= lcm(q.toLong(),p.toLong()) // 최소공배수 구하기
    }
    val queue = mutableListOf<Int>()
    answer[0] = lcm // 모든 숫자의 최소공배수
    queue.add(0)
    while(queue.isNotEmpty()){ // bfs
        val poll = queue.removeAt(0)
        for(i in list[poll]){
            if(answer[i.first] != 0L) continue
            answer[i.first] = answer[poll] * i.third / i.second // 비율을 이용해서 값을 구하면 됨 -> 최소공배수를 이용해서 비율에 맞게 곱함
            queue.add(i.first)
        }
    }
    var gcm = answer[0]
    for(i in answer) // 모든 answer에 대한 최대공약수 구하기
        gcm = gcm(i,gcm)
    for(i in answer)
        print("${i/gcm} ") // 주어진 수를 최대공약수로 나누면 최소값이 됨
}

//private fun gcm(a: Int, b: Int): Int = if (b == 0) a else gcm(b, a % b) // 최대공약수
private fun gcm(a: Long, b: Long): Long = if (b == 0L) a else gcm(b, a % b) // 최대공약수
//private fun lcm(a: Int, b: Int): Int = (a * b) / gcm(a, b) // 최소공배수
private fun lcm(a: Long, b: Long): Long = (a * b) / gcm(a, b) // 최소공배수