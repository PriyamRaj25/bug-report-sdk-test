package com.hotstar.bugreport.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hotstar.bugreport.dataprovider.DataProvider
import com.hotstar.bugreport.utilities.Components
import com.hotstar.bugreport.utilities.ConstantsCollection
import com.hotstar.bugreport.utilities.Countries


class BugReportActivityViewModel(application: Application) : AndroidViewModel(application) {

    // initialize variables
    var userEmail = MutableLiveData<String>(ConstantsCollection.NOT_SELECTED)
    var bugDescription = MutableLiveData<String>(ConstantsCollection.NOT_SELECTED)

    private val listCountries= DataProvider.getCountriesList(application)
    private val listComponents= DataProvider.getComponentsList(application)

    private var componentSelected= (listComponents[0])
    private var userCountry= (listCountries[0])

    fun getListCountries():ArrayList<String>{
        return listCountries
    }
    fun getListComponents():ArrayList<String>{
        return listComponents
    }
}