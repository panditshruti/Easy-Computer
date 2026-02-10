package com.shrutipandit.easycomputer.uiFragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.shrutipandit.easycomputer.Login
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProfileBinding.bind(view)
        auth = FirebaseAuth.getInstance()

        showUserData()

        binding.logout.setOnClickListener {
            logoutUser()
        }
        binding.shareUid.setOnClickListener {
            shareUID()
        }

    }

    private fun showUserData() {
        val user: FirebaseUser? = auth.currentUser

        if (user != null) {
            binding.email.text = user.email ?: "No Email"
            binding.uid.text = user.uid
        }
    }

    private fun logoutUser() {
        FirebaseAuth.getInstance().signOut()

        val intent = Intent(requireContext(), Login::class.java)
        intent.flags =
            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        startActivity(intent)
        requireActivity().finish()
    }

    private fun shareUID(){

        val user: FirebaseUser? = auth.currentUser

        if (user != null) {
            binding.uid.text = user.uid
        }
            val phoneNumber = "+7739717389"
            val message = user?.uid

            val encodedMessage = Uri.encode(message)
            val uri = Uri.parse("https://wa.me/$phoneNumber?text=$encodedMessage")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.whatsapp")
            startActivity(intent)


    }


}