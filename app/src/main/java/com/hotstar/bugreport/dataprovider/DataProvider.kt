package com.hotstar.bugreport.dataprovider

import com.hotstar.bugreport.utilities.Components
import com.hotstar.bugreport.utilities.Countries

class DataProvider {

    companion object{

        fun getCountriesList():ArrayList<String>{
            return arrayListOf<String>(Countries.INDIA, Countries.SOUTH_AFRICA)
        }

        fun getComponentsList():ArrayList<String>{
            return arrayListOf<String>(Components.CORE, Components.ADS, Components.CMS, Components.PLAYER)
        }
    }



}