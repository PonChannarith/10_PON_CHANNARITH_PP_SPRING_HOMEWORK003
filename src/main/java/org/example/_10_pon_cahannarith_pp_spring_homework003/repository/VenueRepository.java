package org.example._10_pon_cahannarith_pp_spring_homework003.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Venue;


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
    List<Venue> getAllVenue(int offset,int size);

    List<Venue> getAllVenue();

//    List<Venue> getAllVenue();


}
