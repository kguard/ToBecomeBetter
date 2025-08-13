package com.kguard.tobecomebetter.baekjoon

//브론즈 2
fun main() {
    repeat(readln().toInt())
    {
        val n = readln()
        println("${isPalindrome(n).first} ${isPalindrome(n).second}")
    }
}

fun recursion(s: String, l: Int, r: Int, c: Int): Pair<Int, Int> {
    return if (l >= r) Pair(1, c)
    else if (s[l] != s[r]) Pair(0, c)
    else recursion(s, l + 1, r - 1, c + 1)
}

fun isPalindrome(s: String): Pair<Int, Int> {
    return recursion(s, 0, s.length - 1, 1)
}



//var count = 1
//fun main() {
//    var c = readln().toInt()
//    repeat(c)
//    {
//        var s = readln()
//        println("${isPalindrome(s)} $count")
//
//    }
//}
//
//fun recursion(s: String, l: Int, r: Int): Int {
//    count++
//    return if (l >= r) {
//        1
//    } else if (s[l] != s[r]) {
//        0
//    } else {
//        recursion(s, l + 1, r - 1)
//    }
//}
//fun isPalindrome(s:String):Int{
//    count = 1
//    return recursion(s, 0, s.length-1)
//}