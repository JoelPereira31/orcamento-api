package desafio.example.orcamento.repository;


import desafio.example.orcamento.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    
}