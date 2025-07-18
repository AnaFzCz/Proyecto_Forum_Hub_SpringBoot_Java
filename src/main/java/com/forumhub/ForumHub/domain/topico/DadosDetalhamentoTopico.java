package com.forumhub.ForumHub.domain.topico;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.forumhub.ForumHub.domain.curso.Curso;
import com.forumhub.ForumHub.domain.curso.DadosListagemCurso;
import com.forumhub.ForumHub.domain.usuario.DadosListagemUsuario;
import com.forumhub.ForumHub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data_Criacao,
        String status,
        DadosListagemUsuario usuario,
        DadosListagemCurso curso
) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getData_criacao(),
                topico.getStatus(),
                new DadosListagemUsuario(topico.getUsuario()),
                new DadosListagemCurso(topico.getCurso())
        );
    }


}
