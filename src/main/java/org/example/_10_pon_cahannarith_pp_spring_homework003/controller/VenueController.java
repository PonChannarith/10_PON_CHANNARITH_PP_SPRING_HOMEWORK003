package org.example._10_pon_cahannarith_pp_spring_homework003.controller;

import com.sun.source.doctree.SummaryTree;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.apache.ibatis.annotations.Delete;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Venue;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.request.VenueRequest;
import org.example._10_pon_cahannarith_pp_spring_homework003.service.VenueService;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/venues")
public class VenueController {
    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @Operation(summary = "Get all venues")
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllVenues(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        int offset = (page - 1) * size;

        // Fetch venues from the service with pagination
        List<Venue> venues = venueService.getAllVenues(offset, size);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "All venues have been successfully fetched.");
        response.put("payload", venues);
        response.put("status", "OK");
        response.put("time", LocalDateTime.now().toString());

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Add a new venue")
    @PostMapping("/create") // Added @PostMapping for saving venue
    public ResponseEntity<Map<String, Object>> saveVenue(@RequestBody VenueRequest request) {
        // Save venue using the service and get the response
        Venue savedVenue = venueService.saveVenue(request);

        // Construct response
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "The venue has been successfully added.");
        response.put("payload", savedVenue);
        response.put("status", "CREATED");
        response.put("time", LocalDateTime.now().toString());

        return ResponseEntity.status(201).body(response); // Return response with status CREATED (201)
    }

    @Operation(summary = "Get venue by Id")
    @GetMapping("/{venue-id}")
    public ResponseEntity<Map<String, Object>> getVenueById(@PathVariable("venue-id") Long venueId) {
        Venue venue = venueService.getAllVenueById(venueId);

        // Create a custom response map
        Map<String, Object> response = new LinkedHashMap<>();
        if (venue != null) {
            response.put("message", "The venue has been successfully found.");
            response.put("payload", venue);
            response.put("status", "OK");
            response.put("time", LocalDateTime.now().toString());

            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Venue not found.");
            response.put("status", "ERROR");
            response.put("time", LocalDateTime.now().toString());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @Operation(summary = "Delete venue by Id")
    @DeleteMapping("/{venue-id}")
    public ResponseEntity<Map<String, Object>> deleteVenue(@PathVariable("venue-id") Long venueId) {
        venueService.deleteVenue(venueId);

        // Prepare custom response
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "The venue has been successfully deleted.");
        response.put("status", "OK");
        response.put("time", LocalDateTime.now().toString());
        return ResponseEntity.ok(response);
    }


    @Operation(summary = "Update venue by Id")
    @PutMapping("/{venue-id}")
    public ResponseEntity<Map<String, Object>> updateVenue(@PathVariable("venue-id") Integer venueId, @RequestBody @Valid VenueRequest request) {
        // Set the venueId from PathVariable to the request
//        request.setVenueId(venueId);

        // Call the service to update the venue
        Venue updatedVenue = venueService.updateVenue(venueId,request);

        // Prepare custom response
        Map<String, Object> response = new LinkedHashMap<>();
        if (updatedVenue != null) {
            response.put("message", "The venue has been successfully updated.");
            response.put("payload", updatedVenue);
            response.put("status", "OK");
            response.put("time", LocalDateTime.now().toString());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Venue not found.");
            response.put("status", "ERROR");
            response.put("time", LocalDateTime.now().toString());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


}
