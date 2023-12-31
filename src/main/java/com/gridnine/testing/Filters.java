package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filters {

    public static List<Flight> filterBeforeThisDate(List<Flight> flights) {
        return flights.stream().filter(flight -> flight.getSegments().stream().anyMatch(segmentBeforeThisDate())).collect(Collectors.toList());
    }

    public static List<Flight> filterArrivedDateBeforeDepartureDate(List<Flight> flights) {
        return flights.stream().filter(flight -> flight.getSegments().stream().anyMatch(segmentWithArrivedDateBeforeDepartureDate())).collect(Collectors.toList());
    }

    public static List<Flight> filterTimeOnLand(List <Flight> flights, Long time) {
        return flights.stream().filter(flight -> getTimeOnLand(flight) <= time).collect(Collectors.toList());
    }

    private static Predicate<Segment> segmentBeforeThisDate() {
        return s -> s.getDepartureDate().isAfter(LocalDateTime.now());
    }

    private static Predicate<Segment> segmentWithArrivedDateBeforeDepartureDate() {
        return s -> s.getArrivalDate().isAfter(s.getDepartureDate());
    }

    private static long getTimeOnLand(Flight flight) {
        long timeOnLand = 0;
        List<Segment> segments = flight.getSegments();
        for (int i = 0; i < segments.size() - 1; i++) {
            Duration duration = Duration.between(segments.get(i).getArrivalDate(), segments.get(i+1).getDepartureDate());
            timeOnLand = timeOnLand + duration.toHours();
        }
        return timeOnLand;
    }


}
