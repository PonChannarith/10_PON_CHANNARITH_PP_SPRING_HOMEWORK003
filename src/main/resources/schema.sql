
-- Create venues table
CREATE TABLE venues (
                        venue_id SERIAL PRIMARY KEY,
                        venue_name VARCHAR(100) NOT NULL,
                        location VARCHAR(255) NOT NULL
);


-- -- Create events table
CREATE TABLE events (

                        event_id SERIAL PRIMARY KEY,
                        event_name VARCHAR(100) NOT NULL,
                        event_date DATE NOT NULL,
                        venue_id INT NOT NULL,
                        FOREIGN KEY (venue_id)
                        REFERENCES venues(venue_id) ON DELETE CASCADE ON UPDATE CASCADE
);


SELECT * FROM venues;
SELECT * FROM venues WHERE venue_id IN (1, 2, 3, 4, 5);


-- Create attendees table
CREATE TABLE attendees (
                           attendee_id SERIAL PRIMARY KEY,
                           attendee_name VARCHAR(100) NOT NULL,
                           email VARCHAR(100) NOT NULL UNIQUE
);
--
-- -- Create event_attendee table (junction table for many-to-many relationship)
CREATE TABLE event_attendee (
                                id SERIAL PRIMARY KEY,
                                event_id INT NOT NULL,
                                attendee_id INT NOT NULL,
                                FOREIGN KEY (event_id) REFERENCES events(event_id) ON DELETE CASCADE,
                                FOREIGN KEY (attendee_id) REFERENCES attendees(attendee_id) ON DELETE CASCADE
);
