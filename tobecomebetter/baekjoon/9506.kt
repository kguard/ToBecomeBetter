package com.kguard.tobecomebetter.baekjoon

fun main() {
    while (true) {
        val a = readln().toInt()
        val prime = mutableListOf<Int>()
        if (a == -1)
            break
        for (i in 1 until a) {
            if (a % i == 0)
                prime.add(i)
        }
        if (a == prime.sum()) {
            print("$a =")
            for (i in prime) {
                if (i == prime.last())
                    println(" $i")
                else
                    print(" $i +")
            }
        } else {
            println("$a is NOT perfect.")
        }
    }
}