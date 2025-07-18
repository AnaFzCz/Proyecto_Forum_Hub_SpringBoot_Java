package com.forumhub.ForumHub.domain.topico;

import com.forumhub.ForumHub.domain.resposta.Resposta;
import jakarta.validation.constraints.NotNull;

public record DadosAtualicacaoTopico(
        @NotNull
        Long id,
        String mensagem,
        String titulo
) {
}
