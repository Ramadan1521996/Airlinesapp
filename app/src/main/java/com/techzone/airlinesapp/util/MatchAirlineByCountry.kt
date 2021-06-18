package com.techzone.airlinesapp.util

import com.techzone.airlinesapp.models.Airline
import java.util.*

class MatchAirlineByCountry :MyMatcher() {
    override fun matchAirLine(airline: Airline?, name: String?): Boolean {
        return airline!!.getCountry()!!.toLowerCase(Locale.ROOT).contains(name!!)
    }

}