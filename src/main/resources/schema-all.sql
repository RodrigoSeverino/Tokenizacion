DROP TABLE DA_Tokens IF EXISTS;

CREATE table DA_Tokens (
    tokenId CHAR (128) NOT NULL,
    status VARCHAR (10) NOT NULL, -- (posibles valores ACTIVE, SUSPENDED, DELETED, PENDING)
    created_date datetime
)
