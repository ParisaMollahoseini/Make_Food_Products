package com.example.make_food_products

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.TypedValue
import android.view.animation.AnimationUtils
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_start.*

class about : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val intent_back = Intent(this,start::class.java)
        /*val text = findViewById<TextView>(R.id.email_about)
        text.setMovementMethod(LinkMovementMethod.getInstance());
        text.setLinkTextColor(Color.BLUE)
        text.setTextSize(30.0F);*/



        val anim_img = AnimationUtils.loadAnimation(this,R.anim.fade_in)
        imageView_about.startAnimation(anim_img)
        title_about.startAnimation(anim_img)
        email_about.startAnimation(anim_img)
        back_button.startAnimation(anim_img)

        back_button.setOnClickListener {
            startActivity(intent_back)
        }
    }
}