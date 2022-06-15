package com.hotstar.bugreport.dataprovider

import android.app.PendingIntent.getActivity
import android.content.Context
import android.util.Log
import com.hotstar.bugreport.BugReport
import com.hotstar.bugreport.BugReportActivity
import com.hotstar.bugreport.R
import com.hotstar.bugreport.utilities.Components
import com.hotstar.bugreport.utilities.Countries
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class DataProvider {

    companion object{

        fun getCountriesList(context:Context):ArrayList<String>{
            return getListItems( context.resources.getString(R.string.countries_json) , context.resources.getString(R.string.countries_array), context)
        }

        fun getComponentsList(context:Context):ArrayList<String>{
            return getListItems(context.resources.getString(R.string.components_json) , context.resources.getString(R.string.componenets_array), context)
        }

        fun getSupportedDomainsList(context:Context):ArrayList<String>{
            return getListItems(context.resources.getString(R.string.supported_domains_json) , context.resources.getString(R.string.supported_domains_array),context)
        }

        private fun loadJSONFromAsset(jsonName:String,context:Context): String? {
            var json: String? = null
            json = try {

                val inputStream = (context).assets.open(jsonName)
                val size= inputStream.available()
                val buffer = ByteArray(size)

                inputStream.read(buffer)
                inputStream.close()
                String(buffer)
            } catch (ex: IOException) {
                ex.printStackTrace()
                return null
            }
            return json
        }

        private fun getListItems(jsonName: String, arrayName: String,context: Context):ArrayList<String>{

            val listItems = ArrayList<String>()
            try {

                val obj =  JSONObject(loadJSONFromAsset(jsonName,context));
                val jsonArray = obj.getJSONArray(arrayName);

                for (i in (0 until jsonArray.length()))
                    listItems.add(jsonArray.getString(i))

            } catch (e:JSONException) {
                e.printStackTrace();
            }

            return listItems
        }
    }
}