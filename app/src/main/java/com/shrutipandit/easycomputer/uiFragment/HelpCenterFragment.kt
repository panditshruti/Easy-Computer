package com.shrutipandit.easycomputer.uiFragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shrutipandit.easycomputer.R
import com.shrutipandit.easycomputer.databinding.FragmentHelpCenterBinding
import com.shrutipandit.easycomputer.databinding.FragmentHomeBinding


class HelpCenterFragment : Fragment(R.layout.fragment_help_center) {
private lateinit var binding : FragmentHelpCenterBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHelpCenterBinding.bind(view)

        binding.telegram.setOnClickListener {
            joinTelegramChannel()
        }

        binding.whatsapp.setOnClickListener {
            joinWhatsAppChannel()
        }
        binding.youtube.setOnClickListener {
            joinYouTubeChannel()
        }



        binding.call.setOnClickListener{
            openCaller()
        }
        binding.message.setOnClickListener {
            sendMessage()
        }
        binding.email.setOnClickListener {
            sendEmail()
        }



    }
    private fun sendMessage() {
        val phoneNumber = "+7739717389"
        val message =
            "Hello, I there is a problem in ADCA Computer Course. Can you please help me troubleshoot it?"
        val encodedMessage = Uri.encode(message)
        val uri = Uri.parse("https://wa.me/$phoneNumber?text=$encodedMessage")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage("com.whatsapp")
        startActivity(intent)
    }
    private fun joinTelegramChannel() {
        val telegramUsername = ""
        val uri = Uri.parse("https://t.me/Easy_Computers")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage("org.telegram.messenger")
        startActivity(intent)
    }
    private fun sendEmail() {
        val recipient = "shrutikumaripandit@gmail.com"
        val subject = "Help Request: ADCA Computer Course"
        val message = "Hello, I need assistance with the ADCA Computer Course. Can you help me?"

        val uri = Uri.parse(
            "mailto:$recipient" +
                    "?subject=" + Uri.encode(subject) +
                    "&body=" + Uri.encode(message)
        )

        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = uri
        }

        startActivity(Intent.createChooser(intent, "Send Email"))
    }

    private fun openCaller() {
        val phoneNumber = "7739717389"   // without + is also fine
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        startActivity(intent)
    }

    private fun joinWhatsAppChannel() {
        // Replace with your actual WhatsApp Channel link
        val channelUrl = "https://whatsapp.com/channel/0029Vb7CE1UK0IBiw0i41V2h"

        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(channelUrl)
            setPackage("com.whatsapp")
        }

        try {
            startActivity(intent)
        } catch (e: Exception) {
            // If WhatsApp not installed, open in browser
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(channelUrl)))
        }
    }

    private fun joinYouTubeChannel() {
        val channelUrl = "https://www.youtube.com/channel/UCvjAEaYocRSJpUWE4FSVlwQ"

        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(channelUrl)
            setPackage("com.google.android.youtube")
        }

        try {
            startActivity(intent)
        } catch (e: Exception) {
            // YouTube app not installed → open in browser
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(channelUrl)))
        }
    }


}



