const val SECOND = 60
const val HOUR = 60 * 60
const val DAY = 60 * 60 * 24

fun main() {
    val userTime = 3600
    val userSex = "man"

    print(agoToText(userTime, userSex))
}

fun agoToText(seconds: Int, userSex: String): String =
    when {
        seconds > DAY * 3 -> "${genderUser(userSex)} давно"
        seconds > DAY * 2 -> "${genderUser(userSex)} вчера"
        seconds >= DAY -> "${genderUser(userSex)} сегодня"
        seconds >= HOUR -> "${genderUser(userSex)} ${seconds / HOUR} ${endHour(seconds)} назад"
        seconds >= SECOND -> "${genderUser(userSex)} ${seconds / SECOND} ${endMinute(seconds)} назад"
        seconds > 1 -> "${genderUser(userSex)} только что"
        else -> "В сети"
    }

fun genderUser(userSex: String): String {
    return if (userSex == "man") "Был" else "Была"
}

fun endHour(seconds: Int): String {
    return when (seconds / HOUR) {
        1, 21 -> "час"
        2, 3, 4, 22, 23 -> "часа"
        else -> "часов"
    }
}

fun endMinute(seconds: Int): String {
    return when (seconds / SECOND) {
        1, 21, 31, 41, 51 -> "минуту"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> "минуты"
        else -> "минут"
    }
}
