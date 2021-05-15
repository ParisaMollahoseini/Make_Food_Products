package com.example.make_food_products

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Typeface
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_type_of_product_growing_step.*
import kotlinx.android.synthetic.main.activity_useful_compost.*

//to float
class useful_compost : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_useful_compost)

        val intent2 = Intent(this,MainActivity::class.java)
        val intent2_2 = Intent(this,useless_compost::class.java)


        ///counter for not ignoring solution being null
        val counter = 0
        ///counter for not ignoring solution being null

        //for getting previous pages datas
        var intent2_3 = intent

        var map_get_data:HashMap<String,String> = intent2_3.getSerializableExtra("data_array") as HashMap<String, String>
        //with_k.text = map_get_data["salt"].toString()
        //for getting previous pages datas
        val sharedPreference =  getSharedPreferences("useful_compost_new",Context.MODE_PRIVATE)
        //update data
        var editor = sharedPreference.edit()


        //update data

        val typeface = Typeface.createFromAsset(assets, "no55.ttf")

        
        // Set the typeface
        title2.typeface = typeface

        first_useful_title.typeface = typeface
        edit_first_useful_1.typeface = typeface
        first_useful_1.typeface = typeface
        first_useful_2.typeface = typeface
        edit_first_useful_2.typeface = typeface

        second_useful_title.typeface = typeface
        edit_second_useful_1.typeface = typeface
        second_useful_1.typeface = typeface
        second_useful_2.typeface = typeface
        edit_second_useful_2.typeface = typeface

        third_useful_title.typeface = typeface
        edit_third_useful_1.typeface = typeface
        third_useful_1.typeface = typeface
        third_useful_2.typeface = typeface
        edit_third_useful_2.typeface = typeface

        register.typeface = typeface
        back.typeface = typeface
        next1.typeface = typeface

        val anim_img = AnimationUtils.loadAnimation(this,R.anim.fade_in)

        var which_compost = 0
        ///Set the typeface
        //when one icon clicked
        spinner_choose.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when(position) {
                    0 -> {
                        which_compost = 0
                        first_compost_useful_layout.visibility = View.INVISIBLE
                        second_compost_useful_layout.visibility = View.INVISIBLE
                        third_compost_useful_layout.visibility = View.INVISIBLE
                        register.visibility = View.INVISIBLE
                    }
                    1 -> {
                        which_compost = 1

                        checkbox_layout1.isChecked = false
                        checkbox_layout2.isChecked = false
                        checkbox_layout3.isChecked = false


                        first_compost_useful_layout.visibility = View.VISIBLE
                        first_compost_useful_layout.startAnimation(anim_img)

                        first_useful_title.text = "نیترات آمونیوم"
                        first_compost_useful_layout_1.visibility = View.INVISIBLE
                        first_useful_1.text = ":N"
                        first_compost_useful_layout_2.visibility = View.INVISIBLE

                        second_compost_useful_layout.visibility = View.VISIBLE
                        second_compost_useful_layout.startAnimation(anim_img)

                        second_useful_title.text = "اسید نیتریک"
                        second_compost_useful_layout_1.visibility = View.INVISIBLE
                        second_useful_1.text = ":N"
                        second_compost_useful_layout_2.visibility = View.INVISIBLE

                        third_compost_useful_layout.visibility = View.INVISIBLE
                        register.visibility = View.VISIBLE
                        if (!sharedPreference.contains(":N"+first_useful_title.text.toString()))
                        {
                            editor.putFloat(":N"+first_useful_title.text.toString(),0.0F)//for store data in this page
                            editor.putFloat(":N"+second_useful_title.text.toString(),0.0F)
                            map_get_data.put(":N"+first_useful_title.text.toString() , "0.0")//send data to other pages
                            map_get_data.put(":N"+second_useful_title.text.toString() , "0.0")

                            edit_first_useful_1.setText("0.0")
                            edit_second_useful_1.setText("0.0")
                        }
                        else
                        {
                            val first_int  = sharedPreference.getFloat(":N"+first_useful_title.text.toString(),0.0F)
                            edit_first_useful_1.setText(first_int.toString())

                            val second_int  = sharedPreference.getFloat(":N"+second_useful_title.text.toString(),0.0F)
                            edit_second_useful_1.setText(second_int.toString())

                            map_get_data.put(":N"+first_useful_title.text.toString() , first_int.toString())//send data to other pages
                            map_get_data.put(":N"+second_useful_title.text.toString() ,second_int.toString())
                        }


                    }
                    2 -> {
                        which_compost = 2

                        checkbox_layout1.isChecked = false
                        checkbox_layout2.isChecked = false
                        checkbox_layout3.isChecked = false

                        first_compost_useful_layout.visibility = View.VISIBLE
                        first_compost_useful_layout.startAnimation(anim_img)

                        first_useful_title.text = "نیترات کلسیم"
                        first_compost_useful_layout_1.visibility = View.INVISIBLE
                        first_useful_1.text = ":N"
                        first_compost_useful_layout_2.visibility = View.INVISIBLE
                        first_useful_2.text = ":Ca"

                        third_compost_useful_layout.visibility = View.INVISIBLE
                        second_compost_useful_layout.visibility = View.INVISIBLE
                        register.visibility = View.VISIBLE
                        if (!sharedPreference.contains(":N"+first_useful_title.text.toString())) {
                            editor.putFloat(":N"+first_useful_title.text.toString(), 0.0F)
                            map_get_data.put(":N"+first_useful_title.text.toString() , "0.0")

                            editor.putFloat(":Ca"+first_useful_title.text.toString(), 0.0F)
                            map_get_data.put(":Ca"+first_useful_title.text.toString() , "0.0")

                            edit_first_useful_1.setText("0.0")
                            edit_first_useful_2.setText("0.0")
                        }
                        else
                        {
                            val first_int  = sharedPreference.getFloat(":N"+first_useful_title.text.toString(),0.0F)
                            edit_first_useful_1.setText(first_int.toString())
                            map_get_data.put(":N"+first_useful_title.text.toString() , first_int.toString())

                            val first_int_2  = sharedPreference.getFloat(":Ca"+first_useful_title.text.toString(),0.0F)
                            edit_first_useful_2.setText(first_int_2.toString())
                            map_get_data.put(":Ca"+first_useful_title.text.toString() , first_int_2.toString())
                        }
                    }
                    3 ->
                    {
                        which_compost = 3

                        checkbox_layout1.isChecked = false
                        checkbox_layout2.isChecked = false
                        checkbox_layout3.isChecked = false

                        first_compost_useful_layout.visibility = View.VISIBLE
                        first_compost_useful_layout.startAnimation(anim_img)

                        first_useful_title.text = "نیترات پتاسیم"
                        first_compost_useful_layout_1.visibility = View.INVISIBLE
                        first_useful_1.text = ":N"
                        first_compost_useful_layout_2.visibility = View.INVISIBLE
                        first_useful_2.text = ":K"

                        second_compost_useful_layout.visibility = View.VISIBLE
                        second_compost_useful_layout.startAnimation(anim_img)

                        second_useful_title.text = "سولفات پتاسیم"
                        second_compost_useful_layout_1.visibility = View.INVISIBLE
                        second_useful_1.text = ":S"
                        second_compost_useful_layout_2.visibility = View.INVISIBLE
                        second_useful_2.text = ":K"

                        third_compost_useful_layout.visibility = View.INVISIBLE
                        register.visibility = View.VISIBLE


                        if (!sharedPreference.contains(":N"+first_useful_title.text.toString())) {

                            editor.putFloat(":N"+first_useful_title.text.toString(), 0.0F)
                            editor.putFloat(":K"+first_useful_title.text.toString(), 0.0F)

                            editor.putFloat(":S"+second_useful_title.text.toString(), 0.0F)
                            editor.putFloat(":K"+second_useful_title.text.toString(), 0.0F)

                            map_get_data.put(":N"+first_useful_title.text.toString(),"0.0")//send data to other pages
                            map_get_data.put(":K"+first_useful_title.text.toString(),"0.0")

                            map_get_data.put(":S"+second_useful_title.text.toString(), "0.0")
                            map_get_data.put(":K"+second_useful_title.text.toString(), "0.0")

                            edit_first_useful_1.setText("0.0")
                            edit_first_useful_2.setText("0.0")

                            edit_second_useful_1.setText("0.0")
                            edit_second_useful_2.setText("0.0")
                        }
                        else
                        {
                            val first_int  = sharedPreference.getFloat(":N"+first_useful_title.text.toString(),0.0F)
                            edit_first_useful_1.setText(first_int.toString())

                            val first_int_2  = sharedPreference.getFloat(":K"+first_useful_title.text.toString(),0.0F)
                            edit_first_useful_2.setText(first_int_2.toString())

                            val second_int  = sharedPreference.getFloat(":S"+second_useful_title.text.toString(),0.0F)
                            edit_second_useful_1.setText(second_int.toString())

                            val second_int_2  = sharedPreference.getFloat(":K"+second_useful_title.text.toString(),0.0F)
                            edit_second_useful_2.setText(second_int_2.toString())

                            map_get_data.put(":N"+first_useful_title.text.toString(),first_int.toString())//send data to other pages
                            map_get_data.put(":K"+first_useful_title.text.toString(),first_int_2.toString())

                            map_get_data.put(":S"+second_useful_title.text.toString(), second_int.toString())
                            map_get_data.put(":K"+second_useful_title.text.toString(), second_int_2.toString())

                        }
                    }
                    4 ->
                    {
                        which_compost = 4

                        checkbox_layout1.isChecked = false
                        checkbox_layout2.isChecked = false
                        checkbox_layout3.isChecked = false

                        first_compost_useful_layout.visibility = View.VISIBLE
                        first_compost_useful_layout.startAnimation(anim_img)
                        second_compost_useful_layout.startAnimation(anim_img)
                        third_compost_useful_layout.startAnimation(anim_img)

                        first_useful_title.text = "مونوپتاسیم فسفات"
                        first_compost_useful_layout_1.visibility = View.INVISIBLE
                        first_useful_1.text = ":P"
                        first_compost_useful_layout_2.visibility = View.INVISIBLE
                        first_useful_2.text = ":K"


                        second_compost_useful_layout.visibility = View.VISIBLE
                        second_useful_title.text = "مونوآمونیوم فسفات"
                        second_compost_useful_layout_1.visibility = View.INVISIBLE
                        second_useful_1.text = ":P"
                        second_compost_useful_layout_2.visibility = View.INVISIBLE
                        second_useful_2.text = ":N"

                        third_compost_useful_layout.visibility = View.VISIBLE
                        third_useful_title.text = "اسید فسفریک"
                        third_compost_useful_layout_1.visibility = View.INVISIBLE
                        third_useful_1.text = ":P"
                        third_compost_useful_layout_2.visibility = View.INVISIBLE

                        register.visibility = View.VISIBLE
                        if (!sharedPreference.contains(":P"+first_useful_title.text.toString())) {

                            editor.putFloat(":P"+first_useful_title.text.toString(), 0.0F)
                            editor.putFloat(":K"+first_useful_title.text.toString(), 0.0F)

                            editor.putFloat(":P"+second_useful_title.text.toString(), 0.0F)
                            editor.putFloat(":N"+second_useful_title.text.toString(), 0.0F)

                            editor.putFloat(":P"+third_useful_title.text.toString(), 0.0F)

                            map_get_data.put(":P"+first_useful_title.text.toString(),"0")//send data to other pages
                            map_get_data.put(":K"+first_useful_title.text.toString(),"0")

                            map_get_data.put(":P"+second_useful_title.text.toString(), "0")
                            map_get_data.put(":N"+second_useful_title.text.toString(), "0")

                            map_get_data.put(":P"+third_useful_title.text.toString(), "0")

                            edit_first_useful_1.setText("0.0")
                            edit_first_useful_2.setText("0.0")

                            edit_second_useful_1.setText("0.0")
                            edit_second_useful_2.setText("0.0")

                            edit_third_useful_1.setText("0.0")

                        }
                        else
                        {
                            val first_int  = sharedPreference.getFloat(":P"+first_useful_title.text.toString(),0.0F)
                            edit_first_useful_1.setText(first_int.toString())
                            val first_int_2  = sharedPreference.getFloat(":K"+first_useful_title.text.toString(),0.0F)
                            edit_first_useful_2.setText(first_int_2.toString())

                            val second_int  = sharedPreference.getFloat(":P"+second_useful_title.text.toString(),0.0F)
                            edit_second_useful_1.setText(second_int.toString())
                            val second_int_2  = sharedPreference.getFloat(":N"+second_useful_title.text.toString(),0.0F)
                            edit_second_useful_2.setText(second_int_2.toString())

                            val third_int  = sharedPreference.getFloat(":P"+third_useful_title.text.toString(),0.0F)
                            edit_third_useful_1.setText(third_int.toString())

                            map_get_data.put(":P"+first_useful_title.text.toString(),first_int.toString())//send data to other pages
                            map_get_data.put(":K"+first_useful_title.text.toString(),first_int_2.toString())

                            map_get_data.put(":P"+second_useful_title.text.toString(), second_int.toString())
                            map_get_data.put(":N"+second_useful_title.text.toString(), second_int_2.toString())

                            map_get_data.put(":P"+third_useful_title.text.toString(), third_int.toString())
                        }
                    }
                    5 ->
                    {
                        which_compost = 5

                        checkbox_layout1.isChecked = false
                        checkbox_layout2.isChecked = false
                        checkbox_layout3.isChecked = false

                        first_compost_useful_layout.visibility = View.VISIBLE
                        first_compost_useful_layout.startAnimation(anim_img)
                        second_compost_useful_layout.startAnimation(anim_img)

                        first_useful_title.text = "سولفات منیزیم"
                        first_compost_useful_layout_1.visibility = View.INVISIBLE
                        first_useful_1.text = ":S"
                        first_compost_useful_layout_2.visibility = View.INVISIBLE
                        first_useful_2.text = ":Mg"

                        second_compost_useful_layout.visibility = View.VISIBLE
                        second_useful_title.text = "نیترات منیزیم"
                        second_compost_useful_layout_1.visibility = View.INVISIBLE
                        second_useful_1.text = ":N"
                        second_compost_useful_layout_2.visibility = View.INVISIBLE
                        second_useful_2.text = ":Mg"

                        register.visibility = View.VISIBLE

                        third_compost_useful_layout.visibility = View.INVISIBLE


                        if (!sharedPreference.contains(":S"+first_useful_title.text.toString())) {

                            editor.putFloat(":S"+first_useful_title.text.toString(), 0.0F)
                            editor.putFloat(":Mg"+first_useful_title.text.toString(), 0.0F)

                            editor.putFloat(":N"+second_useful_title.text.toString(), 0.0F)
                            editor.putFloat(":Mg"+second_useful_title.text.toString(), 0.0F)

                            map_get_data.put(":S"+first_useful_title.text.toString(),"0.0")//send data to other pages
                            map_get_data.put(":Mg"+first_useful_title.text.toString(),"0.0")

                            map_get_data.put(":N"+second_useful_title.text.toString(), "0.0")
                            map_get_data.put(":Mg"+second_useful_title.text.toString(), "0.0")


                            edit_first_useful_1.setText("0.0")
                            edit_first_useful_2.setText("0.0")

                            edit_second_useful_1.setText("0.0")
                            edit_second_useful_2.setText("0.0")

                        }
                        else
                        {
                            val first_int  = sharedPreference.getFloat(":S"+first_useful_title.text.toString(),0.0F)
                            edit_first_useful_1.setText(first_int.toString())
                            val first_int_2  = sharedPreference.getFloat(":Mg"+first_useful_title.text.toString(),0.0F)
                            edit_first_useful_2.setText(first_int_2.toString())

                            val second_int  = sharedPreference.getFloat(":N"+second_useful_title.text.toString(),0.0F)
                            edit_second_useful_1.setText(second_int.toString())
                            val second_int_2  = sharedPreference.getFloat(":Mg"+second_useful_title.text.toString(),0.0F)
                            edit_second_useful_2.setText(second_int_2.toString())

                            map_get_data.put(":S"+first_useful_title.text.toString(),first_int.toString())//send data to other pages
                            map_get_data.put(":Mg"+first_useful_title.text.toString(),first_int_2.toString())

                            map_get_data.put(":N"+second_useful_title.text.toString(), second_int.toString())
                            map_get_data.put(":Mg"+second_useful_title.text.toString(), second_int_2.toString())
                        }
                    }
                    6 ->
                    {
                        which_compost = 6

                        checkbox_layout1.isChecked = false
                        checkbox_layout2.isChecked = false
                        checkbox_layout3.isChecked = false

                        first_compost_useful_layout.visibility = View.VISIBLE
                        first_compost_useful_layout.startAnimation(anim_img)

                        first_useful_title.text = "اسید سولفوریک"
                        first_compost_useful_layout_1.visibility = View.INVISIBLE
                        first_useful_1.text = ":S"
                        first_compost_useful_layout_2.visibility = View.INVISIBLE

                        register.visibility = View.VISIBLE

                        third_compost_useful_layout.visibility = View.INVISIBLE
                        second_compost_useful_layout.visibility = View.INVISIBLE

                        if (!sharedPreference.contains(":S"+first_useful_title.text.toString())) {

                            editor.putFloat(":S"+first_useful_title.text.toString(), 0.0F)

                            map_get_data.put(":S"+first_useful_title.text.toString(), "0.0")

                            edit_first_useful_1.setText("0.0")
                        }
                        else
                        {
                            val first_int  = sharedPreference.getFloat(":S"+first_useful_title.text.toString(),0.0F)
                            edit_first_useful_1.setText(first_int.toString())

                            map_get_data.put(":S"+first_useful_title.text.toString(), first_int.toString())
                        }

                    }
                }
            }

        }

        checkbox_layout1.setOnClickListener()
        {
            if (checkbox_layout1.isChecked)
            {
                when(which_compost)
                {
                    1 ->
                    {
                        first_compost_useful_layout_1.visibility = View.VISIBLE
                        first_compost_useful_layout_2.visibility = View.GONE
                    }
                    2 ->
                    {
                        first_compost_useful_layout_1.visibility = View.VISIBLE
                        first_compost_useful_layout_2.visibility = View.VISIBLE
                    }
                    3 ->
                    {
                        first_compost_useful_layout_1.visibility = View.VISIBLE
                        first_compost_useful_layout_2.visibility = View.VISIBLE
                    }
                    4 ->
                    {
                        first_compost_useful_layout_1.visibility = View.VISIBLE
                        first_compost_useful_layout_2.visibility = View.VISIBLE
                    }
                    5 ->
                    {
                        first_compost_useful_layout_1.visibility = View.VISIBLE
                        first_compost_useful_layout_2.visibility = View.VISIBLE
                    }
                    6 ->
                    {
                        first_compost_useful_layout_1.visibility = View.VISIBLE
                        first_compost_useful_layout_2.visibility = View.GONE
                    }
                }
            }
            else
            {

                  first_compost_useful_layout_1.visibility = View.INVISIBLE
                  first_compost_useful_layout_2.visibility = View.INVISIBLE

            }

        }
        checkbox_layout2.setOnClickListener()
        {
            if (checkbox_layout2.isChecked)
            {
                when(which_compost)
                {
                    1 ->
                    {
                        second_compost_useful_layout_1.visibility = View.VISIBLE
                        second_compost_useful_layout_2.visibility = View.GONE
                    }

                    3 ->
                    {
                        second_compost_useful_layout_1.visibility = View.VISIBLE
                        second_compost_useful_layout_2.visibility = View.VISIBLE
                    }
                    4 ->
                    {
                        second_compost_useful_layout_1.visibility = View.VISIBLE
                        second_compost_useful_layout_2.visibility = View.VISIBLE
                    }
                    5 ->
                    {
                        second_compost_useful_layout_1.visibility = View.VISIBLE
                        second_compost_useful_layout_2.visibility = View.VISIBLE
                    }

                }
            }
            else
            {

                second_compost_useful_layout_1.visibility = View.INVISIBLE
                second_compost_useful_layout_2.visibility = View.INVISIBLE

            }
        }
        checkbox_layout3.setOnClickListener()
        {
            if (checkbox_layout3.isChecked)
            {
                if (which_compost == 4)
                {
                        third_compost_useful_layout_1.visibility = View.VISIBLE
                        third_compost_useful_layout_2.visibility = View.GONE
                }
            }
            else
            {

                third_compost_useful_layout_1.visibility = View.INVISIBLE
                third_compost_useful_layout_2.visibility = View.INVISIBLE

            }
        }

        register.setOnClickListener{
            Toast.makeText(this, ".اطلاعات ثبت شد.", Toast.LENGTH_SHORT).show()//show message

            //make all zero
            map_get_data.put(
                first_useful_1.text.toString()+first_useful_title.text.toString(),
                "0.0"
            )
            map_get_data.put(
                first_useful_2.text.toString()+first_useful_title.text.toString(),
                "0.0"
            )
            map_get_data.put(
                second_useful_1.text.toString()+second_useful_title.text.toString(),
                "0.0"
            )
            map_get_data.put(
                second_useful_2.text.toString()+second_useful_title.text.toString(),
                "0.0"
            )
            map_get_data.put(
                third_useful_1.text.toString()+third_useful_title.text.toString(),
                "0.0"
            )
            map_get_data.put(
                third_useful_2.text.toString()+third_useful_title.text.toString(),
                "0.0"
            )
            editor.putFloat(
                first_useful_1.text.toString()+first_useful_title.text.toString(),
                0.0F
            )
            editor.putFloat(
                first_useful_2.text.toString()+first_useful_title.text.toString(),
                0.0F
            )
            editor.putFloat(
                second_useful_1.text.toString()+second_useful_title.text.toString(),
                0.0F
            )
            editor.putFloat(
                second_useful_2.text.toString()+second_useful_title.text.toString(),
                0.0F
            )
            editor.putFloat(
                third_useful_1.text.toString()+third_useful_title.text.toString(),
                0.0F
            )
            editor.putFloat(
                third_useful_2.text.toString()+third_useful_title.text.toString(),
                0.0F
            )
            //make all zero

            if (first_compost_useful_layout.visibility == View.VISIBLE && checkbox_layout1.isChecked)//if we check text view , it can't recognize visibility .. i don't know the reason
            {
                //first_useful.text = edit_first_useful.text
                if (first_compost_useful_layout_1.visibility == View.VISIBLE )//if we check text view , it can't recognize visibility .. i don't know the reason
                {
                    if (edit_first_useful_1.length() > 0 ) {//if we check edit.!= null , it can't check it right.. so we check the length

                        editor.putFloat(
                            first_useful_1.text.toString()+first_useful_title.text.toString(),
                            edit_first_useful_1.text.toString().toFloat()
                        )
                        editor.apply()
                        editor.commit()

                        map_get_data.put(
                            first_useful_1.text.toString()+first_useful_title.text.toString(),
                            edit_first_useful_1.text.toString()
                        )

                        //first_useful.text =edit_first_useful.text.toString()//test
                    }
                }
                if (first_compost_useful_layout_2.visibility == View.VISIBLE)//if we check text view , it can't recognize visibility .. i don't know the reason
                {
                    if (edit_first_useful_2.length() > 0) {//if we check edit.!= null , it can't check it right.. so we check the length

                        editor.putFloat(
                            first_useful_2.text.toString()+first_useful_title.text.toString(),
                            edit_first_useful_2.text.toString().toFloat()
                        )
                        editor.apply()
                        editor.commit()
                        map_get_data.put(
                            first_useful_2.text.toString()+first_useful_title.text.toString(),
                            edit_first_useful_2.text.toString()
                        )

                        //first_useful.text =edit_first_useful.text.toString()//test
                    }
                }

            }
            if (second_compost_useful_layout.visibility == View.VISIBLE && checkbox_layout2.isChecked)
            {
                if (second_compost_useful_layout_1.visibility == View.VISIBLE)//if we check text view , it can't recognize visibility .. i don't know the reason
                {
                    if (edit_second_useful_1.length() > 0) {//if we check edit.!= null , it can't check it right.. so we check the length

                        editor.putFloat(
                            second_useful_1.text.toString()+second_useful_title.text.toString(),
                            edit_second_useful_1.text.toString().toFloat()
                        )
                        editor.apply()
                        editor.commit()
                        map_get_data.put(
                            second_useful_1.text.toString()+second_useful_title.text.toString(),
                            edit_second_useful_1.text.toString()
                        )

                        //first_useful.text =edit_first_useful.text.toString()//test
                    }
                }
                if (second_compost_useful_layout_2.visibility == View.VISIBLE)//if we check text view , it can't recognize visibility .. i don't know the reason
                {
                    if (edit_second_useful_2.length() > 0) {//if we check edit.!= null , it can't check it right.. so we check the length

                        editor.putFloat(
                            second_useful_2.text.toString()+second_useful_title.text.toString(),
                            edit_second_useful_2.text.toString().toFloat()
                        )
                        editor.apply()
                        editor.commit()
                        map_get_data.put(
                            second_useful_2.text.toString()+second_useful_title.text.toString(),
                            edit_second_useful_2.text.toString()
                        )

                        //first_useful.text =edit_first_useful.text.toString()//test
                    }
                }
            }
            if (third_compost_useful_layout.visibility == View.VISIBLE && checkbox_layout3.isChecked)
            {
                if (third_compost_useful_layout_1.visibility == View.VISIBLE)//if we check text view , it can't recognize visibility .. i don't know the reason
                {
                    if (edit_third_useful_1.length() > 0) {//if we check edit.!= null , it can't check it right.. so we check the length

                        editor.putFloat(
                            third_useful_1.text.toString()+third_useful_title.text.toString(),
                            edit_third_useful_1.text.toString().toFloat()
                        )
                        editor.apply()
                        editor.commit()
                        map_get_data.put(
                            third_useful_1.text.toString()+third_useful_title.text.toString(),
                            edit_third_useful_1.text.toString()
                        )

                        //first_useful.text =edit_first_useful.text.toString()//test
                    }
                }
                if (third_compost_useful_layout_2.visibility == View.VISIBLE)//if we check text view , it can't recognize visibility .. i don't know the reason
                {
                    if (edit_third_useful_2.length() > 0) {//if we check edit.!= null , it can't check it right.. so we check the length

                        editor.putFloat(
                            third_useful_2.text.toString()+third_useful_title.text.toString(),
                            edit_third_useful_2.text.toString().toFloat()
                        )
                        editor.apply()
                        editor.commit()
                        map_get_data.put(
                            third_useful_2.text.toString()+third_useful_title.text.toString(),
                            edit_third_useful_2.text.toString()
                        )

                        //first_useful.text =edit_first_useful.text.toString()//test
                    }
                }
            }



        }

        edit_first_useful_1.setOnClickListener{
            edit_first_useful_1.text = null
        }
        edit_first_useful_2.setOnClickListener {
            edit_first_useful_2.text = null
        }

        edit_second_useful_1.setOnClickListener {
            edit_second_useful_1.text = null
        }
        edit_second_useful_2.setOnClickListener {
            edit_second_useful_2.text = null
        }
        edit_third_useful_1.setOnClickListener {
            edit_third_useful_1.text = null
        }
        edit_third_useful_2.setOnClickListener {
            edit_third_useful_2.text = null
        }

        back.setOnClickListener {


            intent2.putExtra("data_array",map_get_data)
            startActivity(intent2)
        }
        next1.setOnClickListener {


            //with register button automatically data will be updated
            intent2_2.putExtra("data_array",map_get_data)
            startActivity(intent2_2)
        }
    }
    private fun getIndex(spinner: Spinner, myString: String): Int {
        for (i in 0 until spinner.count) {
            if (spinner.getItemAtPosition(i).toString().equals(myString, ignoreCase = true)) {
                return i
            }
        }
        return 0
    }
}


