public abstract class Jogador extends Entidade{
   public int experiencia;
   public int nivel;
   public ArrayList<Item> inventario;
   public String habilidades;

   public Jogador()
   {
      super();
      experiencia = 0;
      nivel = 1;
      habilidades = "";
   }
   
   public void agredir(Entidade e, int dano)
   {
      if(e.armadura >= dano) 
      {
         e.armadura -= dano;
      }
      else
      {
         int danoVida = dano-e.armadura;
         e.armadura = 0;
         e.vidaAtual -= danoVida;
      }
   }

   public void usarItem(Item item, Entidade e)
   {
      if(item.dano > 0) agredir(e, item.dano);
      else if(item.recuperacaoVida > 0) e.vida += item.recuperacaoVida;
   }

   public abstract void subirDeNivel();
}
