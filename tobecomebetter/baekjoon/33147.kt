package com.kguard.tobecomebetter.baekjoon

// 실버 2 K-정렬
// 수학, 정렬, 정수론, 유클리드 호제법
// 유클리드 호제법을 사용해서 n 과 k의 최대공약수를 구함 -> 각 인덱스는 최대공약수 만큼 그룹별로 연결되어 있음 ex) 9 3 이면 최대공약수가 3으로 0 3 6, 1 4 7, 2 5 8 이렇게 3개의 그룹으로 연결되어 있음, 4 3이면 최대공약수가 1로 0 1 2 3 이 다 연결됨
// 모든 인덱스는 최대공약수 만큼 띄워져서 연결되어 있음 -> 정렬이 될 수 있으려면 현재 값과 그 인덱스의 차이가 최대공약수의 배수이면 됨
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    val gcm = gcm(n, k) //최대공약수
    for (i in list.indices)
        if ((i - list[i]) % gcm != 0) { // (현재 값 - 인덱스)가 최대공약수의 배수이면 연결되어 있는 것으로 간주 할 수 있음
            println("NO")
            return
        }
    println("YES")
}

private fun gcm(a: Int, b: Int): Int = if (b == 0) a else gcm(b, a % b) // 최대공약수

