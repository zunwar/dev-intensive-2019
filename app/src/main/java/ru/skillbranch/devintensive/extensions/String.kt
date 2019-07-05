package ru.skillbranch.devintensive.extensions



fun String.truncate(tnum : Int = 16) : String {
    val stroka = this
    val vchar = stroka.toCharArray()
    val uschar : List<Char>
    val usstroka : String
    println(vchar.count())
    println(vchar.lastIndex)
    if(tnum > vchar.count()) {
       return stroka.trimEnd()
    }
    else {
        val n = vchar.count() - tnum
        uschar = vchar.dropLast(n)
//        val d : Char = uschar[lastIndex-1]
        usstroka = uschar.joinToString("").trimEnd()
        if (uschar[lastIndex-1].toString().isEmpty()){
            return usstroka
        }
        else {return "$usstroka..."}


//
//        usstroka = uschar.joinToString("").trimEnd()
//        if ((tnum-1) > usstroka.count()){
////            usstroka = uschar.joinToString("").trimEnd()
//            return usstroka
//        }
////         else {usstroka = uschar.joinToString("").trimEnd()}
//        else {return "$usstroka..."}




    }
//    println(uschar)
//    println(usstroka)

//    println(vchar)
//    return stroka

    return "$usstroka..."
}