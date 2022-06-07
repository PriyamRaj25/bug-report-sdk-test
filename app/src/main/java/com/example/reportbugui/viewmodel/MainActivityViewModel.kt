package com.example.reportbugui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reportbugui.utilities.*
import com.example.reportbugui.dataprovider.*


class MainActivityViewModel: ViewModel() {

    // initialize variables
    var userEmail= MutableLiveData<String>(ConstantsCollection.NOT_SELECTED)
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