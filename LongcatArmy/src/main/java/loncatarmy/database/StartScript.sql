DROP TABLE SELLTABLE;
DROP TABLE BUYTABLE;
DROP TABLE CUSTOMER;
DROP TABLE AUCTION;

/*Customer*/
CREATE TABLE CUSTOMER (
   "ID" INTEGER not null primary key,
    "EMAIL" VARCHAR(60),
    "NAME" VARCHAR(30),
    "PASSWORD" VARCHAR(30),
    "PHONENR" VARCHAR(10),
    "SEQQUEST" VARCHAR(20),
    "ADDRESS" VARCHAR(30),
    "ACCESS" BOOLEAN,
    "NROFSELLS" INTEGER,
    "RATING" DOUBLE
    
);

/*Auction*/
CREATE TABLE AUCTION (
    "ID" INTEGER not null primary key,
    "TITLE" VARCHAR(30),
    "INFO" VARCHAR(60),
    "PRICE" DOUBLE
    /*VI BEHÖVER ANVÄNDA NÅGON SORTS TID*/
);

CREATE TABLE SELLTABLE(
    "C_ID" INTEGER NOT NULL REFERENCES CUSTOMER ON DELETE RESTRICT,
    "A_ID" INTEGER NOT NULL REFERENCES AUCTION ON DELETE RESTRICT
);

CREATE TABLE BUYTABLE(
    "C_ID" INTEGER NOT NULL REFERENCES CUSTOMER ON DELETE RESTRICT,
    "A_ID" INTEGER NOT NULL REFERENCES AUCTION ON DELETE RESTRICT
);

INSERT INTO CUSTOMER VALUES (1,'apa@hej.com', 'apa', 'password', '11111', 
                        'seQuest', 'addressgatan1', TRUE, 0, 0.0);
INSERT INTO CUSTOMER VALUES (2,'bepa@hej.com', 'bepa', 'password', '22222', 
                        'seQuest', 'addressgatan2', TRUE, 0, 0.0);
INSERT INTO CUSTOMER VALUES (3, 'cepa@hej.com', 'cepa', 'password', '33333', 
                        'seQuest', 'addressgatan3', TRUE, 0, 0.0);
INSERT INTO CUSTOMER VALUES (4, 'depa@hej.com', 'depa', 'password', '44444', 
                        'seQuest', 'addressgatan4', TRUE, 0, 0.0);


INSERT INTO AUCTION VALUES(1,'Fisk', 'info', 10.00);
INSERT INTO AUCTION VALUES(2,'Mås', 'info', 101.00);
INSERT INTO AUCTION VALUES(3,'Katt', 'info', 102.00);
INSERT INTO AUCTION VALUES(4,'Hest', 'info', 103.00);
INSERT INTO AUCTION VALUES(5,'Dawgh', 'info', 104.00);
INSERT INTO AUCTION VALUES(6,'ko', 'info', 101.00);
INSERT INTO AUCTION VALUES(7,'häst', 'info', 102.00);
INSERT INTO AUCTION VALUES(8,'katt', 'info', 103.00);


INSERT INTO SELLTABLE VALUES((SELECT ID from CUSTOMER WHERE NAME='apa'), (SELECT ID from AUCTION WHERE TITLE='Fisk'));
INSERT INTO SELLTABLE VALUES((SELECT ID from CUSTOMER WHERE NAME='apa'), (SELECT ID from AUCTION WHERE TITLE='Mås'));
INSERT INTO SELLTABLE VALUES((SELECT ID from CUSTOMER WHERE NAME='apa'), (SELECT ID from AUCTION WHERE TITLE='Katt'));
INSERT INTO SELLTABLE VALUES((SELECT ID from CUSTOMER WHERE NAME='apa'), (SELECT ID from AUCTION WHERE TITLE='Hest'));
INSERT INTO SELLTABLE VALUES((SELECT ID from CUSTOMER WHERE NAME='apa'), (SELECT ID from AUCTION WHERE TITLE='Dawgh'));
INSERT INTO SELLTABLE VALUES((SELECT ID from CUSTOMER WHERE NAME='bepa'), (SELECT ID from AUCTION WHERE TITLE='ko'));
INSERT INTO SELLTABLE VALUES((SELECT ID from CUSTOMER WHERE NAME='cepa'), (SELECT ID from AUCTION WHERE TITLE='häst'));
INSERT INTO SELLTABLE VALUES((SELECT ID from CUSTOMER WHERE NAME='depa'), (SELECT ID from AUCTION WHERE TITLE='katt'));

INSERT INTO BUYTABLE VALUES((SELECT ID from CUSTOMER WHERE NAME='apa'),(SELECT ID from AUCTION WHERE TITLE='ko'))