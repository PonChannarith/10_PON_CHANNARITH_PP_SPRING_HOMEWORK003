package org.example._10_pon_cahannarith_pp_spring_homework003.service.Impl;

import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Event;
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
    public List<Event> getAllEvent() {
        return eventRepository.getAllEvent();
    }

    @Override
    public List<Event> getAllEvent(int page, Integer size) {
        int offset = (page - 1) * size;
        return eventRepository.getAllEvent(offset,size);
    }




}
