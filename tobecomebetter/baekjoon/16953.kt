package com.kguard.tobecomebetter.baekjoon

// 실버 2 A → B
// 그래프 이론, 그리디 알고리즘, 그래프 탐색, 너비 우선 탐색
// 그리디, dfs, bfs로 모두 문제 해결 가능
fun main() {
    var (a, b) = readln().split(" ")
    println(bfs(a.toLong(), b.toLong()))
    // 무한루프 안돌음
    // dfs로 문제 해결
    //    var size = -1
    //    fun dfs(a: Long, b: Long, depth : Int) {
    //        if (a == b) { size = depth + 1 }
    //        else{
    //            if (a * 2 <= b) dfs(a * 2, b, depth+1)
    //            if (a * 10 + 1 <= b) dfs(a * 10 + 1, b, depth+1)
    //        }
    //    }
    //    dfs(a.toLong(),b.toLong(),0)
    //    println(size)
        // 그리디로 문제 해결
        //var count = 0
        //    while (b.toLong() > a.toLong()) {
        //        if (b.last() == '1')
        //            b = b.slice(0..b.lastIndex - 1)
        //        else if (b.toLong() % 2 == 0L)
        //            b = (b.toLong() / 2).toString()
        //        else
        //            a = (a.toLong() * 2).toString()
        //        count++
        //        if (b.toLong() == a.toLong()) {
        //            count++
        //            break
        //        } else if (b.toLong() < a.toLong()) {
        //            count = -1
        //            break
        //        }
        //    }
        //    println(count)
}
// bfs1
//private fun bfs(a: Long, b: Long): Int {
//    var count = 0
//    val queue = mutableListOf<Long>()
//    queue.add(a)
//    while (queue.isNotEmpty()) {
//        val cnt = queue.size // 모두 같은 count 이기 떄문에 묶어서 진행 -> 한 사이클
//        repeat(cnt){
//            val poll = queue.removeAt(0)
//            if (poll == b) return count + 1
//            if (poll * 2 <= b) queue.add(poll * 2)
//            if (poll * 10 + 1 <= b) queue.add(poll * 10 + 1)
//        }
//        count++
//    }
//    return -1
//}

// bfs2
private fun bfs(a: Long, b: Long): Int {
    val queue = mutableListOf<Pair<Long, Int>>()
    queue.add(Pair(a, 0))
    while (queue.isNotEmpty()) {
        val poll = queue.removeAt(0)
        if (poll.first == b) return poll.second + 1
        if (poll.first * 2 <= b) queue.add(Pair(poll.first * 2L, poll.second + 1))
        if (poll.first * 10 + 1 <= b) queue.add(Pair(poll.first * 10 + 1, poll.second + 1))
    }
    return -1
}
