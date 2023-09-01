-- Owner entity dump
INSERT INTO owner_info (owner_id, address, email, licence_number, owner_name, phone_number) VALUES
--    (, '', '', '', '', ''),
    (1, 'Delhi', 'email1', 'DL5S', 'John', 'DL5C'),
    (2, 'Mumbai', 'email2', 'MH2A', 'Doe', 'MH7D');

-- Vehicle entity dump
INSERT INTO vehicle_info (vehicle_id, bike_model, ins_exp_date, purchase_date, registration_number, owner_id) VALUES
--    (, '', '', '', '', ''),
    (1, 'Pulsur', '2024-12-31', '2002-10-10', 'DL55', 1),
    (2, 'Platina', '2024-11-30', '2003-09-09', 'MH9A', 2),
    (3, 'Splendor', '2025-10-12', '2004-08-08', 'DL2B', 1),
    (4, 'Avenger', '2025-09-06', '2005-07-07', 'MH7C', 2);

-- GpsCoordinates entity dump
INSERT INTO gps_data_info (gps_data_id, latitude, longitude, location_date, vehicle_id) VALUES
--    (, , , '', ),
    (1, -63.76493, 59.62073, '2023-09-01', 1),
    (2, -26.71053, 45.76746, '2023-09-05', 1),
    (3, 25.95059, -8.16864, '2023-09-03', 1),
    (4, -24.51162, -16.18115, '2023-08-31', 2),
    (5, -55.74660, 164.82552, '2023-08-25', 2),
    (6, 1.03195, 159.59975, '2023-08-29', 2),
    (7, 5.97309, -129.47990, '2023-07-31', 3),
    (8, 42.06001, -105.02277, '2023-07-25', 3),
    (9, 24.64869, -76.19306, '2023-07-29', 3),
    (10, 21.10570, 131.50775, '2023-06-30', 4),
    (11, -18.92668, -106.33464, '2023-06-24', 4),
    (12, 45.10248, 165.59049, '2023-06-28', 4);

SELECT * from owner_info;