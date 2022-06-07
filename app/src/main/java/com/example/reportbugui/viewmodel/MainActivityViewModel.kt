package com.example.reportbugui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.reportbugui.utilities.*
import com.example.reportbugui.dataprovider.*


class MainActivityViewModel: ViewModel() {

    // initialize variables
    private var userEmail: String = ConstantsCollection.NOT_SELECTED
    private var userCountry: String = Countries.INDIA

    private var componentSelected: String = Components.CORE
    private var bugDescription: String = ConstantsCollection.NOT_SELECTED

    private val listCountries: List<String> = DataProvider.getComponentsList()
    private val listComponents: List<String> = DataProvider.getComponentsList()






}