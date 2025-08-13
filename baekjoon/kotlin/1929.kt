package com.kguard.tobecomebetter.baekjoon

fun main(){
    val n = readln().split(" ").map { it.toBigInteger() }
    var a= n[0]
    while(a <= n[1])
    {
        if(a.isProbablePrime(10))
            println(a)
        a++
    }
}
 // 11달 전에 푼것
//fun main() {
//    var c = readln().split(" ").map { it.toInt() }
//    var num = Array<Int>(c[1]+1) { 0 }
//    for(i in 2 ..c[1] )
//    {
//        num[i] = i
//    }
//    for(i in 2 .. c[1])
//    {
//        if(num[i]==0) continue
//        for(j in 2*i.. c[1] step i)
//            num[j]=0
//    }
//    for(i in c[0]..c[1])
//        if(num[i] != 0) println(num[i])
//}