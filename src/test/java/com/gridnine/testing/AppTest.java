package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class AppTest {
    private List<Flight> flightList;

    @BeforeEach
    public void createFlight() {
        flightList = FlightBuilder.createFlights();
    }

    @Test
    public void checkFilerBeforeThisDate() {
        List <Flight> filerBeforeThisDate = Filters.filterBeforeThisDate(flightList);
        List <Flight> resultFlights = new ArrayList<>(flightList);
        resultFlights.remove(2);
        assertEquals(resultFlights,filerBeforeThisDate);
    }

    @Test
    public void checkFilterWithDepartureTimeBeforeArrivedTime() {
        List <Flight> filterWithDepartureTimeBeforeArrivedTime = Filters.filterArrivedDateBeforeDepartureDate(flightList);
        List <Flight> resultFlights = new ArrayList<>(flightList);
        resultFlights.remove(3);
        assertEquals(resultFlights,filterWithDepartureTimeBeforeArrivedTime);
    }

    @Test
    public void checkFilterWithoutSegmentWithTimeOnLandMore2Hours() {
        List<Flight> filterWithoutSegmentWithTimeOnLandMore2Hours = Filters.filterTimeOnLand(flightList, 2L);
        List <Flight> resultFlights = new ArrayList<>(flightList);
        resultFlights.remove(5);
        resultFlights.remove(4);
        assertEquals(resultFlights,filterWithoutSegmentWithTimeOnLandMore2Hours);
    }


}
