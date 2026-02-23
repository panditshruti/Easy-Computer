package com.shrutipandit.easycomputer

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.shrutipandit.easycomputer.databinding.ActivitySignupBinding

class Signup : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

auth = FirebaseAuth.getInstance()

    binding.registerBtn.setOnClickListener {
        val email = binding.emailEt.text.toString().trim()
        val password = binding.passEt.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()){

            Toast.makeText(this, "Fill all Field", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }
if (password.length<6){
    Toast.makeText(this, "Password must be 6+ chars", Toast.LENGTH_SHORT).show()
    return@setOnClickListener
}
    auth.createUserWithEmailAndPassword(email,password)
        .addOnSuccessListener {

            Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show()
            showTelegramJoinDialog()

        }

        .addOnFailureListener {
            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

        }





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