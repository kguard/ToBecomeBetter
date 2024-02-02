package com.kguard.tobecomebetter.baekjoon

//브론즈 1
fun main(){
    val n = readln().split(" ").map { it.toInt() }
    print(factorial(n[0])/(factorial(n[1])* factorial(n[0]-n[1])))
}
private fun factorial(n : Int) : Int{
    var result = 1
    for(i in n downTo 1)
    {
        result *= i
    }
    return result
}