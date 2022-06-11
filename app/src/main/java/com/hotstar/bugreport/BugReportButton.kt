package com.hotstar.bugreport

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BugReportButton {

    companion object {
        fun addButton(myContext: Context):FloatingActionButton{

            val currentActivity = myContext as Activity
            val parentViewGroup =
                (currentActivity.findViewById(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup

            val floatingButton = FloatingActionButton(myContext)

            //TODO different layout types would have different layout_params

            val layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT)

            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP)

            floatingButton.layoutParams=layoutParams

            parentViewGroup.addView(floatingButton)
            floatingButton.setOnClickListener {

                val intent = Intent(myContext,BugReportActivity::class.java)
                startActivity(myContext,intent,null)
            }

            return floatingButton
        }
    }
}