package org.example._10_pon_cahannarith_pp_spring_homework003.repository;
import org.apache.ibatis.annotations.*;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Venue;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.request.VenueRequest;


import java.util.List;

@Mapper
public interface VenueRepository {
    @Results(id = "venueMapper",value = {
            @Result(property ="venueId",column = "venue_id"),
            @Result(property = "venueName",column = "venue_name"),
            @Result(property = "location",column = "location"),
    })

    @Select("""
        SELECT  * FROM venues;
        """)
    List<Venue> getAllVenue(int offset, int size);
    List<Venue> getAllVenue();
    @ResultMap("venueMapper")
    @Select("""
        INSERT INTO venues
        VALUES(default,#{req.venueName},#{req.location})
        RETURNING *;
    """)
    Venue saveVenue(@Param("req") VenueRequest request);
    @ResultMap("venueMapper")
    @Select("""
     SELECT * FROM venues WHERE venue_id = #{venueId};
    """)
    Venue getAllVenueById(@Param("venueId") Long venueId);

    @ResultMap("venueMapper")
    @Delete("""
        DELETE FROM venues  WHERE venue_id  = #{venueId}
        """)
    void removeVenueById(Long venueId);


    @Select("""
            UPDATE venues
            SET venue_name = #{req.venueName}, location = #{req.location}
            WHERE venue_id = #{venueId}
            RETURNING *;
        """)
    @ResultMap("venueMapper")
    Venue updateVenue(Integer venueId,@Param("req") VenueRequest request);


}
