package desafio3;

public abstract class ProcessarPagamento {
    private EstrategiaTaxa estrategiaTaxa;
    private ValidarPagamento validador;

    protected abstract String executarTransacao(Pagamento pagamento, double taxa);

    public ProcessarPagamento(EstrategiaTaxa estrategiaTaxa,
                              ValidarPagamento validador) {
        this.estrategiaTaxa = estrategiaTaxa;
        this.validador = validador;
    }

    public void setEstrategiaTaxa(EstrategiaTaxa estrategiaTaxa){
        this.estrategiaTaxa = estrategiaTaxa;
    }

    public final String processar(Pagamento pagamento){
        String resultado = validador.validar(pagamento);

        if (!resultado.equals("Pagamento válido")){
            return resultado;
        }

        double taxa = estrategiaTaxa.calcularTaxa(pagamento.getValor());

        String transacao = executarTransacao(pagamento, taxa);

        return notificar(transacao);
    }
    protected String notificar(String resultado) {
        return resultado;
    }
}
