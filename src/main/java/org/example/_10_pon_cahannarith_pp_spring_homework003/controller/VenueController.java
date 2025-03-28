package org.example._10_pon_cahannarith_pp_spring_homework003.controller;

import io.swagger.v3.oas.annotations.Operation;

import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Venue;
import org.example._10_pon_cahannarith_pp_spring_homework003.service.VenueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/venue")
public class VenueController {
    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @Operation(summary = "get all venues")
    @GetMapping()
    public List<Venue> getAllVenue(){
        return venueService.getAllVenue();
    }





}
