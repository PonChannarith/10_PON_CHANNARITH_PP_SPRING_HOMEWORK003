package org.example._10_pon_cahannarith_pp_spring_homework003.service;

import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Event;
import org.example._10_pon_cahannarith_pp_spring_homework003.repository.EventRepository;

import java.util.List;

public interface EventService {


    List<Event> getAllEvent();

    List<Event> getAllEvent(int offset, Integer size);


}
