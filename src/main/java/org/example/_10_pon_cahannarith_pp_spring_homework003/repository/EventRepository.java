package org.example._10_pon_cahannarith_pp_spring_homework003.repository;

import org.apache.ibatis.annotations.*;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Event;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Venue;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.request.EventRequest;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.request.VenueRequest;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EventRepository {

    @Results(id = "eventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venue", column = "venue_id",
                    one = @One(select = "org.example._10_pon_cahannarith_pp_spring_homework003.repository.VenueRepository.getVenueById"))
    })
    @Select("SELECT * FROM events")
    List<Event> getAllEvent(int offset, int size);

    @Insert("INSERT INTO events(event_name, event_date, venue_id) VALUES(#{eventName}, #{eventDate}, #{venueId})")
    void save(Event event);

    @Update("UPDATE events SET event_name = #{eventName}, event_date = #{eventDate}, venue_id = #{venueId} WHERE event_id = #{eventId}")
    void update(Event event);

    @Delete("DELETE FROM events WHERE event_id = #{eventId}")
    void delete(Event event);

    @Select("SELECT * FROM events WHERE event_id = #{eventId}")
    Optional<Event> findById(Long eventId);
}

