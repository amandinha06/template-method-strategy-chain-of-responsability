package desafio3;

public class VerificarFraude extends ValidarPagamento{

    @Override
    protected String verificar(Pagamento pagamento){
        if (pagamento.isSuspeitaFraude()){
            return "Pagamento bloqueado por suspeita de fraude";
        }
        return "Pagamento válido";
    }
}
