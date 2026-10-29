package desafio3;

public class TaxaPix implements EstrategiaTaxa{
    @Override
    public double calcularTaxa(double valor){
        return valor * 0.0;
    }
}
