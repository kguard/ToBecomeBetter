package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 전자레인지
fun main() {
    var t = readln().toInt()
    if (t % 10 != 0)
        print(-1)
    else {
        var a = 0
        var b = 0
        var c = 0
        a += t / 300
        t -= t / 300 * 300
        b += t / 60
        t -= t / 60 * 60
        c += t / 10
        print("$a $b $c")
    }
}