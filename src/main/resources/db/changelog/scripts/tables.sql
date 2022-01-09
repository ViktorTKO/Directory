CREATE SEQUENCE if not exists directory_id_seq;
CREATE TABLE IF NOT EXISTS  directory (
  id int  PRIMARY KEY DEFAULT nextval('directory_id_seq'),
  name varchar(45) DEFAULT NULL,
  shortname varchar(45) DEFAULT NULL
);

