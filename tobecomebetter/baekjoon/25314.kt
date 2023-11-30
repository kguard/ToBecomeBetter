package com.kguard.tobecomebetter.baekjoon

fun main(){
    val count = readln().toInt() / 4
    var output: String = ""
    for(i in 0 until count)
        output += "long "
    output += "int"
    print(output)
}