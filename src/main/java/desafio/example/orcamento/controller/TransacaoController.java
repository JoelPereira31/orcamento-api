package desafio.example.orcamento.controller;

import desafio.example.orcamento.model.Transacao;
import desafio.example.orcamento.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Object> criarTransacao(@RequestBody Transacao transacao) {
        try {
            Transacao novaTransacao = transacaoService.salvarTransacao(transacao);
            return ResponseEntity.ok(novaTransacao);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}