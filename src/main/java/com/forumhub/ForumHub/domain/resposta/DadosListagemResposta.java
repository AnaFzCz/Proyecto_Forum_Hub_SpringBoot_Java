package com.forumhub.ForumHub.domain.resposta;

import java.time.LocalDateTime;
import java.util.List;

public record DadosListagemResposta(
        String mensagem,
        LocalDateTime data_criacao,
        String solucao,
        Long topico_id
) {

    public DadosListagemResposta(Resposta resposta) {
        this(resposta.getMensagem(), resposta.getData_criacao(), resposta.getSolucao(), resposta.getTopico().getId());

    }


}
