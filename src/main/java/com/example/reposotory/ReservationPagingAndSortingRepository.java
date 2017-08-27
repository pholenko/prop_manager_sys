package com.example.reposotory;

import com.example.domain.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;

/**
 * Created by Pavlo Holenko on 27.08.17.
 */
public interface ReservationPagingAndSortingRepository extends PagingAndSortingRepository<Reservation, Long> {

    Page<Reservation> findByStartDateBetweenAndEndDateBetween(LocalDateTime startDateFrom, LocalDateTime startDateTo,
                                                              LocalDateTime endDateFrom, LocalDateTime endDateTo, Pageable pageable);
}
