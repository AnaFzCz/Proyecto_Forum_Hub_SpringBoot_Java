package com.forumhub.ForumHub.controller;

import com.forumhub.ForumHub.domain.curso.Curso;
import com.forumhub.ForumHub.domain.curso.CursoRepository;
import com.forumhub.ForumHub.domain.curso.DadosListagemCurso;
import com.forumhub.ForumHub.domain.resposta.Resposta;
import com.forumhub.ForumHub.domain.resposta.RespostaRepository;
import com.forumhub.ForumHub.domain.topico.*;
import com.forumhub.ForumHub.domain.usuario.Usuario;
import com.forumhub.ForumHub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {


    @Autowired
    private TopicoRepository repository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RespostaRepository respostaRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {
        Usuario usuario = usuarioRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Curso curso = cursoRepository.findByNome(dados.nomeCurso());
        repository.save(new Topico(dados, curso, usuario));
    }

    @GetMapping
    public Page<DadosListagemTopico> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemTopico::new);
    }

    @GetMapping("/{id}")

    public DadosDetalhamentoTopico detalharTopico(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return new DadosDetalhamentoTopico(topico);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualicacaoTopico dados) {
        Topico topico = repository.findById(dados.id())
                .orElseThrow(() -> new RuntimeException("topico não encontrado"));
        ;
        Usuario usuario = usuarioRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));


        Resposta resposta = (new Resposta(dados, topico, usuario));
        respostaRepository.save(resposta);

        topico.atualizarInformacao(dados, resposta);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);


    }


}
