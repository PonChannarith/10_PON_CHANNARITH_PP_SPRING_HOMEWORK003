package org.example._10_pon_cahannarith_pp_spring_homework003.repository;

import org.apache.ibatis.annotations.*;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Attendee;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.request.AttendeeRequest;

import java.util.List;

@Mapper
public interface AttendeeRepository {
    @Results(id = "attendeeMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name"),
            @Result(property = "email", column = "email")
    })
    @Select("SELECT * FROM attendees LIMIT #{size} OFFSET #{offset}")
    List<Attendee> getAllAttendees(int offset, int size);

    @ResultMap("attendeeMapper")
    @Select("SELECT * FROM attendees WHERE attendee_id = #{attendeeId}")
    Attendee getAttendeeById(@Param("attendeeId") Integer attendeeId);


    @Select("INSERT INTO attendees (attendee_name, email) VALUES" +
            " (#{req.attendeeName}, #{req.email}) RETURNING *")
    @ResultMap("attendeeMapper")
    Attendee saveAttendee(@Param("req") AttendeeRequest request);

    @Update("UPDATE attendees SET attendee_name = #{req.attendeeName}," +
            " email = #{req.email} WHERE attendee_id = #{attendeeId}")
    @ResultMap("attendeeMapper")
    void updateAttendee(@Param("attendeeId") Integer attendeeId, @Param("req") AttendeeRequest request);
    @ResultMap("attendeeMapper")
    @Delete("DELETE FROM attendees WHERE attendee_id = #{attendeeId}")
    void deleteAttendee(@Param("attendeeId") Integer attendeeId);
}
