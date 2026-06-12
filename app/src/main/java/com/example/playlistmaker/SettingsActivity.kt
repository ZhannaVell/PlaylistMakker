package com.example.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        val backButton = findViewById<ImageView>(R.id.back_button)
        val shareItem = findViewById<LinearLayout>(R.id.share_item)
        val supportItem = findViewById<LinearLayout>(R.id.support_item)
        val agreementItem = findViewById<LinearLayout>(R.id.agreement_item)

        backButton.setOnClickListener {
            finish()
        }
        shareItem.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT,getString(R.string.share_message))
            }
            startActivity(Intent.createChooser(shareIntent,null))
        }
        supportItem.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.support_email)))
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.support_subject))
                putExtra(Intent.EXTRA_TEXT,getString(R.string.support_body))

            }
            startActivity(Intent.createChooser(emailIntent,null))
        }
        agreementItem.setOnClickListener {
            val termsUrl = getString(R.string.terms_url)
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(termsUrl))
            startActivity(browserIntent)
        }


    }
}