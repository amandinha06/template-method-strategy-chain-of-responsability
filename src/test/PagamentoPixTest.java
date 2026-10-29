package desafio3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PagamentoPixTest {

    @Test
    void deveRetornarPagamentoAprovado() {
        ValidarPagamento validador = new VerificarFraude();
        validador.definirProximo(new VerificarLimite())
                .definirProximo(new VerificarStatusConta());

        Pagamento pagamento = new Pagamento(100.0, 500.0, true, false);
        PagamentoPix pix = new PagamentoPix(validador);

        assertEquals(
                "Pagamento via pix aprovado. total: 100.0",
                pix.processar(pagamento)
        );
    }

    @Test
    void deveBloquearPagamentoPorFraude() {
        ValidarPagamento validador = new VerificarFraude();
        validador.definirProximo(new VerificarLimite())
                .definirProximo(new VerificarStatusConta());

        Pagamento pagamento = new Pagamento(100.0, 500.0, true, true);
        PagamentoPix pix = new PagamentoPix(validador);

        assertEquals(
                "Pagamento bloqueado por suspeita de fraude",
                pix.processar(pagamento)
        );
    }

    @Test
    void deveBloquearPagamentoPorLimiteInsuficiente() {
        ValidarPagamento validador = new VerificarFraude();
        validador.definirProximo(new VerificarLimite())
                .definirProximo(new VerificarStatusConta());

        Pagamento pagamento = new Pagamento(600.0, 500.0, true, false);
        PagamentoPix pix = new PagamentoPix(validador);

        assertEquals(
                "Limite insuficiente",
                pix.processar(pagamento)
        );
    }

    @Test
    void deveBloquearPagamentoPorContaInativa() {
        ValidarPagamento validador = new VerificarFraude();
        validador.definirProximo(new VerificarLimite())
                .definirProximo(new VerificarStatusConta());

        Pagamento pagamento = new Pagamento(100.0, 500.0, false, false);
        PagamentoPix pix = new PagamentoPix(validador);

        assertEquals(
                "Conta inativa",
                pix.processar(pagamento)
        );
    }
}
