create table musics (
	id serial primary key,
	name varchar(255) not null,
	music_key varchar(10) not null,
	descricao varchar(2000) not null
);

create sequence musics_seq increment 1 minvalue 1 start 1;
alter table musics alter column id set default nextval('musics_seq');

insert into musics (name, music_key, descricao) values
('Imutavel Deus', 'Em', ''),
('Aquele que ha de vir vira', 'A', ''),
('Cidade Eternal', 'G', ''),
('So em Jesus', 'Eb', ''),
('Mais que Maravilhoso', 'Eb', ''),
('Nao se turbe o vosso coracao', 'A', ''),
('Aos pes de Jesus', 'F', ''),
('O Senhor e a Minha Rocha', 'F', '');
