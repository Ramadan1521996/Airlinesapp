package com.techzone.airlinesapp.iterfaces

import com.techzone.airlinesapp.models.Airline

interface AddAirlineInterface {
    fun onAddAirlineClicked(airline: Airline?)
}