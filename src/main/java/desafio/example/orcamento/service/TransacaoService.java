package desafio.example.orcamento.service;

import desafio.example.orcamento.model.Transacao;
import desafio.example.orcamento.model.TransacaoBusinessException;
import desafio.example.orcamento.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private static final List<String> CATEGORIAS_VALIDAS = List.of("Alimentação", "Transporte", "Lazer", "Moradia", "Salário");

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public Transacao salvarTransacao(Transacao transacao) {
        // Validação 1: Valor deve ser maior que zero
        if (transacao.getValor() == null || transacao.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new TransacaoBusinessException("O valor da transação deve ser maior que zero.");
        }

        // Validação 2: Categoria deve existir na lista permitida
        if (transacao.getCategoria() == null || !CATEGORIAS_VALIDAS.contains(transacao.getCategoria())) {
            throw new TransacaoBusinessException("A categoria informada é inválida: " + transacao.getCategoria());
        }

        return transacaoRepository.save(transacao);
    }
}