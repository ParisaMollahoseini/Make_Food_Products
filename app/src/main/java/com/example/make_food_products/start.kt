package com.example.make_food_products

import android.Manifest
import android.R.attr.mimeType
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.view.animation.AnimationUtils
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_start.*
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException


class start : AppCompatActivity() {
    private val storagecode: Int = 100


    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val intent = Intent(this,MainActivity::class.java)
        val intent_hint = Intent(this,about::class.java)



        var map_data : HashMap<String, String> = HashMap<String, String>()

        val anim_img = AnimationUtils.loadAnimation(this,R.anim.fade_in)
        imageView.startAnimation(anim_img)
        start_button.startAnimation(anim_img)
        hint_button.startAnimation(anim_img)

        start_button.setOnClickListener {
            intent.putExtra("data_array",map_data)
            startActivity(intent)
        }
        hint_button.setOnClickListener {

            intent_hint.putExtra("data_array",map_data)
            startActivity(intent_hint)
        }
    }


}