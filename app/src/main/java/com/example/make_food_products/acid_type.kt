package com.example.make_food_products

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.Display
import android.view.animation.AnimationUtils
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_acid_type.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_food_formula.*
import kotlinx.android.synthetic.main.activity_type_of_product_growing_step.*

class acid_type : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acid_type)

        val intent5_1 = Intent(this,Type_of_product_growing_step::class.java)
        val intent5_2 = Intent(this,food_formula::class.java)
        //for getting previous pages datas
        val intent5_3 = intent

        val map_get_data :HashMap<String,String> = intent5_3.getSerializableExtra("data_array") as HashMap<String, String>
        //for getting previous pages datas

        //update
            val sharedPreference = getSharedPreferences("acid_type",Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()

        if (editor != null) {
            var nitric = sharedPreference.getInt("nitric_acid",0)
            if(nitric == 1)
                checkbox_nitricacid.isChecked = true
            var phosphoric_acid = sharedPreference.getInt("phosphoric_acid",0)
            if(phosphoric_acid == 1)
                checkbox_phosphoric.isChecked = true
            var sulfuric_acid = sharedPreference.getInt("sulfuric_acid",0)
            if(sulfuric_acid == 1)
                checkbox_sulfuric.isChecked = true
        }
        //update
        // Set the typeface
        val typeface = Typeface.createFromAsset(assets,"no55.ttf")


        title5.typeface = typeface
        checkbox_phosphoric.typeface = typeface
        checkbox_sulfuric.typeface = typeface
        checkbox_nitricacid.typeface = typeface
        back4.typeface = typeface
        next4.typeface = typeface


        ///Set the typeface

        back4.setOnClickListener {


            if(checkbox_nitricacid.isChecked)
            {
                editor.putInt("nitric_acid",1)
                map_get_data.put("nitric_acid" , "1")

            }
            else
            {
                editor.putInt("nitric_acid",0)
                map_get_data.put("nitric_acid" , "0")
            }
            if(checkbox_phosphoric.isChecked)
            {
                editor.putInt("phosphoric_acid",1)
                map_get_data.put("phosphoric_acid" , "1")

            }
            else
            {
                editor.putInt("phosphoric_acid",0)
                map_get_data.put("phosphoric_acid" , "0")
            }
            if(checkbox_sulfuric.isChecked)
            {
                editor.putInt("sulfuric_acid",1)
                map_get_data.put("sulfuric_acid" , "1")

            }
            else
            {
                editor.putInt("sulfuric_acid",0)
                map_get_data.put("sulfuric_acid" , "0")
            }
            editor.apply()
            editor.commit()

            intent5_1.putExtra("data_array",map_get_data)
            startActivity(intent5_1)
        }
        next4.setOnClickListener{


            if(checkbox_nitricacid.isChecked)
            {
                editor.putInt("nitric_acid",1)
                map_get_data.put("nitric_acid" , "1")

            }
            else
            {
                editor.putInt("nitric_acid",0)
                map_get_data.put("nitric_acid" , "0")
            }
            if(checkbox_phosphoric.isChecked)
            {
                editor.putInt("phosphoric_acid",1)
                map_get_data.put("phosphoric_acid" , "1")

            }
            else
            {
                editor.putInt("phosphoric_acid",0)
                map_get_data.put("phosphoric_acid" , "0")
            }
            if(checkbox_sulfuric.isChecked)
            {
                editor.putInt("sulfuric_acid",1)
                map_get_data.put("sulfuric_acid" , "1")

            }
            else
            {
                editor.putInt("sulfuric_acid",0)
                map_get_data.put("sulfuric_acid" , "0")
            }
            editor.apply()
            editor.commit()

            //build data
            intent5_2.putExtra("data_array",map_get_data)
            startActivity(intent5_2)

        }
    }

}












