import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

public class Exec extends JFrame{
   public Exec(String titulo)  {
      super(titulo);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(300, 200);
       
      mudarPanel(telaInicial());

      setVisible(true);
   }
   public void mudarPanel(JPanel panel)  {
      getContentPane().removeAll();
      setContentPane(panel);
      revalidate();
      repaint();
   }
   public JPanel telaInicial()  {
      JPanel panel = new JPanel();
      GameButton personagem = new GameButton("Criar Personagem", 1);
      personagem.addActionListener(new GameListener(personagem.acao, this));
      panel.add(personagem);

      GameButton campanha = new GameButton("Jogar Campanaha", 2);
      campanha.addActionListener(new GameListener(campanha.acao, this));
      panel.add(campanha);

      GameButton salvar = new GameButton("Salvar Jogo", 3);
      salvar.addActionListener(new GameListener(salvar.acao, this));
      panel.add(salvar);

      GameButton carregar = new GameButton("Carregar Jogo", 4);
      carregar.addActionListener(new GameListener(carregar.acao, this));
      panel.add(carregar);

      return panel;
   }

   public JPanel telaPersonagem()  {
      return new JPanel();
   }

   public Jogador criarJogador(String nome,int classe)  { 
      switch (classe) {
         case 1:
            // guerreiro
            return new Guerreiro(nome);
         case 2:
            // mago
            return new Mago(nome);
         case 3:
            // ladino
            return new Ladino(nome);
         case 4:
            //clerigo
            return new Clerigo(nome);
         default:
            return new Guerreiro(nome);
      }
   }

   public static void main(String[] args) {
      Scanner entrada = new Scanner(System.in);
      Jogador jogador = null;
      //Encontro[0] campanha;
      
      new Exec("Jogo Divertido");

   }
}

      
