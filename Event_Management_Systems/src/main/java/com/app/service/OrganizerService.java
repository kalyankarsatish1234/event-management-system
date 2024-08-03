package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.OrganizerDTO;
import com.app.entity.Organizer;
import com.app.repository.OrganizerRepository;

@Service
public class OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    public Organizer createOrganizer(OrganizerDTO organizerDTO) {
        Organizer organizer = new Organizer();
        organizer.setName(organizerDTO.getName());
        organizer.setContactInfo(organizerDTO.getContactInfo());
        return organizerRepository.save(organizer);
    }

    public Optional<Organizer> getOrganizerById(Long id) {
        return organizerRepository.findById(id);
    }

    public Organizer updateOrganizer(Long id, OrganizerDTO organizerDTO) {
        Optional<Organizer> optionalOrganizer = organizerRepository.findById(id);
        if (optionalOrganizer.isPresent()) {
            Organizer organizer = optionalOrganizer.get();
            organizer.setName(organizerDTO.getName());
            organizer.setContactInfo(organizerDTO.getContactInfo());
            return organizerRepository.save(organizer);
        }
        return null;
    }

    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }
}
