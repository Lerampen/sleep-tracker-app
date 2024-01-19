package com.example.sleeptrackerapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime

class LocalDateConverter {
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toDate(dateString: String?): LocalDate? {
        return dateString?.let {
            LocalDate.parse(it)
        }

    }

    @TypeConverter
    fun toDateString(date: LocalDate?): String?{
        return date?.toString()
    }
}

class  LocalTimeConverter{
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toTime(timeString: String?): LocalTime?{
        return timeString?.let {
            LocalTime.parse(it)
        }

    }
    @TypeConverter
    fun timeToString(time: LocalTime?): String?{
        return time?.toString()

    }
}

class DurationConverter {
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toDuration(durationString: String?): Duration? {
        return durationString?.let {
            Duration.parse(it)
        }

    }

    @TypeConverter
    fun durationToString(duration: Duration?): String?{
        return duration?.toString()

    }
}