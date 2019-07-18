package ru.skillbranch.devintensive

import android.app.Activity
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.PersistableBundle
//import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.skillbranch.devintensive.models.Bender
import ru.skillbranch.devintensive.extensions.*

class MainActivity : AppCompatActivity() , View.OnClickListener, OnEditorActionListener {

    lateinit var benderImage: ImageView
    lateinit var textTxt : TextView
    lateinit var messageEt : EditText
    lateinit var sendBtn : ImageView
    lateinit var benderObj : Bender
//    lateinit var et : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        benderImage = findViewById(R.id.iv_bender)
        benderImage = iv_bender
        textTxt = tv_text
        messageEt = et_message
        sendBtn = iv_send
//        et = et_test

        val status = savedInstanceState?.getString("STATUS") ?: Bender.Status.NORMAL.name
        val question = savedInstanceState?.getString("QUESTION") ?: Bender.Question.NAME.name
//        val prevtext = savedInstanceState?.getString("text") ?: messageEt.toString()
//        val prevtext = savedInstanceState?.getString("text") ?: et.text.toString()
        benderObj = Bender(Bender.Status.valueOf(status), Bender.Question.valueOf(question))

        Log.d("M_MainActivity", "OnCreate $status $question")

        val (r,g,b) = benderObj.status.color
        benderImage.setColorFilter(Color.rgb(r,g,b), PorterDuff.Mode.MULTIPLY)

        textTxt.text = (benderObj.askQuestion())
//        messageEt.setText(prevtext)
//        et.setText(prevtext)

        sendBtn.setOnClickListener(this)
        messageEt.setOnEditorActionListener(this)
        messageEt.setImeOptions(EditorInfo.IME_ACTION_DONE)
    }


    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            if (v?.id == R.id.et_message) {
                val (phrase, color) = benderObj.listenAnswer(messageEt.text.toString())
                messageEt.setText("")
                val (r, g, b) = color
                benderImage.setColorFilter(Color.rgb(r, g, b), PorterDuff.Mode.MULTIPLY)
                textTxt.text = phrase
                this.hideKeyboard()
                return true
            }
        }
        return false
    }

    override  fun onClick(v:View?) {
        if(v?.id == R.id.iv_send) {
           val (phrase, color) = benderObj.listenAnswer(messageEt.text.toString().toLowerCase())
            messageEt.setText("")
            val (r,g,b) = color
            benderImage.setColorFilter(Color.rgb(r,g,b), PorterDuff.Mode.MULTIPLY)
            textTxt.text = phrase
            this.hideKeyboard()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString("STATUS" , benderObj.status.name)
        outState?.putString("QUESTION" , benderObj.question.name)
//        outState?.putString("text" , et.text.toString())
        Log.d("M_MainActivity" , "onSaveInstanceState ${benderObj.status.name} ${benderObj.question.name}")

    }
}
