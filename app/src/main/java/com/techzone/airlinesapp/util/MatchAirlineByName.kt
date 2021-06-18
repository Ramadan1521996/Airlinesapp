package com.techzone.airlinesapp.util

import com.techzone.airlinesapp.models.Airline
import java.util.*

class MatchAirlineByName :MyMatcher(){

    override fun matchAirLine(airline: Airline?, name: String?): Boolean {
        return airline!!.getName()!!.toLowerCase(Locale.ROOT).contains(name!!)
    }
}