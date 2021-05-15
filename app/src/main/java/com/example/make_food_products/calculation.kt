package com.example.make_food_products

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Typeface
import android.icu.math.BigDecimal
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Environment.DIRECTORY_DOWNLOADS
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import kotlinx.android.synthetic.main.activity_calculation.*
import kotlinx.android.synthetic.main.activity_start.*

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.math.RoundingMode



//to kg or gr
class calculation : AppCompatActivity() {
    private val storagecode: Int = 100


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)


        System.setProperty(
            "org.apache.poi.javax.xml.stream.XMLOutputFactory",
            "com.fasterxml.aalto.stax.OutputFactoryImpl"
        );
        System.setProperty(
            "org.apache.poi.javax.xml.stream.XMLEventFactory",
            "com.fasterxml.aalto.stax.EventFactoryImpl"
        );


        //for getting previous pages datas
        val intent7_3 = intent
        val intent7_2 = Intent(this, volume::class.java)

        val map_get_data: HashMap<String, String> =
            intent7_3.getSerializableExtra("data_array") as HashMap<String, String>
        //for getting previous pages datas
        var N_dens = 0.0F
        var P_dens = 0.0F
        var K_dens = 0.0F
        var Ca_dens = 0.0F
        var Mg_dens = 0.0F
        var S_dens = 0.0F
        var Fe_dens = 0.0F
        var Mn_dens = 0.0F
        var B_dens = 0.0F
        var Zn_dens = 0.0F
        var Cu_dens = 0.0F
        var Mo_dens = 0.0F
        var Cl_dens = 0.0F

        if (map_get_data.containsKey("K_density")) {
            K_dens = map_get_data["K_density"].toString().toFloat()

        } else {
            K_dens = 0.0F
        }
        if (map_get_data.containsKey("Ca_density")) {
            Ca_dens = map_get_data["Ca_density"].toString().toFloat()

        } else {
            Ca_dens = 0.0F
        }
        if (map_get_data.containsKey("P_density")) {
            P_dens = map_get_data["P_density"].toString().toFloat()

        } else {
            P_dens = 0.0F
        }
        if (map_get_data.containsKey("Mg_density")) {
            Mg_dens = map_get_data["Mg_density"].toString().toFloat()

        } else {
            Mg_dens = 0.0F
        }
        if (map_get_data.containsKey("N_density")) {
            N_dens = map_get_data["N_density"].toString().toFloat()

        } else {
            N_dens = 0.0F
        }
        if (map_get_data.containsKey("S_density")) {
            S_dens = map_get_data["S_density"].toString().toFloat()

        } else {
            S_dens = 0.0F
        }
        if (map_get_data.containsKey("Fe_density")) {
            Fe_dens = map_get_data["Fe_density"].toString().toFloat()

        } else {
            Fe_dens = 0.0F
        }
        if (map_get_data.containsKey("Mn_density")) {
            Mn_dens = map_get_data["Mn_density"].toString().toFloat()

        } else {
            Mn_dens = 0.0F
        }
        if (map_get_data.containsKey("B_density")) {
            B_dens = map_get_data["B_density"].toString().toFloat()

        } else {
            B_dens = 0.0F
        }
        if (map_get_data.containsKey("Cl_density")) {
            Cl_dens = map_get_data["Cl_density"].toString().toFloat()

        } else {
            Cl_dens = 0.0F
        }
        if (map_get_data.containsKey("Zn_density")) {
            Zn_dens = map_get_data["Zn_density"].toString().toFloat()

        } else {
            Zn_dens = 0.0F
        }
        if (map_get_data.containsKey("Cu_density")) {
            Cu_dens = map_get_data["Cu_density"].toString().toFloat()

        } else {
            Cu_dens = 0.0F
        }
        if (map_get_data.containsKey("Mo_density")) {
            Mo_dens = map_get_data["Mo_density"].toString().toFloat()

        } else {
            Mo_dens = 0.0F
        }


        //1.Ca 2.P 3.K 4.Mg 5.S 6.N
        // Set the typeface
        val typeface = Typeface.createFromAsset(assets, "no55.ttf")
        //array
        val arr_combination: Array<String?> = arrayOfNulls<String>(12)
        val value_combination: Array<String?> = arrayOfNulls<String>(12)
        //array
        ///////////////
        if (map_get_data["bicarbon_water"].toString().toFloat() > 2) {
            var bicarbon = map_get_data["bicarbon_water"].toString().toFloat()
            var sulfuric = map_get_data["sulfuric_acid"].toString().toInt()
            var phosphoric = map_get_data["phosphoric_acid"].toString().toInt()
            var nitric = map_get_data["nitric_acid"].toString().toInt()
            if (sulfuric == 1) {
                bicarbon = (bicarbon - 2) * 16 //mg/lit of S
                S_dens = S_dens - bicarbon
            } else if (nitric == 1) {
                bicarbon = (bicarbon - 2) * 14 //mg/lit of N
                N_dens = N_dens - bicarbon
            } else if (phosphoric == 1) {
                bicarbon = (bicarbon - 2) * 31 //mg/lit of P
                P_dens = P_dens - bicarbon
            }
        }
        var Dilution_degree = map_get_data["dilution_degree"].toString().toInt()
        var volume_of_A_B = map_get_data["tank_A_volume"].toString().toInt()
        ///////////////
        ///calculate Fe
        var Fe_gr_weight = Fe_dens * Dilution_degree * volume_of_A_B / 1000
        var string_fe = "کلات آهن"
        var Fe_in_kalat_string: String
        if (map_get_data.containsKey(":Fe$string_fe")) {
            Fe_in_kalat_string = map_get_data[":Fe$string_fe"].toString()

        } else {
            Fe_in_kalat_string = "0.0"
        }

        var Fe_in_kalat = Fe_in_kalat_string.toFloat()
        var kalat_g = (100 * Fe_gr_weight) / Fe_in_kalat //CaCO3 needed

        if (kalat_g > 1000) {
            kalat_g = kalat_g / 1000 //kg
            kalat_g = "%.2f".format(kalat_g).toFloat()
            fe_need.typeface = typeface
            fe_need.text = "کلات آهن:$kalat_g" + "کیلوگرم"
        } else {
            kalat_g = "%.2f".format(kalat_g).toFloat()
            fe_need.typeface = typeface
            fe_need.text = "کلات آهن:$kalat_g" + "گرم"
        }
        arr_combination[5] = "کلات آهن"
        value_combination[5] = kalat_g.toString() + "گرم"

        ///calculate Fe
        ///calculate <Mn>
        var Mn_gr_weight = Mn_dens * Dilution_degree * volume_of_A_B / 1000
        var string_mn1 = "سولفات منگنز"
        var string_mn2 = "کلات منگنز"


        if (map_get_data.containsKey(":Mn$string_mn1") && map_get_data[":Mn$string_mn1"].toString()
                .toFloat() > 0
        )//mnso4
        {
            var mn_in_mnso4_string = map_get_data[":Mn$string_mn1"].toString()
            var mn_in_mnso4 = mn_in_mnso4_string.toFloat()
            var mnso4_g = (100 * Mn_gr_weight) / mn_in_mnso4 //mnso4 needed
            arr_combination[6] = "سولفات منگنز"


            if (mnso4_g > 1000) {
                mnso4_g = mnso4_g / 1000 //kg
                mnso4_g = "%.2f".format(mnso4_g).toFloat()
                mn_need.typeface = typeface
                mn_need.text = "سولفات منگنز:$mnso4_g" + "کیلوگرم"
                value_combination[6] = mnso4_g.toString() + "کیلوگرم"
            } else {
                mnso4_g = "%.2f".format(mnso4_g).toFloat()
                mn_need.typeface = typeface
                mn_need.text = "سولفات منگنز:$mnso4_g" + "گرم"
                value_combination[6] = mnso4_g.toString() + "گرم"
            }
        } else if (map_get_data.containsKey(":Mn$string_mn2") && map_get_data[":Mn$string_mn2"].toString()
                .toFloat() > 0
        )//mnkalat
        {
            var mn_in_mnkalat_string = map_get_data[":Mn$string_mn2"].toString()
            var mn_in_mnkalat = mn_in_mnkalat_string.toFloat()
            var mnkalat_g = (100 * Mn_gr_weight) / mn_in_mnkalat //mnkalat needed
            arr_combination[6] = "کلات منگنز"

            if (mnkalat_g > 1000) {
                mnkalat_g = mnkalat_g / 1000 //kg
                mnkalat_g = "%.2f".format(mnkalat_g).toFloat()
                mn_need.typeface = typeface
                mn_need.text = "کلات منگنز:$mnkalat_g" + "کیلوگرم"
                value_combination[6] = mnkalat_g.toString() + "کیلوگرم"
            } else {
                mnkalat_g = "%.2f".format(mnkalat_g).toFloat()
                mn_need.typeface = typeface
                mn_need.text = "کلات منگنز:$mnkalat_g" + "گرم"
                value_combination[6] = mnkalat_g.toString() + "گرم"
            }
        }
        ///calculate Mn
        ///calculate Zn
        var Zn_gr_weight = Zn_dens * Dilution_degree * volume_of_A_B / 1000
        var string_zn1 = "سولفات روی"
        var string_zn2 = "کلات روی"

        if (map_get_data.containsKey(":Zn$string_zn1") && map_get_data[":Zn$string_zn1"].toString()
                .toFloat() > 0
        )//znso4
        {
            var zn_in_znso4_string = map_get_data[":Zn$string_zn1"].toString()
            var zn_in_znso4 = zn_in_znso4_string.toFloat()
            var znso4_g = (100 * Zn_gr_weight) / zn_in_znso4 //znso4 needed
            arr_combination[7] = "سولفات روی"

            if (znso4_g > 1000) {
                znso4_g = znso4_g / 1000 //kg
                znso4_g = "%.2f".format(znso4_g).toFloat()
                zn_need.typeface = typeface
                zn_need.text = "سولفات روی:$znso4_g" + "کیلوگرم"
                value_combination[7] = znso4_g.toString() + "کیلوگرم"
            } else {
                znso4_g = "%.2f".format(znso4_g).toFloat()
                zn_need.typeface = typeface
                zn_need.text = "سولفات روی:$znso4_g" + "گرم"

                value_combination[7] = znso4_g.toString() + "گرم"
            }
        } else if (map_get_data.containsKey(":Zn$string_zn2") && map_get_data[":Zn$string_zn2"].toString()
                .toFloat() > 0
        )//znkalat
        {
            var zn_in_znkalat_string = map_get_data[":Zn$string_zn2"].toString()
            var zn_in_znkalat = zn_in_znkalat_string.toFloat()
            var znkalat_g = (100 * Zn_gr_weight) / zn_in_znkalat //znkalat needed
            arr_combination[7] = "کلات روی"

            if (znkalat_g > 1000) {
                znkalat_g = znkalat_g / 1000 //kg
                znkalat_g = "%.2f".format(znkalat_g).toFloat()
                zn_need.typeface = typeface
                zn_need.text = "کلات روی:$znkalat_g" + "کیلوگرم"
                value_combination[7] = znkalat_g.toString() + "کیلوگرم"
            } else {
                znkalat_g = "%.2f".format(znkalat_g).toFloat()
                zn_need.typeface = typeface
                zn_need.text = "کلات روی:$znkalat_g" + "گرم"
                value_combination[7] = znkalat_g.toString() + "گرم"
            }
        }
        ///calculate Zn
        ///calculate Cu
        var Cu_gr_weight = Cu_dens * Dilution_degree * volume_of_A_B / 1000
        var string_cu1 = "سولفات مس"
        var string_cu2 = "کلات مس"

        if (map_get_data.containsKey(":Cu$string_cu1") && map_get_data[":Cu$string_cu1"].toString()
                .toFloat() > 0
        )//cuso4
        {
            var cu_in_cuso4_string = map_get_data[":Cu$string_cu1"].toString()
            var cu_in_cuso4 = cu_in_cuso4_string.toFloat()
            var cuso4_g = (100 * Cu_gr_weight) / cu_in_cuso4 //cuso4 needed
            arr_combination[8] = "سولفات مس"

            if (cuso4_g > 1000) {
                cuso4_g = cuso4_g / 1000 //kg
                cuso4_g = "%.2f".format(cuso4_g).toFloat()
                cu_need.typeface = typeface
                cu_need.text = "سولفات مس:$cuso4_g" + "کیلوگرم"
                value_combination[8] = cuso4_g.toString() + "کیلوگرم"
            } else {
                cuso4_g = "%.2f".format(cuso4_g).toFloat()
                cu_need.typeface = typeface
                cu_need.text = "سولفات مس:$cuso4_g" + "گرم"
                value_combination[8] = cuso4_g.toString() + "گرم"
            }
        } else if (map_get_data.containsKey(":Cu$string_cu2") && map_get_data[":Cu$string_cu2"].toString()
                .toFloat() > 0
        )//cukalat
        {
            var cu_in_cukalat_string = map_get_data[":Cu$string_cu2"].toString()
            var cu_in_cukalat = cu_in_cukalat_string.toFloat()
            var cukalat_g = (100 * Cu_gr_weight) / cu_in_cukalat //cukalat needed
            arr_combination[8] = "کلات مس"
            if (cukalat_g > 1000) {
                cukalat_g = cukalat_g / 1000 //kg
                cukalat_g = "%.2f".format(cukalat_g).toFloat()
                cu_need.typeface = typeface
                cu_need.text = "کلات مس:$cukalat_g" + "کیلوگرم"
                value_combination[8] = cukalat_g.toString() + "کیلوگرم"
            } else {
                cukalat_g = "%.2f".format(cukalat_g).toFloat()
                cu_need.typeface = typeface
                cu_need.text = "کلات مس:$cukalat_g" + "گرم"
                value_combination[8] = cukalat_g.toString() + "گرم"
            }
        }
        ///calculate Cu
        ///calculate B
        var B_gr_weight = B_dens * Dilution_degree * volume_of_A_B / 1000
        var string_B1 = "اسید بوریک"
        var string_B2 = "بوراکس"

        if (map_get_data.containsKey(":B$string_B1") && map_get_data[":B$string_B1"].toString()
                .toFloat() > 0
        )//H3BO3
        {

            var B_in_H3BO3_string = map_get_data[":B$string_B1"].toString()
            var B_in_H3BO3 = B_in_H3BO3_string.toFloat()
            var H3BO3_g = (100 * B_gr_weight) / B_in_H3BO3 //H3BO3 needed
            arr_combination[9] = "اسید بوریک"

            if (H3BO3_g > 1000) {
                H3BO3_g = H3BO3_g / 1000 //kg
                H3BO3_g = "%.2f".format(H3BO3_g).toFloat()
                b_need.typeface = typeface
                b_need.text = "اسید بوریک:$H3BO3_g" + "کیلوگرم"
                value_combination[9] = H3BO3_g.toString() + "کیلوگرم"
            } else {
                H3BO3_g = "%.2f".format(H3BO3_g).toFloat()
                b_need.typeface = typeface
                b_need.text = "اسید بوریک:$H3BO3_g" + "گرم"
                value_combination[9] = H3BO3_g.toString() + "گرم"
            }
        } else if (map_get_data.containsKey(":B$string_B2") && map_get_data[":B$string_B2"].toString()
                .toFloat() > 0
        )//borax
        {
            var B_in_borax_string = map_get_data[":B$string_B2"].toString()
            var B_in_borax = B_in_borax_string.toFloat()
            var borax_g = (100 * B_gr_weight) / B_in_borax //borax needed
            arr_combination[9] = "بوراکس"

            if (borax_g > 1000) {
                borax_g = borax_g / 1000 //kg
                borax_g = "%.2f".format(borax_g).toFloat()

                b_need.typeface = typeface
                b_need.text = "بوراکس:$borax_g" + "کیلوگرم"
                value_combination[9] = borax_g.toString() + "کیلوگرم"
            } else {
                borax_g = "%.2f".format(borax_g).toFloat()

                b_need.typeface = typeface
                b_need.text = "بوراکس:$borax_g" + "گرم"
                value_combination[9] = borax_g.toString() + "گرم"
            }
        }
        ///calculate B
        ///calculate Cl
        var Cl_gr_weight = Cl_dens * Dilution_degree * volume_of_A_B / 1000
        var string_cl1 = "کلرور پتاسیم"
        var string_cl2 = "کلرور کلسیم"

        if (map_get_data.containsKey(":Cl$string_cl1") && map_get_data[":Cl$string_cl1"].toString()
                .toFloat() > 0
        )//kcl
        {
            var cl_in_kcl_string = map_get_data[":Cl$string_cl1"].toString()
            var cl_in_kcl = cl_in_kcl_string.toFloat()
            var kcl_g = (100 * Cl_gr_weight) / cl_in_kcl //kcl needed
            arr_combination[10] = "کلرور پتاسیم"

            if (kcl_g > 1000) {
                kcl_g = kcl_g / 1000 //kg
                kcl_g = "%.2f".format(kcl_g).toFloat()

                cl_need.typeface = typeface
                cl_need.text = "کلرور پتاسیم:$kcl_g" + "کیلوگرم"
                value_combination[10] = kcl_g.toString() + "کیلوگرم"
            } else {
                kcl_g = "%.2f".format(kcl_g).toFloat()

                cl_need.typeface = typeface
                cl_need.text = "کلرور پتاسیم:$kcl_g" + "گرم"
                value_combination[10] = kcl_g.toString() + "گرم"

            }
        } else if (map_get_data.containsKey(":Cl$string_cl2") && map_get_data[":Cl$string_cl2"].toString()
                .toFloat() > 0
        )//cacl2
        {
            var cl_in_cacl2_string = map_get_data[":Cl$string_cl2"].toString()
            var cl_in_cacl2 = cl_in_cacl2_string.toFloat()
            var cacl2_g = (100 * Cl_gr_weight) / cl_in_cacl2 //cacl2 needed
            arr_combination[10] = "کلرور کلسیم"

            if (cacl2_g > 1000) {
                cacl2_g = cacl2_g / 1000 //kg
                cacl2_g = "%.2f".format(cacl2_g).toFloat()

                cl_need.typeface = typeface
                cl_need.text = "کلرور کلسیم:$cacl2_g" + "کیلوگرم"
                value_combination[10] = cacl2_g.toString() + "کیلوگرم"

            } else {
                cacl2_g = "%.2f".format(cacl2_g).toFloat()

                cl_need.typeface = typeface
                cl_need.text = "کلرور کلسیم:$cacl2_g" + "گرم"
                value_combination[10] = cacl2_g.toString() + "گرم"

            }
        }
        ///calculate Cl
        ///caclulate Mo

        var Mo_gr_weight = Mo_dens * Dilution_degree * volume_of_A_B / 1000
        var string_mo1 = "مولیبدات سدیم"
        var string_mo2 = "مولیبدات آمونیوم"

        if (map_get_data.containsKey(":Mo$string_mo1") && map_get_data[":Mo$string_mo1"].toString()
                .toFloat() > 0
        )//mo_na
        {
            var mo_in_mo_na_string = map_get_data[":Mo$string_mo1"].toString()
            var mo_in_mo_na = mo_in_mo_na_string.toFloat()
            var mo_na_g = (100 * Mo_gr_weight) / mo_in_mo_na //mo_na needed
            arr_combination[11] = "مولیبدات سدیم"

            if (mo_na_g > 1000) {
                mo_na_g = mo_na_g / 1000 //kg
                mo_na_g = "%.2f".format(mo_na_g).toFloat()

                mo_need.typeface = typeface
                mo_need.text = "مولیبدات سدیم:$mo_na_g" + "کیلوگرم"
                value_combination[11] = mo_na_g.toString() + "کیلوگرم"

            } else {
                mo_na_g = "%.2f".format(mo_na_g).toFloat()

                mo_need.typeface = typeface
                mo_need.text = "مولیبدات سدیم:$mo_na_g" + "گرم"
                value_combination[11] = mo_na_g.toString() + "گرم"

            }
        } else if (map_get_data.containsKey(":Mo$string_mo2") && map_get_data[":Mo$string_mo2"].toString()
                .toFloat() > 0
        )//mo_n
        {
            var mo_in_mo_n_string = map_get_data[":Mo$string_mo2"].toString()
            var mo_in_mo_n = mo_in_mo_n_string.toFloat()
            var mo_n_g = (100 * Mo_gr_weight) / mo_in_mo_n //mo_n needed
            arr_combination[11] = "مولیبدات آمونیوم"

            if (mo_n_g > 1000) {
                mo_n_g = mo_n_g / 1000 //kg
                mo_n_g = "%.2f".format(mo_n_g).toFloat()

                mo_need.typeface = typeface
                mo_need.text = "مولیبدات آمونیوم:$mo_n_g" + "کیلوگرم"
                value_combination[11] = mo_n_g.toString() + "کیلوگرم"

            } else {
                mo_n_g = "%.2f".format(mo_n_g).toFloat()

                mo_need.typeface = typeface
                mo_need.text = "مولیبدات آمونیوم:$mo_n_g" + "گرم"
                value_combination[11] = mo_n_g.toString() + "گرم"

            }
        }

        ///caclulate Mo
        ///////////////


        //calculate Ca
        //Ca_dens = map_get_data["Ca_density"].toString().toFloat()
        //first we look at the ca in water which can provide needed ca
        var Ca_dens_water = map_get_data["ca_water"].toString().toFloat()
        var Ca_subtraction = Ca_dens - Ca_dens_water //ppm
        //so we need this amount of ca now

        var Ca_kg_weight = (Ca_subtraction * Dilution_degree * volume_of_A_B) / 1000000
        var string = "نیترات کلسیم"
        var Ca_in_CaNo3_string = "0.0"
        var CaNo3_kg = 0.0F
        if (map_get_data.containsKey(":Ca$string"))
        {
            Ca_in_CaNo3_string = map_get_data[":Ca$string"].toString()
            var Ca_in_CaNo3 = Ca_in_CaNo3_string.toFloat()
            CaNo3_kg = (100 * Ca_kg_weight) / Ca_in_CaNo3 //CaNO3 needed
            var N_in_CaNo3_string = map_get_data[":N$string"].toString()
            var N_in_CaNo3 = N_in_CaNo3_string.toFloat()/100.0F




            //calculate N
            var N_needed = (CaNo3_kg * (N_in_CaNo3) * 1000000 )/(Dilution_degree * volume_of_A_B)//mg/lit
            //N_dens = map_get_data["N_density"].toString().toFloat()
            N_dens = N_dens - N_needed //N_needed will provide part of N_dens
        }



        //calculate N
        //calculate Ca

        //N_need.text = "نیتروژن مورد نیاز:$N_needed"

        Ca_need.typeface = typeface
        Ca_need.text = "نیترات کلسیم:$CaNo3_kg"+"کیلوگرم"
        CaNo3_kg = "%.2f".format(CaNo3_kg).toFloat()

        value_combination[0] = CaNo3_kg.toString()+"کیلوگرم"


        arr_combination[0] = "نیترات کلسیم"

        //calculate P
        var string11 = "مونوپتاسیم فسفات"//KH2PO4
        var string12 = "مونوآمونیوم فسفات"//(NH4)(H2PO4)
        var string13 = "اسید فسفریک"//H3PO4
        if(map_get_data.containsKey(":P$string11") && map_get_data[":P$string11"].toString().toFloat()>0)//KH2PO4
        {
            //P_dens = map_get_data["P_density"].toString().toFloat()
            var P_gr_weight = P_dens * Dilution_degree * volume_of_A_B / 1000
            var string1 = "مونوپتاسیم فسفات"//KH2PO4
            var P_in_KH2PO4_string = map_get_data[":P$string11"].toString()
            var P_in_KH2PO4 = P_in_KH2PO4_string.toFloat()
            var KH2PO4_gr = (100*P_gr_weight)/P_in_KH2PO4 //KH2PO4 is needed

            var K_in_KH2PO4_string = map_get_data[":K$string11"].toString()
            var K_in_KH2PO4 = K_in_KH2PO4_string.toFloat()/100.0F
            //calculate N
            //calculate N
            //calculate P
            if (KH2PO4_gr > 1000) {
                KH2PO4_gr = KH2PO4_gr / 1000 //kg
                KH2PO4_gr = "%.2f".format(KH2PO4_gr).toFloat()

                p_need.typeface = typeface
                p_need.text = "مونوپتاسیم فسفات:$KH2PO4_gr"+"کیلوگرم"
                value_combination[1] = KH2PO4_gr.toString()+"کیلوگرم"

            }
            else
            {
                KH2PO4_gr = "%.2f".format(KH2PO4_gr).toFloat()

                p_need.typeface = typeface
                p_need.text = "مونوپتاسیم فسفات:$KH2PO4_gr"+"گرم"
                value_combination[1] = KH2PO4_gr.toString()+"گرم"

            }


            arr_combination[1] = "مونو پتاسیم فسفات"

            var K_needed = (KH2PO4_gr * (K_in_KH2PO4) * 1000 )/(Dilution_degree * volume_of_A_B)//mg/lit
            //K_dens = map_get_data["K_density"].toString().toFloat()
            K_dens = K_dens - K_needed
        }
        else if(map_get_data.containsKey(":P$string12") && map_get_data[":P$string12"].toString().toFloat()>0)//(NH4)(H2PO4)
        {
            //P_dens = map_get_data["P_density"].toString().toFloat()
            var P_gr_weight = P_dens * Dilution_degree * volume_of_A_B / 1000
            var string2 = "مونوآمونیوم فسفات"//(NH4)(H2PO4)
            var P_in_NH4H2PO4_string = map_get_data[":P$string12"].toString()
            var P_in_NH4H2PO4 = P_in_NH4H2PO4_string.toFloat()
            var NH4H2PO4_gr = (100*P_gr_weight)/P_in_NH4H2PO4 //NH4H2PO4 is needed


            if (NH4H2PO4_gr > 1000) {
                NH4H2PO4_gr = NH4H2PO4_gr / 1000 //kg
                NH4H2PO4_gr = "%.2f".format(NH4H2PO4_gr).toFloat()

                p_need.typeface = typeface
                p_need.text = "مونوآمونیوم فسفات:$NH4H2PO4_gr"+"کیلوگرم"
                value_combination[1] = NH4H2PO4_gr.toString()+"کیلوگرم"

            }
            else
            {
                NH4H2PO4_gr = "%.2f".format(NH4H2PO4_gr).toFloat()

                p_need.typeface = typeface
                p_need.text = "مونوآمونیوم فسفات:$NH4H2PO4_gr"+"گرم"
                value_combination[1] = NH4H2PO4_gr.toString()+"گرم"

            }

            arr_combination[1] = "مونو آمونیوم فسفات"

            var N_in_NH4H2PO4_string = map_get_data[":N$string12"].toString()
            var N_in_NH4H2PO4 = N_in_NH4H2PO4_string.toFloat()/100.0F

            var N_needed = (NH4H2PO4_gr * (N_in_NH4H2PO4) * 1000 )/(Dilution_degree * volume_of_A_B)//mg/lit
            //N_dens = map_get_data["N_density"].toString().toFloat()
            N_dens = N_dens - N_needed//new N_dens that we need
        }
        else if(map_get_data.containsKey(":P$string13") && map_get_data[":P$string13"].toString().toFloat()>0)//H3PO4
        {
            //P_dens = map_get_data["P_density"].toString().toFloat()
            var P_gr_weight = P_dens * Dilution_degree * volume_of_A_B / 1000
            var string3 = "اسید فسفریک"//H3PO4
            var P_in_H3PO4_string = map_get_data[":P$string13"].toString()
            var P_in_H3PO4 = P_in_H3PO4_string.toFloat()
            var H3PO4_gr = (100*P_gr_weight)/P_in_H3PO4 //H3PO4 is needed


            if (H3PO4_gr > 1000) {
                H3PO4_gr = H3PO4_gr / 1000 //kg
                H3PO4_gr = "%.2f".format(H3PO4_gr).toFloat()

                p_need.typeface = typeface
                p_need.text = "اسید فسفریک:$H3PO4_gr"+"کیلوگرم"
                value_combination[1] = H3PO4_gr.toString()+"کیلوگرم"

            }
            else
            {
                H3PO4_gr = "%.2f".format(H3PO4_gr).toFloat()

                p_need.typeface = typeface
                p_need.text = "اسید فسفریک:$H3PO4_gr"+"گرم"
                value_combination[1] = H3PO4_gr.toString()+"گرم"

            }

            arr_combination[1] = "فسفریک اسید"
        }
        ///calculate K
        var K_gr_weight = K_dens * Dilution_degree * volume_of_A_B / 1000 //gr
        var string21 = "نیترات پتاسیم"
        var string22 = "سولفات پتاسیم"
        if(map_get_data.containsKey(":K$string21") && map_get_data[":K$string21"].toString().toFloat()>0)
        {
            var K_in_KNO3_string = map_get_data[":K$string21"].toString()
            var K_in_KNO3 = K_in_KNO3_string.toFloat()
            var KNO3_gr = (100*K_gr_weight)/K_in_KNO3 //KNO3 is needed



            if (KNO3_gr > 1000) {
                KNO3_gr = KNO3_gr / 1000 //kg
                KNO3_gr = "%.2f".format(KNO3_gr).toFloat()

                k_need.typeface = typeface
                k_need.text = "نیترات پتاسیم:$KNO3_gr"+"کیلوگرم"
                value_combination[2] = KNO3_gr.toString()+"کیلوگرم"

            }
            else
            {
                KNO3_gr = "%.2f".format(KNO3_gr).toFloat()

                k_need.typeface = typeface
                k_need.text = "نیترات پتاسیم:$KNO3_gr"+"گرم"
                value_combination[2] = KNO3_gr.toString()+"گرم"

            }

            arr_combination[2] = "نیترات پتاسیم"

            //N
            var N_in_KNO3_string = map_get_data[":N$string21"].toString()
            var N_in_KNO3 = N_in_KNO3_string.toFloat()/100.0F
            var N_need_KNO3 = (KNO3_gr * N_in_KNO3 * 1000) /  (Dilution_degree * volume_of_A_B)//mg/lit
            N_dens = N_dens - N_need_KNO3 //new N_dens that we need to add
            //N
        }
        else if(map_get_data.containsKey(":K$string22") && map_get_data[":K$string22"].toString().toFloat()>0)
        {
            var K_in_K2SO4_string = map_get_data[":K$string22"].toString()
            var K_in_K2SO4 = K_in_K2SO4_string.toFloat()
            var K2SO4_gr = (100*K_gr_weight)/K_in_K2SO4 //K2SO4 is needed



            if (K2SO4_gr > 1000) {
                K2SO4_gr = K2SO4_gr / 1000 //kg
                K2SO4_gr = "%.2f".format(K2SO4_gr).toFloat()

                k_need.typeface = typeface
                k_need.text = "سولفات پتاسیم:$K2SO4_gr"+"کیلوگرم"
                value_combination[2] = K2SO4_gr.toString()+"کیلوگرم"

            }
            else
            {
                K2SO4_gr = "%.2f".format(K2SO4_gr).toFloat()

                k_need.typeface = typeface
                k_need.text = "سولفات پتاسیم:$K2SO4_gr"+"گرم"
                value_combination[2] = K2SO4_gr.toString()+"گرم"

            }

            arr_combination[2] = "سولفات پتاسیم"

            //S
            var S_in_K2SO4_string = map_get_data[":S$string22"].toString()
            var S_in_K2SO4 = S_in_K2SO4_string.toFloat()/100.0F
            var S_need_K2SO4 = (K2SO4_gr * S_in_K2SO4 * 1000) /  (Dilution_degree * volume_of_A_B)//mg/lit
            S_dens = S_dens - S_need_K2SO4 //new S_dens that we need to add
            //S

        }

        //calculate mg
        var Mg_water = map_get_data["mg_water"].toString().toFloat()
        Mg_dens -= Mg_water
        var Mg_gr_weight = Mg_dens * Dilution_degree * volume_of_A_B / 1000 //gr

        var string31 = "سولفات منیزیم"//MgSO4
        var string32 = "نیترات منیزیم"//Mg(NO3)2
        if(map_get_data.containsKey(":Mg$string31") && map_get_data[":Mg$string31"].toString().toFloat()>0)
        {
            var Mg_in_MgSO4_string = map_get_data[":Mg$string31"].toString()
            var Mg_in_MgSO4 = Mg_in_MgSO4_string.toFloat()
            var MgSO4_gr = (100*Mg_gr_weight)/Mg_in_MgSO4 //MgSO4 is needed



            if (MgSO4_gr > 1000) {
                MgSO4_gr = MgSO4_gr / 1000 //kg
                MgSO4_gr = "%.2f".format(MgSO4_gr).toFloat()

                mg_need.typeface = typeface
                mg_need.text = "سولفات منیزیم:$MgSO4_gr"+"کیلوگرم"
                value_combination[3] = MgSO4_gr.toString()+"کیلوگرم"

            }
            else
            {
                MgSO4_gr = "%.2f".format(MgSO4_gr).toFloat()

                mg_need.typeface = typeface
                mg_need.text = "سولفات منیزیم:$MgSO4_gr"+"گرم"
                value_combination[3] = MgSO4_gr.toString()+"گرم"

            }


            arr_combination[3] = "سولفات منیزیم"

            //S
            var S_in_MgSO4_string = map_get_data[":S$string31"].toString()
            var S_in_MgSO4 = S_in_MgSO4_string.toFloat()/100.0F
            var S_need_MgSO4 = (MgSO4_gr * S_in_MgSO4 * 1000) /  (Dilution_degree * volume_of_A_B)//mg/lit
            S_dens = S_dens - S_need_MgSO4 //new S_dens that we need to add
            //S
        }
        else if(map_get_data.containsKey(":Mg$string32") && map_get_data[":Mg$string32"].toString().toFloat()>0)
        {
            var Mg_in_MgNO3_string = map_get_data[":Mg$string32"].toString()
            var Mg_in_MgNO3 = Mg_in_MgNO3_string.toFloat()
            var MgNO3_gr = (100*Mg_gr_weight)/Mg_in_MgNO3 //MgNO3 is needed

            if (MgNO3_gr > 1000) {
                MgNO3_gr = MgNO3_gr / 1000 //kg
                MgNO3_gr = "%.2f".format(MgNO3_gr).toFloat()

                mg_need.typeface = typeface
                mg_need.text = "نیترات منیزیم:$MgNO3_gr"+"کیلوگرم"
                value_combination[3] = MgNO3_gr.toString()+"کیلوگرم"

            }
            else
            {
                MgNO3_gr = "%.2f".format(MgNO3_gr).toFloat()

                mg_need.typeface = typeface
                mg_need.text = "نیترات منیزیم:$MgNO3_gr"+"گرم"
                value_combination[3] = MgNO3_gr.toString()+"گرم"

            }
            arr_combination[3] = "نیترات منیزیم"

            //N
            var N_in_MgNO3_string = map_get_data[":N$string32"].toString()
            var N_in_MgNO3 = N_in_MgNO3_string.toFloat()/100.0F
            var N_need_MgNO3 = (MgNO3_gr * N_in_MgNO3 * 1000) /  (Dilution_degree * volume_of_A_B)//mg/lit
            N_dens = N_dens - N_need_MgNO3 //new N_dens that we need to add
            //N
        }
        //calculate mg


        //calculate N
        var string41 = "نیترات آمونیوم"//NH4NO3
        var string42 = "اسید نیتریک"//HNO3


            var N_gr_weight = N_dens * Dilution_degree * volume_of_A_B / 1000 //gr

            if(map_get_data.containsKey(":N$string41") && map_get_data[":N$string41"].toString().toFloat()>0)
            {
                var N_in_NH4NO3_string = map_get_data[":N$string41"].toString()
                var N_in_NH4NO3 = N_in_NH4NO3_string.toFloat()
                var NH4NO3_gr = (100*N_gr_weight)/N_in_NH4NO3 //NH4NO3_gr is needed

                if (NH4NO3_gr > 1000) {
                    NH4NO3_gr = NH4NO3_gr / 1000 //kg
                    NH4NO3_gr = "%.2f".format(NH4NO3_gr).toFloat()

                    n_need.typeface = typeface
                    n_need.text = "نیترات آمونیوم:$NH4NO3_gr"+"کیلوگرم"
                    value_combination[4] = NH4NO3_gr.toString()+"کیلوگرم"

                }
                else
                {
                    NH4NO3_gr = "%.2f".format(NH4NO3_gr).toFloat()

                    n_need.typeface = typeface
                    n_need.text = "نیترات آمونیوم:$NH4NO3_gr"+"گرم"
                    value_combination[4] = NH4NO3_gr.toString()+"گرم"

                }
                arr_combination[4] = "نیترات آمونیوم"
            }
            else if(map_get_data.containsKey(":N$string42") && map_get_data[":N$string42"].toString().toFloat()>0)
            {
                var N_in_HNO3_string = map_get_data[":N$string42"].toString()
                var N_in_HNO3 = N_in_HNO3_string.toFloat()
                var HNO3_gr = (100*N_gr_weight)/N_in_HNO3 //HNO3_gr is needed

                if (HNO3_gr > 1000) {
                    HNO3_gr = HNO3_gr / 1000 //kg
                    HNO3_gr = "%.2f".format(HNO3_gr).toFloat()

                    n_need.typeface = typeface
                    n_need.text = "اسید نیتریک:$HNO3_gr"+"کیلوگرم"
                    value_combination[4] = HNO3_gr.toString()+"کیلوگرم"

                }
                else
                {
                    HNO3_gr = "%.2f".format(HNO3_gr).toFloat()

                    n_need.typeface = typeface
                    n_need.text = "اسید نیتریک:$HNO3_gr"+"گرم"
                    value_combination[4] = HNO3_gr.toString()+"گرم"

                }
                arr_combination[4] = "اسید نیتریک"
            }


        //calculate N
        fe_need.typeface = typeface
        b_need.typeface = typeface
        n_need.typeface = typeface
        k_need.typeface = typeface

        mg_need.typeface = typeface
        cl_need.typeface = typeface
        p_need.typeface = typeface
        Ca_need.typeface = typeface

        mo_need.typeface = typeface
        mn_need.typeface = typeface
        cu_need.typeface = typeface
        zn_need.typeface = typeface

        calculate_back.typeface = typeface
        calculate_button.typeface = typeface
        calculate_back.setOnClickListener {
            intent7_2.putExtra("data_array",map_get_data)
            startActivity(intent7_2)
        }




        calculate_button.setOnClickListener {
//excel
            Toast.makeText(this, Build.VERSION.SDK_INT.toString(), Toast.LENGTH_SHORT).show()
            if (Build.VERSION.SDK_INT >= 23) {
                //Toast.makeText(this, "hiiiiiii", Toast.LENGTH_SHORT).show()

                if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_DENIED
                ) {
                    //Toast.makeText(this, "hiiiiiii", Toast.LENGTH_SHORT).show()

                    val perm = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    requestPermissions(perm, storagecode)
                }
            }



            val workbook = XSSFWorkbook()
            val sheet: Sheet = workbook.createSheet("Users") //Creating a sheet


            for (i in 0 until 11) {
                val row: Row = sheet.createRow(i)
                row.createCell(0).setCellValue(arr_combination[i])
                row.createCell(1).setCellValue(value_combination[i])
            }


            //folder.mkdir() //creating the folder
            val fileName = "Nutritional_solution.xlsx" //Name of the file

            val path = this.getExternalFilesDir(null)
            val letDirectory = File(path, "Nutritional_solution")
            letDirectory.mkdirs()

            val file = File(letDirectory, fileName)
            try {
                file.createNewFile() // creating the file inside the folder
            } catch (e1: IOException) {
                e1.printStackTrace()
            }

            try {
                val fileOut = FileOutputStream(file) //Opening the file
                workbook.write(fileOut) //Writing all your row column inside the file
                fileOut.close() //closing the file and done
                Toast.makeText(this, "file generated", Toast.LENGTH_SHORT).show()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            //read(launch excel)
            val intent = Intent(Intent.ACTION_VIEW)
            val apkURI = FileProvider.getUriForFile(
                this,
                "com.example.make_food_products.FileProvider", file
            )

            val myMime = MimeTypeMap.getSingleton()
            val mimeType = myMime.getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(apkURI.toString())) //It will return the mimetype


            intent.setDataAndType(apkURI, mimeType)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            startActivity(intent)
            //read
            //excel
        }

    }
}