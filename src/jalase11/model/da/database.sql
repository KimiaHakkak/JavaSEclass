CREATE TABLE PRODUCT
(
    id    number key number,
    name  nvarchar2(20),
    brand nvarchar2(20),
    price number,
    count number
);

CREATE SEQUENCE PRODUCT_SEQ START WITH 1 INCREMENT BY 1;