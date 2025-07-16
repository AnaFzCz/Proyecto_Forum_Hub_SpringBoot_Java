package com.forumhub.ForumHub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCurso(
        //no puede ser nulo ni vacio
        @NotBlank
        String nome,
        @NotNull
        Categoria categoria
) {
}
