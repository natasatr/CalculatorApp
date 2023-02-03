package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var editText :EditText

    var stariBroj = ""
    var oper = "+"
    var novaOp = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText =  findViewById<EditText>(R.id.numberField)

    }

    fun klikNaBroj(view: View){
        if(novaOp){
            editText.setText("")
        }
        novaOp=false
        var text: String = editText.text.toString()
        var selektovaniBroj : Button = view as Button
        when(selektovaniBroj.id){
            R.id.btnBroj1 -> {text +="1"}
            R.id.btnBroj2 -> {text += "2"}
            R.id.btnBroj3 -> {text +="3"}
            R.id.btnBroj4 -> {text += "4"}
            R.id.btnBroj5 -> {text +="5"}
            R.id.btnBroj6 -> {text += "6"}
            R.id.btnBroj7 -> {text += "7"}
            R.id.btnBroj8 -> {text +="8"}
            R.id.btnBroj9 -> {text +="9"}
            R.id.btnBroj0 -> {text +="0"}
            R.id.btnTacka -> {text +="."}


        }
        editText.setText(text)

    }

    fun klikNaOperaciju(view: View) {
        novaOp = true
        stariBroj = editText.text.toString();
        var selektovaniBroj = view as Button
        when(selektovaniBroj.id){
            R.id.btnMnozenje -> {oper ="*"}
            R.id.btnDijeljenje ->{oper ="/"}
            R.id.btnPlus -> {oper = "+"}
            R.id.btnMinus -> {oper = "-"}
        }
    }

    fun klikNaJednako(view: View) {
        var noviBroj = editText.text.toString()
        var rezultat = 0.0
        when(oper){
            "+" -> {rezultat = stariBroj.toDouble() + noviBroj.toDouble()}
            "*" -> {rezultat = stariBroj.toDouble() * noviBroj.toDouble()}
            "/" -> {rezultat = stariBroj.toDouble() / noviBroj.toDouble()}
            "-" -> {rezultat = stariBroj.toDouble() - noviBroj.toDouble()}
        }
        editText.setText(rezultat.toString())

    }

    fun obrisiPolje(view: View) {
        editText.setText("")
    }


}