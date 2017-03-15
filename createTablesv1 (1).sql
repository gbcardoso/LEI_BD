create table utilizador
	(user varchar(16),
    password varchar(16) not null,
    type int(1) not null,
    status int(1),
    primary key (user),
    constraint status_number_1_0 check (status is not null or status=0 or status=1 or status=2));
    
create table leilao
	(id int(4) not null auto_increment,
    user varchar(16) not null,
    id_produto int(11) not null,
    data_criacao datetime default CURRENT_TIMESTAMP,
    preco decimal(6,2) not null,
    valorin decimal(6,2) default null,
    deadline datetime not null,
    titulo varchar(20) not null,
    descricao varchar(50) not null,
    detalhes varchar(50),
    primary key (id),
	foreign key (user) references utilizador(user));
    
create table licitacao
	(user varchar(16),
    id int(4),
    preco int(4) not null,
    foreign key (user) references utilizador(user),
    foreign key (id) references leilao(id));
    
    
create table mensagem
	(user varchar(16),
    id int(4),
    conteudo varchar(30) not null,
    foreign key (user) references utilizador(user),
    foreign key (id) references leilao(id));
    
create table notificacao
	(user varchar(16),
    id int(4),
    conteudo varchar(150) not null,
    foreign key (user) references utilizador(user),
    foreign key (id) references leilao(id));
    
/*select * from utilizador; 
select * from leilao; 
select * from mensagem;
select * from licitacao; 
select * from notificacao; */
    
insert into utilizador (user,password,type,status) values ("francisco", "ff", 1,0);
insert into utilizador (user,password,type,status) values ("gabriel","gg", 1,0);
insert into utilizador (user,password,type,status) values ("gabi", "gg", 1,0);

insert into leilao (user,id_produto,preco,deadline,titulo,descricao,detalhes) values ("francisco",1,10,"2016-12-16 16:02","computador","grander","entrega em coimbra");
insert into leilao (user,id_produto,preco,deadline,titulo,descricao,detalhes) values ("gabi",1,10,"2016-12-17 16:02","computador","pequeno","lul");
insert into leilao (user,id_produto,preco,deadline,titulo,descricao,detalhes) values ("francisco",1,10,now(),"computador","grander","entrega em coimbra");

insert into licitacao (user, id,preco) values ("gabi",1,5);
insert into licitacao (user, id,preco) values ("francisco",1,4);

insert into mensagem(user,id,conteudo) values("gabi",1,"onde entrega");

DELIMITER $$
CREATE TRIGGER newbid 
	BEFORE INSERT ON licitacao
	for each row
begin
	declare done int default false;
    declare ids varchar(16);
    declare cur CURSOR FOR
		select b.user
		from licitacao b
		where b.id=NEW.id
        union
		select m.user
		from mensagem m
		where m.id = NEW.id;
	declare continue handler for not found set done = TRUE;
	open cur;
		ins_loop: LOOP
			fetch cur into ids;
            if done then
				leave ins_loop;
			end if;
			insert into notificacao (user,id,conteudo) values (ids,NEW.id,concat("Nova bid no leilao: ",NEW.id));
		end loop;
	close cur;
end$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER newMens 
	BEFORE INSERT ON mensagem
	for each row
begin
	declare done int default false;
    declare ids varchar(16);
    declare cur CURSOR FOR
		select b.user
		from licitacao b
		where b.id=NEW.id
        union
		select m.user
		from mensagem m
		where m.id = NEW.id;
	declare continue handler for not found set done = TRUE;
	open cur;
		ins_loop: LOOP
			fetch cur into ids;
            if done then
				leave ins_loop;
			end if;
			insert into notificacao (user,id,conteudo) values (ids,NEW.id,concat("Mensagem: ",NEW.conteudo));
		end loop;
	close cur;
end$$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER new
	BEFORE INSERT ON mensagem
	for each row
begin
	declare done int default false;
    declare ids varchar(16);
    declare cur CURSOR FOR
		select b.user
		from licitacao b
		where b.id=NEW.id
        union
		select m.user
		from mensagem m
		where m.id = NEW.id;
	declare continue handler for not found set done = TRUE;
	open cur;
		ins_loop: LOOP
			fetch cur into ids;
            if done then
				leave ins_loop;
			end if;
			insert into notificacao (user,id,conteudo) values (ids,NEW.id,concat("Mensagem: ",NEW.conteudo));
		end loop;
	close cur;
end$$
DELIMITER ;
