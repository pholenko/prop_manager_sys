package com.example.demo;

import com.example.domain.Reservation;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Created by admin on 26.08.17.
 */
public class ReservationGenerator {

    public static final int PUBLISHING_TIME_MAX_DIFF = 4;

    private static final String[] FIRST_NAMES = new String[]{
            "John",
            "Mike",
            "Json",
            "Dean",
            "Tom"
    };

    private static final String[] LAST_NAMES = new String[]{
            "Doe",
            "Tyson",
            "Statham",
            "Windass",
            "Hangs"
    };

    public Reservation nextReservation(LocalDateTime currentTime) {
        Reservation reservation = new Reservation();
        reservation.setFirstName(nextRandomFromArray(FIRST_NAMES));
        reservation.setLastName(nextRandomFromArray(LAST_NAMES));
        reservation.setRoomNumber(nextRoomNumber());
        LocalDateTime startDate = nextPublishingTime(currentTime);
        reservation.setStartDate(startDate);
        reservation.setEndDate(nextPublishingTime(startDate));
        return reservation;
    }


    private static Integer nextRoomNumber() {
        return Integer.valueOf(nextInt(10) * 10 + 10);
    }

    private static LocalDateTime nextPublishingTime(LocalDateTime previous) {
        return previous.plusMinutes(nextInt(PUBLISHING_TIME_MAX_DIFF - 1) + 1);
    }

    private static <T> T nextRandomFromArray(T[] array) {
        return array[nextInt(array.length)];
    }

    private static int nextInt(int bound) {
        return new Random().nextInt(bound);
    }
}
