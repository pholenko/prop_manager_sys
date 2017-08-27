package com.example.service;

import com.example.domain.FilterRequest;
import com.example.domain.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Pavlo Holenko on 27.08.17.
 */
public interface ReservationService {

    Page<Reservation> filter(FilterRequest filterRequest);

}
