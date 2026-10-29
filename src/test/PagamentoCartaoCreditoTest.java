
package desafio3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PagamentoCartaoCreditoTest {

    @Test
    void deveRetornarPagamentoAprovado() {
        ValidarPagamento validador = new VerificarFraude();
        validador.definirProximo(new VerificarLimite())
                .definirProximo(new VerificarStatusConta());

        Pagamento pagamento = new Pagamento(100.0, 500.0, true, false);
        PagamentoCartaoCredito cartao = new PagamentoCartaoCredito(validador);

        assertEquals(
                "Pagamento via cartão de crédito aprovado. total: 103.0",
                cartao.processar(pagamento)
        );
    }

    @Test
    void deveBloquearPagamentoPorFraude() {
        ValidarPagamento validador = new VerificarFraude();
        validador.definirProximo(new VerificarLimite())
                .definirProximo(new VerificarStatusConta());

        Pagamento pagamento = new Pagamento(100.0, 500.0, true, true);
        PagamentoCartaoCredito cartao = new PagamentoCartaoCredito(validador);

        assertEquals(
                "Pagamento bloqueado por suspeita de fraude",
                cartao.processar(pagamento)
        );
    }

    @Test
    void deveBloquearPagamentoPorLimiteInsuficiente() {
        ValidarPagamento validador = new VerificarFraude();
        validador.definirProximo(new VerificarLimite())
                .definirProximo(new VerificarStatusConta());

        Pagamento pagamento = new Pagamento(600.0, 500.0, true, false);
        PagamentoCartaoCredito cartao = new PagamentoCartaoCredito(validador);

        assertEquals(
                "Limite insuficiente",
                cartao.processar(pagamento)
        );
    }

    @Test
    void deveBloquearPagamentoPorContaInativa() {
        ValidarPagamento validador = new VerificarFraude();
        validador.definirProximo(new VerificarLimite())
                .definirProximo(new VerificarStatusConta());

        Pagamento pagamento = new Pagamento(100.0, 500.0, false, false);
        PagamentoCartaoCredito cartao = new PagamentoCartaoCredito(validador);

        assertEquals(
                "Conta inativa",
                cartao.processar(pagamento)
        );
    }
}
