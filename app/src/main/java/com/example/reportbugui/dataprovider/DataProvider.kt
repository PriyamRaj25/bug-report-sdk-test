package com.example.reportbugui.dataprovider

import com.example.reportbugui.utilities.Components
import com.example.reportbugui.utilities.Countries

class DataProvider {

    companion object{

        fun getCountriesList():List<String>{
            return listOf<String>(Countries.INDIA,Countries.SOUTH_AFRIFA)
        }

        fun getComponentsList():List<String>{
            return listOf<String>(Components.CORE,Components.ADS,Components.CMS,Components.PLAYER)
        }
    }



}