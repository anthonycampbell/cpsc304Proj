create table member_companies
       (aa_name varchar(20),
       ac_name varchar(20),
       primary key (aa_name, ac_name));

grant select on member_companies to public;

create table airline_Company
       (ac_name varchar(20),
       location   varchar(20),
       primary key (ac_name));

grant select airline_companies to public;

create table airliner_operatedby_operatedon_1
       (flight# char(5),
       model# char(5),
       aoo_name varchar(20),
       to_airport_code char(3),
       from_airport_code char(3),
       primary key (flight#, departure_time));

grant select on airliner_operatedby_operatedon_1 to public;

create table airliner_operatedby_operatedon_2
       (flight# char(5),
       departure_time time,
       arrival_time time,
       primary key (flight#, departure_time));

grant select on airliner_operatedby_operatedon_2 to public;

create table air_alliances
       (aa_name varchar(20),
       primary key (aa_name));

grant select on air_aliiances to public;

create table airports
       (airport_code varchar(20),
       primary key (airport_code));

grant select on airports to public;

create table isMember
       (aa_name varchar(20),
       passport# int,
       primary key (aa_name, passport#));

grant select on isMember to public;

create table passenger
       (passport# int,
       primary key (passport#));

grant select on passenger to public;

                                        
