package com.example.make_food_products

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_type_of_product_growing_step.*


class Type_of_product_growing_step : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_of_product_growing_step)

        val intent4 = Intent(this,useless_compost::class.java)
        val intent4_2 = Intent(this,acid_type::class.java)

        //for getting previous pages datas
        val intent4_3 = intent

        val map_get_data:HashMap<String,String> = intent4_3.getSerializableExtra("data_array") as HashMap<String, String>

        //for getting previous pages datas

        //update data
        val sharedPreference =  getSharedPreferences("type_of_product_growing_step", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        if (editor != null) {
            val sharedproduct = sharedPreference.getInt("product_type",0)
            spinner_product.setSelection(sharedproduct)
            val sharedgrow = sharedPreference.getInt("grow_period",0)
            spinner_grow.setSelection(sharedgrow)

        }


        //update data

        val typeface = Typeface.createFromAsset(assets,"no55.ttf")

        // Set the typeface
        title4.typeface = typeface
        type_product.typeface = typeface

        grow_period.typeface = typeface
        back3.typeface = typeface
        next3.typeface = typeface


        ///Set the typeface

        back3.setOnClickListener {


            editor.putInt("product_type",getIndex(spinner_product,spinner_product.selectedItem.toString()))
            editor.putInt("grow_period",getIndex(spinner_grow,spinner_grow.selectedItem.toString()))
            editor.apply()
            editor.commit()

            intent4.putExtra("data_array",map_get_data)
            startActivity(intent4)
        }
        next3.setOnClickListener {


            editor.putInt("product_type",getIndex(spinner_product,spinner_product.selectedItem.toString()))
            editor.putInt("grow_period",getIndex(spinner_grow,spinner_grow.selectedItem.toString()))
            editor.apply()
            editor.commit()
            //build data
            map_get_data.put("product_type" , spinner_product.selectedItem.toString())
            map_get_data.put("grow_period",spinner_grow.selectedItem.toString())

            //build data
            intent4_2.putExtra("data_array",map_get_data)
            startActivity(intent4_2)
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











