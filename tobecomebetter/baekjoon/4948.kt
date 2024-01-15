package com.kguard.tobecomebetter.baekjoon

fun main() {
    while(true) {
        val n = readln().toInt()
        if(n==0)
            break
        println((n+1 .. n*2).count{ isPrime(it) })
    }
}
////소수를 판별할 숫자의 제곱근 까지 나누어서 나누어 떨어지지 않으면 해당 숫자는 소수임으로 none 으로 확인 후 결과 리턴
private fun isPrime(n: Int): Boolean {
    var i = 2
    while (i * i <= n) {
        if (n % i++ == 0) return false
    }
    return true
}

//fun main() {
//    var list =ArrayList<Int>()
//    do {
//        var c = readln().toInt()
//        var size = 2*c+1
//        var count = 0
//        var num = Array<Int>(size) { 0 }
//        for (i in 2 until size) {
//            num[i] = i
//        }
//        for (i in 2 until size) {
//            if (num[i] == 0) continue
//            for (j in 2 * i until size step i)
//                num[j] = 0
//        }
//        for (i in c+1 until size)
//            if (num[i] != 0) count +=1
//        list.add(count)
//    } while (c != 0)
//    list.remove(0)
//    for(i in list)
//        println(i)
//}