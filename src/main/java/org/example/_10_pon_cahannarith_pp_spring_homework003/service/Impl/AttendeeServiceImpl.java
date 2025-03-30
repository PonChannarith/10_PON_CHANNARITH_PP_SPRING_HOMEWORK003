package org.example._10_pon_cahannarith_pp_spring_homework003.service.impl;

import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Attendee;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.request.AttendeeRequest;
import org.example._10_pon_cahannarith_pp_spring_homework003.repository.AttendeeRepository;
import org.example._10_pon_cahannarith_pp_spring_homework003.service.AttendeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeServiceImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;

    public AttendeeServiceImpl(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public List<Attendee> getAllAttendees(int page, Integer size) {
        int offset = (page - 1) * size;
        return attendeeRepository.getAllAttendees(offset, size);
    }

    @Override
    public Attendee getAttendeeById(Integer attendeeId) {
        return attendeeRepository.getAttendeeById(attendeeId);
    }

    @Override
    public Attendee saveAttendee(AttendeeRequest request) {
        return attendeeRepository.saveAttendee(request);
    }

    @Override
    public Attendee updateAttendee(Integer attendeeId, AttendeeRequest request) {
        attendeeRepository.updateAttendee(attendeeId, request);
        return getAttendeeById(attendeeId);
    }

    @Override
    public void deleteAttendee(Integer attendeeId) {
        attendeeRepository.deleteAttendee(attendeeId);
    }
}
