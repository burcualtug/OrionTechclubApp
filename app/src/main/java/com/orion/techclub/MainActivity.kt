package com.orion.techclub

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.Gravity
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)


        val textView: TextView= findViewById(R.id.textView)
        val name = getColoredSpanned("Follow us on", "#FFFFFF")
        val surName = getColoredSpanned("techClub", "#FF9800")
        textView.setText(Html.fromHtml(name+" "+surName));


        val mediumClick = findViewById(R.id.mediumImg) as ImageView
        mediumClick.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://medium.com/orion-innovation-turkey"))
            startActivity(i)
        }



        val gitClick = findViewById(R.id.gitImg) as ImageView
        gitClick.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/OrionInnovationTRTech"))
            startActivity(i)
        }


        val linkedinClick = findViewById(R.id.linkedinImg) as ImageView
        linkedinClick.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/orion-innovation-turkey"))
            startActivity(i)
        }

        val instaClick = findViewById(R.id.instagramImg) as ImageView
        instaClick.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/oriontr.tech/"))
            startActivity(i)
        }

        val twitterClick = findViewById(R.id.twitterImg) as ImageView
        twitterClick.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/oriontr_tech"))
            startActivity(i)
        }

        val kommunityClick = findViewById(R.id.kommunityImg) as ImageView
        kommunityClick.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://kommunity.com/orion-innovation-tr-tech-club/about"))
            startActivity(i)
        }


        val coopintern = findViewById<TextView>(R.id.coopintern)
        coopintern.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://medium.com/orion-innovation-turkey/coop/home"))
            startActivity(i)
        }



        val phonenum = findViewById<TextView>(R.id.phonenum)
        phonenum.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "02165222100")
            startActivity(dialIntent)
        }

        val adres = findViewById<TextView>(R.id.adres)
        adres.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/w65thfs9AQxUzwmB7"))
            startActivity(i)
        }

        val mailTxt = findViewById<TextView>(R.id.mailTxt)
        mailTxt.setOnClickListener {
            sendEmail()
        }

        val coop=findViewById<ImageView>(R.id.coop)
        coop.setOnClickListener{applyCoop();}

        val webTxt = findViewById<TextView>(R.id.webTxt)
        webTxt.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.netrd.com.tr/"))
            startActivity(i)
        }

    }
    private fun getColoredSpanned(text: String, color: String): String? {
        return "<font color=$color>$text</font>"
    }
    companion object {
        val TAG: String = MainActivity::class.java.name
    }

    private fun sendEmail() {
        val mIntent = Intent(Intent.ACTION_SENDTO)

        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("info@NetRD.com.tr"))
        try {
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        }
        catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }

    private fun applyCoop() {
        val mIntent = Intent(Intent.ACTION_SENDTO)

        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("dpd-tur.netrd-ik@orioninc.com"))
        try {
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        }
        catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }

}
