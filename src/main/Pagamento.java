package desafio3;

public class Pagamento {

    private double valor;
    private double limiteDisponivel;
    private boolean contaAtiva;
    private boolean suspeitaFraude;

    public Pagamento(double valor, double limiteDisponivel, boolean contaAtiva, boolean suspeitaFraude){
        this.valor = valor;
        this.limiteDisponivel = limiteDisponivel;
        this.contaAtiva = contaAtiva;
        this.suspeitaFraude = suspeitaFraude;
    }

    public double getValor(){
        return valor;
    }

    public double getLimiteDisponivel(){
        return limiteDisponivel;
    }

    public boolean isContaAtiva(){
        return contaAtiva;
    }

    public boolean isSuspeitaFraude(){
        return suspeitaFraude;
    }
}
