public class Mago extends Jogador {

    private int mana;

    public Mago(String nome, int vidaMaxima, int velocidade, int ataque, int defesa, int armadura) {
        super(nome, vidaMaxima, velocidade, ataque, defesa, armadura);
        this.mana = 100;
    }

    public String BoladeFogo(Entidade e) {
        int dano = 40;
        e.vidaAtual -= dano;
        mana -= 30;
        return nome + " lançou Bola de Fogo em " + e.nome + ", causando " + dano + " de dano.";
    }

    public String ArmaduraArcana() {
        int armaduraRecuperada = 10;
        armadura += armaduraRecuperada;
        mana -= 20;
        return nome + " usou Armadura Arcana e recuperou " + armaduraRecuperada + " de armadura.";
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