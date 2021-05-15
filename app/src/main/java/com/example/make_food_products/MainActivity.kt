package com.example.make_food_products

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_start.*


class MainActivity : AppCompatActivity() {
    private val sharedPrefFile = "make_food_products"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val typeface = Typeface.createFromAsset(assets, "no55.ttf")

        //update data
        val sharedPreference =  getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        if (editor != null) {
            val sharedsalt = sharedPreference.getInt("salt_water",0)
            spinner_salt.setSelection(sharedsalt)
            val sharedacid = sharedPreference.getInt("acid_water",0)
            spinner_acid.setSelection(sharedacid)
            val sharedbicarbon = sharedPreference.getInt("bicarbon_water",0)
            spinner_bicarbon.setSelection(sharedbicarbon)
            val sharedca = sharedPreference.getInt("ca_water",0)
            spinner_ca_water.setSelection(sharedca)
            val sharedmg = sharedPreference.getInt("mg_water",0)
            spinner_mg_water.setSelection(sharedmg)
            val sharedso4 = sharedPreference.getInt("so4_water",0)
            spinner_so4_water.setSelection(sharedso4)
            }



        //update data

        // Set the typeface
        title1.typeface = typeface
        title_metric.typeface = typeface
        mg_water.typeface = typeface
        so4_water.typeface = typeface
        ca_water.typeface = typeface
        salt.typeface = typeface
        Bicarbon.typeface = typeface
        acid.typeface = typeface
        next.typeface = typeface
        back0.typeface = typeface
        ///Set the typeface
        val intent1 = Intent(this,useful_compost::class.java)
        val intent1_2 = Intent(this,start::class.java)
        var intent1_3 = intent
        val map_data :HashMap<String,String> = intent1_3.getSerializableExtra("data_array") as HashMap<String, String>


        next.setOnClickListener {

            editor.putInt("salt_water",getIndex(spinner_salt,spinner_salt.selectedItem.toString()))
            editor.putInt("acid_water",getIndex(spinner_acid,spinner_acid.selectedItem.toString()))
            editor.putInt("bicarbon_water",getIndex(spinner_bicarbon,spinner_bicarbon.selectedItem.toString()))
            editor.putInt("ca_water",getIndex(spinner_ca_water,spinner_ca_water.selectedItem.toString()))
            editor.putInt("mg_water",getIndex(spinner_mg_water,spinner_mg_water.selectedItem.toString()))
            editor.putInt("so4_water",getIndex(spinner_so4_water,spinner_so4_water.selectedItem.toString()))

            editor.apply()
            editor.commit()
            //build data
            map_data.put("salt_water" , spinner_salt.selectedItem.toString())
            map_data.put("acid_water",spinner_acid.selectedItem.toString())
            map_data.put("bicarbon_water",spinner_bicarbon.selectedItem.toString())

            val ca_water_str = (spinner_ca_water.selectedItem.toString().toFloat()*20).toString()
            val mg_water_str = (spinner_mg_water.selectedItem.toString().toFloat()*12).toString()
            val so4_water_str = (spinner_so4_water.selectedItem.toString().toFloat()*16).toString()

            map_data.put("ca_water",ca_water_str)
            map_data.put("mg_water",mg_water_str)
            map_data.put("so4_water",so4_water_str)
            //build data
            intent1.putExtra("data_array",map_data)
            startActivity(intent1)
        }
        back0.setOnClickListener {


            editor.putInt("salt_water",getIndex(spinner_salt,spinner_salt.selectedItem.toString()))
            editor.putInt("acid_water",getIndex(spinner_acid,spinner_acid.selectedItem.toString()))
            editor.putInt("bicarbon_water",getIndex(spinner_bicarbon,spinner_bicarbon.selectedItem.toString()))
            editor.putInt("ca_water",getIndex(spinner_ca_water,spinner_ca_water.selectedItem.toString()))
            editor.putInt("mg_water",getIndex(spinner_mg_water,spinner_mg_water.selectedItem.toString()))
            editor.putInt("so4_water",getIndex(spinner_so4_water,spinner_so4_water.selectedItem.toString()))

            editor.apply()
            editor.commit()
            //build data
            map_data.put("salt_water" , spinner_salt.selectedItem.toString())
            map_data.put("acid_water",spinner_acid.selectedItem.toString())
            map_data.put("bicarbon_water",spinner_bicarbon.selectedItem.toString())

            val ca_water_str = (spinner_ca_water.selectedItem.toString().toFloat()*20).toString()
            val mg_water_str = (spinner_mg_water.selectedItem.toString().toFloat()*12).toString()
            val so4_water_str = (spinner_so4_water.selectedItem.toString().toFloat()*16).toString()

            map_data.put("ca_water",ca_water_str)
            map_data.put("mg_water",mg_water_str)
            map_data.put("so4_water",so4_water_str)
            //build data
            intent1_2.putExtra("data_array",map_data)
            startActivity(intent1_2)
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