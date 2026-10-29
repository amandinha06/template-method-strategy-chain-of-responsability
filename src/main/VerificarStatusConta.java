package desafio3;

public class VerificarStatusConta extends ValidarPagamento {

    @Override
    protected String verificar(Pagamento pagamento) {
        if (!pagamento.isContaAtiva()) {
            return "Conta inativa";
        }

        return "Pagamento válido";
    }
}