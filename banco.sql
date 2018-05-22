create database mundogk;

use mundogk;

create table entidade(
	`id_entidade` int not null auto_increment,
    `nome` varchar(25) not null,
    primary key(id_entidade)
);

create table artigo(
	`id_artigo` int not null auto_increment,
    `titulo` varchar(45) not null unique,
    `txt_artigo` text not null, /*Primariamente essa coluna chamava-se ´txtArtigo, mas por algum motivo o hibernate mudou para txt_artigo e na inserção de dados o mysql não encontrava a tabela.´*/
    `id_entidade` int not null,
    `data_publicacao` date,
    `autor` varchar(55),
    primary key(id_artigo),
    foreign key(id_entidade) references entidade(id_entidade)    
);

insert into entidade(nome) values('Marvel Comics');
insert into entidade(nome) values('DC Comics');
insert into entidade(nome) values('Guerreiros Z');
insert into entidade(nome) values('Outros');