package com.forumhub.ForumHub.domain.resposta;

import com.forumhub.ForumHub.domain.topico.DadosAtualicacaoTopico;
import com.forumhub.ForumHub.domain.topico.Topico;
import com.forumhub.ForumHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity(name = "Resposta")
@Table(name = "respostas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    @Column(name = "dataCriacao")
    private LocalDateTime data_criacao;

    private String solucao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    public Resposta(DadosAtualicacaoTopico dados, Topico topicoS, Usuario usuarioS) {
        this.mensagem = dados.mensagem();
        this.data_criacao = LocalDateTime.now();
        this.solucao = dados.titulo();
        this.usuario = usuarioS;
        this.topico = topicoS;
    }


}
