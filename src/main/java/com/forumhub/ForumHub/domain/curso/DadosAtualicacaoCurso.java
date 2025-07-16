package com.forumhub.ForumHub.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DadosAtualicacaoCurso(
        @NotNull
        Long id,
        Categoria categoria) {
}
