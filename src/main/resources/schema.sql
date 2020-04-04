drop table if exists location;

create table if not exists location
(
	id bigint not null
		constraint location_pkey
			primary key,
	district varchar(150),
	koatuu varchar(20) not null
		constraint location_koatuu_idx
			unique,
	location_type varchar(20),
	region varchar(150),
	settlement varchar(150)
);

alter table location owner to db;

create index if not exists location_settlement_idx
	on location (settlement);

create index if not exists location_region_idx
	on location (region);

create index if not exists district_district_idx
	on location (district);

