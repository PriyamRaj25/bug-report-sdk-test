package com.hotstar.bugreport

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi

import androidx.core.content.ContextCompat.startActivity
import com.hotstar.bugreport.R


class BugReportButton {

    companion object {

        fun addButton(myContext: Context):Button{

            val currentActivity = myContext as Activity
            val parentViewGroup =
                (currentActivity.findViewById(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup

            val bugReportButton = Button(myContext)

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

                val intent = Intent(myContext,BugReportActivity::class.java)
                startActivity(myContext,intent,null)
            }

            return bugReportButton
        }
    }
}