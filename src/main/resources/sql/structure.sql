﻿CREATE TABLE ATTRIBUTE (
  ID   INT PRIMARY KEY NOT NULL,
  NAME TEXT            NOT NULL
);

CREATE TABLE BROWSER (
  ID      INT PRIMARY KEY  NOT NULL,
  NAME    TEXT             NOT NULL,
  VERSION VARCHAR(10)      NOT NULL
);

CREATE TABLE BROWSER_TO_ATTRIBUTE (
  BROWSER_ID   INT NOT NULL,
  ATTRIBUTE_ID INT NOT NULL,
  SUPPORTED    VARCHAR(10)--FULL, PARTIAL, NOT
);

ALTER TABLE BROWSER_TO_ATTRIBUTE
  ADD CONSTRAINT BROWSER_ID_FK FOREIGN KEY (BROWSER_ID) REFERENCES BROWSER (ID);
ALTER TABLE BROWSER_TO_ATTRIBUTE
  ADD CONSTRAINT ATTRIBUTE_ID_FK FOREIGN KEY (ATTRIBUTE_ID) REFERENCES ATTRIBUTE (ID);

