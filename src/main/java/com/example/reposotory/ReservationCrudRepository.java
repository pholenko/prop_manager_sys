package com.example.reposotory;

import com.example.domain.Reservation;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by admin on 26.08.17.
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findByStartDateAfter(LocalDateTime startDate);

    List<Reservation> findByStartDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Reservation> findByEndDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Reservation> findByStartDateBetweenAndEndDateBetween(LocalDateTime startDateFrom, LocalDateTime startDateTo,
                                                              LocalDateTime endDateFrom, LocalDateTime endDateTo);

}
