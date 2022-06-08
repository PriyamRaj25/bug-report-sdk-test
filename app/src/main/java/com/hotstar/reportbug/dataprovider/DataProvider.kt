package com.hotstar.reportbug.dataprovider

import com.hotstar.reportbug.utilities.Components
import com.hotstar.reportbug.utilities.Countries

class DataProvider {

    companion object{

        fun getCountriesList():ArrayList<String>{
            return arrayListOf<String>(Countries.INDIA, Countries.SOUTH_AFRIFA)
        }

        fun getComponentsList():ArrayList<String>{
            return arrayListOf<String>(Components.CORE, Components.ADS, Components.CMS, Components.PLAYER)
        }
    }



}