package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR




    fun Date.format(pattern:String = "HH:mm:ss dd.MM.yy") :String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

    fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
        var time = this.time

        time += when (units) {
            TimeUnits.SECOND -> value * SECOND
            TimeUnits.MINUTE -> value * MINUTE
            TimeUnits.HOUR -> value * HOUR
            TimeUnits.DAY -> value * DAY
        }
        this.time = time
        return this
}

fun Date?.humanizeDiff(date: Date = Date()): String {

//    val net  = this!!.time.toString()

    fun qformat (pattern: String =  "HH:mm:ss dd.MM.yy") :String {
        val sdf = SimpleDateFormat(pattern, Locale("ru"))
        val exdate = sdf.format(Date())
        println(exdate)
        return exdate
    }

//    val rty = qformat()
////    println(rty)
    val curdate = Date().time
    val difsec = (date.time - this!!.time)/1000
//    val curdate2 = Date().time

    var znach: Long = 0
    var minlist : List <Long> = arrayListOf(2,3,4,22,23,24,32,33,34,42,43,44)
    // 2,3,4 минуты  21 минуту 22,23,24..... все остальное минут
    // 2,3,4  часа   21 час  22,23,24.....  все остальное часов
    // 2,3,4, дня    21 день 22,23,24.....  все остальное дней
if (difsec > 0 ) {
    when (difsec) {
        in 76..2700 -> znach = difsec / 60
        in 4501..79200 -> znach = difsec / 3600
        in 93601..311040000 -> znach = difsec / 86400
    }

    return when (difsec) {
        in 0..1 -> "только что"
        in 2..45 -> "несколько секунд назад"
        in 46..75 -> "минуту назад"
        in 76..2700 -> "$znach минут назад"
        in 2701..4500 -> "час назад"
        in 4501..79200 -> "$znach часов назад"
        in 79201..93600 -> "день назад"
        in 93601..311040000 -> "$znach дней назад"
        else -> "более года назад"
    }
}
    else {
    val difsecp = difsec*(-1)
    }
//    println(difsec)
//    println(curdate)


//    fun qformat (pattern: String =  "HH:mm:ss dd.MM.yy") :String {
//        val dateFormat = SimpleDateFormat(pattern , Locale("ru"))
//        return dateFormat.format(this)
//    }
//    val opt = qformat(net)
//    println(rt)
//    println(opt)
//    val da = SimpleDateFormat(net, Locale ("ru"))

//    println(da)
//    net.compareTo(date)

//    val sd = date - net
    return "tek"
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}