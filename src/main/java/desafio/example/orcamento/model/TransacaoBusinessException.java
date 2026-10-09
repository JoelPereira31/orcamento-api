package desafio.example.orcamento.model;

public class TransacaoBusinessException extends RuntimeException {
    public TransacaoBusinessException(String message) {
        super(message);
    }
}