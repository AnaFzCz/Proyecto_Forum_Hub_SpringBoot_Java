package com.forumhub.ForumHub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @NotBlank( message = "Nome é obrigatorio")
        String nome,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato do email é inválido")
        String email,
        @NotBlank( message = "senha é obrigatorio")
        String senha
) {
}
