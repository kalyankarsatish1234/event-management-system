Here's a streamlined README for your GitHub repository:

---

# Event Management System

## Overview

A Java Spring Boot application for managing events, venues, and organizers with a MySQL database.

## Features

- **Manage Events:** Create, retrieve, update, and delete events.
- **Manage Venues:** Create, retrieve, update, and delete venues.
- **Manage Organizers:** Create, retrieve, update, and delete organizers.
- **Relationships:** 
  - An event is organized by one organizer.
  - An event takes place at one venue.
  - One venue can host one event.
  - An organizer can organize multiple events.

## Technologies

- **Java Spring Boot**
- **MySQL**
- **Spring Data JPA**

## Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/kalyankarsatish1234/event-management-system.git
   cd event-management-system
   ```

2. **Configure Database**

   Create a MySQL database and update the `application.properties` file:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/event_management
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build and Run**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access the Application**

   The application will be available at `http://localhost:8080`.

## API Endpoints

### Organizers

- **Create Organizer:** `POST /api/organizers`
- **Get Organizer by ID:** `GET /api/organizers/{id}`
- **Update Organizer:** `PUT /api/organizers/{id}`
- **Delete Organizer:** `DELETE /api/organizers/{id}`

### Venues

- **Create Venue:** `POST /api/venues`
- **Get Venue by ID:** `GET /api/venues/{id}`
- **Update Venue:** `PUT /api/venues/{id}`
- **Delete Venue:** `DELETE /api/venues/{id}`

### Events

- **Create Event:** `POST /api/events`
- **Get Event by ID:** `GET /api/events/{id}`
- **Update Event:** `PUT /api/events/{id}`
- **Delete Event:** `DELETE /api/events/{id}`
- **Get Events by Organizer:** `GET /api/events/organizers/{organizerId}`

## Contributing

Feel free to open issues and submit pull requests.

## License

MIT License. See the [LICENSE](LICENSE) file for details.

---

This README provides a concise overview and setup guide for your project.
