package com.udacoding.mylogin.view.login

import android.app.ListActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.udacoding.mylogin.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login()
    }

    private fun login() {
        btn_login.setOnClickListener {
            val username = edt_email.text.toString()
            val pass = edt_password.text.toString()

            if (username == "miftah" && pass == "miftah12") {
                val intent = Intent(this, com.udacoding.mylogin.view.list.ListActivity::class.java)
                startActivity(intent)
            } else {
                Snackbar.make(it, "Username atau password salah", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}