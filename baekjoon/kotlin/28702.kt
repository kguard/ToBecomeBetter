package com.kguard.tobecomebetter.baekjoon

// 브론즈 1 FizzBuzz
// 수학, 문자열
fun main() {
    val first = readln()
    val second = readln()
    val third = readln()
    if (check(first))
        println(change(first.toInt() + 3))
    else if (check(second))
        println(change(second.toInt() + 2))
    else if (check(third))
        println(change(third.toInt() + 1))
}

private fun check(now: String): Boolean {
    return !(now == "Fizz" || now == "Buzz" || now == "FizzBuzz")
}

private fun change(now: Int): String {
    return if (now % 5 == 0 && now % 3 == 0) "FizzBuzz"
    else if (now % 3 == 0) "Fizz"
    else if (now % 5 == 0) "Buzz"
    else now.toString()
}