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
        return "eshe ne sdelano toInitials"
    }
}