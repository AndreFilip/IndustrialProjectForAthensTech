DROP TABLE IF EXISTS codehub_user;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS techstack;
DROP TABLE IF EXISTS user_files;
DROP TABLE IF EXISTS user_status;


CREATE TABLE  role(
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(128) UNIQUE  NOT NULL ,
  PRIMARY KEY (id)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS country(
  id BIGINT UNSIGNED NOT NULL ,
  isoCode TEXT NOT NULL,
  nameCapital TEXT NOT NULL,
  nameView TEXT NOT NULL,
  isoCode3 TEXT,
  numCode TEXT,
  phoneCode TEXT NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table code.hub1.user_files
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS user_profile(
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  userId BIGINT NULL,
  cvPath TEXT NULL,
  avatarPath TEXT NULL ,
  linkedinPath TEXT NULL,
  stackoverflowPath TEXT NULL,
  githubPath TEXT NULL,
  PRIMARY KEY (id))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table code.hub1.user_status
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS user_status (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  userId BIGINT NULL,
  stage VARCHAR(128) NULL,
  timestamp TIMESTAMP NULL,
  changedBy VARCHAR(128) NULL,
  PRIMARY KEY (id))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table code.hub1.techstack
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS techstack (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  stack VARCHAR(256) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX stack_UNIQUE (stack ASC))
  ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table code.hub1.code.hub_user
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS codehub_user (
  id           BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  email        VARCHAR(128)    NOT NULL,
  username     VARCHAR(128)    NOT NULL,
  password     VARCHAR(256)    NOT NULL,
  firstName    VARCHAR(128)    NOT NULL,
  lastName     VARCHAR(128)    NOT NULL,
  roleId       BIGINT UNSIGNED NOT NULL,
  countryId    BIGINT UNSIGNED NOT NULL,
  dateCreated  DATE            NOT NULL,
  isActive     BOOLEAN         NOT NULL,
  latestLogin  DATETIME        NULL,
  phone        VARCHAR(20),
  userProfileId  BIGINT UNSIGNED,
  userStatusId BIGINT UNSIGNED,
  techstackId  BIGINT UNSIGNED,
  internalComments        VARCHAR(128),
  PRIMARY KEY (id),
  FOREIGN KEY (roleId) REFERENCES role (id),
  FOREIGN KEY (countryId) REFERENCES country (id),
  FOREIGN KEY (userProfileId) REFERENCES user_profile (id),
  FOREIGN KEY (userStatusId) REFERENCES user_status (id),
  FOREIGN KEY (techstackId) REFERENCES techstack (id),

  UNIQUE INDEX email_UNIQUE (email ASC),
  UNIQUE INDEX userName_UNIQUE (userName ASC),
  INDEX role_id_idx (roleId ASC),
  INDEX country_id_idx (countryId ASC),
  INDEX userProfile_id_idx (userProfileId ASC),
  INDEX user_status_id_idx (userStatusId ASC),
  INDEX techstack_id_idx (techstackId ASC),
    CONSTRAINT role_id
    FOREIGN KEY (roleId)
    REFERENCES role (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
    CONSTRAINT country_id
    FOREIGN KEY (countryId)
    REFERENCES country (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
    CONSTRAINT user_files_id
    FOREIGN KEY (userProfileId)
    REFERENCES user_profile (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
    CONSTRAINT user_status_id
    FOREIGN KEY (userStatusId)
    REFERENCES user_status (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
    CONSTRAINT techstack_id
    FOREIGN KEY (techstackId)
    REFERENCES techstack (id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION)
  ENGINE = InnoDB;


# -- -----------------------------------------------------
# -- Table code.hub1.job_posts
# -- -----------------------------------------------------
# CREATE TABLE IF NOT EXISTS job_posts (
#   id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
#   jobTitle VARCHAR(128) NOT NULL,
#   location VARCHAR(128) NULL,
#   dateCreated DATE NOT NULL,
#   description MEDIUMTEXT NULL,
#   PRIMARY KEY (id))
#   ENGINE = InnoDB;
#
#
# -- -----------------------------------------------------
# -- Table code.hub1.job_posts_has_code.hub_user
# -- -----------------------------------------------------
# CREATE TABLE IF NOT EXISTS job_posts_has_code.hub_user (
#   job_posts_id BIGINT UNSIGNED NOT NULL,
#   code.hub_user_id BIGINT UNSIGNED NOT NULL,
#   PRIMARY KEY (job_posts_id, code.hub_user_id),
#   INDEX fk_job_posts_has_code.hub_user_code.hub_user1_idx (code.hub_user_id ASC),
#   INDEX fk_job_posts_has_code.hub_user_job_posts1_idx (job_posts_id ASC),
#   CONSTRAINT fk_job_posts_has_code.hub_user_job_posts1
#   FOREIGN KEY (job_posts_id)
#   REFERENCES job_posts (id)
#     ON DELETE NO ACTION
#     ON UPDATE NO ACTION,
#   CONSTRAINT fk_job_posts_has_code.hub_user_code.hub_user1
#   FOREIGN KEY (code.hub_user_id)
#   REFERENCES codehub_user (id)
#     ON DELETE NO ACTION
#     ON UPDATE NO ACTION)
#   ENGINE = InnoDB;




# CREATE TABLE codehub_user(
#   id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
#   email NVARCHAR(128) NOT NULL,
#   username NVARCHAR(128) NOT NULL,
#   password NVARCHAR(256) NOT NULL,
#   role_id BIGINT UNSIGNED NOT NULL,
#   first_name NVARCHAR(128),
#   last_name NVARCHAR(128),
#   PRIMARY KEY (id),
#   FOREIGN KEY (role_id) REFERENCES role(id),
#   UNIQUE (email)
# );
# CREATE INDEX codehub_user_role_id_fk ON codehub_user(role_id ASC);


