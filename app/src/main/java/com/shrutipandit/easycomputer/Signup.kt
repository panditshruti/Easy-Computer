package com.shrutipandit.easycomputer

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
            finish()
        }

        .addOnFailureListener {
            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

        }





    }


    }
}