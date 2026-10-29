package desafio3;

public class TaxaCartaoCredito implements EstrategiaTaxa{
    @Override
    public double calcularTaxa(double valor){
        return valor * 0.03;
    }
}
