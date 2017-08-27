package com.example.controller;

import com.example.domain.FilterRequest;
import com.example.domain.Reservation;
import com.example.reposotory.ReservationPagingAndSortingRepository;
import com.example.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Pavlo Holenko on 26.08.17.
 */
@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value="/reservations/filter", method=RequestMethod.POST, consumes = "application/json",
            produces = "application/json")
    public Page<Reservation> filter(@RequestBody FilterRequest filterRequest){
        return reservationService.filter(filterRequest);
    }


}
