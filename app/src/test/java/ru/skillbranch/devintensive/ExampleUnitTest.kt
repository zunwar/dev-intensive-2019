package ru.skillbranch.devintensive

import org.hamcrest.core.StringContains
import org.junit.Test

import org.junit.Assert.*
import java.util.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.utils.Utils
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import androidx.core.graphics.toColorInt
//import android.support.test.espresso.Espresso
//import android.support.test.espresso.action.ViewActions
//import android.support.test.espresso.matcher.ViewMatchers
//import android.support.test.rule.ActivityTestRule
//import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import ru.skillbranch.devintensive.ui.custom.CircleImageView

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user = User(id = "1")
        val user2 = User(id = "2")
        val user3 = User(id = "3")

        user.printMe()

        println("$user $user2 $user3")
    }


    @Test
    fun test_factory() {
//        val user = User.makeUser("john Cena")
//        val user2 = User.makeUser("john Wick")
        val user3 = User.makeUser("john wick")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("john Cena")
        val user2 = User.makeUser(" Cena")
        val user3 = User.makeUser("john ")
        val user4 = User.makeUser("")
        val user5 = User.makeUser(" ")
        val user6 = User.makeUser("null")

        fun getUserInfo() = user
        fun getUserInfo2() = user2
        fun getUserInfo3() = user3
        fun getUserInfo4() = user4
        fun getUserInfo5() = user5
        fun getUserInfo6() = user6
        val (id, firstName, lastName) = getUserInfo()
        val (id2, firstName2, lastName2) = getUserInfo2()
        val (id3, firstName3, lastName3) = getUserInfo3()
        val (id4, firstName4, lastName4) = getUserInfo4()
        val (id5, firstName5, lastName5) = getUserInfo5()
        val (id6, firstName6, lastName6) = getUserInfo6()

        println("$id2, $firstName2, $lastName2")
        println("$id3, $firstName3, $lastName3")
        println("$id3, $firstName3, $lastName3")
        println("$id4, $firstName4, $lastName4")
        println("$id5, $firstName5, $lastName5")
        println("$id6, $firstName6, $lastName6")
               
        println("$id , $firstName , $lastName")
        println("${user.component1()}, ${user.component2()} , ${user.component3()}")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("john wick")
        var user2 = user.copy()
        if (user.equals(user2)) {
            println("equals data and hash ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
        } else {
            println("not equals data and hash ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
        }
 // говорим что 2 объект и есть 1 объект, ссылаются на один участок памями , и при изменении юзера2 изменитсся и юзер 1
        user2 = user

  // проверка равенства объектов
        if (user == user2) {
            println("equals data and hash ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
        } else {
            println("not equals data and hash ${user.hashCode()} $user \n ${user2.hashCode()} $user2")
        }
//проверка равенствова структуры
        if (user === user2) {
            println("equals address ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
        } else {
            println("not equals address ${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
        }

        user2.lastName = "doe"
        println("$user \n n$user2")
    }




    @Test
    fun test_copy2() {
        val user = User.makeUser("john wick")
        var user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastVisit = Date().add(-2 , TimeUnits.SECOND))
        var user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2 , TimeUnits.HOUR))
        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent())

    }

    @Test
    fun test_data_maping() {
        val user = User.makeUser("Макеев Михаил")
        val newUser = user.copy(lastVisit = Date().add(-7, TimeUnits.SECOND))
        println(user)
        val userView = user.toUserView()
        userView.printMe()
    }


    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Макеев Михаил")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message" , type ="text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type = "image")
        when (txtMessage) {
            is TextMessage -> println ("this is text message")
            is ImageMessage -> println ("this is image message")
        }
    }



    @Test
    fun test_pasefullname () {
       println(Utils.parseFullName(null)) //null null
       println(Utils.parseFullName("")) //null null
       println(Utils.parseFullName(" ")) //null null
       println(Utils.parseFullName("John")) //John null
       println(Utils.parseFullName("John Wick"))
    }


    @Test
    fun test_toInitials () {
        println(Utils.toInitials("joe", "petr"))
    }

    @Test
    fun test_toInitials2 () {
       println(Utils.toInitials("john" ,"doe")) //JD
       println(Utils.toInitials(null ,"doe")) //D
       println(Utils.toInitials("John", null)) //J
       println(Utils.toInitials(null, null)) //null
       println(Utils.toInitials("", " ")) //null
       println(Utils.toInitials(" ", "")) //null
       println(Utils.toInitials("", "")) //null
    }


    @Test
    fun test_transliteration  ()  {
        println(Utils.transliteration("женя иванов"))
//        assertEquals("Petr_Stereotipov", Utils.transliteration("Петр Стереотипов", "_"))
        println(Utils.transliteration("Петр Стереотипов", "_"))
        println(Utils.transliteration("Petr Стереотипов", "_"))
        println(Utils.transliteration("Petr Стереотипов"))
        println(Utils.transliteration("Petr Стереотипов", "_"))

        println(Utils.transliteration("Женя Стереотипов")) //Zhenya Stereotipov
        println(Utils.transliteration("Amazing Петр","_")) //Amazing_Petr
        println(Utils.transliteration("Amazing Петр","_")) //Amazing_Petr
        println(Utils.transliteration("Amazing Петр петрович","_")) //Amazing_Petr
        println(Utils.transliteration("Amazing Петр Петрович ываыва sddfsd fs fs ddfs","+")) //Amazing_Petr
    }


    @Test
    fun test_humanizediff () {
        println(Date().add(-76, TimeUnits.SECOND).humanizeDiff())
        println(Date().add(-2, TimeUnits.HOUR).humanizeDiff() )    //2 часа назад
        println(Date().add(-5, TimeUnits.DAY).humanizeDiff()  )    //5 дней назад
        println(Date().add(2, TimeUnits.MINUTE).humanizeDiff())    //через 2 минуты
        println(Date().add(7, TimeUnits.DAY).humanizeDiff()   )    //через 7 дней
        println(Date().add(-400, TimeUnits.DAY).humanizeDiff())    //более года назад
        println(Date().add(400, TimeUnits.DAY).humanizeDiff() )    //более чем через год
        println(Date().add(20, TimeUnits.DAY).humanizeDiff()  )    //20 дней назад
    }

    @Test
    fun test_factoryqw () {
        val user = User.makeUser("Михаил Макеев")
//        val listusers : MutableList<User> = mutableListOf(user)
//
//        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message" , type ="text")
//        val bmessage : MutableList<BaseMessage> = mutableListOf(txtMessage)
//      val chat = Chat("rty" , listusers , bmessage)
        println(BaseMessage.makeMessage(user, Chat("0"), Date(),"text", "any text message"))
        val user2 = User.makeUser("Петр Петрович")
        println(BaseMessage.makeMessage(user2,Chat("1"), Date().add(-2, TimeUnits.HOUR),"image","https://anyurl.com",true).formatMessage())
    }

//    BaseMessage.makeMessage(user, chat, date, "any text message", "text") //Василий отправил сообщение "any text message" только что
 //Василий получил изображение "https://anyurl.com" 2 часа назад
//val message = BaseMessage.makeMessage(user, Chat("0"), Date(), "text", "any text message")

    @Test
    fun builder () {
        val user = User.Builder().id("143")
            .firstName("petr")
            .lastName("ivanov")
            .avatar("*path to avatar")
            .rating(99)
            .respect(5)
            .lastVisit(Date().add(-7, TimeUnits.DAY))
            .isOnline(false)
            .build()
        println(user)
    }


    @Test
    fun test_plural () {
//        println(Date().add(-76, TimeUnits.SECOND).humanizeDiff())
//        println(TimeUnits.SECOND.plural(23))    //
//        println(TimeUnits.SECOND.plural(1))    //
//        println(TimeUnits.SECOND.plural(4589))    //
//        println(TimeUnits.SECOND.plural(455))    //
//        println(TimeUnits.SECOND.plural(873))    //
//        println(TimeUnits.SECOND.plural(34))
//        println(TimeUnits.SECOND.plural(761))
//
//        println(TimeUnits.MINUTE.plural(23))    //
//        println(TimeUnits.MINUTE.plural(1))    //
//        println(TimeUnits.MINUTE.plural(4589))    //
//        println(TimeUnits.MINUTE.plural(455))    //
//        println(TimeUnits.MINUTE.plural(873))    //
//        println(TimeUnits.MINUTE.plural(34))
//        println(TimeUnits.MINUTE.plural(761))
//
//        println(TimeUnits.HOUR.plural(23))    //
//        println(TimeUnits.HOUR.plural(1))    //
//        println(TimeUnits.HOUR.plural(4589))    //
//        println(TimeUnits.HOUR.plural(455))    //
//        println(TimeUnits.HOUR.plural(873))    //
//        println(TimeUnits.HOUR.plural(34))
//        println(TimeUnits.HOUR.plural(761))
//
//        println(TimeUnits.DAY.plural(23))    //
//        println(TimeUnits.DAY.plural(1))    //
//        println(TimeUnits.DAY.plural(4589))    //
//        println(TimeUnits.DAY.plural(455))    //
//        println(TimeUnits.DAY.plural(873))    //
//        println(TimeUnits.DAY.plural(34))//
//        println(TimeUnits.DAY.plural(761))//

        println(TimeUnits.SECOND.plural(1)) //1 секунду
        println(TimeUnits.MINUTE.plural(4)) //4 минуты
        println(TimeUnits.HOUR.plural(19)) //19 часов
        println(TimeUnits.DAY.plural(222)) //222 дня
    }


    @Test
    fun truncate () {
        println("такое количество символов оказывается очень мало".truncate())
        println("такое количество символов оказывается очень мало".truncate(4))
        println("такое количество символов оказывается очень мало".truncate(15))
        println("такое количество символов оказывается очень мало".truncate(16))
        println("такое количество символов оказывается очень мало".truncate(20))
        println("такое количество символов оказывается очень мало".truncate(60))
//               123456789123456789123456789
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate()) //Bender Bending R...
        println("Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15)) //Bender Bending...
        println("A     ".truncate(3))   //A
        println("B         ".truncate(3))   //B
//               123456789123456789123456789

        println("такое ".truncate(9))
        println("такое  gfhfgh".truncate(7))

    }

    @Test
    fun HIW () {
//        val a = "adfasdf s123"
//        //       123456789
//        val b = a.toCharArray()
//        val uschar : List<Char>
//        uschar = b.dropLast(3)
//        println(uschar)
//
//        println(uschar.lastIndex)
//        println(uschar.lastIndex-1)
//        val d = uschar.lastIndex-1
//        if (uschar[d].isWhitespace()) {
//            println("vishlo to cho nado ")
//
//        }

//        val n = vchar.count() - tnum
//        uschar = vchar.dropLast(n)
////        val d : Char = uschar[lastIndex-1]
//        usstroka = uschar.joinToString("").trimEnd()
//        if (uschar[lastIndex-1].toString().isEmpty()){
////        if (1==1){
//            return usstroka
//        }
//        else {return "$usstroka..."}



//        var nr :String = "asdf  123   34534     asdasdasd      asdasd78 asd"
//        while (nr.contains("  ")) {
//            nr = nr.replace("  ", " ")
//        }
//        println("testing")
//        println(nr)
//        println("end")



//        var a : String   = "asd2sd45"
////        var b = a.toCharArray()
////        b.forEach { when (it.toInt()) {
////            2 -> println("kruto")
////            else -> println("tut bukva")}
////        }
//
////        val c : Collection<String> = listOf("1234567890")
//
////        if (a.contains(c.toChar()) ) {
////            println ("dsfd")
////        }
////       val d = a.findAnyOf(c)
////        println( a.findAnyOf(c))
////        else println("ne udalos")
//
//        val n : String = "1234567890"
////        if (n. in a ) {
////            println("udalos mb")
////        } else println("ne")
//
//        for (i in 0..n.lastIndex){
//            if (n[i] in a) {
//                println("chet poluchilos")
//            } else {println("ili ne och")}
//        }
//
//        n.forEach {
//            if (it in a) {println("toj")}
//
//        }

//        val a = "0sdfkd"
//        val b = a.toCharArray().get(0)
//        if (b.isDigit()){
//            println("+")
//        } else println("-")


//        val a = 5
//        val b = 9
//        if (a == 7) println("sdf")
//        else println("ne vishlo")

//         val DEFAULT_BORDER_COLOR : Triple <Int, Int, Int> = Triple(255,255,255)
//         val abs: String = "#675F7F"
//
//
//
//         val borcolor = Color.parseColor(abs)
//         println(borcolor)

//        println("#000000".toColorInt())

    val a = "325"
        val b = a.toInt()
        println(b)

    }





    @Test
    fun stripHtml () {
        println("""<p class="title">Образовательное IT-сообщество Skill Branch</p>""".stripHtml()) //Образовательное IT-сообщество Skill Branch
        println("<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml()) //Образовательное IT-сообщество Skill Branch
    }


    @Test
    fun test_string_striphtml() {
        val result1 = "<p class=\"title\">Образовательное IT-сообщество Skill Branch</p>".stripHtml() //Образовательное IT-сообщество Skill Branch
        val result2 = "<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml() //Образовательное IT-сообщество Skill Branch

        assertEquals("Образовательное IT-сообщество Skill Branch", result1)
        assertEquals("Образовательное IT-сообщество Skill Branch", result2)
    }

    @Test
    fun stripHtmlTest() {
        /* skillBranch tests */
        assertEquals("Образовательное IT-сообщество Skill Branch",
            "<p class=\"title\">Образовательное IT-сообщество Skill Branch</p>".stripHtml())
        assertEquals("Образовательное IT-сообщество Skill Branch",
            "<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml())

        /* additional tests */
        assertEquals("single", "&amp;&lt;&gt;single&#39;&quot;".stripHtml())
        assertEquals("", "&amp;&lt;&gt;&#39;&quot;".stripHtml())
//        assertEquals(" ", "&amp;&lt;&gt;    &#39;&quot;".stripHtml())
        assertEquals("1978", "<path fill=\"Color\" d=\"M11.63 10z\"></svg><span>1978</span>".stripHtml())
        assertEquals("", "&gt;<head>&#39;&quot;</head>".stripHtml())
        assertEquals(" ", "&gt;<head> &quot; </head>".stripHtml())
        assertEquals("&игра; amp lt &gt 39; meters ()quot;", "&игра; amp lt &gt 39; meters ()quot;".stripHtml())
        assertEquals(" one two ", "  one   two ".stripHtml())
        assertEquals("null", "null".stripHtml())
        val longHtml = """
            <TD valign="top" style="padding-bottom:15px;"> <b>line1<b> </TD>
            <TD valign="top"> <span class="HeadTitleNews"> line2</span>
            <img src='http://2011WaterpoloF.jpg' >
            <div style="margin: 0in 0in 0pt">line3</div>
        """.trimIndent()
        assertEquals(" line1 \n line2\n\nline3", longHtml.stripHtml())
    }



    @Test
    fun stripHtmlTest22() {

        println("&amp;&lt;&gt;    &#39;&quot;".stripHtml())
        /* skillBranch tests */
//        assertEquals(
//            "Образовательное IT-сообщество Skill Branch",
//            "<p class=\"title\">Образовательное IT-сообщество Skill Branch</p>".stripHtml2()
//        )
//        assertEquals(
//            "Образовательное IT-сообщество Skill Branch",
//            "<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml2()
//        )
//
//        /* additional tests */
//        assertEquals("single", "&amp;&lt;&gt;single&#39;&quot;".stripHtml2())
//        assertEquals("", "&amp;&lt;&gt;&#39;&quot;".stripHtml2())
//        assertEquals(" ", "&amp;&lt;&gt;    &#39;&quot;".stripHtml())
//        assertEquals("1978", "<path fill=\"Color\" d=\"M11.63 10z\"></svg><span>1978</span>".stripHtml2())
//        assertEquals("", "&gt;<head>&#39;&quot;</head>".stripHtml2())
//        assertEquals(" ", "&gt;<head> &quot; </head>".stripHtml2())// почему возвращается 1 пробел
//        assertEquals("&игра; amp lt &gt 39; meters ()quot;", "&игра; amp lt &gt 39; meters ()quot;".stripHtml2())
//        assertEquals(" one two ", "  one   two ".stripHtml2())
//        assertEquals("null", "null".stripHtml2())
//        val longHtml = """
//            <TD valign="top" style="padding-bottom:15px;"> <b>line1<b> </TD>
//            <TD valign="top"> <span class="HeadTitleNews"> line2</span>
//            <img src='http://2011WaterpoloF.jpg' >
//            <div style="margin: 0in 0in 0pt">line3</div>
//        """.trimIndent()
//        assertEquals(" line1 \n line2\n\nline3", longHtml.stripHtml2())

    }

    @Test
    fun valid() {

         val a = "asd34"
        val n : String = "1234567890"
        n.forEach {if (it in a) {println("uco")}}
    }


    @Test
    fun validation() {
//        val a = Bender().validation("adsd" , Bender.Question.MATERIAL)
        val a = Bender().validation("122233" , Bender.Question.BDAY)
        println(a)
    }


//    @RunWith(AndroidJUnit4::class)
//    class Task3 {
//        @Rule
//        @JvmField
//        val rule = ActivityTestRule(ProfileActivity::class.java)
//
//        @Test
//        fun listenAnswerNegativeTest2() {
//            assertEquals("Как меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Фрай"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Зоя"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
//                .perform(ViewActions.replaceText("Бандарчук"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
//                .perform(ViewActions.replaceText("Bomberman"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//
//            assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Фрай"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Зоя"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
//                .perform(ViewActions.replaceText("Бандарчук"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
//                .perform(ViewActions.replaceText("Bomberman"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//
//            assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Фрай"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Зоя"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
//                .perform(ViewActions.replaceText("Бандарчук"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
//                .perform(ViewActions.replaceText("Bomberman"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", rule.activity.textTxt.text)
//        }

//        @Test
//        fun listenAnswerHalfPosTest() {
//            assertEquals("Как меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
//                .perform(ViewActions.replaceText("Валя Голубкова"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Bender"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Отлично - ты справился\nНазови мою профессию?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
//                .perform(ViewActions.replaceText("актёр мультфильма"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nНазови мою профессию?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("actor"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nНазови мою профессию?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
//                .perform(ViewActions.replaceText("сгибальщик"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Отлично - ты справился\nИз чего я сделан?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("iron"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Отлично - ты справился\nКогда меня создали?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("2993"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Отлично - ты справился\nМой серийный номер?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("2716057"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Отлично - ты справился\nНа этом все, вопросов больше нет", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("2716057"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("На этом все, вопросов больше нет", rule.activity.textTxt.text)
//        }
//
//        @Test
//        fun listenAnswerNegativeTest1() {
//            assertEquals("Как меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
//                .perform(ViewActions.replaceText("Валя Голубкова"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Bender"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Отлично - ты справился\nНазови мою профессию?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
//                .perform(ViewActions.replaceText("актёр мультфильма"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nНазови мою профессию?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
//                .perform(ViewActions.replaceText("хозяин казино с блэкджеком и ..."))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nНазови мою профессию?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
//                .perform(ViewActions.replaceText("сгибальщик"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Отлично - ты справился\nИз чего я сделан?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("iron"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Отлично - ты справился\nКогда меня создали?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("2993"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Отлично - ты справился\nМой серийный номер?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("2716054"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Bender"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Отлично - ты справился\nНазови мою профессию?", rule.activity.textTxt.text)
//
//        }


//        @Test
//        fun listenAnswerNegativeUITest() {
//            assertEquals("Как меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("Ender"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("Ender"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("Ender"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            rotateScreen(rule.activity, true)
//            rotateScreen(rule.activity, false)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.typeText("Ender"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", rule.activity.textTxt.text)
//        }
//
//        @Test
//        fun saveStateWhenRotateTest() {
//            assertEquals("Как меня зовут?", rule.activity.textTxt.text)
//            val normalColorFilter = PorterDuffColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.MULTIPLY)
//            assertEquals(normalColorFilter, rule.activity.benderImage.colorFilter)
//
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Tinder"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            val warnColorFilter = PorterDuffColorFilter(Color.rgb(255, 120, 0), PorterDuff.Mode.MULTIPLY)
//            assertEquals(warnColorFilter, rule.activity.benderImage.colorFilter)
//
//            rotateScreen(rule.activity, true)
//            assertEquals("Как меня зовут?", rule.activity.textTxt.text)
//            assertEquals(warnColorFilter, rule.activity.benderImage.colorFilter)
//
//            rotateScreen(rule.activity, false)
//            assertEquals("Как меня зовут?", rule.activity.textTxt.text)
//            assertEquals(warnColorFilter, rule.activity.benderImage.colorFilter)
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id)).perform(ViewActions.replaceText("Blender"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            val dangerColorFilter = PorterDuffColorFilter(Color.rgb(255, 60, 60), PorterDuff.Mode.MULTIPLY)
//            assertEquals(dangerColorFilter, rule.activity.benderImage.colorFilter)
//
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
//                .perform(ViewActions.replaceText("Espander"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ\nКак меня зовут?", rule.activity.textTxt.text)
//            val critColorFilter = PorterDuffColorFilter(Color.rgb(255, 0, 0), PorterDuff.Mode.MULTIPLY)
//            assertEquals(critColorFilter, rule.activity.benderImage.colorFilter)
//
//            Espresso.onView(ViewMatchers.withId(rule.activity.messageEt.id))
//                .perform(ViewActions.replaceText("Labrador"))
//            Espresso.onView(ViewMatchers.withId(rule.activity.sendBtn.id)).perform(ViewActions.click())
//            assertEquals("Это неправильный ответ. Давай все по новой\nКак меня зовут?", rule.activity.textTxt.text)
//            assertEquals(normalColorFilter, rule.activity.benderImage.colorFilter)
//        }
//    }



}

