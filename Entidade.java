public abstract class Entidade {
   public String nome;
   public int vidaAtual;
   public int vidaMaxima;
   public int velocidade;
   public int ataque;
   public int defesa;
   public int armadura;

   public Entidade()
   {
      vidaMaxima = 10;
      vidaAtual = vidaMaxima;
      velocidade = 1;
      ataque = 1;
      armadura = 0;
   }

   public abstract boolean agredir(Entidade e, int dano);
   
   public String recuperarArmadura()
   {
      armadura++;
      return "Armadura recuperada";
   }
   public String recuperarArmadura(int valor)
   {
      armadura += valor;
      return "Armadura recuperada";
   }

   public boolean morrer()
   {
      if(vidaAtual<=0)
      {
         return true;
      }
      else 
      {
         return false;
      }
   }
}
