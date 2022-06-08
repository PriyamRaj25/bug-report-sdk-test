package com.example.reportbugui

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.reportbugui.databinding.ActivityMainBinding
import com.example.reportbugui.viewmodel.MainActivityViewModel

class MainActivity : ComponentActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // initialise binding and viewmodel for Data binding
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

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

        var listCountries = viewModel.getListCountries()
        var listComponents = viewModel.getListComponents()


        //viewModel.country_selector_spinner not working here
        populateDataInSpinner(findViewById(R.id.country_selector_spinner),listCountries)
        populateDataInSpinner(findViewById(R.id.component_selector_spinner),listComponents)
    }

    private fun populateDataInSpinner(spinner: Spinner, arrayItems: ArrayList<String>){

        var arrayAdapter = ArrayAdapter(this, R.layout.spinner_item , arrayItems)
        spinner.adapter = arrayAdapter
    }


    private  fun isEmailValid(email:String?):Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }







}
