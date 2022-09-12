CREATE TABLE translation
(

    id                INTEGER NOT NULL PRIMARY KEY,
    language          VARCHAR (100) NOT NULL,
    originalMessage   VARCHAR (100),
    translatedMessage VARCHAR (100) NOT NULL

);