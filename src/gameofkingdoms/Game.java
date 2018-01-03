/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameofkingdoms;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author tiagoantunes
 */
public class Game {

    boolean gameActive = false;
    private String kingdom = "";
    private kingdomCollection kingdoms;
    private castleCollection castles;
    private int sizeH;
    private int sizeV;

    public String getPlay(String[] info) {
        //Gets input from the user
        String move = info[0];
        switch (move) {
            case "novo":
                try {
                    gameActive = startGame(info[1], info[2], info[3], info[4]);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Numero de elementos invalidos!");
                }
                break;
            case "ajuda":
                displayHelpScreen();
                break;
            case "sai":
                return move;
            case "soldado":
                if (gameActive) {
                } else {
                    System.out.println("Comando inativo.");
                }
                break;
            case "recruta":
                if (gameActive) {
                } else {
                    System.out.println("Comando inativo.");
                }
                break;
            case "mapa":
                if (gameActive) {
                    giveGameState();
                } else {
                    System.out.println("Comando inativo.");
                }
                break;
            case "castelos":
                if (gameActive) {
                } else {
                    System.out.println("Comando inativo.");
                }
                break;
            case "exercito":
                if (gameActive) {
                } else {
                    System.out.println("Comando inativo.");
                }
                break;
            case "reinos":
                if (gameActive) {
                } else {
                    System.out.println("Comando inativo.");
                }
                break;
            default:
                System.out.println("Comando invalido.");
                return move;
        }
        return move;
    }

    public boolean startGame(String x, String y, String k, String c) {
        //Starts and restarts a game

        int maxX = Integer.valueOf(x);
        int maxY = Integer.valueOf(y);
        int nKingdoms = Integer.valueOf(k);
        int nCastles = Integer.valueOf(c);

        if (maxX < 10 || maxY < 10) {
            System.out.println("Mapa pequeno demais para iniciar o jogo.");
            System.out.println("Erro fatal, jogo nao inicializado");
            return false;
        } else if (nKingdoms < 2 || nKingdoms > 8) {
            System.out.println("Numero de reinos invalido.");
            System.out.println("Erro fatal, jogo nao inicializado");
            return false;
        } else if (nCastles < nKingdoms || nCastles > maxX * maxY) {
            System.out.println("Numero de castelos invalido.");
            System.out.println("Erro fatal, jogo nao inicializado");
            return false;
        }
        
        sizeH = maxX;
        sizeV = maxY;
        Scanner sc = new Scanner(System.in);

        //get all the game castles
        castles = new castleCollection();
        System.out.println(c + " castelos:");
        String[] castleNames = new String[nCastles];
        int counter = 0;
        for (int i = 0; i < nCastles; i++) {
            int hor = Integer.valueOf(sc.next());
            int ver = Integer.valueOf(sc.next());
            int val = Integer.valueOf(sc.next());
            String name = sc.nextLine().replaceFirst(" ", "");

            if (hor <= 0 || hor > maxX || ver <= 0 || ver > maxY) {
                System.out.println("Castelo em posicao invalida.");
            } else if (val < 0) {
                System.out.println("Castelo com riqueza invalida.");
            } else if (Arrays.asList(castleNames).contains(name)) {
                System.out.println("Os castelos nao podem ter nomes duplicados.");
            } else {
                Castle castle = new Castle(name, new Position(hor, ver), val);
                castles.addCastle(castle);
                counter++;
                castleNames[counter - 1] = name;
            }
        }
        //check minimum number of castles
        if (counter < nKingdoms) {
            System.out.println("Numero insuficiente de castelos.");
            System.out.println("Erro fatal, jogo nao inicializado.");
            return false;
        }

        //get kingdoms
        System.out.println(nKingdoms + " reinos:");
        kingdoms = new kingdomCollection();

        for (int i = 0; i < nKingdoms; i++) {
            String name = sc.next();
            String castleID = sc.nextLine().replaceFirst(" ", "");

            if (kingdoms.checkIfKingdomExists(name)) {
                System.out.println("Os reinos nao podem ter nomes duplicados.");
            } else if (castles.getCastle(castleID) == null) {
                System.out.println("O castelo nao existe.");
            } else if (!castles.getCastle(castleID).getCurrentOwner().equals("sem dono")) {
                System.out.println("O castelo ja esta ocupado.");
            } else {
                Kingdom tempKingdom = new Kingdom(name);
                Castle tempCastle = castles.getCastle(castleID);
                tempKingdom.addCastle(tempCastle);
                kingdoms.addKingdom(tempKingdom);
            }
        }

        //validate number of kingdoms
        if (kingdoms.nKingdoms() < 2) {
            System.out.println("Numero insuficiente de reinos.");
            System.out.println("Erro fatal, jogo nao inicializado.");
            return false;
        } else {
            System.out.println("Jogo iniciado, comeca o reino " + kingdoms.getCurrentKingdom().getName());
            return true;
        }
    }

    public void giveGameState() {
        System.out.println(String.valueOf(sizeH) + " " + String.valueOf(sizeV));
        System.out.println(String.valueOf(castles.numberOfCastles()) + " castelos:");
        for (Castle castle : castles.getAllCastles()) {
            System.out.println(castle.getName() + " (" + castle.getCurrentOwner() + ")");
        }
        System.out.println(String.valueOf(kingdoms.nKingdoms()) + " reinos:");
        kingdoms.displayKingdoms();
    }
    
    public void displayHelpScreen() {
        System.out.println("novo - Novo jogo");
        if (gameActive) {
            System.out.println("soldado - Move o soldado");
            System.out.println("recruta - Recruta um soldado num castelo");
            System.out.println("mapa - Lista todos os castelos do mapa, incluindo os abandonados, pela ordem de criacao no jogo\n"
                    + "e todos os reinos ainda em jogo, pela ordem de jogada");
            System.out.println("castelos - Lista os castelos do jogador activo, pela ordem pela qual foram conquistados");
            System.out.println("exercito - Lista os soldados vivos do jogador activo, pela ordem de recrutamento");
            System.out.println("reinos - Lista os varios reinos ainda em jogo, ordenados por nome do reino");
        }
        System.out.println("ajuda - Mostra a ajuda");
        System.out.println("sai - Termina a execucao do programa");
    }

    public String getKingdom() {
        return kingdom;
    }

    public void changeKingdom(String newKingdom) {
        kingdom = newKingdom;
    }
}
