package com.kguard.tobecomebetter.baekjoon

//fun main() {
//    repeat(readln().toInt())
//    {
//        val list = mutableListOf<String>()
//        val vps = readln().split("")
//        var check = true
//        vps.forEach {
//            when (it) {
//                "(" -> list.add(it)
//                ")" -> if (list.isNotEmpty()) list.removeLast() else {
//                    check = false
//                }
//            }
//        }
//        if (check)
//            check = list.isEmpty()
//        if (check)
//            println("YES")
//        else
//            println("NO")
//    }
//}

fun main() {
    repeat(readln().toInt())
    {
        var list = 0
        val vps = readln().split("")
        for (i in vps) {
            when (i) {
                "(" -> list++
                ")" -> list--
            }
            if (list < 0)
                break
        }
        println(if (list == 0) "YES" else "NO")
    }
}