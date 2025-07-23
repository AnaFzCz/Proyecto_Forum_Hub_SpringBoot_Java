package com.forumhub.ForumHub.controller;

import com.forumhub.ForumHub.domain.curso.Curso;
import com.forumhub.ForumHub.domain.curso.CursoRepository;
import com.forumhub.ForumHub.domain.curso.DadosListagemCurso;
import com.forumhub.ForumHub.domain.resposta.Resposta;
import com.forumhub.ForumHub.domain.resposta.RespostaRepository;
import com.forumhub.ForumHub.domain.topico.*;
import com.forumhub.ForumHub.domain.usuario.Usuario;
import com.forumhub.ForumHub.domain.usuario.UsuarioRepository;
import com.forumhub.ForumHub.infraestructura.security.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional



    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder, Authentication authentication) {

        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();

//        Usuario usuario = usuarioRepository.findById(1L)
//                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Curso curso = cursoRepository.findByNome(dados.nomeCurso());
        var topico = new Topico(dados, curso, usuarioLogado);
        repository.save(topico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")

    public ResponseEntity<DadosDetalhamentoTopico> detalharTopico(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualicacaoTopico dados, Authentication authentication) {
        Topico topico = repository.findById(dados.id())
                .orElseThrow(() -> new RuntimeException("topico não encontrado"));

        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();

//        Usuario usuario = usuarioRepository.findById(1L)
//                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));


        Resposta resposta = (new Resposta(dados, topico, usuarioLogado));
        respostaRepository.save(resposta);

        topico.atualizarInformacao(dados, resposta);

        return ResponseEntity.ok(new DadosDetalhamentoTopicoRespostas(topico));

    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
