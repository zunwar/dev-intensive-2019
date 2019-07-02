package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName (fullName:String?) : Pair<String?, String?> {

        if ( fullName != null && fullName.isNotEmpty() ) {
            val parts: List<String>? = fullName.split(" ")
            val firstName = parts?.getOrNull(0)
            val lastName = parts?.getOrNull(1)

            return when {
                firstName=="" -> Pair(null, lastName)
                lastName=="" -> Pair(firstName, null)
                else -> Pair (firstName , lastName)
            }
        }
        return Pair(null , null )
    }

    fun transliteration(payload: String, divider:String = " "): String {
        return "eshe ne sdelano transliteration"

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

        return when {
            firstName=="" -> (l)
            lastName=="" -> (f)
            firstName==null&& lastName==null -> ("null")
            firstName==" " || lastName==" " -> ("null")
            else -> ("$f$l")
        }

//        return "null"

//        return when {
//            firstName=="" -> null
//            else -> val fi: Char =name?.first()
//        }

//        var fi = firstName?.get(0)
//        var si = lastName?.get(0)
//        return println("$fi , $si")
    }
}