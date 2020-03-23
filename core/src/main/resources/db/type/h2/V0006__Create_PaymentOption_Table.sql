CREATE TABLE PaymentOption (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  type                VARCHAR(10 CHAR) NOT NULL,
  reference           VARCHAR(512 CHAR) NOT NULL,
  user_id             BIGINT NOT NULL,
  CONSTRAINT PK_PaymentOption PRIMARY KEY (ID),
  CONSTRAINT FK_PaymentOption_User FOREIGN KEY (user_id) REFERENCES user(ID)
);
