package org.example._10_pon_cahannarith_pp_spring_homework003.service;


import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Venue;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.request.VenueRequest;

import java.util.List;



public interface VenueService {
    List<Venue> getAllVenue();


    List<Venue> getAllVenues(int page, int size);

    Venue saveVenue(VenueRequest request);

    Venue getAllVenueById(Long venueId);

    void deleteVenue(Long venueId);

    Venue updateVenue(Integer id,VenueRequest request);


}
