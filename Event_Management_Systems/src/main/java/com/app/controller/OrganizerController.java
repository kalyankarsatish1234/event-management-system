package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.OrganizerDTO;
import com.app.entity.Organizer;
import com.app.service.OrganizerService;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;

    @PostMapping
    public Organizer createOrganizer(@RequestBody OrganizerDTO organizerDTO) {
        return organizerService.createOrganizer(organizerDTO);
    }

    @GetMapping("/{id}")
    public Optional<Organizer> getOrganizerById(@PathVariable Long id) {
        return organizerService.getOrganizerById(id);
    }

    @PutMapping("/{id}")
    public Organizer updateOrganizer(@PathVariable Long id, @RequestBody OrganizerDTO organizerDTO) {
        return organizerService.updateOrganizer(id, organizerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganizer(@PathVariable Long id) {
        organizerService.deleteOrganizer(id);
    }
}
