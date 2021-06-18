package com.techzone.airlinesapp.util

import com.techzone.airlinesapp.models.Airline

abstract class  MyMatcher {
    abstract fun matchAirLine(airline: Airline?, name: String?): Boolean
}