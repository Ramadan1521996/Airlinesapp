package com.techzone.airlinesapp.models

import java.io.Serializable

class Airline :Serializable {
    private var id: String? = null
    private var name: String? = null
    private var country: String? = null
    private var logo: String? = null
    private var slogan: String? = null
    private var head_quaters: String? = null
    private var website: String? = null
    private var established: String? = null

    fun Airline() {}

    fun Airline(name: String?, country: String?, logo: String?, slogan: String?,
                head_quaters: String?, website: String?, established: String?) {
        this.name = name
        this.country = country
        this.logo = logo
        this.slogan = slogan
        this.head_quaters = head_quaters
        this.website = website
        this.established = established
    }

    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
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