package com.forumhub.ForumHub.controller;


import com.forumhub.ForumHub.domain.usuario.DadosCadastroUsuario;
import com.forumhub.ForumHub.domain.usuario.DadosListagemUsuario;
import com.forumhub.ForumHub.domain.usuario.Usuario;
import com.forumhub.ForumHub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {
        repository.save(new Usuario(dados));
    }

    @GetMapping
    public Page<DadosListagemUsuario> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemUsuario::new);
    }




}
