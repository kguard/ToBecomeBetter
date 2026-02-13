import kotlin.math.max
import kotlin.math.min

// 골드 4 DAG LCA
// bfs를 이용해서 문제 해결
// 무가중치 방향 비순환 그래프 이니까 그냥 bfs를 생각
// 근데 bfs가 한 점에서 다른 점들까지 라는 점을 까먹고, 잘못 짰었음
// 처음에는 할때 마다 bfs를 돌렸는데, 생각해보니까 bfs를 다 돌려 놓고 하면 되었었음
// bfs 다시 공부해야 할둣
fun main() {
    val (n, m, q) = readln().split(" ").map { it.toInt() }
    val g = MutableList(n + 1) { mutableListOf<Int>() }
    val gb = MutableList(n + 1) { MutableList(n + 1) { -1 } }
    repeat(m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        g[u].add(v)
    }

    fun bfs(start: Int) {
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(start to 0)
        gb[start][start] = 0
        while (queue.isNotEmpty()) {
            val poll = queue.removeFirst()
            for (i in g[poll.first]) {
                if (gb[start][i] == -1) { // 시작점에서 i까자리르 구하는 로직이니까 bfs 공부 다시하셈
                    gb[start][i] = poll.second + 1
                    queue.add(i to poll.second + 1)
                }
            }
        }
    }

    for (i in 1..n)
        bfs(i)

    repeat(q) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        var minV = Int.MAX_VALUE
        for (i in 1..n) {
            if (gb[i][u] != -1 && gb[i][v] != -1)
                minV = min(minV, max(gb[i][u], gb[i][v]))
        }
        println(if (minV == Int.MAX_VALUE) -1 else minV)
    }

}
