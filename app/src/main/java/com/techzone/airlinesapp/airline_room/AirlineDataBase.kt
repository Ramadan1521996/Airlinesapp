package com.techzone.airlinesapp.airline_room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.techzone.airlinesapp.models.Airline

@Database(entities = [Airline::class], version = 1, exportSchema = false)
abstract class AirlineDataBase : RoomDatabase() {
    abstract fun airlineDao(): AirlineDao?

    companion object {
        @Synchronized
        open fun  getInstance(context: Context): AirlineDataBase? {
                var instance: AirlineDataBase = Room.databaseBuilder(context.applicationContext,
                        AirlineDataBase::class.java, "airlines_database")
                        .fallbackToDestructiveMigration()
                        .build()
            return instance
        }
    }

}