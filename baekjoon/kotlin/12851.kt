// 골드 4 숨바꼭질 4
// BFS를 이용하는 문제
// 같은 경우에도 큐에 숫자를 추가해주는 게 좋음
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val visited = IntArray(100001) { Int.MAX_VALUE }
    val queue = ArrayDeque<Int>()
    queue.add(n)
    visited[n] = 0
    var count = 0
    while (queue.isNotEmpty()) {
        val poll = queue.removeFirst()
        if(poll == k)
            count++
        for (i in intArrayOf(poll * 2, poll - 1, poll + 1)) {
            if(i in 0..100000 && visited[i] >= visited[poll]+1){ // 숫자가 같은 경우에도 큐에 추가 -> 모든 경우의 수를 세기 위해서
                visited[i] = visited[poll] + 1
                queue.add(i)
            }
        }
    }
    println(visited[k])
    println(count)
}
