CREATE TABLE BringDemand (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  item                VARCHAR(2000 CHAR) NOT NULL,
  dropHint            VARCHAR(2000 CHAR),
  deadline            TIMESTAMP,
  estimatedAmount     INTEGER,
  currency            VARCHAR(3 CHAR),
  acceptedByUser      BIGINT,
  user_id             BIGINT NOT NULL,
  CONSTRAINT PK_BringDemand PRIMARY KEY (ID),
  CONSTRAINT FK_BringDemand_acceptedBy FOREIGN KEY (acceptedByUser) REFERENCES user(ID),
  CONSTRAINT FK_BringDemand_User FOREIGN KEY (user_id) REFERENCES user(ID)
);
