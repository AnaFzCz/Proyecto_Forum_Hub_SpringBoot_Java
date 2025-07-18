create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensagem varchar(100) not null,
    dataCriacao datetime not null,
    status varchar(100) not null,
    usuario_id bigint not null,
    curso_id bigint not null,
    resposta_id bigint,

    constraint fk_topicos_usuario_id foreign key(usuario_id) references usuarios(id),
    constraint fk_topicos_curso_id foreign key(curso_id) references cursos(id),


    primary key(id)

);
