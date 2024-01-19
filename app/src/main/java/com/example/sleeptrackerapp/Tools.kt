package com.example.sleeptrackerapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import java.text.SimpleDateFormat
import java.util.Date

class Tools {

   companion object {
        fun openLink(mContext: Context, url: String) {
            val openUrl = Intent(Intent.ACTION_VIEW)
            openUrl.data = Uri.parse(url)
            mContext.startActivity(openUrl)
        }

        fun convertLongToTime(time: Long): String {
            val date = Date(time)
            val format = SimpleDateFormat("dd MMM yyyy")
            return format.format(date)
        }
    }
}
