package desafio3;

public class VerificarLimite extends ValidarPagamento{

    @Override
    protected String verificar(Pagamento pagamento){
        if (pagamento.getValor() > pagamento.getLimiteDisponivel()) {
            return "Limite insuficiente";
        }
        return "Pagamento válido";
    }
}
