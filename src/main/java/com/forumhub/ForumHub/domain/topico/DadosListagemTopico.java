package com.forumhub.ForumHub.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data_criacao
) {

    public DadosListagemTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData_criacao());
    }
}
