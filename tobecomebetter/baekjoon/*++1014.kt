package com.kguard.tobecomebetter.baekjoon

import kotlin.math.max

// 플래티넘 4 컨닝
// 다이나믹 프로그래밍, 비트마스킹, 최대 유량, 비트필드를 이용한 다이나믹 프로그래밍
// 비트 마스킹을 학생들이 앉아 있는 위치로 생각해서 문제를 풀면됨 ex) 5 -> 101 1부분에 학생이 앉아 있는 것을 뜻함
// dp[열][행] -> 행은 현재 열에 학생들이 어떠한 형식으로 앉아 있는지 보여주는 부분, 행열에 따른 최대 학생 수를 뜻함
// 이해하는데 너무 어려웠다.. 이해하는데 2일 걸림
// 나중에 다시 확인해볼 필요가 있음
// 추후 재풀이 필요
fun main() {
    val c = readln().toInt()
    repeat(c) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val board = mutableListOf<List<String>>()
        val dp = MutableList(n) { MutableList(1 shl m) { 0 } }
        repeat(n) { // 처음에 보드 채워 넣기
            val list = readln().split("").toMutableList()
            list.removeAt(0)
            list.removeAt(list.lastIndex)
            board.add(list)
//            board.add( list.map { it == "." })
        }
        // 블로그 1
        // dp[row][state] = 현재 row행이 state 상태일 경우, 배치할 수 있는 최대 학생 수 (state는 이진수로 표현된것)
        val binary = MutableList(1 shl m) { "" }
        fun toBinary(x: Int): String { // m에 대한 2진수를 구하는 함수 -> 학생들이 어떻게 앉아 있는지 알 수 있는 모든 경우의 수
            var x1 = x
            var line = ""
            while (x1 >= 1) {
                line += if (x1 % 2 == 0) "0"
                else "1"
                x1 /= 2
            }
            while (line.length < m) line += "0"
            return line.reversed()
        }
        for (i in 0 until (1 shl m)) {
            binary[i] = toBinary(i)
        }
        for (i in 0 until n)
            for (j in 0 until (1 shl m)) {
                val str = binary[j]
                var flag = false
                var count = 0
                // 같은 행을 판단하는 부분
                for (a in str.indices) { // 양 옆을 판단하는 기준 -> 못 앉는 을때 flag = true
                    if (str[a] == '1' && board[i][a] == "x") { // 1로 앉을 수 있지만, x로 없는 자리일 때
                        flag = true
                        break
                    }
                    if (str[a] == '1' && a < str.length - 1) // 1로 앉을 수 있고, 전체 길이 보다 작을 떄
                        if (str[a + 1] == '1') { // 바로 다음 것이 1이면 앉을 수 없음
                            flag = true
                            break
                        }
                    if (str[a] == '1') count++ // 1이면 앉을 수 있기 때문에 count+1
                }
                if (flag) continue // 못 앉으면 넘어감
                if (i == 0) { // 맨 윗줄일 때
                    dp[i][j] = count // 그냥 넣기 -> 위에 열을 확인 할 필요가 없음
                    continue
                }
                for (k in 0 until (1 shl m)) { // 위의 열에서 같은 행 부분을 확인하는 부분
                    val upStr = binary[k]
                    if (dp[i - 1][k] == 0) continue // 위의 열에서 같은 행 부분이 0 이면 넘어감
                    flag = false
                    for (a in str.indices) {
                        if (str[a] == '1') { // 본인이 1일때
                            if (a > 0 && upStr[a - 1] == '1') { // 왼쪽 위에 자리에 앉아 있을 떄
                                flag = true
                                break
                            }
                            if (a < str.length - 1 && upStr[a + 1] == '1') { // 오른쪽 위에 자리에 앉아 있을 때
                                flag = true
                                break
                            }
                        }
                    }
                    if (flag) continue
                    dp[i][j] = max(dp[i][j], count + dp[i - 1][k]);
                }
            }
        var answer = 0
        for (i in 0 until (1 shl m))
            answer = max(answer, dp[n - 1][i])
        println(answer)


        // 블로그 2
        // 한줄에 앉을 수 있는 경우의 수만 구했기 때문에 블로그 1에서의 같은 행을 검사하는 부분은 필요 없음
        // 𝑏𝑖𝑡𝑀𝑎𝑠𝑘[𝑐𝑢𝑟𝑟𝑒𝑛𝑡_𝑙𝑖𝑛𝑒_𝑛𝑢𝑚𝑏𝑒𝑟][𝑏𝑒𝑓𝑜𝑟𝑒_𝑙𝑖𝑛𝑒_𝑏𝑖𝑡𝑚𝑎𝑠𝑘]=현재 𝑙𝑖𝑛𝑒을 포함한 뒷자리에 학생들이 앉는 최대 학생수
        val dfsArray = MutableList(m) { 0 }
        val lines = mutableListOf<String>()
        fun dfs(index: Int) { // 한줄에 앉을 수 있는 학생들의 경우의 수 (1이 학생이 앉아있는거, 0이 앉아있지 않은거)
            if (m == index) { // 끝까지 진행 했을 떄?
                var str = ""
                for (a in dfsArray)
                    str += a.toString()
                lines.add(str)
                return
            }
            dfsArray[index] = 0
            dfs(index + 1)
            if (0 < index && dfsArray[index - 1] != 0) // 인덱스가 0 보다 크고, array의 마지막이 1이면
                return
            dfsArray[index] = 1
            dfs(index + 1)
        }
        dfs(0)
        println(lines)
        fun dp(lineNumber: Int, beforeBit: Int): Int {
            if (n == lineNumber)
                return 0
            if (-1 < dp[lineNumber][beforeBit])
                return dp[lineNumber][beforeBit]
            var answer = 0
            for (i in lines) { // 라인에는 행에 앉을 수 있는 학생의 경우의 수만 나와있음 (않지 못하는 경우는 뺌)
                var bits = 0
                var count = 0
                for (j in 0 until m) {
                    if ('0' == i[j]) continue // 0인 부분은 넘어감
                    if ("x" == board[lineNumber][j]) continue // 의자가 부서진 부분도 넘어감
                    if (0 < j && 0 < beforeBit and (1 shl (j - 1))) continue // 오른쪽 위를 and하여 1이상이 나오면 겹치는 것. 첫번째는 beforebit가 0 이기 떄문에 무조건 0이 나올 수 밖에 없음
                    if (0 < beforeBit and (1 shl (j + 1))) continue // 왼쪽 위를 and하여 1이상이 나오면 겹치는 것. 첫번째는 beforebit가 0 이기 떄문에 무조건 0이 나올 수 밖에 없음
                    count++ // 마지막에 count 추가
                    bits = bits or (1 shl j) // 비트에 현재 비트 추가 (덧셈 개념)
                }
                answer = max(answer, dp(lineNumber + 1, bits) + count)
            }
            dp[lineNumber][beforeBit] = answer
            return answer
        }
        println(dp(0, 0))
    }
}