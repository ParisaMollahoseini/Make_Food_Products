package com.example.make_food_products

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Typeface
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_type_of_product_growing_step.*
import kotlinx.android.synthetic.main.activity_useful_compost.*
import kotlinx.android.synthetic.main.activity_useless_compost.*


class useless_compost : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_useless_compost)

        val intent3 = Intent(this,useful_compost::class.java)
        val intent3_2 = Intent(this,Type_of_product_growing_step::class.java)


        //for getting previous pages datas
        var intent3_3 = intent

        var map_get_data:HashMap<String,String> = intent3_3.getSerializableExtra("data_array") as HashMap<String, String>
        //with_k.text = map_get_data["salt"].toString()
        //for getting previous pages datas
        val sharedPreference =  getSharedPreferences("useless_compost_new",Context.MODE_PRIVATE)
        //update data
        var editor = sharedPreference.edit()


        //update data

        val typeface = Typeface.createFromAsset(assets, "no55.ttf")


        // Set the typeface
        title2_useless.typeface = typeface


        first_useful_title_useless.typeface = typeface
        edit_first_useful_1_useless.typeface = typeface
        first_useful_1_useless.typeface = typeface

        second_useful_title_useless.typeface = typeface
        edit_second_useful_1_useless.typeface = typeface
        second_useful_1_useless.typeface = typeface


        val anim_img = AnimationUtils.loadAnimation(this,R.anim.fade_in)


        register_useless.typeface = typeface
        back1.typeface = typeface
        next2.typeface = typeface

        var which_compost = 0
        ///Set the typeface
        //when one icon clicked
        spinner_choose_useless.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when(position) {
                    0 -> {
                        first_compost_useful_layout_useless.visibility = View.INVISIBLE
                        second_compost_useful_layout_useless.visibility = View.INVISIBLE
                        register_useless.visibility = View.INVISIBLE
                    }
                    1 -> {
                        which_compost = 1

                        checkbox_layout1_useless.isChecked = false
                        checkbox_layout2_useless.isChecked = false


                        first_compost_useful_layout_useless.visibility = View.VISIBLE
                        first_compost_useful_layout_useless.startAnimation(anim_img)

                        first_useful_title_useless.text = "کلات آهن"
                        first_compost_useful_layout_1_useless.visibility = View.INVISIBLE
                        first_useful_1_useless.text = ":Fe"


                        second_compost_useful_layout_useless.visibility = View.INVISIBLE


                        register_useless.visibility = View.VISIBLE
                        if (!sharedPreference.contains(":Fe"+first_useful_title_useless.text.toString()))
                        {
                            editor.putFloat(":Fe"+first_useful_title_useless.text.toString(),0.0F)//for store data in this page

                            map_get_data.put(":Fe"+first_useful_title_useless.text.toString() , "0.0")//send data to other pages


                            edit_first_useful_1_useless.setText("0.0")

                        }
                        else
                        {
                            val first_int  = sharedPreference.getFloat(":Fe"+first_useful_title_useless.text.toString(),0.0F)
                            edit_first_useful_1_useless.setText(first_int.toString())

                            map_get_data.put(":Fe"+first_useful_title_useless.text.toString() , first_int.toString())//send data to other pages

                        }


                    }
                    2 -> {
                        which_compost = 2

                        checkbox_layout1_useless.isChecked = false
                        checkbox_layout2_useless.isChecked = false


                        first_compost_useful_layout_useless.visibility = View.VISIBLE
                        first_useful_title_useless.text = "سولفات منگنز"
                        first_compost_useful_layout_1_useless.visibility = View.INVISIBLE
                        first_useful_1_useless.text = ":Mn"

                        second_compost_useful_layout_useless.visibility = View.VISIBLE
                        second_useful_title_useless.text = "کلات منگنز"
                        second_compost_useful_layout_1_useless.visibility = View.INVISIBLE
                        second_useful_1_useless.text = ":Mn"

                        first_compost_useful_layout_useless.startAnimation(anim_img)
                        second_compost_useful_layout_useless.startAnimation(anim_img)

                        register_useless.visibility = View.VISIBLE

                        if (!sharedPreference.contains(":Mn"+first_useful_title_useless.text.toString())) {

                            editor.putFloat(":Mn"+first_useful_title_useless.text.toString(), 0.0F)
                            map_get_data.put(":Mn"+first_useful_title_useless.text.toString() , "0.0")

                            editor.putFloat(":Mn"+second_useful_title_useless.text.toString(), 0.0F)
                            map_get_data.put(":Mn"+second_useful_title_useless.text.toString(), "0.0")

                            edit_first_useful_1_useless.setText("0.0")
                            edit_second_useful_1_useless.setText("0.0")
                        }
                        else
                        {
                            val first_int  = sharedPreference.getFloat(":Mn"+first_useful_title_useless.text.toString(),0.0F)
                            edit_first_useful_1_useless.setText(first_int.toString())
                            map_get_data.put(":Mn"+first_useful_title_useless.text.toString() , first_int.toString())

                            val second_int  = sharedPreference.getFloat(":Mn"+second_useful_title_useless.text.toString(),0.0F)
                            edit_second_useful_1_useless.setText(second_int.toString())
                            map_get_data.put(":Mn"+second_useful_title_useless.text.toString(),second_int.toString())

                        }
                    }
                    3 ->
                    {
                        which_compost = 3

                        checkbox_layout1_useless.isChecked = false
                        checkbox_layout2_useless.isChecked = false


                        first_compost_useful_layout_useless.visibility = View.VISIBLE
                        first_useful_title_useless.text = "سولفات روی"
                        first_compost_useful_layout_1_useless.visibility = View.INVISIBLE
                        first_useful_1_useless.text = ":Zn"

                        second_compost_useful_layout_useless.visibility = View.VISIBLE
                        second_useful_title_useless.text = "کلات روی"
                        second_compost_useful_layout_1_useless.visibility = View.INVISIBLE
                        second_useful_1_useless.text = ":Zn"

                        first_compost_useful_layout_useless.startAnimation(anim_img)
                        second_compost_useful_layout_useless.startAnimation(anim_img)

                        register_useless.visibility = View.VISIBLE

                        if (!sharedPreference.contains(":Zn"+first_useful_title_useless.text.toString())) {

                            editor.putFloat(":Zn"+first_useful_title_useless.text.toString(), 0.0F)
                            map_get_data.put(":Zn"+first_useful_title_useless.text.toString() , "0")

                            editor.putFloat(":Zn"+second_useful_title_useless.text.toString(), 0.0F)
                            map_get_data.put(":Zn"+second_useful_title_useless.text.toString(), "0")

                            edit_first_useful_1_useless.setText("0.0")
                            edit_second_useful_1_useless.setText("0.0")
                        }
                        else
                        {
                            val first_int  = sharedPreference.getFloat(":Zn"+first_useful_title_useless.text.toString(),0.0F)
                            edit_first_useful_1_useless.setText(first_int.toString())
                            map_get_data.put(":Zn"+first_useful_title_useless.text.toString() , first_int.toString())

                            val second_int  = sharedPreference.getFloat(":Zn"+second_useful_title_useless.text.toString(),0.0F)
                            edit_second_useful_1_useless.setText(second_int.toString())
                            map_get_data.put(":Zn"+second_useful_title_useless.text.toString(),second_int.toString())

                        }
                    }
                    4 ->
                    {
                        which_compost = 4

                        checkbox_layout1_useless.isChecked = false
                        checkbox_layout2_useless.isChecked = false


                        first_compost_useful_layout_useless.visibility = View.VISIBLE
                        first_useful_title_useless.text = "سولفات مس"
                        first_compost_useful_layout_1_useless.visibility = View.INVISIBLE
                        first_useful_1_useless.text = ":Cu"

                        second_compost_useful_layout_useless.visibility = View.VISIBLE
                        second_useful_title_useless.text = "کلات مس"
                        second_compost_useful_layout_1_useless.visibility = View.INVISIBLE
                        second_useful_1_useless.text = ":Cu"

                        first_compost_useful_layout_useless.startAnimation(anim_img)
                        second_compost_useful_layout_useless.startAnimation(anim_img)

                        register_useless.visibility = View.VISIBLE

                        if (!sharedPreference.contains(":Cu"+first_useful_title_useless.text.toString())) {

                            editor.putFloat(":Cu"+first_useful_title_useless.text.toString(), 0.0F)
                            map_get_data.put(":Cu"+first_useful_title_useless.text.toString() , "0")

                            editor.putFloat(":Cu"+second_useful_title_useless.text.toString(), 0.0F)
                            map_get_data.put(":Cu"+second_useful_title_useless.text.toString(), "0")

                            edit_first_useful_1_useless.setText("0.0")
                            edit_second_useful_1_useless.setText("0.0")
                        }
                        else
                        {
                            val first_int  = sharedPreference.getFloat(":Cu"+first_useful_title_useless.text.toString(),0.0F)
                            edit_first_useful_1_useless.setText(first_int.toString())

                            val second_int  = sharedPreference.getFloat(":Cu"+second_useful_title_useless.text.toString(),0.0F)
                            edit_second_useful_1_useless.setText(second_int.toString())

                            map_get_data.put(":Cu"+first_useful_title_useless.text.toString() , first_int.toString())

                            map_get_data.put(":Cu"+second_useful_title_useless.text.toString(), second_int.toString())
                        }
                    }
                    5 ->
                    {
                        which_compost = 5

                        checkbox_layout1_useless.isChecked = false
                        checkbox_layout2_useless.isChecked = false


                        first_compost_useful_layout_useless.visibility = View.VISIBLE
                        first_useful_title_useless.text = "اسید بوریک"
                        first_compost_useful_layout_1_useless.visibility = View.INVISIBLE
                        first_useful_1_useless.text = ":B"

                        second_compost_useful_layout_useless.visibility = View.VISIBLE
                        second_useful_title_useless.text = "بوراکس"
                        second_compost_useful_layout_1_useless.visibility = View.INVISIBLE
                        second_useful_1_useless.text = ":B"

                        first_compost_useful_layout_useless.startAnimation(anim_img)
                        second_compost_useful_layout_useless.startAnimation(anim_img)

                        register_useless.visibility = View.VISIBLE

                        if (!sharedPreference.contains(":B"+first_useful_title_useless.text.toString())) {

                            editor.putFloat(":B"+first_useful_title_useless.text.toString(), 0.0F)
                            map_get_data.put(":B"+first_useful_title_useless.text.toString() , "0")

                            editor.putFloat(":B"+second_useful_title_useless.text.toString(), 0.0F)
                            map_get_data.put(":B"+second_useful_title_useless.text.toString(), "0")

                            edit_first_useful_1_useless.setText("0.0")
                            edit_second_useful_1_useless.setText("0.0")
                        }
                        else
                        {
                            val first_int  = sharedPreference.getFloat(":B"+first_useful_title_useless.text.toString(),0.0F)
                            edit_first_useful_1_useless.setText(first_int.toString())

                            val second_int  = sharedPreference.getFloat(":B"+second_useful_title_useless.text.toString(),0.0F)
                            edit_second_useful_1_useless.setText(second_int.toString())

                            map_get_data.put(":B"+first_useful_title_useless.text.toString() , first_int.toString())

                            map_get_data.put(":B"+second_useful_title_useless.text.toString(), second_int.toString())
                        }
                    }
                    6 ->
                    {
                        which_compost = 6

                        checkbox_layout1_useless.isChecked = false
                        checkbox_layout2_useless.isChecked = false


                        first_compost_useful_layout_useless.visibility = View.VISIBLE
                        first_useful_title_useless.text = "کلرور پتاسیم"
                        first_compost_useful_layout_1_useless.visibility = View.INVISIBLE
                        first_useful_1_useless.text = ":Cl"

                        second_compost_useful_layout_useless.visibility = View.VISIBLE
                        second_useful_title_useless.text = "کلرور کلسیم"
                        second_compost_useful_layout_1_useless.visibility = View.INVISIBLE
                        second_useful_1_useless.text = ":Cl"

                        first_compost_useful_layout_useless.startAnimation(anim_img)
                        second_compost_useful_layout_useless.startAnimation(anim_img)

                        register_useless.visibility = View.VISIBLE

                        if (!sharedPreference.contains(":Cl"+first_useful_title_useless.text.toString())) {

                            editor.putFloat(":Cl"+first_useful_title_useless.text.toString(), 0.0F)
                            map_get_data.put(":Cl"+first_useful_title_useless.text.toString() , "0")

                            editor.putFloat(":Cl"+second_useful_title_useless.text.toString(), 0.0F)
                            map_get_data.put(":Cl"+second_useful_title_useless.text.toString(), "0")

                            edit_first_useful_1_useless.setText("0.0")
                            edit_second_useful_1_useless.setText("0.0")
                        }
                        else
                        {
                            val first_int  = sharedPreference.getFloat(":Cl"+first_useful_title_useless.text.toString(),0.0F)
                            edit_first_useful_1_useless.setText(first_int.toString())

                            val second_int  = sharedPreference.getFloat(":Cl"+second_useful_title_useless.text.toString(),0.0F)
                            edit_second_useful_1_useless.setText(second_int.toString())

                            map_get_data.put(":Cl"+first_useful_title_useless.text.toString() , first_int.toString())

                            map_get_data.put(":Cl"+second_useful_title_useless.text.toString(), second_int.toString())
                        }
                    }
                    7 ->
                    {
                        which_compost = 7

                        checkbox_layout1_useless.isChecked = false
                        checkbox_layout2_useless.isChecked = false


                        first_compost_useful_layout_useless.visibility = View.VISIBLE
                        first_useful_title_useless.text = "مولیبدات سدیم"
                        first_compost_useful_layout_1_useless.visibility = View.INVISIBLE
                        first_useful_1_useless.text = ":Mo"

                        second_compost_useful_layout_useless.visibility = View.VISIBLE
                        second_useful_title_useless.text = "مولیبدات آمونیوم"
                        second_compost_useful_layout_1_useless.visibility = View.INVISIBLE
                        second_useful_1_useless.text = ":Mo"

                        first_compost_useful_layout_useless.startAnimation(anim_img)
                        second_compost_useful_layout_useless.startAnimation(anim_img)

                        register_useless.visibility = View.VISIBLE

                        if (!sharedPreference.contains(":Mo"+first_useful_title_useless.text.toString())) {

                            editor.putFloat(":Mo"+first_useful_title_useless.text.toString(), 0.0F)
                            map_get_data.put(":Mo"+first_useful_title_useless.text.toString() , "0")

                            editor.putFloat(":Mo"+second_useful_title_useless.text.toString(), 0.0F)
                            map_get_data.put(":Mo"+second_useful_title_useless.text.toString(), "0")

                            edit_first_useful_1_useless.setText("0.0")
                            edit_second_useful_1_useless.setText("0.0")
                        }
                        else
                        {
                            val first_int  = sharedPreference.getFloat(":Mo"+first_useful_title_useless.text.toString(),0.0F)
                            edit_first_useful_1_useless.setText(first_int.toString())

                            val second_int  = sharedPreference.getFloat(":Mo"+second_useful_title_useless.text.toString(),0.0F)
                            edit_second_useful_1_useless.setText(second_int.toString())

                            map_get_data.put(":Mo"+first_useful_title_useless.text.toString() , first_int.toString())

                            map_get_data.put(":Mo"+second_useful_title_useless.text.toString(), second_int.toString())
                        }
                    }
                }
            }

        }

        checkbox_layout1_useless.setOnClickListener()
        {
            if (checkbox_layout1_useless.isChecked)
            {
                when(which_compost)
                {
                    1 ->
                    {
                        first_compost_useful_layout_1_useless.visibility = View.VISIBLE
                    }
                    2 ->
                    {
                        first_compost_useful_layout_1_useless.visibility = View.VISIBLE
                    }
                    3 ->
                    {
                        first_compost_useful_layout_1_useless.visibility = View.VISIBLE
                    }
                    4 ->
                    {
                        first_compost_useful_layout_1_useless.visibility = View.VISIBLE
                    }
                    5 ->
                    {
                        first_compost_useful_layout_1_useless.visibility = View.VISIBLE
                    }
                    6 ->
                    {
                        first_compost_useful_layout_1_useless.visibility = View.VISIBLE
                    }
                    7 ->
                    {
                        first_compost_useful_layout_1_useless.visibility = View.VISIBLE
                    }
                }
            }
            else
            {

                first_compost_useful_layout_1_useless.visibility = View.INVISIBLE

            }

        }
        checkbox_layout2_useless.setOnClickListener()
        {
            if (checkbox_layout2_useless.isChecked)
            {
                when(which_compost)
                {
                    2 ->
                    {
                        second_compost_useful_layout_1_useless.visibility = View.VISIBLE
                    }
                    3 ->
                    {
                        second_compost_useful_layout_1_useless.visibility = View.VISIBLE
                    }
                    4 ->
                    {
                        second_compost_useful_layout_1_useless.visibility = View.VISIBLE

                    }
                    5 ->
                    {
                        second_compost_useful_layout_1_useless.visibility = View.VISIBLE
                    }
                    6 ->
                    {
                        second_compost_useful_layout_1_useless.visibility = View.VISIBLE
                    }
                    7 ->
                    {
                        second_compost_useful_layout_1_useless.visibility = View.VISIBLE
                    }

                }
            }
            else
            {

                second_compost_useful_layout_1_useless.visibility = View.INVISIBLE

            }
        }


        register_useless.setOnClickListener {

            Toast.makeText(this, ".اطلاعات ثبت شد.", Toast.LENGTH_SHORT).show()
            //make all zero

            map_get_data.put(
                first_useful_1_useless.text.toString()+first_useful_title_useless.text.toString(),
                "0.0"
            )
            editor.putFloat(
                first_useful_1_useless.text.toString()+first_useful_title_useless.text.toString(),
                0.0F
            )
            map_get_data.put(
                second_useful_1_useless.text.toString()+second_useful_title_useless.text.toString(),
                "0.0"
            )
            editor.putFloat(
                second_useful_1_useless.text.toString()+second_useful_title_useless.text.toString(),
                0.0F
            )
            //make all zero
            if (first_compost_useful_layout_useless.visibility == View.VISIBLE && checkbox_layout1_useless.isChecked)//if we check text view , it can't recognize visibility .. i don't know the reason
            {
                //first_useful.text = edit_first_useful.text
                if (first_compost_useful_layout_1_useless.visibility == View.VISIBLE)//if we check text view , it can't recognize visibility .. i don't know the reason
                {
                    if (edit_first_useful_1_useless.length() > 0) {//if we check edit.!= null , it can't check it right.. so we check the length

                        editor.putFloat(
                            first_useful_1_useless.text.toString()+first_useful_title_useless.text.toString(),
                            edit_first_useful_1_useless.text.toString().toFloat()
                        )
                        map_get_data.put(
                            first_useful_1_useless.text.toString()+first_useful_title_useless.text.toString(),
                            edit_first_useful_1_useless.text.toString()
                        )

                        //first_useful.text =edit_first_useful.text.toString()//test
                    }
                }


            }
            if (second_compost_useful_layout_useless.visibility == View.VISIBLE && checkbox_layout2_useless.isChecked)
            {
                if (second_compost_useful_layout_1_useless.visibility == View.VISIBLE)//if we check text view , it can't recognize visibility .. i don't know the reason
                {
                    if (edit_second_useful_1_useless.length() > 0) {//if we check edit.!= null , it can't check it right.. so we check the length

                        editor.putFloat(
                            second_useful_1_useless.text.toString()+second_useful_title_useless.text.toString(),
                            edit_second_useful_1_useless.text.toString().toFloat()
                        )
                        map_get_data.put(
                            second_useful_1_useless.text.toString()+second_useful_title_useless.text.toString(),
                            edit_second_useful_1_useless.text.toString()
                        )

                        //first_useful.text =edit_first_useful.text.toString()//test
                    }
                }

            }

            editor.apply()
            editor.commit()

        }

        edit_first_useful_1_useless.setOnClickListener {
            edit_first_useful_1_useless.text = null
        }
        edit_second_useful_1_useless.setOnClickListener {
            edit_second_useful_1_useless.text = null
        }
        back1.setOnClickListener {



            intent3.putExtra("data_array",map_get_data)
            startActivity(intent3)
        }
        next2.setOnClickListener {


            //with register button automatically data will be updated
            intent3_2.putExtra("data_array",map_get_data)
            startActivity(intent3_2)
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

