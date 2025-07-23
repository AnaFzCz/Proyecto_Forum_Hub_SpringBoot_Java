package com.forumhub.ForumHub.domain.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DadosAuthenticacao(
        @JsonProperty("login") String email,
        @JsonProperty("senha") String senha) {
}
