package org.example._10_pon_cahannarith_pp_spring_homework003.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private Integer eventId;
    private String eventName;
    private String eventDate;
    private Venue venue;

    public void setVenueId(Venue venueId) {
    }
}
