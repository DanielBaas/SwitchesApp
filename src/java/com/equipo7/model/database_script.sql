create database CiscoSwitches;

use CiscoSwitches;

create table SwitchCisco(
	pk int primary key auto_increment,
    user varchar(50),
    host varchar(20),
    port int,
    pass varchar(50),
    software varchar(50),
    version varchar(50),
    disponible tinyint
);

create table SwitchInterface(
	pk int primary key auto_increment,
    interfaceType varchar(20),
    ip varchar(20),
    okStatus varchar(5),
    method varchar(10),
    status varchar(30),
    protocol varchar(10),
    switchCisco int,
    diponible tinyint,
    foreign key(switchCisco) references SwitchCisco(pk)
);