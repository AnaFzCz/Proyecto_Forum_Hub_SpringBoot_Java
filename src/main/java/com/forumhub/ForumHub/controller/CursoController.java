package com.forumhub.ForumHub.controller;

import com.forumhub.ForumHub.domain.curso.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCurso dados) {
        // System.out.print(dados);
        repository.save(new Curso(dados));

    }

    @GetMapping
    public Page<DadosListagemCurso> listar(@PageableDefault(size = 10, sort = {"categoria"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemCurso::new);
    }

    @PutMapping
    @Transactional
    public void actualizar(@RequestBody @Valid DadosAtualicacaoCurso dados) {
        var curso = repository.getReferenceById(dados.id());
        curso.atualizarInformacoes(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void exhibir(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
