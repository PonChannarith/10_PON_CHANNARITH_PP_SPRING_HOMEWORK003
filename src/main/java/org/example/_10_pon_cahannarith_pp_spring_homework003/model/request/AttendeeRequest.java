package org.example._10_pon_cahannarith_pp_spring_homework003.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AttendeeRequest {
    private String attendeeName;
    private String email;
}

