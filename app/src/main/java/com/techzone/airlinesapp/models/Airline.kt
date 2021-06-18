package com.techzone.airlinesapp.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "airline_table")
class Airline( private var name: String?,   private var country: String?,  private var logo: String?
,  private var slogan: String? , private var head_quaters: String? ,private var website: String? = null ,
               private var established: String?) :Serializable {

    @PrimaryKey
    @NonNull
    private var id: String =""
    fun getId(): String {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getCountry(): String? {
        return country
    }

    fun setCountry(country: String?) {
        this.country = country
    }

    fun getLogo(): String? {
        return logo
    }

    fun setLogo(logo: String?) {
        this.logo = logo
    }

    fun getSlogan(): String? {
        return slogan
    }

    fun setSlogan(slogan: String?) {
        this.slogan = slogan
    }

    fun getHead_quaters(): String? {
        return head_quaters
    }

    fun setHead_quaters(head_quaters: String?) {
        this.head_quaters = head_quaters
    }

    fun getWebsite(): String? {
        return website
    }

    fun setWebsite(website: String?) {
        this.website = website
    }

    fun getEstablished(): String? {
        return established
    }

    fun setEstablished(established: String?) {
        this.established = established
    }
}