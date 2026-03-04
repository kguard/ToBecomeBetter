/*
    골드 5 신기한 소수
    소수라서 에라토스테네스 체를 떠올려서 풀었지만, 메모리초과
    1의 자리가 소수인건 2 3 5 7 이고, 마지막이 짝수이면 2로 나눠서 소수가 되지 않으니, 홀수를 붙여가며 진행
    i가 2부터 하나씩 늘려가며 루트(n)까지 나누어 떨어지는지 확인(소수인지 확인하는 부분) -> 모든 수의 약수는 루트(n)을 기준으로 대칭(짝꿍)을 이루기 때문에
 */
fun main() {
    val n = readln().toInt()
    val start = arrayOf(2, 3, 5, 7)
    fun dfs(depth: Int, num: Int) {
        if (depth == n) {
            println(num)
            return
        }
        for (i in 1..9 step 2) { // 뒤에가 짝수면 무조건 2로 나눠지기 때문에 홀 수 여야 함
            val next = num * 10 + i
            if(isPrime(next))
                dfs(depth+1, next)
        }
    }
    start.forEach { dfs(1,it) }
}

private fun isPrime(n: Int): Boolean { // 소수인지 판단하는 함수
    if (n < 2) return false
    var i = 2
    while (i * i <= n) { // (양변 제곱)모든 수의 약수는 루트(n)을 기준으로 대칭(짝꿍)을 이루므로, 루트(n) 이하에서 작은 약수가 없다면 그 이상에서도 큰 약수가 절대 존재할 수 없음.
        if (n % i == 0)
            return false
        i++
    }
    return true
}
/* 에라토스테네스의 체로 풀었던 문제 -> 당연하게 소수여서 그런 줄
fun main(){
    val n = readln().toInt()
    val c = 10.0.pow(n).toInt()
    val primes = prime(c)
    for(i in c/10 .. c){
        if(primes[i]){
            var check = true
            var now = i/10
            while(now > 0){
                if(primes[now]){
                    now /= 10
                }else{
                    check = false
                    break
                }
            }
            if(check)
                println(i)
        }
    }
}

private fun prime(n: Int): BooleanArray{
    val check = BooleanArray(n+1){true}
    check[0] = false
    check[1] = false

    for(i in 2..n){
        if(!check[i])
            continue
        for(j in i*2 .. n step i) // i의 배수를 지우는 과정
            check[j] = false
    }
    return check
}*/
