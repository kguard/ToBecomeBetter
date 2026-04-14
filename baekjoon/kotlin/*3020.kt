// 골드 5 개똥벌레
// 위 아래로 나누어서 각각 이분탐색을 진행하는 방식
// lower_bound를 통해서 높이 기준 나보다 큰 것들의 개수를 세면 됨 -> 내가 부서야할 벽의 개수
fun main() {
    val (n, h) = readln().split(" ").map { it.toInt() }
    val bottom = mutableListOf<Int>()
    val top = mutableListOf<Int>()
    repeat(n / 2) {
        bottom.add(readln().toInt())
        top.add(readln().toInt())
    }
    bottom.sort()
    top.sort()
    fun lower_bound(s: Int, list: MutableList<Int>): Int { // 이분 탐색
        var start = 0
        var end = list.size
        var mid: Int
        while (start < end) {
            mid = (start + end) / 2
            if (list[mid] >= s) {
                end = mid
            } else
                start = mid + 1
        }
        return start
    }

    var min = Int.MAX_VALUE
    var count = 1

    for (i in 1..h) {
        val topCount = top.size - lower_bound(h - i + 1, top) // 위에서 부터 내려 오기 때문에 높이를 h-i+1 로 설정 후 이분탐색
        val bottomCount = bottom.size - lower_bound(i, bottom)  // 이분 탐색을 진행해서 나보다 큰거 개수들 세기
        val now = topCount + bottomCount
        if (now < min) {
            min = now
            count = 1
        } else if (now == min) {
            count++
        }
    }
    println("$min $count")
}
