
--LandLord

INSERT INTO PropertyRental.Landlord(l_taxcode, l_name, scannedID, Status, password) VALUES
('LVNSDS97D87Z171N', 'Jone Doe','ID file', 'verified', 'Pass12345'),
('JKLDQ907221ZXZ3O','Harry now','ID file', 'verified','Pass12345'),
('SVNSDS97D87Z171E', 'Jone bob','ID file', 'new', 'Pass12345'),
('NKLDQ907221ZXZ3R', 'Harry may','ID file', 'new', 'Pass12345'),
('PVNSDS97D87Z171E', 'Jone Doe','ID file', 'pending', 'Pass12345'),
('YKLDQ907221ZXZ3R', 'Harry','ID file', 'new', 'Pass12345')
    ON CONFLICT DO NOTHING;
--Student

INSERT INTO PropertyRental.Student(s_taxcode, s_name, age, country, foreign_lang, scannedID, Status, password) VALUES
('QWRHY97D87Z171E','Rendly Doe',21,'England','English','ID file', 'new','Pass12345' ),
('ASFRG97D87Z171E','Sameh Doe',22,'Egypt','French','ID file', 'verified', 'Pass12345' ),
('ISFDJ975435271G','Jess', 23,'Albania','Italian','ID file', 'pending','Pass12345' ),
('PHCDD903452J45E', 'PhACID', 80, 'Xanadu', 'Other','ID file', 'new','Pass12345'),
('BWRHY97D87Z171E','Rendly Doe',21,'England','English','ID file', 'new','Pass12345' ),
('MSFRG97D87Z171E','Sameh Doe',22,'Egypt','French','ID file', 'verified', 'Pass12345' )
    ON CONFLICT DO NOTHING;

--Appartment

INSERT INTO PropertyRental.Appartment(address, ownership_proof, n_room, n_bath, extra_info, energy_class,  s_kitchen, p_code, totSquareMeter, Status ) VALUES
('Via Venezia 8', 'file', 4, 2, 'Availability of nearby facilities', 'B', 'mine', '15111', '180', 'new'),
('Via 8 Febbraio', 'file', 3, 2, 'Free WI-FI', 'D', 'fully equipped', '15999', '200', 'verified'),
('Via F.Chopin', 'file', 5, 2, '24/7 Assistance Support', 'G', 'yes', '15888', '250', 'new'),
('via del Portello 4','file', 4, 2,'Payment on agency', 'C', 'no', '15222', '120', 'new'),
('Via Venezia 80', 'file', 4, 2, 'Availability of nearby facilities', 'B', 'mine', '15111', '180', 'new'),
('Via Roma 20', 'file', 3, 2, 'Free WI-FI', 'D', 'fully equipped', '15999', '200', 'verified'),
('Via Roma 1', 'file', 5, 2, '24/7 Assistance Support', 'G', 'yes', '15888', '250', 'new'),
('via padova 4','file', 4, 2,'Payment on agency', 'C', 'no', '15222', '120', 'pending')
    ON CONFLICT DO NOTHING;

--Administrator

INSERT INTO PropertyRental.Administrator(username, password) VALUES
('admin1', 'Pass12345' ),
('admin2', 'Pass12345' ),
('admin3', 'Pass12345' )
    ON CONFLICT DO NOTHING;

--Room

INSERT INTO PropertyRental.Room(app_address ,capacity_persons,Other) VALUES
('Via Venezia 8', 1, 'east_orientied'),
('Via Venezia 8', 2, 'east_orientied'),
('Via 8 Febbraio', 3, 'west_orientied'),
('Via Roma 1', 2, 'private_house').
('Via Roma 20', 1, 'private Bathroom')
ON CONFLICT DO NOTHING;

-- ## Second time Insert all others Entity with dependency ##
--Relation

INSERT INTO PropertyRental.Relation(ssource, target, stype) VALUES
('QWRHY97D87Z171E','ASFRG97D87Z171E','friends'),
('ISFDJ975435271G', 'ASFRG97D87Z171E','roomates')
    ON CONFLICT DO NOTHING;

--Insert App

INSERT INTO PropertyRental.Insert_App(landlord, app_address) VALUES
('LVNSDS97D87Z171E','Via Venezia 8'),
('JKLDQ907221ZXZ3R','Via 8 Febbraio'),
('JKLDQ907221ZXZ3R','Via F.Chopin'),
('LVNSDS97D87Z171E','via del Portello 4'),
('JKLDQ907221ZXZ3R','Via Venezia 80'),
('JKLDQ907221ZXZ3R','Via Roma 20'),
('LVNSDS97D87Z171E','Roma 1'),
('JKLDQ907221ZXZ3R','via padova 4')
    ON CONFLICT DO NOTHING;

--Questionnaire

INSERT INTO PropertyRental.Questionnaire(taxcode,languages, sociable_level, cooking_level,noise_level, smoking, instrument_play, general_info ) VALUES
('QWRHY97D87Z171E', 'English', 4, 5, 1, 'Yes', 'No', 'good in physics'),
('ASFRG97D87Z171E',  'Italian', 3, 4, 3, 'No', 'Yes', 'good in math')
    ON CONFLICT DO NOTHING;

--Rent_Request

INSERT INTO PropertyRental.Rent_Request(student, roomaddress, roomBadge, rtime, status) VALUES
('ASFRG97D87Z171E', 'Via Venezia 8', 1,'2020-12-01 10:10:10', 'approved'),
('YKLDQ907221ZXZ3R', 'Via Venezia 8', 1,'2020-08-01 07:10:10', 'confirmed'),
('BWRHY97D87Z171E', 'Via Roma 1', 1,'2020-06-01 10:15:25', 'approved'),
('PHCDD903452J45E', 'Via Roma 20', 1,'2020-10-01 10:10:10', 'confirmed'),
('ISFDJ975435271G', 'Via F.Chopin', 4,'2020-12-05 08:12:55', 'rejected')
    ON CONFLICT DO NOTHING;

--Verify

INSERT INTO PropertyRental.Verify (appartmentID, adminusername) VALUES
('Via Venezia 8', 1),
('Via F.Chopin', 3)
    ON CONFLICT DO NOTHING;

--Contract

INSERT INTO PropertyRental.Contract( Request_nr, duration_months, Ctime)  VALUES
(1, 6, '2020-11-01 14:10:10')
    (3, 12, '2020-11-01 14:10:10')
ON CONFLICT DO NOTHING;