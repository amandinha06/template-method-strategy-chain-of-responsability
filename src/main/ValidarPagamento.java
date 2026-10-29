package desafio3;

public abstract class ValidarPagamento {

    private ValidarPagamento proximo;

    public ValidarPagamento definirProximo(ValidarPagamento proximo){
        this.proximo = proximo;
        return proximo;
    }

    public String validar(Pagamento pagamento){
        String resultado = verificar(pagamento);

        if(!resultado.equals("Pagamento válido")){
            return resultado;
        }

        if (proximo != null) {
            return proximo.validar(pagamento);
        }

        return "Pagamento válido";
    }
    protected abstract String verificar (Pagamento pagamento);
}
