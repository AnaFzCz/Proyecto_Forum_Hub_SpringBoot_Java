package com.forumhub.ForumHub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTopico(
        @NotBlank
        String mensagem,
        @NotBlank
        String nomeCurso,
        @NotBlank
        String titulo
) {
}
