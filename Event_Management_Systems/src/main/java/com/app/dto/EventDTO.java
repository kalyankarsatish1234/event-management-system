package com.app.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EventDTO {
    private Long id;
    private String eventName;
    private LocalDate eventDate;
    private String description;
    private Long organizerId;
    private Long venueId;
	
}
