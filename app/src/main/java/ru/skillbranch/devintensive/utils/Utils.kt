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
        var fslovo : String = ""
        var sslovo : String = ""
        var z1 : String = ""
        var z2 : String = ""
        var ssslovo :String =""
        var ffslovo :String =""


         if (payload != null && payload.isNotBlank()) {
             val parts: List<String>? = payload.split(" ")
             val firstName = parts?.getOrNull(0)
             val lastName = parts?.getOrNull(1)


             val preob = firstName!!.toCharArray()

             val translit: MutableList<String> = mutableListOf()

           fun funcpreob (preob : CharArray) :String {
             for (i in preob) {
                 var s = i.toString()

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

                 }
             }
               return translit.toString().replace("[", "").replace(",", "")
                   .replace("]", "").replace(" ", "")
           }

                fslovo = funcpreob(preob).toLowerCase()
                 z1 = fslovo.first().toUpperCase().toString()
             val perv = fslovo.first().toString()
             ffslovo = fslovo.replace(perv , "")

            val preob2 = lastName!!.toCharArray()
             translit.clear()
                sslovo = funcpreob(preob2).toLowerCase()
             val perv2 = sslovo.first().toString()
              z2 = sslovo.first().toUpperCase().toString()
                 ssslovo = sslovo.replace(perv2 , "")

         }
        return ("$z1$ffslovo$divider$z2$ssslovo")

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