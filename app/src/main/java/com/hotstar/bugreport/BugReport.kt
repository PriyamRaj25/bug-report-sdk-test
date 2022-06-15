package com.hotstar.bugreport

import android.annotation.SuppressLint
import android.app.Activity
import android.app.usage.UsageEvents.Event
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.KeyEvent
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.annotation.RequiresApi

import androidx.core.content.ContextCompat.startActivity
import com.hotstar.bugreport.R

class BugReport(){

    companion object{

        fun addButton(context: Context):Button{



            val currentActivity = context as Activity
            val parentViewGroup =
                (currentActivity.findViewById(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup

            val bugReportButton = Button(context)

            //TODO different layout types would have different layout_params

            val layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT)

            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP)
            layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL)

            bugReportButton.layoutParams=layoutParams

            bugReportButton.text = "REPORT"
            bugReportButton.setTextColor(Color.parseColor("#FFFFFF"))

            bugReportButton.setBackgroundResource(R.drawable.focusable_bug_report_button)

            bugReportButton.isFocusable = true
            bugReportButton.isFocusableInTouchMode = true
            bugReportButton.bringToFront()
            bugReportButton.requestFocus()

            parentViewGroup.addView(bugReportButton)
            bugReportButton.setOnClickListener {
                openBugReportActivity(context)
            }

            return bugReportButton
        }

        fun invokeBugReportByLongPress(event: KeyEvent?, context:Context){

            if ( (event?.action == KeyEvent.ACTION_DOWN) && event.isLongPress && (event.keyCode == KeyEvent.KEYCODE_DPAD_CENTER))
                openBugReportActivity(context)
        }


        private fun openBugReportActivity(context: Context){
            val intent = Intent(context,BugReportActivity::class.java)
            startActivity(context,intent,null)
        }
    }




}
