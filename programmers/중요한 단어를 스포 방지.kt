// 구현
class 중요한_단어를_스포_방지 {
    fun solution(message: String, spoiler_ranges: Array<IntArray>): Int {
        var answer: Int = 0

        // 1. 전체 문장을 (단어, 시작 인덱스, 끝 인덱스) 순으로 묶는다.
        var start = 0
        val words = mutableListOf<Triple<String, Int, Int>>()
        for (i in message.indices) {
            if (message[i] == ' ') {
                words.add(Triple(message.slice(start until i), start, i - 1))
                start = i + 1
            }
        }
        if (start < message.length) // 마지막 단어 추가
            words.add(Triple(message.slice(start until message.length), start, message.length-1))


        // 2. 전체 단어를 돌면서 스포일러 단어인지 아닌지 판단
        val non = mutableSetOf<String>()
        val yes = mutableSetOf<String>()

        for (j in words) {
            var isSpoiler = false

            for (i in spoiler_ranges) {
                if (i[0] <= j.third && i[1] >= j.second) { // 단어의 시작 <= 스포일러 범위의 끝 && 단어의 끝 >= 스포일러 범위의 시작 이면 범위가 겹치는 걸로 판단
                    isSpoiler = true
                    break
                }
            }

            if (isSpoiler)
                yes.add(j.first)
            else
                non.add(j.first)
        }

        // 3. 스포일러 단어가 일반 단어에 속하는 지 확인(속한다면 제거)
        answer = yes.size
        for (i in yes)
            if (i in non)
                answer--

        return answer
    }
}
