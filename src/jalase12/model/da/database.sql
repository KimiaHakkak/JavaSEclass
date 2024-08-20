CREATE TABLE PRODUCT
(
    id    number primary key,
    name  nvarchar2(20),
    brand nvarchar2(20),
    price number,
    count number,
    OWNER_ID REFERENCES PERSON
);

CREATE SEQUENCE PRODUCT_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE PERSON
(
    id    number primary key,
    name  nvarchar2(20),
    family  nvarchar2(20),
    birth_date date,
    national_id nvarchar2(20),
    gender  nvarchar2(6)
);

CREATE SEQUENCE PERSON_SEQ START WITH 1 INCREMENT BY 1;

CREATE VIEW PRODUCT_OWNER_REPORT AS
SELECT P.ID           AS OWNER_ID,
       P.NAME         AS PERSON_NAME,
       P.FAMILY       AS PERSON_FAMILY,
       S.ID           AS PRODUCT_ID,
       S.NAME AS PRODUCT_NAME,
       S.BRAND   AS PRODUCT_BRAND

FROM PERSON P
         JOIN PRODUCT S
              ON P.ID = S.OWNER_ID;

CREATE TABLE SELL_TBL
(
    ID NUMBER PRIMARY KEY,
    PRICE NUMBER,
    SELL_TIME TIMESTAMP,
    OWNER_ID REFERENCES PERSON,
    PRODUCT_ID REFERENCES PRODUCT
);

CREATE SEQUENCE SELL_TBL_SEQ START WITH 1 INCREMENT BY 1;