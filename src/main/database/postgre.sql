-- Create User
CREATE USER PropertyRental;
-- Database Creation
CREATE DATABASE PropertyRental OWNER PropertyRental ENCODING = 'UTF8';
-- Add GRANT
GRANT CREATE ON DATABASE PropertyRental TO PropertyRental;
-- Schema Creation
CREATE SCHEMA PropertyRental;

-- Usefull to delete & update tables
--DROP TABLE Landlord, Appartment, Insert_App, Room, Student, Relation, Administrator, Verify, Rent_Request, Contract, Questionnaire CASCADE;

-- Create new domains
CREATE DOMAIN PropertyRental.passw AS VARCHAR(32)
    CONSTRAINT validpassw CHECK (((VALUE)::text ~* '[A-Za-z0-9._%!]{8,}'::text));

-- Create new data types
CREATE TYPE PropertyRental.RelationType AS ENUM ( 
			'friends' ,
			'roomates'
);

CREATE TYPE PropertyRental.KnownLanguages AS ENUM (
			'English',
			'French',
			'Italian',
			'Other'
);

CREATE TYPE PropertyRental.RequestStatus AS ENUM (
    'new',
    'confirmed',
    'pending',
    'approved',
    'rejected'

    );

CREATE TYPE PropertyRental.Status AS ENUM (
    'new',
    'verified',
    'pending'

    );

CREATE TYPE propertyrental.energyClass AS ENUM (
    'A4',
    'A3',
    'A2',
    'A1',
    'B',
    'C',
    'D',
    'E',
    'F',
    'G'
    );
ALTER TYPE propertyrental.energyClass
    OWNER TO propertyrental;

-- Table Creation (create tables in the correct order,
-- i.e. use FKeys only referring to already created tables)
CREATE TABLE IF NOT EXISTS PropertyRental.Landlord (
        l_taxcode VARCHAR(32)  NOT NULL,
        l_name VARCHAR(32) NOT NULL,
        university_dep VARCHAR (32),
        scannedID BYTEA,
        Status PropertyRental.Status default 'new',
        password PropertyRental.passw,
        CONSTRAINT landlord_pkey PRIMARY KEY (l_taxcode)
);

CREATE TABLE IF NOT EXISTS PropertyRental.Appartment (
        address TEXT PRIMARY KEY,
        ownership_proof BYTEA,
        n_room INTEGER,
        n_bath INTEGER,
        s_kitchen Text,
        extra_info Text,
        p_code VARCHAR(5),
        energy_class PropertyRental.energyClass,
        totSquareMeter double precision,
        Status PropertyRental.Status default 'new',
        coordinate point
);

CREATE TABLE IF NOT EXISTS PropertyRental.Insert_App (
        landlord VARCHAR(32),
        app_address text,
        CONSTRAINT landlord FOREIGN KEY (landlord)
            REFERENCES PropertyRental.LandLord(l_taxcode)
                MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE ,

        CONSTRAINT app_address FOREIGN KEY (app_address)
            REFERENCES PropertyRental.Appartment(address)
                MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE,
        PRIMARY KEY (landlord, app_address)
);

CREATE TABLE IF NOT EXISTS PropertyRental.Room (
        app_address text,
        Space_Badge SMALLSERIAL,
        capacity_persons INTEGER NOT NULL,
        Other TEXT,
        FOREIGN KEY (app_address) REFERENCES PropertyRental.Appartment(address)
            MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE,
        PRIMARY KEY (app_address,Space_Badge)
);

CREATE TABLE IF NOT EXISTS PropertyRental.Student (
        s_taxcode VARCHAR(32) PRIMARY KEY,
        s_name VARCHAR(32) NOT NULL,
        age INTEGER,
        country VARCHAR(32),
        foreign_lang PropertyRental.KNOWNLANGUAGES,
        Status PropertyRental.Status default 'new',
        password PropertyRental.passw,
        scannedID BYTEA
);

CREATE TABLE IF NOT EXISTS PropertyRental.Relation (
        ssource VARCHAR(32),
        target VARCHAR(32),
        FOREIGN KEY (ssource) REFERENCES PropertyRental.Student(s_taxcode),
        FOREIGN KEY (target) REFERENCES PropertyRental.Student(s_taxcode),
        Stype PropertyRental.RELATIONTYPE DEFAULT null,
        PRIMARY KEY (ssource, target)
);

CREATE TABLE IF NOT EXISTS PropertyRental.Questionnaire (
        taxcode VARCHAR(32),
        FOREIGN KEY (taxcode) REFERENCES PropertyRental.Student(s_taxcode),
        languages PropertyRental.KNOWNLANGUAGES,
        sociable_level INTEGER,
        cooking_level INTEGER,
        noise_level INTEGER,
        smoking BOOLEAN,
        instrument_play BOOLEAN,
        general_info text,
        PRIMARY KEY (taxcode)
);

CREATE TABLE IF NOT EXISTS PropertyRental.Administrator (
        serialnum BIGSERIAL PRIMARY KEY,
        username CHAR(10) NOT NULL,
        password PropertyRental.passw
);

CREATE TABLE IF NOT EXISTS PropertyRental.Verify (
        appartmentID text,
        adminusername integer,
        FOREIGN KEY (appartmentID) REFERENCES PropertyRental.Appartment(address)
            MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE,
        FOREIGN KEY (adminusername) REFERENCES PropertyRental.Administrator(serialnum)
            MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE,
        PRIMARY KEY (appartmentID,adminusername)
);

CREATE TABLE IF NOT EXISTS PropertyRental.Rent_Request(
        Request_nr BIGSERIAL PRIMARY KEY,
        student VARCHAR(32),
        roomaddress text,
        roomBadge integer,
        FOREIGN KEY (student) REFERENCES PropertyRental.Student(s_taxcode)
        MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE,
        FOREIGN KEY (roomaddress, roomBadge) REFERENCES PropertyRental.room(app_address, space_badge)
        MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE,
        Rtime TIMESTAMP,
        status PropertyRental.REQUESTSTATUS default 'new',
        CONSTRAINT rent_request_unique UNIQUE (student, roomaddress, roombadge)
);

CREATE TABLE IF NOT EXISTS PropertyRental.Contract (
        Contract_nr BIGSERIAL PRIMARY KEY,
        Request_nr integer,
        FOREIGN KEY (Request_nr) REFERENCES PropertyRental.Rent_Request(Request_nr),
        duration_months INTEGER,
        Ctime TIMESTAMP
);