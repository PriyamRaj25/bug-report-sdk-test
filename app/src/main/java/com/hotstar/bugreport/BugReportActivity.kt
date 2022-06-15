package com.hotstar.bugreport

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hotstar.bugreport.databinding.ActivityBugReportBinding
import com.hotstar.bugreport.dataprovider.DataProvider
import com.hotstar.bugreport.viewmodel.BugReportActivityViewModel

class BugReportActivity : ComponentActivity() {

    private lateinit var viewBinding: ActivityBugReportBinding
    private lateinit var viewModel: BugReportActivityViewModel
    private lateinit var binding: ActivityBugReportBinding
    private lateinit var supportedDomains: ArrayList<String>

    private var TAG = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setFinishOnTouchOutside(false);

        // initialise binding and viewmodel for Data binding
        viewBinding = ActivityBugReportBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_bug_report)
        viewModel = ViewModelProvider(this)[BugReportActivityViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // get List of Domains
        supportedDomains = DataProvider.getSupportedDomainsList(this)

        // initialise country and component dropdowns
        intialiseSpinner()

        // add observer to the user email and bug description strings so as to validate and enable the submit button
        validateInput()
    }

    private fun validateInput(){

        var observer = getObserver()

        // sets the observer to the live data
        viewModel.bugDescription.observe(this, observer)
        viewModel.userEmail.observe(this,observer)
    }

    private fun getObserver():Observer<String>{

        val observer = Observer<String> {

            // Button is enabled only if description is not empty and email is valid
            (findViewById<Button>(R.id.submit_button)).isEnabled =
                !(viewModel.bugDescription.value?.isEmpty() == true || (!(isEmailValid(viewModel.userEmail.value))))
        }
        return observer
    }

    private fun intialiseSpinner(){

        var listCountries= viewModel.getListCountries()
        var listComponents= viewModel.getListComponents()


        //viewModel.country_selector_spinner not working here
        populateDataInSpinner(findViewById(R.id.country_selector_spinner),listCountries)
        populateDataInSpinner(findViewById(R.id.component_selector_spinner),listComponents)
    }

    private fun populateDataInSpinner(spinner: Spinner, arrayItems: ArrayList<String>){

        var arrayAdapter= ArrayAdapter(this, R.layout.spinner_item, arrayItems)
        spinner.adapter= arrayAdapter
    }


    private  fun isEmailValid(email:String?):Boolean{

        var isValidDomain=false
        // checks if the email domain is supported
        for(domain in supportedDomains){
            if( email?.endsWith(domain) == true ) {
                isValidDomain = true

                Log.d("PRIYAM SDK", "Email"+email + " Domain "+domain)
                break
            }
        }

        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && isValidDomain
    }
}
