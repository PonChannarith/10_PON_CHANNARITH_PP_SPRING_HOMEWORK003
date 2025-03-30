package org.example._10_pon_cahannarith_pp_spring_homework003.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Event;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Venue;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.request.EventRequest;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.request.VenueRequest;
import org.example._10_pon_cahannarith_pp_spring_homework003.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @Operation(summary = "Get all events with pagination")
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllEvents(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        int offset = (page - 1) * size;
        List<Event> events = eventService.getAllEvent(offset, size);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "All events have been successfully fetched.");
        response.put("payload", events);
        response.put("status", "OK");
        response.put("time", LocalDateTime.now().toString());

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Add a new event")
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> saveEvent(@RequestBody EventRequest request) {
        Event savedEvent = eventService.saveEvent(request);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "The event has been successfully created.");
        response.put("payload", savedEvent);
        response.put("status", "CREATED");
        response.put("time", LocalDateTime.now().toString());

        return ResponseEntity.status(201).body(response);
    }

    @Operation(summary = "Update an existing event")
    @PutMapping("/update/{eventId}")
    public ResponseEntity<Map<String, Object>> updateEvent(@PathVariable Long eventId, @RequestBody EventRequest request) {
        Event updatedEvent = eventService.updateEvent(eventId, request);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "The event has been successfully updated.");
        response.put("payload", updatedEvent);
        response.put("status", "OK");
        response.put("time", LocalDateTime.now().toString());

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete an event")
    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<Map<String, Object>> deleteEvent(@PathVariable Long eventId) {
        boolean deleted = eventService.deleteEvent(eventId);

        Map<String, Object> response = new LinkedHashMap<>();
        if (deleted) {
            response.put("message", "The event has been successfully deleted.");
            response.put("status", "OK");
        } else {
            response.put("message", "Event not found.");
            response.put("status", "NOT_FOUND");
        }
        response.put("time", LocalDateTime.now().toString());

        return ResponseEntity.ok(response);
    }
}
