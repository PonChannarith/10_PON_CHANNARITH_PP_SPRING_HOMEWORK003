package org.example._10_pon_cahannarith_pp_spring_homework003.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example._10_pon_cahannarith_pp_spring_homework003.model.entity.Venue;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest {

    private String eventName;
    private String eventDate;


    public Venue getVenueId() {
        return null;
    }
}
