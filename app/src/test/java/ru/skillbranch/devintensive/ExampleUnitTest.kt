package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import java.util.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.utils.Utils
//import android.support.test.espresso.Espresso
//import android.support.test.espresso.action.ViewActions
//import android.support.test.espresso.matcher.ViewMatchers
//import android.support.test.rule.ActivityTestRule
//import android.support.test.runner.AndroidJUnit4
import java.io.File

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

//    val a = "325"
//        val b = a.toInt()
//        println(b)

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




//
//    @Test
//    fun schet (str:String): Int {
//        val parts:List<String> = str.split(" ")
//        val fn = parts.get(0)
//        val sn = parts.get(1)
//        val ifn = fn.toInt()
//        val isn = sn.toInt()
//        val sum = ifn + isn
//        println(sum)
//        return sum
//    }
@Test
 fun testschet() {
    var c = 0
        val a = 2
        val b = 4
    for (n in 1..2){
        c = c+b
        c+=b
    }

    }

    @Test
    fun ert() {
        val buf = File("input.txt")
var avc = 0
        val inputString = buf.readLines()
        if (inputString != null) {

            for( line in buf.readLines()){

                for ( word in line.split(" ")){
                var av: Int
                av = 0
                av = word.toInt()
                var avc = +av
                }


        }



            val outwriter = File("output.txt").bufferedWriter()
            outwriter.write(avc)
            outwriter.close()
        }
        else {println("error")}


    }



@Test
fun erty() {
    val buf = File("input.txt")
    var avc = 0
    val inputString = buf.readLines()


    for( line in buf.readLines()){

        for ( word in line.split(" ")){
            val av: Int = word.toInt()
            avc += av
        }



        val outwriter = File("output.txt").bufferedWriter()
        outwriter.write(avc)
        outwriter.close()
    }
}

    private fun schet0() {
        val buf = File("""C:\\Users\\admin\\AndroidStudioProjects\\dev-intensive-2019\\app\\input.txt""")
        var avc = 0
        val outwriter = File("output.txt").bufferedWriter()

        for( line in buf.readLines()){
            for ( word in line.split(" ")){
                val av: Int = word.toInt()
                println(av)
                avc += av
                println(avc)
            }
            outwriter.write(avc.toString())
        }
        outwriter.close()
    }


    @Test
    fun schet(){
        schet0()
    }

@Test
fun reshaem(){
    val a = arrayOf("1", "2", "2", "3", "3")
    val b = a.distinct() // ["a", "b", "c"]
    println(b)

}


    private fun schet1() {
        val buf = File("input.txt")
        val outwriter = File("output.txt").bufferedWriter()
        val skolko: String
        val mlist: MutableList<Int> = mutableListOf()


        skolko = buf.bufferedReader().readLines().first()
        val skl = skolko
        for( line in buf.readLines()){
            for ( word in line.split(" ")){
                val av: Int = word.toInt()
                    mlist.add(av)
            }
        }
        mlist.removeAt(0)
        var ber = 0
        for (i in mlist.distinct()) {
            ber += i
        }
        outwriter.write(ber.toString())
        outwriter.close()
    }


    @Test
    fun schet2(){
        schet1()
    }



    @Test
    fun RLE () {
//        val str=readLine()
        val rlst = "156BA236ABCF54"
        val str = rlst+"S"
        val ch = str!!.toCharArray()
        val mlist2 : MutableList<Int> = mutableListOf()
        val mlist3 : MutableList<Int> = mutableListOf()
        var pchislo : Int
        for (i in ch.indices) {
            if (i+1<=ch.lastIndex) {
                if (ch[i].isLetter() && ch[i +1].isDigit()){
                    val cifra = ch[i +1].toString().toInt()
//                    println(cifra)
                    mlist2.add(cifra)
                }
                if (ch[i].isDigit() && ch[i+1].isDigit()){
                    val cifra = ch[i +1].toString().toInt()
//                    println(cifra)
                    mlist2.add(cifra)
                }
                if (ch[i].isLetter() && ch[i+1].isLetter()){
                    mlist2.add(1)
                    pchislo = mlist2.toString().replace("[", "").
                        replace(",", "").replace("]", "").
                        replace(" ", "").toInt()
//                println(mlist2)
                    mlist2.clear()
                    mlist3.add(pchislo)
                }
                if (ch[i].isDigit() && ch[i+1].isLetter()){
                    pchislo = mlist2.toString().replace("[", "").
                        replace(",", "").replace("]", "").
                        replace(" ", "").toInt()
//                println(mlist2)
                    mlist2.clear()
                    mlist3.add(pchislo)
                }

            }


        }
        println (mlist3.sum())
//        var avc : Int = 0
//        for (i in mlist3) {
//            avc+=i
//            println(avc)
//        }
//
//
//
//
//            while (i2.isDigit()) {
//                mlist2.add(i.toInt())
//                bg = mlist2.toString().replace("[", "").replace(",", "")
//            .replace("]", "").replace(" ", "")
//                i2++
//            }
//
//
//
//
//
//        str.forEach { if (it.isDigit()) mlist.add(it.toString())
//        else mlist.add(" ")}
//        println(mlist)
//
//        val c = mlist.toString().replace("[", "").replace(",", "")
//            .replace("]", "").replace(" ", "")
//        println(c)
//
//        val cc = c.trim()
//        println(cc)
//        val ccc = cc.split(" ")
//        println(ccc)
//        println(c.split( " "))
//        var fva : Int = 0
////        for ( word in c.split(" ")) {
////            val av: Int = word.toInt()
////            fva += av
//////            println(fva)
////        }
//
////        for (i in mlist)
//
//
//        for ( i in ch){
//            val s = i.toString()
//
//
//
//
//        when (s) {
//                    "A"  ->  mlist.add(" ")
//                    "B"  ->  mlist.add(" ")
//                    "C"  ->  mlist.add(" ")
//                    "D"  ->  mlist.add(" ")
//                    "E"  ->  mlist.add(" ")
//                    "F"  ->  mlist.add(" ")
//                    "G"  ->  mlist.add(" ")
//                    "H"  ->  mlist.add(" ")
//                    "I"  ->  mlist.add(" ")
//                    "J"  ->  mlist.add(" ")
//                    "K"  ->  mlist.add(" ")
//                    "L"  ->  mlist.add(" ")
//                    "M"  ->  mlist.add(" ")
//                    "N"  ->  mlist.add(" ")
//                    "O"  ->  mlist.add(" ")
//                    "P"  ->  mlist.add(" ")
//                    "Q"  ->  mlist.add(" ")
//                    "R"  ->  mlist.add(" ")
//                    "S"  ->  mlist.add(" ")
//                    "T"  ->  mlist.add(" ")
//                    "U"  ->  mlist.add(" ")
//                    "V"  ->  mlist.add(" ")
//                    "W"  ->  mlist.add(" ")
//                    "X"  ->  mlist.add(" ")
//                    "Y"  ->  mlist.add(" ")
//                    "Z"  ->  mlist.add(" ")
//                        "2" -> mlist.add("2")
//                        "3" -> mlist.add("3")
//                        "4" -> mlist.add("4")
//                        "5" -> mlist.add("5")
//                        "6" -> mlist.add("6")
//                        "7" -> mlist.add("7")
//                        "8" -> mlist.add("8")
//                        "9" -> mlist.add("9")
//               }
//
//        }
//
//
//        val bs : Int

    }


    @Test
    fun sdfsdfs() {
        val a = "12aa34"
        val b = a.toCharArray()
        for (i in b) {
            var i2 = i
            while (i2.isDigit()) {
                println("i2")
                println(i2)
                println("i2")
                i2++
            }
        }
    }
    @Test
    fun sdfsdfs2() {
//        val a = File("input.txt")
        val a = readLine()



    }





    @Test
    fun rabochii_v_itoge() {
        val buf = File("input.txt")
        val outwriter = File("output.txt").bufferedWriter()
        val mlist: MutableList<Int> = mutableListOf()

        for( line in buf.readLines()){
            for ( word in line.split(" ")){
                val av: Int = word.toInt()
                mlist.add(av)
            }
        }
        mlist.removeAt(0)
        var ber = 0L
        for (i in mlist.distinct()) {
            ber += i
        }
        outwriter.write(ber.toString())
        outwriter.close()

    }


    @Test
    fun parity() {

        val a = "1 0 0 0 1 1 0 1 1 0"    //11
//        val a = "1 0 0 0 0 1 0 1 1 0 0"    //11
//        val a = "1 0 1 0 1 0 0 1 1 0"   //22
//        val a =   "3 2 2 2 3 3 2 3 3 2"
//        val a =   "3 2 3 2 3 2 2 3 3 2"

//        val b = a.sortedBy {  }

        var CntSwaps  = 0
        val badind = mutableListOf<Int>()
        fun MutableList<Int>.sortbyparity() : MutableList<Int> {
//            var swap = true
//            while(swap){
//                swap = false
//                for(i in 0 until this.indices.last){

var vip = true
//            for (y in 0..0){
            while (vip) {
            var find1 = true
            var find2 = true
            var find3 = true


                    for (i in this.indices) {
                        if (badind.count() == 2) {
//                            println("i tut toje bivau")
//                            println(badind[0])
//                            println(badind[1])

                            CntSwaps++
                            val temp = this [ badind[0]]
                            this[badind[0]] = this[badind[1]]
                            this[badind[1]] = temp
                            badind.clear()
                            break
                        }
                        else {
                            if (this[i] % 2 == 1 && this[i + 1] % 2 == 0) {

//                                println("oba norm")
//                                println(this[i])
//                                println(this[i+1])
//                                val temp = this[i]
//                                this[i] = this[i+1]
//                                this[i + 1] = temp
//                                swap = true
                            }
                            if  ((this[i] % 2 == 0 && this[i + 1] % 2 == 1)&& (find3) && (i % 2 == 1 && (i+1) % 2 == 0)){


                            }
                            else {

                                if ((this[i] % 2 == 0 && this[i + 1] % 2 == 0) && (find1) && ((i+1) % 2 == 0)) {
                                    //мб тут надо сделать так чтобы запоминался именно четный индекс\
//                                    println("oba chetnie")
//                                    println(this[i])
//                                    println(this[i+1])
                                    find1 = false
                                    badind.add(i + 1)
                                }

                                if ((this[i] % 2 == 1 && this[i + 1] % 2 == 1)&& (find2) && ((i+1) % 2 == 1)) {
//                                    println("oba NEchetnie")
//                                    println(i)
//                                    println(i+1)
                                    find2 = false
                                    badind.add(i + 1)
                                }
                                if  ((this[i] % 2 == 0 && this[i + 1] % 2 == 1)&& (find3) && (i % 2 == 0 && (i+1) % 2 == 1)){
//                                    println("yo")
                                    find3 = false
//                                    badind.add(i)
                                    badind.add(i + 1)
                                } else {vip=false}
                            }
                        }
                    }
            }
//            }
            return this
        }


        val inputwriter = File("input.txt")
        val outwriter = File("output.txt").bufferedWriter()
        val inpt: MutableList<Int> = mutableListOf()

        for( line in inputwriter.readLines()){
            for ( word in line.split(" ")){
                val av: Int = word.toInt()
                inpt.add(av)
            }
        }
        inpt.removeAt(0)
//        print(inpt)


//            val inputline = a
//            val mlist = mutableListOf<Int>()

//        val bb = inputline.split(" ")
//        bb.forEach{mlist.add(it.toInt())}

        inpt.sortbyparity()
        println(CntSwaps*2)
        inpt.forEach { print(it) }








//        val n = 6
//
//        if (n and 1 === 0) {
//            println("четное")
//        } else {
//            println("нечетное")
//        }
    }













}

