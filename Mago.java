public class Mago extends Jogador {
    int mana;
    public Mago() {
        super();
    }

    public Mago(String nome, int vidaMaxima, int velocidade, int ataque, int defesa, int armadura) {
        super(nome, vidaMaxima, velocidade, ataque, defesa, armadura);
        this.mana = 100;
    }

    public String BolaDeFogo(Entidade e) {
        int danoEspecial = ataque * 3;
        boolean inimigoMorto = agredir(e, danoEspecial);
        mana -= 30;
        if (inimigoMorto) {
            ganharExperiencia(100);
            return nome + " usou Bola de Fogo em " + e.nome + " causando " + danoEspecial + " de dano e o matou!";
        } else {
            return nome + " usou Bola de Fogo em " + e.nome + " causando " + danoEspecial + " de dano.";
        }
    }

    public String ArmaduraArcana() {
        int armaduraRecuperada = 10;
        armadura += armaduraRecuperada;
        mana -= 20;
        return nome + " usou Armadura Arcana e recuperou " + armaduraRecuperada + " de armadura.";
    }

    public void subirDeNivel() {
        while (experiencia >= experienciaNecessaria) {
            experiencia -= experienciaNecessaria;
            nivel++;
            experienciaNecessaria = nivel * 100;
            ataque += 5;
            defesa += 3;
            vidaMaxima += 10;
            vidaAtual = vidaMaxima;
        }
    }
}