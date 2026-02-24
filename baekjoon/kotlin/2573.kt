/*
    골드 4 빙산
    bfs로 해결하는 문제
    문제를 끝까지 잘 읽어봐야한다..
    문제 마지막에 조건 하나 있었음
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = mutableListOf<MutableList<Int>>()
    repeat(n) {
        graph.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }

    val moveHeight = intArrayOf(0, 0, -1, 1)
    val moveWidth = intArrayOf(-1, 1, 0, 0)
    var year = 0
    y@ while (true) {
        val count = Array(n) { IntArray(m) { 0 } }
        val save = ArrayDeque<Triple<Int, Int, Int>>()
        fun bfs(group: Int, sy: Int, sx: Int) {
            val q = ArrayDeque<Pair<Int, Int>>()
            q.add(sy to sx)
            count[sy][sx] = group
            while (q.isNotEmpty()) {
                val poll = q.removeFirst()
                var c = 0
                for (i in 0 until 4) {
                    val ny = poll.first + moveHeight[i]
                    val nx = poll.second + moveWidth[i]
                    if (ny in 0 until n && nx in 0 until m && count[ny][nx] == 0) {
                        if (graph[ny][nx] != 0) {
                            q.add(ny to nx)
                            count[ny][nx] = group
                        } else {
                            c++
                        }
                    }
                }
                save.add(Triple(poll.first, poll.second, c))
            }

        }

        var iceBerg = 1 // 빙산의 개수
        for (i in 1 until n - 1)
            for (j in 1 until m - 1) {
                if (graph[i][j] > 0 && count[i][j] == 0) {
                    bfs(iceBerg, i, j)
                    iceBerg++
                }
                if (iceBerg >= 3) // 2개 이상, 처음에 1로 시작
                    break@y
            }

        if(save.isEmpty()) { // 비어 있으면 0 을 출력 하고 종료 -> 전부 다 녹을 때 까지 두 덩어리 이상으로 분리되지 않았음
            println(0)
            return
        }
        while (save.isNotEmpty()) {
            val p = save.removeFirst()
            graph[p.first][p.second] -= p.third
            if (graph[p.first][p.second] <= 0) graph[p.first][p.second] = 0
        }
        year++
//        graph.forEach { println(it) }
//        println()
    }
    println(year)
}
