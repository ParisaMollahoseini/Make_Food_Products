package com.example.make_food_products

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Typeface
import android.view.animation.AnimationUtils
import android.widget.Spinner
import androidx.core.content.SharedPreferencesCompat
import kotlinx.android.synthetic.main.activity_food_formula.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_useful_compost.*
import kotlinx.android.synthetic.main.activity_useless_compost.*


class food_formula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_formula)

        val intent6_1 = Intent(this,acid_type::class.java)
        val intent6_2 = Intent(this,volume::class.java)

        //for getting previous pages datas
        val intent6_3 = intent

        val map_get_data:HashMap<String,String> = intent6_3.getSerializableExtra("data_array") as HashMap<String, String>
        //for getting previous pages datas

        //update data
        val sharedPreference =  getSharedPreferences("food_formula", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()




        if (editor != null && sharedPreference.contains("N_density")) {

            val N_dens = sharedPreference.getFloat("N_density", 0.0F)
            edit_N_density.setText(N_dens.toString())

            val P_dens = sharedPreference.getFloat("P_density",0.0F)
            edit_P_density.setText(P_dens.toString())

            val K_dens = sharedPreference.getFloat("K_density",0.0F)
            edit_K_density.setText(K_dens.toString())

            val Ca_dens = sharedPreference.getFloat("Ca_density",0.0F)
            edit_Ca_density.setText(Ca_dens.toString())

            val Mg_dens = sharedPreference.getFloat("Mg_density",0.0F)
            edit_Mg_density.setText(Mg_dens.toString())

            val S_dens = sharedPreference.getFloat("S_density",0.0F)
            edit_S_density.setText(S_dens.toString())

            val Fe_dens = sharedPreference.getFloat("Fe_density",0.0F)
            edit_Fe_density.setText(Fe_dens.toString())

            val Mn_dens = sharedPreference.getFloat("Mn_density",0.0F)
            edit_Mn_density.setText(Mn_dens.toString())

            val B_dens = sharedPreference.getFloat("B_density",0.0F)
            edit_B_density.setText(B_dens.toString())

            val Cl_dens = sharedPreference.getFloat("Cl_density",0.0F)
            edit_Cl_density.setText(Cl_dens.toString())

            val Zn_dens = sharedPreference.getFloat("Zn_density",0.0F)
            edit_Zn_density.setText(Zn_dens.toString())

            val Cu_dens = sharedPreference.getFloat("Cu_density",0.0F)
            edit_Cu_density.setText(Cu_dens.toString())

            val Mo_dens = sharedPreference.getFloat("Mo_density",0.0F)
            edit_Mo_density.setText(Mo_dens.toString())


        }
        else if(!sharedPreference.contains("N_density"))
        {
            map_get_data.put("N_density","0.0")
            map_get_data.put("P_density","0.0")
            map_get_data.put("K_density","0.0")
            map_get_data.put("Ca_density","0.0")
            map_get_data.put("Mg_density","0.0")
            map_get_data.put("S_density","0.0")

            map_get_data.put("Fe_density","0.0")
            map_get_data.put("Mn_density","0.0")
            map_get_data.put("B_density","0.0")
            map_get_data.put("Cl_density","0.0")
            map_get_data.put("Zn_density","0.0")
            map_get_data.put("Cu_density","0.0")
            map_get_data.put("Mo_density","0.0")
        }
        //update data

        val typeface = Typeface.createFromAsset(assets, "no55.ttf")


        // Set the typeface
        title6.typeface = typeface
        cucumber.typeface = typeface
        cucumber.text = "نام محصول :"+ map_get_data["product_type"].toString()

        N_density_text.typeface = typeface
        P_density_text.typeface = typeface
        K_density_text.typeface = typeface
        Ca_density_text.typeface = typeface
        Mg_density_text.typeface = typeface
        S_density_text.typeface = typeface
        Fe_density_text.typeface = typeface
        Mn_density_text.typeface = typeface
        B_density_text.typeface = typeface
        Cl_density_text.typeface = typeface
        Zn_density_text.typeface = typeface
        Cu_density_text.typeface = typeface
        Mo_density_text.typeface = typeface

        back5.typeface = typeface
        next5.typeface = typeface
        ///Set the typeface
        edit_N_density.setOnClickListener {
            edit_N_density.text = null
        }
        edit_P_density.setOnClickListener {
            edit_P_density.text = null
        }
        edit_K_density.setOnClickListener {
            edit_K_density.text = null
        }
        edit_Ca_density.setOnClickListener {
            edit_Ca_density.text = null
        }
        edit_Mg_density.setOnClickListener {
            edit_Mg_density.text = null
        }
        edit_S_density.setOnClickListener {
            edit_S_density.text = null
        }
        edit_Fe_density.setOnClickListener {
            edit_Fe_density.text = null
        }
        edit_Mn_density.setOnClickListener {
            edit_Mn_density.text = null
        }
        edit_B_density.setOnClickListener {
            edit_B_density.text = null
        }
        edit_Cl_density.setOnClickListener {
            edit_Cl_density.text = null
        }
        edit_Zn_density.setOnClickListener {
            edit_Zn_density.text = null
        }
        edit_Cu_density.setOnClickListener {
            edit_Cu_density.text = null
        }
        edit_Mo_density.setOnClickListener {
            edit_Mo_density.text = null
        }

        back5.setOnClickListener {

            if(edit_N_density.length()>0)
            {
                editor.putFloat("N_density",edit_N_density.text.toString().toFloat())
                map_get_data.put("N_density",edit_N_density.text.toString())

            }
            if(edit_P_density.length()>0)
            {
                editor.putFloat("P_density",edit_P_density.text.toString().toFloat())
                map_get_data.put("P_density",edit_P_density.text.toString())

            }
            if(edit_K_density.length()>0)
            {
                editor.putFloat("K_density",edit_K_density.text.toString().toFloat())
                map_get_data.put("K_density",edit_K_density.text.toString())

            }
            if(edit_Ca_density.length()>0)
            {
                editor.putFloat("Ca_density",edit_Ca_density.text.toString().toFloat())
                map_get_data.put("Ca_density",edit_Ca_density.text.toString())

            }
            if(edit_Mg_density.length()>0)
            {
                editor.putFloat("Mg_density",edit_Mg_density.text.toString().toFloat())
                map_get_data.put("Mg_density",edit_Mg_density.text.toString())

            }
            if(edit_S_density.length()>0)
            {
                editor.putFloat("S_density",edit_S_density.text.toString().toFloat())
                map_get_data.put("S_density",edit_S_density.text.toString())

            }
            if(edit_Fe_density.length()>0)
            {
                editor.putFloat("Fe_density",edit_Fe_density.text.toString().toFloat())
                map_get_data.put("Fe_density",edit_Fe_density.text.toString())

            }
            if(edit_Mn_density.length()>0)
            {
                editor.putFloat("Mn_density",edit_Mn_density.text.toString().toFloat())
                map_get_data.put("Mn_density",edit_Mn_density.text.toString())

            }
            if(edit_B_density.length()>0)
            {
                editor.putFloat("B_density",edit_B_density.text.toString().toFloat())
                map_get_data.put("B_density",edit_B_density.text.toString())

            }
            if(edit_Cl_density.length()>0)
            {
                editor.putFloat("Cl_density",edit_Cl_density.text.toString().toFloat())
                map_get_data.put("Cl_density",edit_Cl_density.text.toString())

            }
            if(edit_Zn_density.length()>0)
            {
                editor.putFloat("Zn_density",edit_Zn_density.text.toString().toFloat())
                map_get_data.put("Zn_density",edit_Zn_density.text.toString())

            }
            if(edit_Cu_density.length()>0)
            {
                editor.putFloat("Cu_density",edit_Cu_density.text.toString().toFloat())
                map_get_data.put("Cu_density",edit_Cu_density.text.toString())

            }
            if(edit_Mo_density.length()>0)
            {
                editor.putFloat("Mo_density",edit_Mo_density.text.toString().toFloat())
                map_get_data.put("Mo_density",edit_Mo_density.text.toString())

            }

            editor.apply()
            editor.commit()




            intent6_1.putExtra("data_array",map_get_data)
            startActivity(intent6_1)
        }
        next5.setOnClickListener {

            if(edit_N_density.length()>0)
            {
                editor.putFloat("N_density",edit_N_density.text.toString().toFloat())
                map_get_data.put("N_density",edit_N_density.text.toString())

            }
            if(edit_P_density.length()>0)
            {
                editor.putFloat("P_density",edit_P_density.text.toString().toFloat())
                map_get_data.put("P_density",edit_P_density.text.toString())

            }
            if(edit_K_density.length()>0)
            {
                editor.putFloat("K_density",edit_K_density.text.toString().toFloat())
                map_get_data.put("K_density",edit_K_density.text.toString())

            }
            if(edit_Ca_density.length()>0)
            {
                editor.putFloat("Ca_density",edit_Ca_density.text.toString().toFloat())
                map_get_data.put("Ca_density",edit_Ca_density.text.toString())

            }
            if(edit_Mg_density.length()>0)
            {
                editor.putFloat("Mg_density",edit_Mg_density.text.toString().toFloat())
                map_get_data.put("Mg_density",edit_Mg_density.text.toString())

            }
            if(edit_S_density.length()>0)
            {
                editor.putFloat("S_density",edit_S_density.text.toString().toFloat())
                map_get_data.put("S_density",edit_S_density.text.toString())

            }
            if(edit_Fe_density.length()>0)
            {
                editor.putFloat("Fe_density",edit_Fe_density.text.toString().toFloat())
                map_get_data.put("Fe_density",edit_Fe_density.text.toString())

            }
            if(edit_Mn_density.length()>0)
            {
                editor.putFloat("Mn_density",edit_Mn_density.text.toString().toFloat())
                map_get_data.put("Mn_density",edit_Mn_density.text.toString())

            }
            if(edit_B_density.length()>0)
            {
                editor.putFloat("B_density",edit_B_density.text.toString().toFloat())
                map_get_data.put("B_density",edit_B_density.text.toString())

            }
            if(edit_Cl_density.length()>0)
            {
                editor.putFloat("Cl_density",edit_Cl_density.text.toString().toFloat())
                map_get_data.put("Cl_density",edit_Cl_density.text.toString())

            }
            if(edit_Zn_density.length()>0)
            {
                editor.putFloat("Zn_density",edit_Zn_density.text.toString().toFloat())
                map_get_data.put("Zn_density",edit_Zn_density.text.toString())

            }
            if(edit_Cu_density.length()>0)
            {
                editor.putFloat("Cu_density",edit_Cu_density.text.toString().toFloat())
                map_get_data.put("Cu_density",edit_Cu_density.text.toString())

            }
            if(edit_Mo_density.length()>0)
            {
                editor.putFloat("Mo_density",edit_Mo_density.text.toString().toFloat())
                map_get_data.put("Mo_density",edit_Mo_density.text.toString())

            }

            editor.apply()
            editor.commit()

            intent6_2.putExtra("data_array",map_get_data)
            startActivity(intent6_2)
        }
    }

}