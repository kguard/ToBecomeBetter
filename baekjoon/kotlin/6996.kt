package com.kguard.tobecomebetter.baekjoon

// 브론즈 1 에너그램
// 구현, 문자열, 정렬
// 입력 받은 문자열을 CharArray로 만들고 정렬한 다음 다시 String으로 만들어서 비교
fun main(){
    repeat(readln().toInt()){
        val (a,b) = readln().split(" ")
        if(a.toCharArray().sorted().joinToString("") == b.toCharArray().sorted().joinToString(""))
            println("$a & $b are anagrams.")
        else
            println("$a & $b are NOT anagrams.")
    }
}