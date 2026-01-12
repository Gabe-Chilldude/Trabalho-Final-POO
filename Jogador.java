import java.util.ArrayList;
public abstract class Jogador extends Entidade {
   private int experiencia;
   private int nivel;
   public ArrayList<Item> inventario;
   public String habilidades;

   public Jogador() {
      super();
      experiencia = 0;
      nivel = 1;
      habilidades = "";
      inventario = new ArrayList<Item>();
   }

   public Jogador(String nome, int vidaMaxima, int velocidade, int ataque, int defesa, int armadura) {
      super(nome, vidaMaxima, velocidade, ataque, defesa, armadura);
      vidaAtual = vidaMaxima;
      experiencia = 0;
      nivel = 1;
      habilidades = "";
      inventario = new ArrayList<Item>();
   }

   public boolean agredir(Entidade e) {
      int danoArmadura = Math.max(0, ataque - e.defesa);

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

   

   public void agredirComItem(Entidade e, Item item) {

    int danoArmadura = Math.max(0, item.dano - e.defesa);

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
    }
   }

   public void ganharExperiencia(int xp) {
      experiencia += xp;
      subirDeNivel();
   }

   public int getNivel() {
      return nivel;
   }

   public int getExperiencia() {
      return experiencia;
   }

   public int getExperienciaNecessaria() {
      return nivel * 100;
   }
  public void reduzirExperiencia(int xp) {
      experiencia -= xp;
   }
   public void aumentarNivel() {
      nivel++;
   }

   public void usarItem(Item item, Entidade e) {
      if (item.dano > 0) {
         agredirComItem(e, item);
      } else if (item.recuperacaoVida > 0) {
         e.vidaAtual = Math.min(
            e.vidaAtual + item.recuperacaoVida,
            e.vidaMaxima
         );
      }
   }

   public abstract void subirDeNivel();
}
