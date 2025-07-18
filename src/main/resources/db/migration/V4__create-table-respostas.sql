create table respostas(

    id bigint not null auto_increment,
    mensagem varchar(100) not null,
    dataCriacao datetime not null,
    solucao varchar(100) not null,

    usuario_id bigint not null,
    topico_id bigint not null,


    constraint fk_respostas_usuario_id foreign key(usuario_id) references usuarios(id),
    constraint fk_respostas_topico_id foreign key(topico_id) references topicos(id),

    primary key(id)

);
