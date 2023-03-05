package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var btn: Button
    var stariBroj = ""
    var oper: String? = null
    var novaOp = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById<EditText>(R.id.numberField)
        btn = findViewById<Button>(R.id.btnTacka)
    }

    fun klikNaBroj(view: View) {
        if (novaOp) {
            editText.setText("")
        }

        novaOp = false

        var text: String = editText.text.toString()
        var selektovaniBroj: Button = view as Button

        when (selektovaniBroj.id) {
            R.id.btnBroj1 -> {
                text += "1"
            }
            R.id.btnBroj2 -> {
                text += "2"
            }
            R.id.btnBroj3 -> {
                text += "3"
            }
            R.id.btnBroj4 -> {
                text += "4"
            }
            R.id.btnBroj5 -> {
                text += "5"
            }
            R.id.btnBroj6 -> {
                text += "6"
            }
            R.id.btnBroj7 -> {
                text += "7"
            }
            R.id.btnBroj8 -> {
                text += "8"
            }
            R.id.btnBroj9 -> {
                text += "9"
            }
            R.id.btnBroj0 -> {
                text += "0"
            }
            R.id.btnTacka -> {
                if (!editText.text.isEmpty()) {
                    text += ".";
                    btn.isEnabled = false;

                }

            }

        }
        if (editText.text.contains(".")) {
            btn.setEnabled(false)
        }
        editText.setText(text)

    }

    fun klikNaOperaciju(view: View) {
        btn.setEnabled(false)
        novaOp = true
        stariBroj = editText.text.toString();
        var selektovaniBroj = view as Button
        when (selektovaniBroj.id) {
            R.id.btnMnozenje -> {
                oper = "*"
            }
            R.id.btnDijeljenje -> {
                oper = "/"
            }
            R.id.btnPlus -> {
                oper = "+"
            }
            R.id.btnMinus -> {
                oper = "-"
            }

        }
        btn.setEnabled(true)
    }

    fun klikNaJednako(view: View) {

        var noviBroj: String = editText.text.toString()
        var rezultat = 0.0

        when (oper) {
            "+" -> {
                rezultat = stariBroj.toDouble() + noviBroj.toDouble()
            }
            "*" -> {
                rezultat = stariBroj.toDouble() * noviBroj.toDouble()
            }
            "/" -> {
                rezultat = stariBroj.toDouble() / noviBroj.toDouble()
            }
            "-" -> {
                rezultat = stariBroj.toDouble() - noviBroj.toDouble()
            }

        }
        if (rezultat == 0.0) {
            rezultat = noviBroj.toDouble()
            editText.setText(rezultat.toString())
        } else {
            editText.setText(rezultat.toString())
        }
        btn.setEnabled(false)
    }

    fun obrisiPolje(view: View) {
        btn.setEnabled(true)

        editText.setText("")
    }

}