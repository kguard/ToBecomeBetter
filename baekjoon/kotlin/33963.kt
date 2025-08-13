package com.kguard.tobecomebetter.baekjoon

// 브론즈 2 돈복사
// 수학, 문자열
fun main(){
    var n = readln()
    val first = n.length
    var count = -1
    while(n.length <= first){
        n = (n.toLong() * 2).toString()
        count++
    }
    print(count)
}