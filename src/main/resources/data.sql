INSERT INTO venues(venue_name, location) VALUES
                                             ('Channarith', 'Takeo'),
                                             ('Channaroth', 'Kampot'),
                                             ('Channareak', 'Kampong Speu'),
                                             ('Chansreyleak', 'Kampong Cham'),
                                             ('Channara', 'Kampong Chhnang');



INSERT INTO events (event_name, event_date, venue_id) VALUES

                                            ('Startup Pitch Night', '2025-05-20', 3),
                                            ('AI Workshop', '2025-07-05', 4),
                                            ('Book Fair', '2025-09-12', 2);




INSERT INTO attendees (attendee_name, email) VALUES
                                                 ('John Doe', 'johndoe@example.com'),
                                                 ('Jane Smith', 'janesmith@example.com'),
                                                 ('Alice Johnson', 'alicej@example.com'),
                                                 ('Bob Brown', 'bobbrown@example.com'),
                                                 ('Charlie Davis', 'charlied@example.com');

INSERT INTO event_attendee (event_id, attendee_id)
VALUES

    (1, 102),
    (2, 103),
    (3, 104),
    (4, 105);