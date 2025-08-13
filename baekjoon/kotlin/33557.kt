package com.kguard.tobecomebetter.baekjoon

// 실버 5 곱셈을 누가 이렇게 해 ㅋㅋ
// 수학, 구현, 문자열, 사칙연산
// 세로식 곱셈에서 받아올림을 하지 않고 바로 결과에 적는 잘못된 곱셈 결과와 일반 곱셈 결과가 같은지 확인하는 문제
// 자릿수가 다르면 자릿수가 적은쪽에 빈칸을 1로 다 채움 -> 187 88 이 있으면 187 188로 변경
// 변경후 한자릿씩 곱한 결과를 list에 넣은다음 합쳐서 원래 결과와 비교
fun main() {
    val t = readln().toInt()
    repeat(t) {
        var (a, b) = readln().split(" ")
        val normal = a.toLong() * b.toLong()
        if (a.length > b.length)
            repeat(a.length - b.length) { b = "1$b" }
        else
            repeat(b.length - a.length) { a = "1$a" }
        val list = mutableListOf<Long>()
        for (i in a.indices) {
            list.add(a[i].toString().toLong() * b[i].toString().toLong())
        }
        val abNormal = list.joinToString("").toLong()
        if (normal == abNormal) println(1)
        else println(0)
    }
}