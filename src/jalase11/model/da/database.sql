CREATE TABLE PRODUCT {
    id number key number,
    name ncharvar2(20),
    brand ncharvar(20),
    price number,
    count number
};

CREATE SEQUENCE PRODUCT_SEQ START WITH 1 INCREMENT BY 1;