package ToBecomeBetter.tobecomebetter.baekjoon

// 브론즈 4 DORO
// 문자열
fun main(){
    val n = readln().toInt()
    val s = readln().split(" ").map { it+"DORO" }
    s.forEach { print("$it ") }
}