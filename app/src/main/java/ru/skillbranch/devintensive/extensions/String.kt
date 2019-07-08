package ru.skillbranch.devintensive.extensions



fun String.truncate(tnum : Int = 16) : String {
    val stroka = this
    val vchar = stroka.toCharArray()
    val uschar : List<Char>
    val usstroka : String
//    println(vchar.count())
//    println(vchar.lastIndex)
    if(tnum > vchar.count()) {
       return stroka.trimEnd()
    }
    else {
        val n = vchar.count() - tnum
        uschar = vchar.dropLast(n)
//        val d = uschar.lastIndex-1
//        val dd = uschar.lastIndex
//        println(d)
//        println(uschar)
        usstroka = uschar.joinToString("").trimEnd()
        if (uschar[uschar.lastIndex].isWhitespace() && uschar[uschar.lastIndex-1].isWhitespace()){
            return usstroka
        }
        else {return "$usstroka..."}

    }
//        usstroka = uschar.joinToString("").trimEnd()
//        if ((tnum-1) > usstroka.count()){
////            usstroka = uschar.joinToString("").trimEnd()
//            return usstroka
//        }
////         else {usstroka = uschar.joinToString("").trimEnd()}
//        else {return "$usstroka..."}

//    return "$usstroka..."
}





    fun String.stripHtml () :String {
        val stroka : String = this
        var uco = Regex("<[^>]*>").replace(stroka, "")
//        var uco = this
            .replace("&amp;", "")
            .replace("&lt;", "")
            .replace("&gt;", "")
            .replace("&quot;" ,"")
            .replace("&apos;", "")
            .replace("&#39;", "")
//            .replace("&", "")
            .replace("\"", "")
            .replace("\'", "")
//            .trimEnd()
        while (uco.contains("  ")) {
            uco = uco.replace("  ", " ")
        }

        return uco
}
