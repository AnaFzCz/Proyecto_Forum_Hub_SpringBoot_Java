package com.forumhub.ForumHub.domain.topico;

import com.forumhub.ForumHub.domain.curso.Curso;
import com.forumhub.ForumHub.domain.resposta.Resposta;
import com.forumhub.ForumHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDateTime data_criacao;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;


    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    @Column(name = "resposta_id")
    private List<Resposta> resposta;

    public Topico(DadosCadastroTopico dados, Curso cursoS, Usuario usuarioS) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data_criacao = LocalDateTime.now();
        this.status = "NAO-RESOLVIDO";
        this.curso = cursoS;
        this.usuario = usuarioS;
        this.resposta = new ArrayList<>();

    }


    public void atualizarInformacao(DadosAtualicacaoTopico dados, Resposta resposta) {
        if (dados.id() != null && dados.mensagem() != null && dados.titulo() != null) {
            this.status = "SOLUCIONADO";

            resposta.setTopico(this);
            this.resposta.add(resposta);
        }
    }
}
