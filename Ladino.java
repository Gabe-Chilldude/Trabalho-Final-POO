public class Ladino extends Jogador {

    public Ladino(String nome, int vidaMaxima, int velocidade, int ataque, int defesa, int armadura) {
        super(nome, vidaMaxima, velocidade, ataque, defesa, armadura);
    }

    public String sabotar(Entidade e) {

        int reducaoDefesa = 5;

        e.defesa = Math.max(0, e.defesa - reducaoDefesa);

        return nome + " usou Sabotar em " + e.nome + ", reduzindo a defesa em " + reducaoDefesa + ".";
    }

    public boolean agredir(Entidade e) {
        return super.agredir(e);
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
