package com.gridnine.testing;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("Набор полетов до фильтрации " + flights);
        List<Flight> filerBeforeThisDate = Filters.filterBeforeThisDate(flights);
        System.out.println("Набор перелетов с исключением вылетов до текущего времени " + filerBeforeThisDate);
        List <Flight> filterWithDepartureTimeBeforeArrivedTime = Filters.filterArrivedDateBeforeDepartureDate(flights);
        System.out.println("Набор перелетов с исключением вылетов, где дата прибытия раньше даты отправления" + filterWithDepartureTimeBeforeArrivedTime);
        List<Flight> filterWithoutSegmentWithTimeOnLandMore2Hours = Filters.filterTimeOnLand(flights, 2L);
        System.out.println("Набор перелетов с исключением вылетов, где общее время на земле более 2 часов" + filterWithoutSegmentWithTimeOnLandMore2Hours);

    }
}
