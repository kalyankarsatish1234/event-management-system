package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.VenueDTO;
import com.app.entity.Venue;
import com.app.repository.VenueRepository;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    public VenueDTO createVenue(VenueDTO venueDTO) {
        Venue venue = new Venue();
        venue.setName(venueDTO.getName());
        venue.setLocation(venueDTO.getLocation());
        venue.setCapacity(venueDTO.getCapacity());
        Venue savedVenue = venueRepository.save(venue);
        return convertToDTO(savedVenue);
    }

    public List<VenueDTO> getAllVenues() {
        return venueRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Optional<VenueDTO> getVenueById(Long id) {
        return venueRepository.findById(id).map(this::convertToDTO);
    }

    public VenueDTO updateVenue(Long id, VenueDTO venueDTO) {
        Optional<Venue> optionalVenue = venueRepository.findById(id);
        if (optionalVenue.isPresent()) {
            Venue venue = optionalVenue.get();
            venue.setName(venueDTO.getName());
            venue.setLocation(venueDTO.getLocation());
            venue.setCapacity(venueDTO.getCapacity());
            Venue updatedVenue = venueRepository.save(venue);
            return convertToDTO(updatedVenue);
        }
        return null;
    }

    public void deleteVenue(Long id) {
        venueRepository.deleteById(id);
    }

    private VenueDTO convertToDTO(Venue venue) {
        VenueDTO venueDTO = new VenueDTO();
        venueDTO.setId(venue.getId());
        venueDTO.setName(venue.getName());
        venueDTO.setLocation(venue.getLocation());
        venueDTO.setCapacity(venue.getCapacity());
        return venueDTO;
    }
}
