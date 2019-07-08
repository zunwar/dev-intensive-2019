package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName (fullName:String?) : Pair<String?, String?> {


        if ( fullName != null && fullName.isNotBlank() ) {
            val parts: List<String>? = fullName.split(" ")
            val firstName = parts?.getOrNull(0)
            val lastName = parts?.getOrNull(1)
            val  name = firstName to lastName

            return when {
                firstName=="" -> Pair(null, lastName)
                lastName=="" -> Pair(firstName, null)
                else -> Pair (firstName , lastName)
            }
        }
        return Pair(null , null )
    }

    fun transliteration(payload: String, divider:String = " "): String {

         if (payload != null && payload.isNotBlank()) {
             val parts: List<String>? = payload.split(" ")
             println(parts)

             val translit: MutableList<String> = mutableListOf()
//             println(preob)

           fun funcpreob (preob : CharArray) :String {
             for (i in preob) {
                 val s = i.toString()

                 when (s) {
                     "а" -> translit.add("a")
                     "б" -> translit.add("b")
                     "в" -> translit.add("v")
                     "г" -> translit.add("g")
                     "д" -> translit.add("d")
                     "е" -> translit.add("e")
                     "ё" -> translit.add("e")
                     "ж" -> translit.add("zh")
                     "з" -> translit.add("z")
                     "и" -> translit.add("i")
                     "й" -> translit.add("i")
                     "к" -> translit.add("k")
                     "л" -> translit.add("l")
                     "м" -> translit.add("m")
                     "н" -> translit.add("n")
                     "о" -> translit.add("o")
                     "п" -> translit.add("p")
                     "р" -> translit.add("r")
                     "с" -> translit.add("s")
                     "т" -> translit.add("t")
                     "у" -> translit.add("u")
                     "ф" -> translit.add("f")
                     "х" -> translit.add("h")
                     "ц" -> translit.add("c")
                     "ч" -> translit.add("ch")
                     "ш" -> translit.add("sh")
                     "щ" -> translit.add("sh'")
                     "ъ" -> translit.add("")
                     "ы" -> translit.add("i")
                     "ь" -> translit.add("")
                     "э" -> translit.add("e")
                     "ю" -> translit.add("yu")
                     "я" -> translit.add("ya")
                     "А" -> translit.add("A")
                     "Б" -> translit.add("B")
                     "В" -> translit.add("V")
                     "Г" -> translit.add("G")
                     "Д" -> translit.add("D")
                     "Е" -> translit.add("E")
                     "Ё" -> translit.add("E")
                     "Ж" -> translit.add("ZH")
                     "З" -> translit.add("Z")
                     "И" -> translit.add("I")
                     "Й" -> translit.add("I")
                     "К" -> translit.add("K")
                     "Л" -> translit.add("L")
                     "М" -> translit.add("M")
                     "Н" -> translit.add("N")
                     "О" -> translit.add("O")
                     "П" -> translit.add("P")
                     "Р" -> translit.add("R")
                     "С" -> translit.add("S")
                     "Т" -> translit.add("T")
                     "У" -> translit.add("U")
                     "Ф" -> translit.add("F")
                     "Х" -> translit.add("H")
                     "Ц" -> translit.add("C")
                     "Ч" -> translit.add("CH")
                     "Ш" -> translit.add("SH")
                     "Щ" -> translit.add("SH'")
                     "Ъ" -> translit.add("")
                     "Ы" -> translit.add("I")
                     "Ь" -> translit.add("")
                     "Э" -> translit.add("E")
                     "Ю" -> translit.add("YU")
                     "Я" -> translit.add("YA")
                     "a" -> translit.add("a")
                     "b" -> translit.add("b")
                     "v" -> translit.add("v")
                     "g" -> translit.add("g")
                     "d" -> translit.add("d")
                     "e" -> translit.add("e")
                     "zh" -> translit.add("zh")
                     "z" -> translit.add("z")
                     "i" -> translit.add("i")
                     "k" -> translit.add("k")
                     "l" -> translit.add("l")
                     "m" -> translit.add("m")
                     "n" -> translit.add("n")
                     "o" -> translit.add("o")
                     "p" -> translit.add("p")
                     "r" -> translit.add("r")
                     "s" -> translit.add("s")
                     "t" -> translit.add("t")
                     "u" -> translit.add("u")
                     "f" -> translit.add("f")
                     "h" -> translit.add("h")
                     "c" -> translit.add("c")
                     "ch" -> translit.add("ch")
                     "sh" -> translit.add("sh")
                     "sh'"-> translit.add("sh'")
                     "yu" -> translit.add("yu")
                     "ya" -> translit.add("ya")
                     "A"  -> translit.add("A")
                     "B"  -> translit.add("B")
                     "V"  -> translit.add("V")
                     "G"  -> translit.add("G")
                     "D"  -> translit.add("D")
                     "E"  -> translit.add("E")
                     "ZH" -> translit.add("ZH")
                     "Z"  -> translit.add("Z")
                     "I"  -> translit.add("I")
                     "K" -> translit.add("K")
                     "L" -> translit.add("L")
                     "M" -> translit.add("M")
                     "N" -> translit.add("N")
                     "O" -> translit.add("O")
                     "P" -> translit.add("P")
                     "R" -> translit.add("R")
                     "S" -> translit.add("S")
                     "T" -> translit.add("T")
                     "U" -> translit.add("U")
                     "F" -> translit.add("F")
                     "H" -> translit.add("H")
                     "C" -> translit.add("C")
                     "CH" -> translit.add("CH")
                     "SH" -> translit.add("SH")
                     "SH'"-> translit.add("SH'")
                     "YU" -> translit.add("YU")
                     "YA" -> translit.add("YA")
                 }
             }
               return translit.toString().replace("[", "").replace(",", "")
                   .replace("]", "").replace(" ", "")
           }

                val arstroka : MutableList<String> = arrayListOf()
             for (n in 0..parts!!.lastIndex) {
                 arstroka.add(funcpreob(parts[n].toCharArray()))
                 translit.clear()
                 println(parts[n].toCharArray())
             }
             println(arstroka)
//             println(arstroka.joinToString (""))

//             val te = "Super"
//             val tes = te.toCharArray()
//             val test = funcpreob(tes)
//             println(test)



             return ("${arstroka[0]}$divider${arstroka[1]} ${arstroka.getOrNull(2)}")
         }
////        return ("$z1$ffslovo$divider$z2$ssslovo")
//        return ("${trans} $divider 123")
        return ""

    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var f : String = ""
        var l : String = ""
        if (firstName != null && firstName.isNotEmpty()) {
            val fic = firstName.toCharArray().first()
            val fi = fic.toString().toUpperCase()
            f = fi
        }
        if (lastName != null && lastName.isNotEmpty()) {
            val lic = lastName.toCharArray().first()
            val li = lic.toString().toUpperCase()
            l=li
        }
        if (firstName != null &&  firstName.isBlank() && lastName != null &&  lastName.isBlank() ){
            return null
        }
        return when {
            firstName=="" -> (l)
            lastName=="" -> (f)
            firstName==null && lastName==null -> null
            firstName=="" && lastName==null -> null
            firstName==null && lastName=="" -> null
            else -> ("$f$l")
        }

    }
}