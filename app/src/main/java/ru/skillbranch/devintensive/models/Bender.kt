package ru.skillbranch.devintensive.models

class Bender (var status: Status = Status.NORMAL, var question : Question = Question.NAME) {

       fun askQuestion(): String = when (question) {
        Question.NAME -> Question.NAME.question
        Question.PROFESSION -> Question.PROFESSION.question
        Question.MATERIAL -> Question.MATERIAL.question
        Question.BDAY -> Question.BDAY.question
        Question.SERIAL -> Question.SERIAL.question
        Question.IDLE -> Question.IDLE.question
    }
    var ercnt = 1
    fun listenAnswer(answer: String): Pair<String, Triple<Int, Int, Int>> {
        lateinit var otvet : Pair<String, Triple<Int, Int, Int>>
//        if (answer=="") {
//            ercnt++
//            return "Это неправильный ответ\n${question.question}" to status.color
//        }
        if ( (answer=="") || (validation(answer, question))  ) {
//            || (answer.get(0).toString().toInt() >= 0) // если вставить в условие if  то рушится проверка валидации
            if (ercnt > 3) {
                status = Status.NORMAL
                question = Question.NAME
                otvet = "Это неправильный ответ. Давай все по новой\n${question.question}" to status.color
                ercnt = 1
            } else {
                if (question.question !== Question.IDLE.question) {
                    if (question.answers.contains(answer)) {
                        question = question.nextQuestion()
                        otvet = "Отлично - ты справился\n${question.question}" to status.color
                    } else {
                        status = status.nextStatus()
                        otvet = "Это неправильный ответ\n${question.question}" to status.color
                        ercnt++
                    }
                } else {otvet = question.question to status.color}
            }
        } else {
            when (question){
                Question.NAME -> otvet = "Имя должно начинаться с заглавной буквы\n${question.question}" to status.color
                Question.PROFESSION -> otvet = "Профессия должна начинаться со строчной буквы\n${question.question}" to status.color
                Question.MATERIAL -> otvet = "Материал не должен содержать цифр\n${question.question}" to status.color
                Question.BDAY -> otvet = "Год моего рождения должен содержать только цифры\n${question.question}" to status.color
                Question.SERIAL -> otvet = "Серийный номер содержит только цифры, и их 7\n${question.question}" to status.color
            }

        }


        return otvet
    }

    enum class Status(val color: Triple<Int, Int, Int>) {
        NORMAL(Triple(255, 255, 255)),
        WARNING(Triple(255, 120, 0)),
        DANGER(Triple(255, 60, 60)),
        CRITICAL(Triple(255, 0, 0));

        fun nextStatus(): Status {
            return if (this.ordinal < values().lastIndex) {
                values()[this.ordinal + 1]
            } else {
                values()[0]
            }
        }
    }


    enum class Question(val question: String, val answers: List<String>) {
        NAME("Как меня зовут?", listOf("Бендер", "Bender")) {
            override fun nextQuestion(): Question {

                return PROFESSION
            }
        },
        PROFESSION("Назови мою профессию?", listOf("сгибальщик", "bender")) {
            override fun nextQuestion(): Question = MATERIAL
        },
        MATERIAL("Из чего я сделан?", listOf("металл", "дерево", "metal", "iron", "wood")) {
            override fun nextQuestion(): Question = BDAY
        },
        BDAY("Когда меня создали?", listOf("2993")) {
            override fun nextQuestion(): Question = SERIAL
        },
        SERIAL("Мой серийный номер?", listOf("2716057")) {
            override fun nextQuestion(): Question = IDLE
        },
        IDLE("На этом все, вопросов больше нет", listOf()) {
            override fun nextQuestion(): Question = IDLE
        };

        abstract fun nextQuestion(): Question

    }

    fun validation(ans:String , question: Question) : Boolean {
        when (question) {
            Question.NAME -> {
                val a = ans.toCharArray().get(0)
                if (a.isDigit()) {return true}
                return a.isUpperCase()
            }
            Question.PROFESSION -> {val a = ans.toCharArray().get(0); return a.isLowerCase()}
//            Question.MATERIAL -> {val a = ans.toCharArray().forEach { it.toInt() }}
            Question.MATERIAL -> {
                val n = "1234567890"
                n.forEach {if (it in ans) {return false}}
            }
            Question.BDAY -> {
                var sc = -1
                for (i in 0..ans.lastIndex){
                    for (r in 0..9)
                         if (r.toString() in ans[i].toString()) {sc++}
                }
                return (sc==ans.lastIndex)
            }
            Question.SERIAL -> {
                var sc = -1
                if (ans.length == 7) {
                    for (i in 0..ans.lastIndex) {
                        for (r in 0..9)
                            if (r.toString() in ans[i].toString()) {
                                sc++
                            }
                    }
                    return (sc == ans.lastIndex)
                } else return false
            }
//            IDLE -> {}
        }
        return true
    }
}
