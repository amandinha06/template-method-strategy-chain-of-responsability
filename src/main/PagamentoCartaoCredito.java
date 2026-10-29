package desafio3;

public class PagamentoCartaoCredito extends ProcessarPagamento{

    public PagamentoCartaoCredito(ValidarPagamento validador){
        super(new TaxaCartaoCredito(), validador);
    }

    @Override
    protected  String executarTransacao(Pagamento pagamento, double taxa){
        double total = pagamento.getValor() + taxa;

        return "Pagamento via cartão de crédito aprovado. total: " + total;
    }
}
