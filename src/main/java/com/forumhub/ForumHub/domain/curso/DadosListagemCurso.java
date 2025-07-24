package com.forumhub.ForumHub.domain.curso;

public record DadosListagemCurso(

        String nome,
        Categoria categoria) {
    public DadosListagemCurso (Curso curso) {
        this( curso.getNome(), curso.getCategoria());
    }
}
