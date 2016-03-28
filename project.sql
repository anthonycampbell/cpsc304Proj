drop table member_companies;
drop table isMember;
drop table from_to;
drop table has_premium_lounge_in;
drop table on_board;
drop table airliner_oo1;
drop table airliner_oo2;
drop table air_alliances;
drop table airline_companies;
drop table airports;
drop table passengers;

create table air_alliances
       (aa_name varchar(20) not null,
       primary key (aa_name));

grant select on air_alliances to public;

create table airports
       (airport_code char(3) not null,
       primary key (airport_code));

grant select on airports to public;

create table passengers
       (passport# int not null,
       pname varchar(20),
       primary key (passport#));

grant select on passengers to public;

create table airline_companies
       (ac_name varchar(20) not null,
       location   varchar(20),
       primary key (ac_name));

grant select on airline_companies to public;

create table member_companies
       (aa_name varchar(20) not null,
       ac_name varchar(20) not null,
       primary key (aa_name, ac_name),
       foreign key (aa_name) references air_alliances,
       foreign key (ac_name) references airline_companies);

grant select on member_companies to public;

create table airliner_oo1
       (flight# char(6),
       ac_name varchar(20) not null,
       to_airport_code char(3) not null,
       from_airport_code char(3) not null,
       model# varchar(15),
       primary key (flight#),
       foreign key (ac_name) references airline_companies ON DELETE CASCADE,
       foreign key (to_airport_code) references airports ON DELETE CASCADE,
       foreign key (from_airport_code) references airports ON DELETE CASCADE);

grant select on airliner_oo1 to public;

create table airliner_oo2
       (flight# char(6) not null,
       departure_time date not null,
       arrival_time date not null,
       primary key (flight#, departure_time),
       unique (flight#, arrival_time));

grant select on airliner_oo2 to public;

create table isMember
       (aa_name varchar(20) not null,
       passport# int not null,
       primary key (aa_name, passport#),
       foreign key (passport#) references passengers ON DELETE CASCADE,
       foreign key (aa_name) references air_alliances ON DELETE CASCADE);

grant select on isMember to public;

create table from_to
       (from_airport_code char(3) not null,
       to_airport_code char(3) not null,
       primary key (from_airport_code, to_airport_code),
       foreign key (from_airport_code) references airports ON DELETE CASCADE,
       foreign key (to_airport_code) references airports ON DELETE CASCADE);

grant select on from_to to public;

create table has_premium_lounge_in
       (airport_code char(3) not null,
       aa_name varchar(20),
       primary key (airport_code),
       foreign key (airport_code) references airports ON DELETE CASCADE,
       foreign key (aa_name) references air_alliances ON DELETE CASCADE);

grant select on has_premium_lounge_in to public;

create table on_board
       (passport# int not null,
       flight# char(6) not null,
       departure_time date not null,
       destination char(3),
       primary key (passport#, departure_time),
       foreign key (passport#) references passengers ON DELETE CASCADE,
       foreign key (flight#, departure_time) references airliner_oo2 ON DELETE CASCADE,
       foreign key (flight#) references airliner_oo1 ON DELETE CASCADE,
       foreign key (destination) references airports ON DELETE CASCADE);

grant select on on_board to public;


insert into airline_companies
values('Air Canada', 'Dorval');

insert into airline_companies
values('Air China', 'Beijing');

insert into airline_companies
values('Korean Air', 'Seoul');

insert into airline_companies
values('Air France', 'Paris');

insert into airline_companies
values('Air India', 'Bombay'); 

insert into air_alliances
values('Star Alliance');

insert into air_alliances
values('SkyTeam');

insert into air_alliances
values('Oneworld');

insert into member_companies
values('Star Alliance', 'Air Canada');

insert into member_companies
values('Star Alliance', 'Air China');

insert into member_companies
values('Star Alliance', 'Air India');

insert into member_companies
values('SkyTeam', 'Korean Air');

insert into member_companies
values('SkyTeam', 'Air France');

insert into airports
values('PVG');

insert into airports
values('YVR');

insert into airports
values('BOM');

insert into airports
values('PEK');

insert into airports
values('ICN');

insert into airliner_oo1
values('AC025', 'Air Canada', 'PVG', 'YVR', 'Boeing 767');

insert into airliner_oo1
values('AC026', 'Air Canada', 'YVR', 'PVG', 'Boeing 767');

insert into airliner_oo1
values('KE071', 'Korean Air', 'ICN', 'YVR', 'Airbus A320');

insert into airliner_oo1
values('AI191', 'Air India', 'YVR', 'BOM', 'Boeing 787');

insert into airliner_oo1
values('CA7452', 'Air China', 'YVR', 'PEK', 'Airbus A320');

insert into airliner_oo2
values('AC025', TO_DATE('2016/03/27 11:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2016/03/28 8:02:44', 'yyyy/mm/dd hh24:mi:ss'));

insert into airliner_oo2
values('AC026', TO_DATE('2016/03/27 13:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2016/03/28 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));

insert into airliner_oo2
values('KE071', TO_DATE('2016/03/27 2:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2016/03/28 9:02:44', 'yyyy/mm/dd hh24:mi:ss'));

insert into airliner_oo2
values('AI191', TO_DATE('2016/03/27 11:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2016/03/22 11:04:44', 'yyyy/mm/dd hh24:mi:ss'));

insert into airliner_oo2
values('CA7452', TO_DATE('2016/03/27 18:22:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2016/03/28 17:02:44', 'yyyy/mm/dd hh24:mi:ss'));
