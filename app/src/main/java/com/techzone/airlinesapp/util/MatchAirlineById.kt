package com.techzone.airlinesapp.util

import com.techzone.airlinesapp.models.Airline
import java.util.*

class MatchAirlineById:MyMatcher() {
    override fun matchAirLine(airline: Airline?, name: String?): Boolean {
        return airline!!.getId().toLowerCase(Locale.ROOT).contains(name!!)
    }
}