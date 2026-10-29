package desafio3;

public class PagamentoPix extends ProcessarPagamento{

    public PagamentoPix(ValidarPagamento valiador){
        super(new TaxaPix(), valiador);
    }

    @Override
    protected String executarTransacao(Pagamento pagamento, double taxa){
        double total = pagamento.getValor() + taxa;

        return "Pagamento via pix aprovado. total: " + total;
    }
}
