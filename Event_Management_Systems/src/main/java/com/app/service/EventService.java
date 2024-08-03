package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.EventDTO;
import com.app.entity.Event;
import com.app.repository.EventRepository;
import com.app.repository.OrganizerRepository;
import com.app.repository.VenueRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private OrganizerRepository organizerRepository;

    @Autowired
    private VenueRepository venueRepository;

    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setEventName(eventDTO.getEventName());
        event.setEventDate(eventDTO.getEventDate());
        event.setDescription(eventDTO.getDescription());
        event.setOrganizer(organizerRepository.findById(eventDTO.getOrganizerId()).orElse(null));
        event.setVenue(venueRepository.findById(eventDTO.getVenueId()).orElse(null));
        Event savedEvent = eventRepository.save(event);
        return convertToDTO(savedEvent);
    }

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Optional<EventDTO> getEventById(Long id) {
        return eventRepository.findById(id).map(this::convertToDTO);
    }

    public EventDTO updateEvent(Long id, EventDTO eventDTO) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.setEventName(eventDTO.getEventName());
            event.setEventDate(eventDTO.getEventDate());
            event.setDescription(eventDTO.getDescription());
            event.setOrganizer(organizerRepository.findById(eventDTO.getOrganizerId()).orElse(null));
            event.setVenue(venueRepository.findById(eventDTO.getVenueId()).orElse(null));
            Event updatedEvent = eventRepository.save(event);
            return convertToDTO(updatedEvent);
        }
        return null;
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<EventDTO> getEventsByVenue(Long venueId) {
        return eventRepository.findByVenueId(venueId).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<EventDTO> getEventsByOrganizer(Long organizerId) {
        return eventRepository.findByOrganizerId(organizerId).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private EventDTO convertToDTO(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setEventName(event.getEventName());
        eventDTO.setEventDate(event.getEventDate());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setOrganizerId(event.getOrganizer().getId());
        eventDTO.setVenueId(event.getVenue().getId());
        return eventDTO;
    }
    
}
