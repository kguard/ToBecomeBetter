// 실버 1 댄스 타임
// dp를 이용해서 문제를 푸는 문제
// 접근까지는 좋았지만, 방향성이 잘못되었었음
// 수학적으로 접근했는데 아숩네
fun main() {
    // 1, 3, 1, 3, -> 9
    // 1, 1, 1, 3 -> 3
    // 1, 3, 1, 1 -> 3
    // 3, 3, 1, 3 -> 27
    // 1, 3, 3, 3, -> 27
    // 54 + 9 + 3 + 3 => 15+ 54
    // 다 맞추는 경우 1 개  + 앞일때 틀릴 경우 * 앞의 개수 + 뒤의 틀릴때 개수 * 뒤의 개수
    val mod = 1000000007
    val (n, m) = readln().split(" ").map { it.toInt() }
    var dp0 = 1L // 실수가 0번이 경우 -> 처음에는 무조건 실수를 안했음
    var dp1 = 0L // 실수를 1번하는 경우의 수 -> 1번만 실수를 하는 경우는 처음에는 없음
    repeat(n) {
        val (_, b) = readln().split(" ").map { it.toInt() }

        val correct = if (b == 1) m - 1 else 1
        val wrong = if (b == 1) 1 else m - 1

        val next0 = (dp0 * correct) % mod
        val next1 = (dp0 * wrong + dp1 * correct) % mod

        dp0 = next0
        dp1 = next1

    }
    println((dp0 + dp1) % mod)
}
