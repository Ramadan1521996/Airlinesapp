package com.techzone.airlinesapp

import com.techzone.airlinesapp.models.Airline
import com.techzone.airlinesapp.util.MatchAirlineByCountry
import com.techzone.airlinesapp.util.MatchAirlineByName
import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    @Ignore
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testMatchAirlineByName() {
        val matcher = MatchAirlineByName()
        val airline = Airline(
            "Quatar Airways", "Quatar", " ", " ", " ", " ", ""
        )
        assertTrue(matcher.matchAirLine(airline, "qu"))
    }

    @Test
    fun notTestMatchAirlineByName() {
        val matcher = MatchAirlineByName()
        val airline = Airline(
            "Quatar Airways", "Quatar", " ", " ", " ", " ", ""
        )
        assertFalse(matcher.matchAirLine(airline, "qa"))
    }

    @Test
    fun testMatchAirlineByCountry() {
        val matcher = MatchAirlineByCountry()
        val airline = Airline(
            "Quatar Airways", "Egypt", " ", " ", " ", " ", ""
        )
        assertTrue(matcher.matchAirLine(airline, "EGY")) //this test case expected to be true
        //by found false so this indicate that i have problem with this class
        //this line airline.getCountry().toLowerCase().contains(country) have to be
        //airline.getCountry().toLowerCase().contains(country.toLowerCase())
    }

    @Test
    fun notTestMatchAirlineCountry() {
        val matcher = MatchAirlineByCountry()
        val airline = Airline(
            "Quatar Airways", "Egypt", " ", " ", " ", " ", ""
        )
        assertFalse(matcher.matchAirLine(airline, "Egypttt"))
    }
}