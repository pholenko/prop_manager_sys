package com.example.service;

import com.example.domain.FilterRequest;
import com.example.domain.Reservation;
import com.example.reposotory.ReservationPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by Pavlo Holenko on 27.08.17.
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationPagingAndSortingRepository reservationPagingAndSortingRepository;

    @Override
    public Page<Reservation> filter(FilterRequest filterRequest) {
        Pageable pageable = new PageRequest(filterRequest.getPageNumber() - 1, filterRequest.getPages(), Sort.Direction.ASC, "id");
        Page<Reservation> reservations = reservationPagingAndSortingRepository.findByStartDateBetweenAndEndDateBetween(filterRequest.getStartDateFrom(),
                filterRequest.getStartDateTo(), filterRequest.getEndDateFrom(), filterRequest.getEndDateTo(), pageable);
        return reservations;
    }
}
