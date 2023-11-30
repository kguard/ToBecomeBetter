package com.kguard.tobecomebetter.forcodingtest

fun main() {
    //solution1(arrayOf("joy", "brad", "alessandro", "conan", "david"), arrayOf("alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"))
     solution(arrayOf(intArrayOf(4,15), intArrayOf(15,16),
         intArrayOf(16,17), intArrayOf(13,2), intArrayOf(2, 14),
         intArrayOf(14,13),intArrayOf(4, 11), intArrayOf(1, 12), intArrayOf(8, 3), intArrayOf(12, 7), intArrayOf(4, 2), intArrayOf(7, 11), intArrayOf(4, 8), intArrayOf(9, 6), intArrayOf(10, 11), intArrayOf(6, 10), intArrayOf(3, 5), intArrayOf(11, 1), intArrayOf(5, 3), intArrayOf(11, 9), intArrayOf(3, 8)))
    //solution(4, intArrayOf(3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4))
}

fun solution1(friends: Array<String>, gifts: Array<String>): Int {
    val give = mutableMapOf<String, Int>()
    val receive = mutableMapOf<String, Int>()
    val all = Array(friends.size) { IntArray(friends.size) { 0 } }
    val giftCount = mutableListOf<Int>()
    val finalCount = Array(friends.size) { 0 }
    for (i in all.indices)
        all[i][i] = -1
    for (i in friends) {
        give[i] = 0
        receive[i] = 0
    }
    for (i in friends) {
        for (t in gifts) {
            val a = t.split(" ")[0]
            val b = t.split(" ")[1]
            if (i == a) {
                val x = give[i]!!
                give[i] = x + 1
            } else if (i == b) {
                val x = receive[i]!!
                receive[i] = x + 1
            }
        }
    }
    for (i in friends) {
        giftCount.add(give[i]!! - receive[i]!!)
    }
    for (i in gifts) {
        val row = friends.indexOf(i.split(" ")[0])
        val columns = friends.indexOf(i.split(" ")[1])
        all[row][columns]++
    }
    for (i in friends.indices) {
        for (j in i + 1 until friends.size) {
            if (all[i][j] > all[j][i])
                finalCount[i]++
            else if (all[i][j] < all[j][i])
                finalCount[j]++
            else if (all[i][j] == all[j][i]) {
                if (giftCount[i] > giftCount[j])
                    finalCount[i]++
                else if (giftCount[i] < giftCount[j])
                    finalCount[j]++
            }
        }
    }
    return finalCount.toMutableList().maxOrNull()!!
}


fun solution(edges: Array<IntArray>):IntArray {
    val count = edges.groupingBy { it[0] }.eachCount().toMutableMap()
    val max = count.maxByOrNull { it.value }!!.key
    val maxValue = count[max]
    val edge = edges.toMutableList().map { it.toMutableList() }.toMutableList()
    count.remove(max)
    edge.removeAll{ it[0] == max }
    val eights = mutableListOf<MutableList<Int>>()
    val lineSize = edge.size
    var donut = 0
    var stick = 0
    var eight = 0

    for(i in count) {
        if (i.value == 2) {
            eight++
            edge.removeAll { it.contains(i.key) }
        }
    }
    donut = (maxValue!!-eight)/2
    stick = maxValue!!-eight-donut

    println(intArrayOf(max,donut,stick,eight).toMutableList())
    return intArrayOf(max,donut,stick,eight)
}

//fun solution(coin: Int, cards: IntArray) {
//    val hand = cards.slice(0 until cards.size / 3).toMutableList()
//    val deck = cards.slice(cards.size/3..<cards.size).toMutableList()
//    var coins = coin
//    var check = false
//    val num = cards.size + 1
//    if (hands(hand, num).third) {
//        hand.remove(hands(hand, num).first)
//        hand.remove(hands(hand, num).second)
//    } else {
//        hand.add(deck.removeFirst())
//        if (hands(hand, num).third) {
//            hand.remove(hands(hand, num).first)
//            hand.remove(hands(hand, num).second)
//            coins -= 1
//        }
//        else{
//            hand.add(deck.removeFirst())
//            if (hands(hand, num).third) {
//                hand.remove(hands(hand, num).first)
//                hand.remove(hands(hand, num).second)
//                coins -= 1
//            }
//        }
//
//    }
//}
fun hands(hand:MutableList<Int>, num :Int):Triple<Int,Int,Boolean>{
    var check = false
    var han1 = 0
    var han2 = 0
    loop1@ for (i in hand.indices) {
        for (j in i + 1 until hand.size) {
            if (hand[i] + hand[j] == num) {
                han1 = hand[i]
                han2 = hand[j]
                check = true
                break@loop1
            }
            else
                check = false
        }
    }
    return Triple(han1,han2,check)
}