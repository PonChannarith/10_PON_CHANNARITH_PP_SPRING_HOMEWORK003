package org.example._10_pon_cahannarith_pp_spring_homework003.service;


import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Venue;

import java.util.List;



public interface VenueService {
    List<Venue> getAllVenue();


    List<Venue> getAllVenues(int page, int size);
}
