package com.example.make_food_products

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_acid_type.*
import kotlinx.android.synthetic.main.activity_useful_compost.*
import kotlinx.android.synthetic.main.activity_volume.*

class volume : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)

        val intent7_1 = Intent(this,food_formula::class.java)
        val intent7_2 = Intent(this,calculation::class.java)

        //for getting previous pages datas
        val intent7_3 = intent

        val map_get_data :HashMap<String,String> = intent7_3.getSerializableExtra("data_array") as HashMap<String, String>
        //for getting previous pages datas

        //update
        val sharedPreference = getSharedPreferences("volume", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        if (editor != null && sharedPreference.contains("dilution_degree")) {
            val dilution_degree = sharedPreference.getInt("dilution_degree",0)
            dilution_degree_edit.setText(dilution_degree.toString())
            val tank_A_volume = sharedPreference.getInt("tank_A_volume",0)
            tank_A_volume_edit.setText(tank_A_volume.toString())


        }
        //update
        // Set the typeface
        val typeface = Typeface.createFromAsset(assets,"no55.ttf")


        dilution_degree_text.typeface = typeface
        tank_A_volume_text.typeface = typeface
        back6.typeface = typeface
        next6.typeface = typeface
        register_volume.typeface = typeface
        dilution_title.typeface = typeface


        dilution_degree_edit.setOnClickListener {
            dilution_degree_edit.text = null
        }

        tank_A_volume_edit.setOnClickListener {
            tank_A_volume_edit.text = null
        }
        ///Set the typeface
        register_volume.setOnClickListener {
            if(dilution_degree_edit.length()>0){
                if(dilution_degree_edit.text.toString().toInt() in 50..500)
                {
                    dilution_degree_edit.setTextColor(Color.BLACK)
                    editor.putInt(
                        "dilution_degree",
                        dilution_degree_edit.text.toString().toInt()
                    )
                    editor.apply()
                    editor.commit()

                    map_get_data.put(
                        "dilution_degree",
                        dilution_degree_edit.text.toString()
                    )
                }
                else
                {

                    dilution_degree_edit.setTextColor(Color.RED)

                    Toast.makeText(this, ".درجه رقت باید بین 50 و 500 باشد.", Toast.LENGTH_SHORT).show()//show message

                }
            }
            if(tank_A_volume_edit.length()>0)
            {
                if(tank_A_volume_edit.text.toString().toInt() in 0..1000)
                {
                    tank_A_volume_edit.setTextColor(Color.BLACK)

                    editor.putInt(
                        "tank_A_volume",
                        tank_A_volume_edit.text.toString().toInt()
                    )
                    editor.apply()
                    editor.commit()

                    map_get_data.put(
                        "tank_A_volume",
                        tank_A_volume_edit.text.toString()
                    )
                }
                else
                {
                    tank_A_volume_edit.setTextColor(Color.RED)
                    Toast.makeText(this, ".عدد مخزن A باید بین 0 و 1000 باشد.", Toast.LENGTH_SHORT).show()//show message

                }

            }

            Toast.makeText(this, ".اطلاعات ثبت شد.", Toast.LENGTH_SHORT).show()//show message

        }
        back6.setOnClickListener {


            if(dilution_degree_edit.length()>0)
            {
                if(dilution_degree_edit.text.toString().toInt() in 50..500) {
                    editor.putInt("dilution_degree", dilution_degree_edit.text.toString().toInt())
                    map_get_data.put("dilution_degree", dilution_degree_edit.text.toString())
                }
            }
            if(tank_A_volume_edit.length()>0)
            {
                if(tank_A_volume_edit.text.toString().toInt() in 0..1000) {
                    editor.putInt("tank_A_volume", tank_A_volume_edit.text.toString().toInt())
                    map_get_data.put("tank_A_volume", tank_A_volume_edit.text.toString())
                }
            }

            editor.apply()
            editor.commit()

            intent7_1.putExtra("data_array",map_get_data)
            startActivity(intent7_1)
        }
        next6.setOnClickListener{


            if(dilution_degree_edit.length()>0)
            {
                if(dilution_degree_edit.text.toString().toInt() in 50..500) {
                    editor.putInt("dilution_degree", dilution_degree_edit.text.toString().toInt())
                    map_get_data["dilution_degree"] = dilution_degree_edit.text.toString()
                }
            }
            if(tank_A_volume_edit.length()>0)
            {
                if(tank_A_volume_edit.text.toString().toInt() in 0..1000) {
                    editor.putInt("tank_A_volume", tank_A_volume_edit.text.toString().toInt())
                    map_get_data["tank_A_volume"] = tank_A_volume_edit.text.toString()
                }
            }

            editor.apply()
            editor.commit()

            intent7_2.putExtra("data_array",map_get_data)
            startActivity(intent7_2)

        }

}
}