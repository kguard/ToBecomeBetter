package ToBecomeBetter.tobecomebetter.baekjoon

// 브론즈 4 첫 번째는 문제는 정말 쉬운 문제일까?
// 구현
fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Int>()
    repeat(n) {
        list.add(readln().toInt())
    }
    if (list[0] == list.min())
        println("ez")
    else if (list[0] == list.max())
        println("hard")
    else
        println("?")
}
