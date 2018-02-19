/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameofkingdoms;

import java.util.Scanner;
/**
 *
 * @author tiagoantunes
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Game game = new Game();
        String[] info;
        Scanner sc = new Scanner(System.in); //get user input
        
        
        System.out.print(game.getKingdom() + "> ");
        info = sc.nextLine().toLowerCase().split(" "); //user input to analyze
        
        while (!(info[0].equals("sai"))) {
            game.getPlay(info);
            System.out.print(game.getKingdom() + "> ");
            info = sc.nextLine().toLowerCase().split(" ");
        }
        sc.close();
        System.out.println("Obrigado por jogar. Ate a proxima.");
        
        
    }

}
