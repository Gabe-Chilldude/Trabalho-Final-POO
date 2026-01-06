public class Guerreiro extends Jogador {
    int stamina;
    public Guerreiro() {
        super();
    }

    public Guerreiro(String nome, int vidaMaxima, int velocidade, int ataque, int defesa, int armadura) {
        super(nome, vidaMaxima, velocidade, ataque, defesa, armadura);
        this.stamina = 100;
    }

    public String AtaqueEspecial(Entidade e) {
        int danoEspecial = ataque * 2;
        boolean inimigoMorto = agredir(e, danoEspecial);
        stamina -= 20;
        if (inimigoMorto) {
            return nome + " usou Ataque Especial em " + e.nome + " causando " + danoEspecial + " de dano e o matou!";
        } else {
            return nome + " usou Ataque Especial em " + e.nome + " causando " + danoEspecial + " de dano.";
        }
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