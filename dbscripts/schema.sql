DROP TABLE IF EXISTS codehub_user;
DROP TABLE IF EXISTS role;

CREATE TABLE  role(
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(128),
  PRIMARY KEY (id)
);

CREATE TABLE codehub_user(
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  email NVARCHAR(128) NOT NULL,
  username NVARCHAR(128) NOT NULL,
  password NVARCHAR(256) NOT NULL,
  role_id BIGINT UNSIGNED NOT NULL,
  first_name NVARCHAR(128),
  last_name NVARCHAR(128),
  PRIMARY KEY (id),
  FOREIGN KEY (role_id) REFERENCES role(id),
  UNIQUE (email)
);
CREATE INDEX codehub_user_role_id_fk ON codehub_user(role_id ASC);


INSERT INTO role (name) VALUES ('admin');
INSERT INTO role (name) VALUES ('user');
