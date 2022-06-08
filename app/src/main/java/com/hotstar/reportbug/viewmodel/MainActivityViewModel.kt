package com.hotstar.reportbug.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hotstar.reportbug.dataprovider.DataProvider
import com.hotstar.reportbug.utilities.Components
import com.hotstar.reportbug.utilities.ConstantsCollection
import com.hotstar.reportbug.utilities.Countries


class MainActivityViewModel: ViewModel() {

    // initialize variables
    var userEmail = MutableLiveData<String>(ConstantsCollection.NOT_SELECTED)
    var bugDescription = MutableLiveData<String>(ConstantsCollection.NOT_SELECTED)

    private var componentSelected= (Components.CORE)
    private var userCountry= (Countries.INDIA)

    private val listCountries= DataProvider.getCountriesList()
    private val listComponents= DataProvider.getComponentsList()

    fun getListCountries():ArrayList<String>{
        return listCountries
    }
    fun getListComponents():ArrayList<String>{
        return listComponents
    }
}