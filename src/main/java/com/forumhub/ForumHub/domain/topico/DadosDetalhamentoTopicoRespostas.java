package com.forumhub.ForumHub.domain.topico;

import com.forumhub.ForumHub.domain.curso.DadosListagemCurso;
import com.forumhub.ForumHub.domain.resposta.DadosListagemResposta;
import com.forumhub.ForumHub.domain.resposta.Resposta;
import com.forumhub.ForumHub.domain.usuario.DadosListagemUsuario;

import java.time.LocalDateTime;
import java.util.List;

public record DadosDetalhamentoTopicoRespostas(Long id,
                                               String titulo,
                                               String mensagem,
                                               LocalDateTime data_Criacao,
                                               String status,
                                               DadosListagemUsuario usuario,
                                               DadosListagemCurso curso,
                                               List<DadosListagemResposta> respostas
) {

    public DadosDetalhamentoTopicoRespostas(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getData_criacao(),
                topico.getStatus(),
                new DadosListagemUsuario(topico.getUsuario()),
                new DadosListagemCurso(topico.getCurso()),
                topico.getResposta().stream().map(DadosListagemResposta::new).toList()
        );
    }
}
