public class Guerreiro extends Jogador {

    private int stamina;

    public Guerreiro(String nome, int vidaMaxima, int velocidade, int ataque, int defesa, int armadura) {
        super(nome, vidaMaxima, velocidade, ataque, defesa, armadura);
        this.stamina = 100;
    }

    public boolean agredir(Entidade e) {
        return super.agredir(e);
    }

    public String ataqueEspecial(Entidade e) {

        if (stamina < 20) {
            return "Stamina insuficiente!";
        }

        stamina -= 20;

        boolean inimigoMorto = atacarEspecial(e);

        if (inimigoMorto) {
            return "Ataque especial derrotou o inimigo!";
        } else {
            return "Ataque especial executado.";
        }
    }

    private boolean atacarEspecial(Entidade e) {
        int poder = ataque * 2;

        int danoArmadura = Math.max(0, poder - e.defesa);

        if (e.armadura >= danoArmadura) {
            e.armadura -= danoArmadura;
        } else {
            int excesso = danoArmadura - e.armadura;
            e.armadura = 0;
            e.vidaAtual -= excesso;
        }

        if (e.vidaAtual <= 0) {
            e.vidaAtual = 0;
            ganharExperiencia(100);
            return true;
        }
        return false;
    }

    public String descasnar() {
        int recuperacao = 30;
        stamina = Math.min(100, stamina + recuperacao);
        return nome + " descansou e recuperou " + recuperacao + " de stamina.";
    }

    public void subirDeNivel() {
        while (getExperiencia() >= getExperienciaNecessaria()) {

            reduzirExperiencia(getExperienciaNecessaria());
            aumentarNivel();

            ataque += 5;
            defesa += 3;
            vidaMaxima += 10;
            vidaAtual = vidaMaxima;
        }
    }
}
