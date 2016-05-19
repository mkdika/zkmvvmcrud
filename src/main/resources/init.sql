CREATE DATABASE "testing" WITH
  OWNER = "postgres"
  ENCODING = 'UTF8'
  TEMPLATE = "template1"
  TABLESPACE = pg_default;

CREATE SCHEMA testing AUTHORIZATION postgres;

CREATE TABLE testing.tb_person (
  id           varchar(32) NOT NULL,
  address      varchar(255),
  birthday     date NOT NULL,
  email        varchar(100) NOT NULL,
  firstname    varchar(255) NOT NULL,
  gender       integer NOT NULL,
  idnumber     varchar(50) NOT NULL,
  idtype       integer NOT NULL,
  lastname     varchar(255) NOT NULL,
  phonenumber  varchar(50) NOT NULL,
  /* Keys */
  CONSTRAINT tb_person_pkey
    PRIMARY KEY (id)
) WITH (
    OIDS = FALSE
  );

ALTER TABLE testing.tb_person
  OWNER TO postgres;

CREATE TABLE testing.tb_experience (
  id                  varchar(32) NOT NULL,
  achievement         varchar(255),
  bonus               numeric(19,2),
  companyaddress1     varchar(255),
  companyaddress2     varchar(255),
  companycity         varchar(255),
  companycountry      varchar(255),
  companyemail        varchar(50),
  companyname         varchar(255) NOT NULL,
  companyprovince     varchar(255),
  companysector       integer NOT NULL,
  companywebsite      varchar(100),
  companyzipcode      varchar(6),
  dtfrom              date NOT NULL,
  dtto                date NOT NULL,
  duty                varchar(255),
  insurance           numeric(19,2),
  leavingreason       varchar(255) NOT NULL,
  mealallowance       numeric(19,2),
  note                varchar(255),
  otherallowance      numeric(19,2),
  "position"          varchar(255) NOT NULL,
  salary              numeric(19,2),
  transportallowance  numeric(19,2),
  person              varchar(32),
  /* Keys */
  CONSTRAINT tb_experience_pkey
    PRIMARY KEY (id),
  /* Foreign keys */
  CONSTRAINT fk_ht95emh1swqtjo6twestf26s0
    FOREIGN KEY (person)
    REFERENCES testing.tb_person(id)
) WITH (
    OIDS = FALSE
  );

ALTER TABLE testing.tb_experience
  OWNER TO postgres;