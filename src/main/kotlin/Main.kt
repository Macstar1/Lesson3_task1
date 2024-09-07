fun main() {
    println(agoToText(4 * HOUR))
}

fun agoToText(secondsAgo: Int): String {
    return when (secondsAgo) {
        in 0..<MINUTE -> "был(а) только что"
        in MINUTE..<HOUR -> "был(а) ${secondsAgo / MINUTE} ${minutesConvert(secondsAgo)} назад"
        in HOUR..DAY -> "был(а) ${secondsAgo / HOUR} ${hoursConvert(secondsAgo)} назад"
        in DAY + 1..<DAY * 2 -> "был(а) вчера"
        in DAY * 2..<DAY * 3 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}

fun minutesConvert(secondsAgo: Int): String {
    return if (secondsAgo / MINUTE in 11..20) "минут" else {
        when (secondsAgo / MINUTE % 10) {
            1 -> "минуту"
            2, 3, 4 -> "минуты"
            else -> "минут"
        }
    }
}

fun hoursConvert(secondsAgo: Int): String {
    return if (secondsAgo / HOUR in 5..20) "часов" else {
        when (secondsAgo / HOUR % 10) {
            1 -> "час"
            else -> "часа"
        }
    }
}

const val MINUTE = 60
const val HOUR = 60 * 60
const val DAY = 24 * 60 * 60
