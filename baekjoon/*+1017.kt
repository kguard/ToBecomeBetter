package com.kguard.tobecomebetter.baekjoon

// 플래티넘 3 소수 쌍
// 수학, 정수론, 소수 판정, 에라토스테네스의 체, 이분 매칭
// 2를 제외한 모든 소수는 홀수 이기 떄문에 짝수 + 짝수 , 홀수 + 홀수는 소수가 될 수 없음
// 홀수 + 짝수는 더하면 소수가 될수 있음
// 이분 매칭은 dfs를 사용해서 연결될 수 있는 최대 매칭을 구하는 방법
// 1. 이분 매칭을 위해서 짝수와 홀수로 나누고
// 2. 각 나눈 부분에서 더하면 소수가 되는 부분에 간선 추가 -> 이부분에서 에라토스테네스의 체를 이용해서 소수 판별
// 3. 첫번째 숫자와 더해서 소수가 되는 수들을 기준으로 이분 매칭(dfs)를 진행하여서 짝의 수가 기존의 나눈 수와 같으면(모든 짝이 지어지면) 첫번째 숫자와 더해서 소수가 되는 수들 추가
fun main(){
    val prims = sieveOfEratosthenes(2000)
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val answer = mutableListOf<Int>()
    val a = mutableListOf<Int>()
    val b = mutableListOf<Int>()
    var visit = MutableList(0){false}
    if(list[0] % 2 == 0 ) // 짝수와 홀수로 나누는 부분 -> 첫번쨰 숫자가 중요하기 떄문에 첫번쨰 숫자가 짝수인지 홀수인지를 기준으로 먼저오는 리스트 설정
        list.forEach { if(it % 2 == 0) a.add(it) else b.add(it)} // 첫번째 숫자가 짝수 일때
    else
        list.forEach { if(it % 2 == 0) b.add(it) else a.add(it)} // 첫번째 숫자가 홀수 일때

    if(a.size != b.size){ // 두 리스트의 사이즈가 다르면 완성이 될수 없으므로 -1
        println(-1)
        return
    }
    val graph = MutableList(a.size){ mutableListOf<Int>() } // 소수들로 연결된 간선이 들어갈 리스트
    for(i in a.indices) // 간선을 추가하기 위해서 연결하는 부분
        for(j in b.indices)
            if(prims[a[i]+b[j]]) // 두수를 더해서 소수가 되면 그래프 간선에 추가
                graph[i].add(j)

    for(i in graph[0].indices){ // 첫번째 수와 연결될 수 있는 모든 수를 탐색 (나머지로 이분 매칭을 해야하기 때문)
        val bPairIndex = graph[0][i] // a의 처음와 연결될 b
        var pairSize = 1 // 연결된 쌍의 갯수

        val aMatch = MutableList(a.size){-1} // a와 연결될 b를 확인하는 리스트
        val bMatch = MutableList(b.size){-1} // b와 연결될 a를 확인하는 리스트

        aMatch[0] = bPairIndex // 첫번째 수는 미리 연결되어 있음
        bMatch[bPairIndex] = 0 // 첫번쨰 수와 연결되어 있음

        fun dfs(aIndex : Int): Boolean{ // 이분 매칭을 하기 위한 함수 -> 한번 했던 건 중복으로 할 수 없게 설정
            if(aIndex == 0 || visit[aIndex]) return false // 입력받음 값이 0 이거나 (원래로 돌아왔을 때) 방문한 인덱스일 경우 return false
            visit[aIndex] = true // 입력된 인덱스 방문으로 표시
            for(index in graph[aIndex].indices){
                val bIndex = graph[aIndex][index] // a와 연결가능한 b 인덱스
                if(bMatch[bIndex] == -1 || dfs(bMatch[bIndex])){ // b인덱스를 방문하지 않고, 깊이 우선 탐색으로 연결되어 있을 떄 -> 쭉 이었을때 짝이 지어진 것들은 false를 반환(중복으로 이어지지 않게 해줌)
                    aMatch[aIndex] = bIndex // a에 b를 연결
                    bMatch[bIndex] = aIndex // b에 a를 연결
                    return true // 성공적으로 이어짐
                }
            }
            return false
        }

        for(j in a.indices){ // 나머지 a에 있는 숫자에 대하여 이분 매칭 진행
            visit = MutableList(a.size){false}
            if (dfs(j)) pairSize++ // 성공적으로 이어지면 짝의 갯수 +1
        }
        if (pairSize == b.size) // 짝의 갯수와 b의 사이즈가 같으면 -> 모든 짝이 정해지면
            answer.add(b[bPairIndex]) // 처음에 a와 연결된 b인덱스에 해당되는 값 저장
    }
    if(answer.isNotEmpty())
        answer.sorted().forEach { print("$it ") }
    else
        print(-1)
}
// 에라토스테네스의 체 -> 소수를 찾는 방법
// 1. 0 과 1은 소수이니 false로 시작
// 2. 2부터 시작해서 i의 제곱이 end값보다 작을 때 까지
// 3. i가 소수 이면 i의 배수들은 다 소수가 아님
// 4. i가 소수가 아니면 넘어감
// 5. 마지막에 i+1
private fun sieveOfEratosthenes(end: Int): List<Boolean> {
    val list = BooleanArray(end + 1) { true }
    list[0] = false
    list[1] = false
    var i = 2 // 2부터 시작
    while (i * i <= end) { // i의 제곱이 마지막 값보다 작은 경우 반복 !! 중요한 부분 -> 제곱수가 end보다 작은 배수만 삭제
        if (list[i]) { // 소수로 표현되어 있을 경우
            for (j in i * i..end step i) { // i제곱 부터 end 까지 i의 배수는 다 false
                list[j] = false
            }
        }
        i++
    }
    return list.toMutableList()
}

