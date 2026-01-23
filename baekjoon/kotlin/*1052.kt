// 골드 5 물병
// 비트 마스킹을 이용하는 문제, 이진수를 이용하는 문제
// 물병 2개를 합쳐 상위 물병 1개를 만든다 -> 이진수를 이하면 된다는 문제
// 가낮ㅇ 낮은 비투의 숫자를 더하면서 1의 개수를 세어보기
fun main(){
    var (n,k) = readln().split(" ").map { it.toInt() }
    var result = 0
    while(n.countOneBits() > k){ // 2진수를 변환했을 떄 1의 개수를 세는 함수
        val lowest = n.takeLowestOneBit()  // n & -n -> n에서의 가장 낮은 비트를 구하는 함수
        result += lowest
        n += lowest
    }
    println(result)
}
