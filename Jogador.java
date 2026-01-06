import java.util.ArrayList;

public abstract class Jogador extends Entidade{
   public int experiencia;
   public int nivel;
   public int experienciaNecessaria = nivel * 100;
   public ArrayList<Item> inventario;
   public String habilidades;

   public Jogador()
   {
      super();
      experiencia = 0;
      nivel = 1;
      habilidades = "";
   }
   public Jogador(String nome, int vidaMaxima, int velocidade, int ataque, int defesa, int armadura)
   {
      super(nome, vidaMaxima, velocidade, ataque, defesa, armadura);
      experiencia = 0;
      nivel = 1;
      habilidades = "";
   }
   
   public boolean agredir(Entidade e, int dano) {
        int danoRestante;

        if (e.armadura >= dano) {
            e.armadura -= dano;
            danoRestante = 0;
        } else {
            danoRestante = dano - e.armadura;
            e.armadura = 0;
        }

        if (danoRestante > 0) {
            e.vidaAtual -= danoRestante;
        }

        if (e.vidaAtual <= 0) {
            e.vidaAtual = 0;
            ganharExperiencia(100);
            return true;
        }
        return false;
}

   public void ganharExperiencia(int xp) {
        experiencia += xp;
        subirDeNivel();
}

   public void usarItem(Item item, Entidade e)
   {
      if(item.dano > 0) agredir(e, item.dano);
      else if(item.recuperacaoVida > 0) e.vidaAtual += item.recuperacaoVida;
   }

   public abstract void subirDeNivel();
}
