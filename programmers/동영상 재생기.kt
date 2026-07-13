package com.kguard.tobecomebetter.programmers

class SSolution {
    fun solution(
        video_len: String,
        pos: String,
        op_start: String,
        op_end: String,
        commands: Array<String>
    ): String {
        var answer: String = pos
        for (i in commands) {
            if (i == "next") {
                answer = op(op_start, op_end, answer)
                answer = next(video_len, answer)
                answer = op(op_start, op_end, answer)
            } else if (i == "prev") {
                answer = op(start = op_start, end = op_end, answer)
                answer = prev(video_len, answer)
                answer = op(op_start, op_end, answer)
            }
        }
        return answer
    }

    fun op(start: String, end: String, now: String): String {
        var (nowH, nowS) = now.split(":").map { it.toInt() }
        val (sH, sS) = start.split(":").map { it.toInt() }
        val (eH, eS) = end.split(":").map { it.toInt() }

        val n = nowH * 60 + nowS
        val s = sH * 60 + sS
        val e = eH * 60 + eS
        
       if(n in s..e){
           nowH = eH
           nowS = eS
       }

        var rH = nowH.toString()
        var rS = nowS.toString()
        if (nowH < 10)
            rH = "0$nowH"
        if (nowS < 10)
            rS = "0$nowS"
        return "$rH:$rS"
    }

    fun next(video_len: String, time: String): String {
        val (vH, vS) = video_len.split(":").map { it.toInt() }
        var (nowH, nowS) = time.split(":").map { it.toInt() }
        nowS += 10

        if (nowS >= 60) {
            nowS -= 60
            nowH += 1
        }

        if (nowH > vH) {
            nowH = vH
            nowS = vS
        } else if (nowH == vH && nowS > vS) {
            nowS = vS
        }

        var rH = nowH.toString()
        var rS = nowS.toString()

        if (nowH < 10)
            rH = "0$nowH"
        if (nowS < 10)
            rS = "0$nowS"
        return "$rH:$rS"
    }

    fun prev(video_len: String, time: String): String {
        var (nowH, nowS) = time.split(":").map { it.toInt() }
        nowS -= 10

        if (nowS < 0) {
            nowS += 60
            nowH -= 1
        }

        if (nowH < 0) {
            nowH = 0
            nowS = 0
        }

        var rH = nowH.toString()
        var rS = nowS.toString()
        if (nowH < 10)
            rH = "0$nowH"
        if (nowS < 10)
            rS = "0$nowS"
        return "$rH:$rS"
    }
}