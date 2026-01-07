public class Clerigo extends Jogador {
    int fé;
    public Clerigo(String nome, int vidaMaxima, int velocidade, int ataque, int defesa, int armadura) {
        super(nome, vidaMaxima, velocidade, ataque, defesa, armadura);
        this.fé = 100;
    }

    public boolean agredir(Entidade e) {
        return super.agredir(e);
    }

    public String Rezar(){
        fé += 20;
        if(fé > 100) fé = 100;
        return nome + " rezou e recuperou fé. Fé atual: " + fé;
    }

    public String LuzDivina(){
        int cura = 30;
        vidaAtual += cura;
        fé -= 25;
        return nome + " usou Luz Divina, recuperando " + cura + " de vida.";
    }
    
    public String ArmaduraDivina() {
        int armaduraRecuperada = 15;
        armadura += armaduraRecuperada;
        fé -= 20;
        return nome + " usou Armadura Divina e recuperou " + armaduraRecuperada + " de armadura.";
    }

    public void subirDeNivel() {
        while (getExperiencia() >= getExperienciaNecessaria()) {

            reduzirExperiencia(getExperienciaNecessaria());
            aumentarNivel();

            ataque += 4;
            defesa += 2;
            velocidade += 2;
            vidaMaxima += 6;
            vidaAtual = vidaMaxima;
        }
    }
}
