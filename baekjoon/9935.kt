package com.kguard.tobecomebetter.baekjoon

// 골드 4 문자열 폭발
// 자료구조, 문자열, 스택
// StringBuilder를 스택 처럼 사용해서 일정 크기 이상시 삭제할 것과 비교 후, 문자열 대체 해버림
fun main() {
    val list = readln().toList()
    val check = readln()
    val string = StringBuilder()
    for (i in list) {
        string.append(i)
        if (string.length >= check.length) {
            if (string.slice(string.lastIndex - check.length + 1 until string.lastIndex + 1) == check) {
                string.replace(string.lastIndex - check.length + 1, string.lastIndex + 1, "")
            }
        }
    }
    if (string.isEmpty())
        println("FRULA")
    else
        println(string)
}
