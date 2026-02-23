package com.shrutipandit.easycomputer

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.shrutipandit.easycomputer.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.loginBtn.setOnClickListener {

            val email = binding.emailEt.text.toString().trim()
            val password = binding.passwordEt.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // ✅ Firebase Login
            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    showTelegramJoinDialog()
                }
                .addOnFailureListener {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
        }


        // ✅ GO TO SIGNUP
        binding.signIn.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
        }

    }
        override fun onStart() {
            super.onStart()
            if (auth.currentUser != null) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }

    }


    private fun showTelegramJoinDialog() {

        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Join Our Telegram Channel")
        builder.setMessage("Please join our Telegram channel before continuing.")

        // YES → Open Telegram
        builder.setPositiveButton("Join Now") { _, _ ->

            val telegramUrl = "https://t.me/Easy_Computers"

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = android.net.Uri.parse(telegramUrl)
            startActivity(intent)

            // After opening Telegram → Go to MainActivity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        // NO → Direct Go
        builder.setNegativeButton("Skip") { _, _ ->
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        builder.setCancelable(false) // User back press se close na kare
        builder.show()
    }

}