package com.kguard.tobecomebetter.baekjoon

// 브론즈 1 태권도와 복싱을 합한 운동
// 문자열
fun main() {
    val a = readln()
    val b = readln()
    var aFirst = firstLang(a)
    var bFirst = firstLang(b)
    if (aFirst.isEmpty() || bFirst.isEmpty())
        print("no such exercise")
    else
        println(aFirst + bFirst)
}

private fun firstLang(t: String): String {
    val moums = listOf('a', 'e', 'i', 'o', 'u')
    var moum = false
    var jaum = false
    var firstUm = ""
    for (i in t) {
        if (i in moums) {
            moum = true
            firstUm += i
        } else {
            if (!moum)
                firstUm += i
            else {
                jaum = true
                break
            }
        }
    }
    return if (jaum) firstUm else ""
}