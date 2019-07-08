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
        val stroka : String = this.replace("<p>", "").replace("class=\"title\">" , "").replace("</p>" , "")
            .replace("<p","")
            .replace	(	"<a>"	,	""	)
            .replace	(	"<abbr>"	,	""	)
            .replace	(	"<address>"	,	""	)
            .replace	(	"<area>"	,	""	)
            .replace	(	"<article>"	,	""	)
            .replace	(	"<aside>"	,	""	)
            .replace	(	"<audio>"	,	""	)
            .replace	(	"<b>"	,	""	)
            .replace	(	"<base>"	,	""	)
            .replace	(	"<bdi>"	,	""	)
            .replace	(	"<bdo>"	,	""	)
            .replace	(	"<blockquote>"	,	""	)
            .replace	(	"<body>"	,	""	)
            .replace	(	"<br>"	,	""	)
            .replace	(	"<button>"	,	""	)
            .replace	(	"<canvas>"	,	""	)
            .replace	(	"<caption>"	,	""	)
            .replace	(	"<cite>"	,	""	)
            .replace	(	"<code>"	,	""	)
            .replace	(	"<col>"	,	""	)
            .replace	(	"<colgroup>"	,	""	)
            .replace	(	"<data>"	,	""	)
            .replace	(	"<datalist>"	,	""	)
            .replace	(	"<dd>"	,	""	)
            .replace	(	"<del>"	,	""	)
            .replace	(	"<details>"	,	""	)
            .replace	(	"<dfn>"	,	""	)
            .replace	(	"<dialog>"	,	""	)
            .replace	(	"<div>"	,	""	)
            .replace	(	"<dl>"	,	""	)
            .replace	(	"<dt>"	,	""	)
            .replace	(	"<em>"	,	""	)
            .replace	(	"<embed>"	,	""	)
            .replace	(	"<fieldset>"	,	""	)
            .replace	(	"<figcaption>"	,	""	)
            .replace	(	"<figure>"	,	""	)
            .replace	(	"<footer>"	,	""	)
            .replace	(	"<form>"	,	""	)
            .replace	(	"<h1-h6>"	,	""	)
            .replace	(	"<head>"	,	""	)
            .replace	(	"<header>"	,	""	)
            .replace	(	"<hr>"	,	""	)
            .replace	(	"<html>"	,	""	)
            .replace	(	"<i>"	,	""	)
            .replace	(	"<iframe>"	,	""	)
            .replace	(	"<img>"	,	""	)
            .replace	(	"<input>"	,	""	)
            .replace	(	"<ins>"	,	""	)
            .replace	(	"<kbd>"	,	""	)
            .replace	(	"<label>"	,	""	)
            .replace	(	"<legend>"	,	""	)
            .replace	(	"<li>"	,	""	)
            .replace	(	"<link>"	,	""	)
            .replace	(	"<main>"	,	""	)
            .replace	(	"<map>"	,	""	)
            .replace	(	"<mark>"	,	""	)
            .replace	(	"<meta>"	,	""	)
            .replace	(	"<meter>"	,	""	)
            .replace	(	"<nav>"	,	""	)
            .replace	(	"<noscript>"	,	""	)
            .replace	(	"<object>"	,	""	)
            .replace	(	"<ol>"	,	""	)
            .replace	(	"<optgroup>"	,	""	)
            .replace	(	"<option>"	,	""	)
            .replace	(	"<output>"	,	""	)
            .replace	(	"<p>"	,	""	)
            .replace	(	"<param>"	,	""	)
            .replace	(	"<picture>"	,	""	)
            .replace	(	"<pre>"	,	""	)
            .replace	(	"<progress>"	,	""	)
            .replace	(	"<q>"	,	""	)
            .replace	(	"<ruby>"	,	""	)
            .replace	(	"<rb>"	,	""	)
            .replace	(	"<rt>"	,	""	)
            .replace	(	"<rtc>"	,	""	)
            .replace	(	"<rp>"	,	""	)
            .replace	(	"<s>"	,	""	)
            .replace	(	"<samp>"	,	""	)
            .replace	(	"<script>"	,	""	)
            .replace	(	"<section>"	,	""	)
            .replace	(	"<select>"	,	""	)
            .replace	(	"<small>"	,	""	)
            .replace	(	"<source>"	,	""	)
            .replace	(	"<span>"	,	""	)
            .replace	(	"<strong>"	,	""	)
            .replace	(	"<style>"	,	""	)
            .replace	(	"<sub>"	,	""	)
            .replace	(	"<summary>"	,	""	)
            .replace	(	"<sup>"	,	""	)
            .replace	(	"<table>"	,	""	)
            .replace	(	"<tbody>"	,	""	)
            .replace	(	"<td>"	,	""	)
            .replace	(	"<template>"	,	""	)
            .replace	(	"<textarea>"	,	""	)
            .replace	(	"<tfoot>"	,	""	)
            .replace	(	"<th>"	,	""	)
            .replace	(	"<thead>"	,	""	)
            .replace	(	"<time>"	,	""	)
            .replace	(	"<title>"	,	""	)
            .replace	(	"<tr>"	,	""	)
            .replace	(	"<track>"	,	""	)
            .replace	(	"<u>"	,	""	)
            .replace	(	"<ul>"	,	""	)
            .replace	(	"<var>"	,	""	)
            .replace	(	"<video>"	,	""	)
            .replace	(	"<wbr>"	,	""	)
            .replace	(	"</a>"	,	""	)
            .replace	(	"</abbr>"	,	""	)
            .replace	(	"</address>"	,	""	)
            .replace	(	"</area>"	,	""	)
            .replace	(	"</article>"	,	""	)
            .replace	(	"</aside>"	,	""	)
            .replace	(	"</audio>"	,	""	)
            .replace	(	"</b>"	,	""	)
            .replace	(	"</base>"	,	""	)
            .replace	(	"</bdi>"	,	""	)
            .replace	(	"</bdo>"	,	""	)
            .replace	(	"</blockquote>"	,	""	)
            .replace	(	"</body>"	,	""	)
            .replace	(	"</br>"	,	""	)
            .replace	(	"</button>"	,	""	)
            .replace	(	"</canvas>"	,	""	)
            .replace	(	"</caption>"	,	""	)
            .replace	(	"</cite>"	,	""	)
            .replace	(	"</code>"	,	""	)
            .replace	(	"</col>"	,	""	)
            .replace	(	"</colgroup>"	,	""	)
            .replace	(	"</data>"	,	""	)
            .replace	(	"</datalist>"	,	""	)
            .replace	(	"</dd>"	,	""	)
            .replace	(	"</del>"	,	""	)
            .replace	(	"</details>"	,	""	)
            .replace	(	"</dfn>"	,	""	)
            .replace	(	"</dialog>"	,	""	)
            .replace	(	"</div>"	,	""	)
            .replace	(	"</dl>"	,	""	)
            .replace	(	"</dt>"	,	""	)
            .replace	(	"</em>"	,	""	)
            .replace	(	"</embed>"	,	""	)
            .replace	(	"</fieldset>"	,	""	)
            .replace	(	"</figcaption>"	,	""	)
            .replace	(	"</figure>"	,	""	)
            .replace	(	"</footer>"	,	""	)
            .replace	(	"</form>"	,	""	)
            .replace	(	"</h1-h6>"	,	""	)
            .replace	(	"</head>"	,	""	)
            .replace	(	"</header>"	,	""	)
            .replace	(	"</hr>"	,	""	)
            .replace	(	"</html>"	,	""	)
            .replace	(	"</i>"	,	""	)
            .replace	(	"</iframe>"	,	""	)
            .replace	(	"</img>"	,	""	)
            .replace	(	"</input>"	,	""	)
            .replace	(	"</ins>"	,	""	)
            .replace	(	"</kbd>"	,	""	)
            .replace	(	"</label>"	,	""	)
            .replace	(	"</legend>"	,	""	)
            .replace	(	"</li>"	,	""	)
            .replace	(	"</link>"	,	""	)
            .replace	(	"</main>"	,	""	)
            .replace	(	"</map>"	,	""	)
            .replace	(	"</mark>"	,	""	)
            .replace	(	"</meta>"	,	""	)
            .replace	(	"</meter>"	,	""	)
            .replace	(	"</nav>"	,	""	)
            .replace	(	"</noscript>"	,	""	)
            .replace	(	"</object>"	,	""	)
            .replace	(	"</ol>"	,	""	)
            .replace	(	"</optgroup>"	,	""	)
            .replace	(	"</option>"	,	""	)
            .replace	(	"</output>"	,	""	)
            .replace	(	"</p>"	,	""	)
            .replace	(	"</param>"	,	""	)
            .replace	(	"</picture>"	,	""	)
            .replace	(	"</pre>"	,	""	)
            .replace	(	"</progress>"	,	""	)
            .replace	(	"</q>"	,	""	)
            .replace	(	"</ruby>"	,	""	)
            .replace	(	"</rb>"	,	""	)
            .replace	(	"</rt>"	,	""	)
            .replace	(	"</rtc>"	,	""	)
            .replace	(	"</rp>"	,	""	)
            .replace	(	"</s>"	,	""	)
            .replace	(	"</samp>"	,	""	)
            .replace	(	"</script>"	,	""	)
            .replace	(	"</section>"	,	""	)
            .replace	(	"</select>"	,	""	)
            .replace	(	"</small>"	,	""	)
            .replace	(	"</source>"	,	""	)
            .replace	(	"</span>"	,	""	)
            .replace	(	"</strong>"	,	""	)
            .replace	(	"</style>"	,	""	)
            .replace	(	"</sub>"	,	""	)
            .replace	(	"</summary>"	,	""	)
            .replace	(	"</sup>"	,	""	)
            .replace	(	"</table>"	,	""	)
            .replace	(	"</tbody>"	,	""	)
            .replace	(	"</td>"	,	""	)
            .replace	(	"</template>"	,	""	)
            .replace	(	"</textarea>"	,	""	)
            .replace	(	"</tfoot>"	,	""	)
            .replace	(	"</th>"	,	""	)
            .replace	(	"</thead>"	,	""	)
            .replace	(	"</time>"	,	""	)
            .replace	(	"</title>"	,	""	)
            .replace	(	"</tr>"	,	""	)
            .replace	(	"</track>"	,	""	)
            .replace	(	"</u>"	,	""	)
            .replace	(	"</ul>"	,	""	)
            .replace	(	"</var>"	,	""	)
            .replace	(	"</video>"	,	""	)
            .replace	(	"</wbr>"	,	""	)
            .replace("&amp;", "")
            .replace("&lt;", "")
            .replace("&gt;", "")
            .replace("&quot;" ,"")
            .replace("&apos;", "")
            .replace("&#39;", "")
            .replace("&", "")
            .replace("\"", "")
            .replace("\'", "")
            .trim()

        val achar  = stroka.toCharArray()
        val mutlist : MutableList<String> = arrayListOf()
        achar.forEach { mutlist.add(it.toString()) }
//        println(mutlist)
        for (n in 0..mutlist.lastIndex) {
            if (mutlist[n].isBlank() && mutlist[n+1].isBlank()) {
                mutlist.set(n+1, "")
            }
        }
    return mutlist.joinToString ("")
}


    fun String.stripHtml2 () :String {
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

//        println("123")
//        println(uco)

//        if (uco=="") {
//            return ""
//        }
//        if (uco==" ") {
//            return uco
//        }




//        val achar  = uco.toCharArray()
//        val mutlist : MutableList<String> = arrayListOf()
//        achar.forEach { mutlist.add(it.toString()) }
//        println(mutlist)
//        for (n in 0..mutlist.lastIndex) {
//            if (mutlist[n].isBlank() && mutlist[n+1].isBlank()) {
////                mutlist.set(n+1, "")
//                mutlist.removeAt(n+1)
//                println("123")
//                println(mutlist)
//            }
//        }
////        println(mutlist.joinToString(""))
////        if (mutlist.joinToString ("") == "") {
////            return " "
////        }
////    return mutlist.joinToString ("")
//

        while (uco.contains("  ")) {
            uco = uco.replace("  ", " ")
        }
//        println("testing")
//        println(uco)
//        println("end")



        return uco
}
