create table PROVIDER(
  ID int not null AUTO_INCREMENT,
  NAME varchar(100) not null,
  BUSINESS_NAME varchar(200) not null,
  ADDRESS varchar(250) not null,
  PRIMARY KEY ( ID )
);

create table USER_PREFERENCE(
  ID int not null AUTO_INCREMENT,
  USERNAME varchar(100) not null,
  WELCOME_MESSAGE varchar(200) not null,
  VERSION varchar(100) not null,
  PRIMARY KEY ( ID )
);