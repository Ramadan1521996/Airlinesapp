package com.techzone.airlinesapp.airline_room

import androidx.room.*
import com.techzone.airlinesapp.models.Airline
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface AirlineDao {
    @Query("SELECT * FROM airline_table")
    fun getAllAirlines(): Single<List<Airline>>

    @Query("SELECT * FROM airline_table where id = :id")
    fun getAirlineById(id: String?): Single<Airline>

    @Insert
    fun insertAll(airlines: List<Airline>): Completable

    @Query("DELETE FROM airline_table")
    fun deleteAll(): Completable?

    //////////////////////////////////////////////////////////
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMenu(airline: Airline?): Completable?

    @Update
    fun update(airline: Airline?): Completable?

    @Delete
    fun delete(airline: Airline?): Completable?
}