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
INSERT INTO CUSTOMER VALUES (1,'apa@hej.com', 'apa', 'password', '11111', 
                        'seQuest', 'addressgatan1', TRUE, 0, 0.0);
INSERT INTO CUSTOMER VALUES (2,'bepa@hej.com', 'bepa', 'password', '22222', 
                        'seQuest', 'addressgatan2', TRUE, 0, 0.0);
INSERT INTO CUSTOMER VALUES (3, 'cepa@hej.com', 'cepa', 'password', '33333', 
                        'seQuest', 'addressgatan3', TRUE, 0, 0.0);
INSERT INTO CUSTOMER VALUES (4, 'depa@hej.com', 'depa', 'password', '44444', 
                        'seQuest', 'addressgatan4', TRUE, 0, 0.0);
/*Auction*/
CREATE TABLE AUCTION (
    "ID" INTEGER not null primary key,
    "TITLE" VARCHAR(30),
    "INFO" VARCHAR(60),
    "PRICE" DOUBLE
    /*VI BEHÖVER ANVÄNDA NÅGON SORTS TID*/
);

INSERT INTO AUCTION VALUES(1,'Mås', 'info', 101.00);
INSERT INTO AUCTION VALUES(2,'Katt', 'info', 102.00);
INSERT INTO AUCTION VALUES(3,'Hest', 'info', 103.00);
INSERT INTO AUCTION VALUES(4,'Dawgh', 'info', 104.00);
INSERT INTO AUCTION VALUES(5,'ko', 'info', 101.00);
INSERT INTO AUCTION VALUES(6,'häst', 'info', 102.00);
INSERT INTO AUCTION VALUES(7,'katt', 'info', 103.00);
/*
    public String title;
    public String info;
    public Double price;
    public Date expireDate; /// INTE ÄN
    //public Customer creator;
    public HashMap<Customer, Double> bidderMap; //för att kunna presentera listan på smidigt sätt
    public List<HashMap> bidderList;
    public List<Customer> flagList;
    public Long id;
*/