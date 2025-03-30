package org.example._10_pon_cahannarith_pp_spring_homework003.service;

import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Attendee;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.request.AttendeeRequest;

import java.util.List;

public interface AttendeeService {
    List<Attendee> getAllAttendees(int page, Integer size);
    Attendee getAttendeeById(Integer attendeeId);
    Attendee saveAttendee(AttendeeRequest request);
    Attendee updateAttendee(Integer attendeeId, AttendeeRequest request);
    void deleteAttendee(Integer attendeeId);
}
