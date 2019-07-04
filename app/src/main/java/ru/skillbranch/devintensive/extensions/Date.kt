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

//    fun qformat (pattern: String =  "HH:mm:ss dd.MM.yy") :String {
//        val sdf = SimpleDateFormat(pattern, Locale("ru"))
//        val exdate = sdf.format(Date())
//        println(exdate)
//        return exdate
//    }

//    val rty = qformat()
////    println(rty)
//    val curdate = Date().time
    val difsec = (date.time - this!!.time)/1000
//    val curdate2 = Date().time

    var znachmin: Long = 0
    var znachchas: Long = 0
    var znachdni: Long = 0
    val minlist : List <Long> = arrayListOf(2,3,4,22,23,24,32,33,34,42,43,44)
    val chaslist : List <Int> = arrayListOf(2,3,4,22)
    val range1 = 22..352 step 10
    val range2 = 23..353 step 10
    val range3 = 24..354 step 10
    // 2,3,4 минуты 22,23,24..... 1,21 минуту  все остальное минут
    // 2,3,4  часа  22,23,24..... 1,21 час    все остальное часов
    // 2,3,4, дня   22,23,24..... 1,21 день   все остальное дней
if (difsec > 0 ) {
    when (difsec) {
        in 76..2700 -> znachmin = difsec / 60
        in 4501..79200 -> znachchas = difsec / 3600
        in 93601..31104000 -> znachdni = difsec / 86400
    }

    when (znachmin) {
        in minlist -> return "$znachmin минуты назад"
        21.toLong() -> return "$znachmin минуту назад"
        1.toLong() -> return "$znachmin минуту назад"
    }

    when (znachchas.toInt()) {
        in chaslist -> return "$znachchas часа назад"
        1,21 -> return "$znachchas час назад"
    }


    when (znachdni.toInt()) {
        in range1 -> return "$znachdni дня назад"
        in range2 -> return "$znachdni дня назад"
        in range3 -> return "$znachdni дня назад"
        1,21 -> return "$znachdni день назад"
    }

    return when (difsec) {
        in 0..1 -> "только что"
        in 2..45 -> "несколько секунд назад"
        in 46..75 -> "минуту назад"
        in 76..2700 -> "$znachmin минут назад"
        in 2701..4500 -> "час назад"
        in 4501..79200 -> "$znachchas часов назад"
        in 79201..93600 -> "день назад"
        in 93601..31104000 -> "$znachdni дней назад"
        else -> "более года назад"
    }
}
    else {
    val difsecp = difsec*(-1)
    when (difsecp) {
        in 76..2700 -> znachmin = difsecp / 60
        in 4501..79200 -> znachchas = difsecp / 3600
        in 93601..31104000 -> znachdni = difsecp / 86400
    }

    when (znachmin) {
        in minlist -> return "через $znachmin минуты"
        21.toLong() -> return "через $znachmin минуту"
        1.toLong() -> return "через $znachmin минуту"
    }

    when (znachchas.toInt()) {
        in chaslist -> return "через $znachchas часа"
        1,21 -> return "через $znachchas час"
    }


    when (znachdni.toInt()) {
        in range1 -> return "через $znachdni дня"
        in range2 -> return "через $znachdni дня"
        in range3 -> return "через $znachdni дня"
        1,21 -> return "через $znachdni день"
    }

    return when (difsecp) {
        in 0..1 -> "только что"
        in 2..45 -> "через несколько секунд"
        in 46..75 -> "через минуту"
        in 76..2700 -> "через $znachmin минут"
        in 2701..4500 -> "через час"
        in 4501..79200 -> "через $znachchas часов"
        in 79201..93600 -> "через день"
        in 93601..31104000 -> "через $znachdni дней"
        else -> "более чем через год"
    }
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
    return "$difsec"
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural (int: Int) : String{
        val unit = this
        println(unit)
        val parse = int.toString().toCharArray().last()
        println(parse)
        var vremya : String = ""
        when (unit) {
            SECOND ->  {
                println("ya tut")
                val nen = parse.toString().toInt()
                println(nen)
                if (nen==2 || nen==3 || nen==4){
                    vremya = "секунды"
                }
            }
            MINUTE ->  MINUTE
            HOUR ->  HOUR
            DAY ->  DAY
        }

        return "$int $vremya"
    }
}
//    fun TimeUnits.plural (int: Int) : String{
//        val unit = TimeUnits.
//        val parse = int.toString().toCharArray().last()
//        var vremya : String = ""
//        when (unit) {
//           TimeUnits.SECOND ->  {
//               val nen = parse.toInt()
//               if (nen==2 || nen==3 || nen==4){
//                   vremya = "секунды"
//               }
//           }
//           TimeUnits.MINUTE ->  MINUTE
//           TimeUnits.HOUR ->  HOUR
//           TimeUnits.DAY ->  DAY
//        }
//
//    return "$int $vremya"
//    }


