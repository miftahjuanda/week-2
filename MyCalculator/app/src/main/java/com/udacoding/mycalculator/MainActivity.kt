package com.udacoding.mycalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        btn_tambah.setOnClickListener {
            if (edt_number1.text.toString().isEmpty() || edt_number2.text.toString().isEmpty()) {
                edt_number1.error = getString(R.string.input_angka)
            } else {
                val number1 = edt_number1.text.toString().toDouble()
                val number2 = edt_number2.text.toString().toDouble()
                val hasil = this.tambah(number1, number2)
                edt_Hasil.text = hasil.toString()
            }
        }

        btn_kurang.setOnClickListener {
            if (edt_number1.text.toString().isEmpty() || edt_number2.text.toString().isEmpty()) {
                edt_number1.error = getString(R.string.input_angka)
            } else {
                val number1 = edt_number1.text.toString().toDouble()
                val number2 = edt_number2.text.toString().toDouble()
                val hasil = this.kurang(number1, number2)
                edt_Hasil.text = hasil.toString()
            }
        }

        btn_kali.setOnClickListener {
            if (edt_number1.text.toString().isEmpty() || edt_number2.text.toString().isEmpty()) {
                edt_number1.error = getString(R.string.input_angka)
            } else {
                val number1 = edt_number1.text.toString().toDouble()
                val number2 = edt_number2.text.toString().toDouble()
                val hasil = this.kali(number1, number2)
                edt_Hasil.text = hasil.toString()
            }
        }

        btn_bagi.setOnClickListener {
            if (edt_number1.text.toString().isEmpty() || edt_number2.text.toString().isEmpty()) {
                edt_number1.error = getString(R.string.input_angka)
            } else {
                val number1 = edt_number1.text.toString().toDouble()
                val number2 = edt_number2.text.toString().toDouble()
                val hasil = this.bagi(number1, number2)
                edt_Hasil.text = hasil.toString()
            }
        }
    }

    private fun tambah(number1: Double, number2: Double): Double {
        return number1 + number2
    }

    private fun kurang(number1: Double, number2: Double): Double {
        return number1 - number2
    }

    private fun kali(number1: Double, number2: Double): Double {
        return number1 * number2
    }

    private fun bagi(number1: Double, number2: Double): Double {
        return number1 / number2
    }
}