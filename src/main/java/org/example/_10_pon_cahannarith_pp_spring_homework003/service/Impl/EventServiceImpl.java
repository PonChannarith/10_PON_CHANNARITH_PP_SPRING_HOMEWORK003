package org.example._10_pon_cahannarith_pp_spring_homework003.service.Impl;

import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Event;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.request.EventRequest;
import org.example._10_pon_cahannarith_pp_spring_homework003.repository.EventRepository;
import org.example._10_pon_cahannarith_pp_spring_homework003.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvent(int offset, Integer size) {
        return eventRepository.getAllEvent(offset, size);
    }

    @Override
    public Event saveEvent(EventRequest request) {
        Event event = new Event();
        event.setEventName(request.getEventName());
        event.setEventDate(request.getEventDate());
        event.setVenue(request.getVenueId());
        // You may need additional processing depending on your requirements

        eventRepository.save(event); // assuming save method is implemented in your repository
        return event;
    }

    @Override
    public Event updateEvent(Long eventId, EventRequest request) {
        Event existingEvent = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        existingEvent.setEventName(request.getEventName());
        existingEvent.setEventDate(request.getEventDate());
        existingEvent.setVenueId(request.getVenueId());

        eventRepository.update(existingEvent); // assuming update method is implemented in your repository
        return existingEvent;
    }

    @Override
    public boolean deleteEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        eventRepository.delete(event); // assuming delete method is implemented in your repository
        return true;
    }
}
