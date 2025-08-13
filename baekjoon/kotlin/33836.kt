package com.kguard.tobecomebetter.baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 실버 4 벌집우주와 쿼리
// 수학, 애드 혹, 많은 조건 분기
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val q = br.readLine().toInt()
    repeat(q) {
        // 시작이 (0,0) 에서 x만 증가하는 0도 방향
        val (x, y) = br.readLine().split(" ").map { it.toLong() }
        if (x >= 0) { // x가 0보다 크거나 같으면 x에 대해서는 방향을 안 바꿔도 됨
            if (y == 0L) // y가 0이면 y는 방향을 바꾸지 않은거 0
                bw.write("0\n")
            else
                bw.write("1\n") // y가 변하면 방향을 1번 바꾸면 됨
        } else { // x가 0 보다 작을 떄 x에 대해서 방향을 1번 바꿔야 됨
            if (y == 0L) // y가 0이면 x에 대한 방향 1번 바꾼거임
                bw.write("1\n")
            else if (x >= y) // x가 y보다 크면 0도 방향으로 움직이다가 방향을 1번 바꾼것이 됨
                bw.write("1\n")
            else // 나머지는 방향을 2번 바꿔야 됨
                bw.write("2\n")
        }
    }
    bw.flush()
    bw.close()
}