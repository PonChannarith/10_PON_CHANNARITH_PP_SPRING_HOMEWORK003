package org.example._10_pon_cahannarith_pp_spring_homework003.service.Impl;

import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Venue;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.request.VenueRequest;
import org.example._10_pon_cahannarith_pp_spring_homework003.repository.VenueRepository;
import org.example._10_pon_cahannarith_pp_spring_homework003.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {
    private final VenueRepository venueRepository;

    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<Venue> getAllVenue() {
        return venueRepository.getAllVenue();
    }

    @Override
    public List<Venue> getAllVenues(int page, int size) {
        int offset = (page - 1) * size;
        return venueRepository.getAllVenue(offset, size);
    }

    @Override
    public Venue saveVenue(VenueRequest request) {
        return venueRepository.saveVenue(request);
    }

    @Override
    public Venue getAllVenueById(Long venueId) {
        return venueRepository.getAllVenueById(venueId);
    }

    @Override
    public void deleteVenue(Long venueId) {
        venueRepository.removeVenueById(venueId);
    }

    @Override
    public Venue updateVenue(Integer id,VenueRequest request) {
        return venueRepository.updateVenue(id,request);
    }
}
