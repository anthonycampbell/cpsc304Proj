drop table member_companies;
drop table airline_companies;
drop table airliner_oo1;
drop table airliner_oo2;
drop table air_alliances;
drop table airports;
drop table isMember;
drop table passengers;
drop table from_to;
drop table has_premium_lounge_in;
drop table on_board;

create table member_companies
       (aa_name varchar(20),
       ac_name varchar(20),
       primary key (aa_name, ac_name));

grant select on member_companies to public;

create table airline_companies
       (ac_name varchar(20),
       location   varchar(20),
       primary key (ac_name));

grant select on airline_companies to public;

create table airliner_oo1
       (flight# char(5),
       model# char(5),
       ac_name varchar(20),
       to_airport_code char(3),
       from_airport_code char(3),
       primary key (flight#));

grant select on airliner_oo1 to public;

create table airliner_oo2
       (flight# char(5),
       departure_time date,
       arrival_time date,
       primary key (flight#, arrival_time));

grant select on airliner_oo2 to public;

create table air_alliances
       (aa_name varchar(20),
       primary key (aa_name));

grant select on air_alliances to public;

create table airports
       (airport_code varchar(20),
       primary key (airport_code));

grant select on airports to public;

create table isMember
       (aa_name varchar(20),
       passport# int,
       primary key (aa_name, passport#));

grant select on isMember to public;

create table passengers
       (passport# int,
       primary key (passport#));

grant select on passengers to public;

create table from_to
       (from_airport_code varchar(20),
       to_airport_code varchar(20),
       primary key (from_airport_code, to_airport_code));

grant select on from_to to public;

create table has_premium_lounge_in
       (airport_code char(3),
       aa_name varchar(20),
       primary key (airport_code));

grant select on has_premium_lounge_in to public;

create table on_board
       (passport# int,
       flight# int,
       departure_time date,
       destination varchar(20),
       primary key (passport#, departure_time));

grant select on on_board to public;

insert into member_companies
('Star Alliance', 'Air Canada');

insert into member_companies
('Star Alliance', 'Air China');

insert into member_companies
('Star Alliance', 'Air India');

insert into member_companies
('SkyTeam', 'Korean Air');

insert into member_companies
('SkyTeam', 'Air France');

insert into ariline_companies
('Air Canada', 'Dorval');

insert into ariline_companies
('Air China', 'Beijing');

insert into ariline_companies
('Korean Air', 'Seoul');

insert into ariline_companies
('Air France', 'Paris');

insert into ariline_companies
('Air India', 'Bombay'); 

insert into airliner_oo1
('AC025', 'Air Canada', 'PVG', 'YVR', 'Boeing 767');

insert into airliner_oo1
('AC026', 'Air Canada', 'YVR', 'PVG', 'Boeing 767');

insert into airliner_oo1
('KE071', 'Korean Air', 'ICN', 'YVR', 'Airbus A320');

insert into airliner_oo1
('AI191', 'Air India', 'YVR', 'BOM', 'Boeing 787');

insert into airliner_oo1
('CA7452', 'Air China', 'YVR', 'PEK', 'Airbus A320');

insert into airliner_oo2
('AC025', TO_DATE('2016/03/27 11:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2016/03/28 8:02:44', 'yyyy/mm/dd hh24:mi:ss'));

insert into airliner_oo2
('AC026', TO_DATE('2016/03/27 13:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2016/03/28 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));

insert into airliner_oo2
('KE071', TO_DATE('2016/03/27 2:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2016/03/28 9:02:44', 'yyyy/mm/dd hh24:mi:ss'));

insert into airliner_oo2
('AI191', TO_DATE('2016/03/27 11:02:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2016/03/22 11:04:44', 'yyyy/mm/dd hh24:mi:ss'));

insert into airliner_oo2
('CA7452', TO_DATE('2016/03/27 18:22:44', 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2016/03/28 17:02:44', 'yyyy/mm/dd hh24:mi:ss'));

insert into air_alliances
('Star Alliance');

insert into air_alliances
('SkyTeam');

insert into air_alliances
('Oneworld');

insert into airports
('PVG');

insert into airports
('YVR');

insert into airports
('BOM');

insert into airports
('PEK');

insert into airports
('ICN');
