package com.hotstar.bugreport.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.hotstar.bugreport.dataprovider.DataProvider
import com.hotstar.bugreport.utilities.ConstantsCollection


class BugReportActivityViewModel(application: Application) : AndroidViewModel(application) {

    // initialize variables
    var userEmail = MutableLiveData<String>(ConstantsCollection.NOT_SELECTED)
    var bugDescription = MutableLiveData<String>(ConstantsCollection.NOT_SELECTED)

    private val listCountries= DataProvider.getCountriesList(application.applicationContext)
    private val listComponents= DataProvider.getComponentsList(application.applicationContext)

    private var componentSelected= (listComponents[0])
    private var userCountry= (listCountries[0])

    fun getListCountries():ArrayList<String>{
        return listCountries
    }
    fun getListComponents():ArrayList<String>{
        return listComponents
    }
}