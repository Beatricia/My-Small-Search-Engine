
package mysmallsearchengine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FORGE-15 I7 Haitham
 */
public class MySmallSearchEngine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Googol!");
        String s = in.nextLine();
        String keyword="";
        char key = s.charAt(0);
        if(s.length()>1)
            keyword = s.substring(2);
        switch (key) {
            case 'c':
            case 'C':
                Calculator c = new Calculator();
                break;
            case 't':
            case 'T':    
                TicTacToe t = new TicTacToe();
                break;
            case 'x':
            case 'X':    
                new My_Currency_Converter().setVisible(true);
                break;
            case 's':
            case 'S':
//                To do GUI
                search(keyword);
                break;
                 case 'M':
            case 'm':
                MainForGraphics1 miniGame = new MainForGraphics1();
                break; 
            case 'd':
                new Dice().setVisible(true);
                break;
            default:
                System.out.println("You entered invalid inquiry");
                }
        }

    private static void search(String k) {

        FileReader fr = null;
        try {
            String fileName = "topSites.csv";
            File file = new File(fileName);
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int i = 1;
            try {
                while ((line = br.readLine()) != null) {
                    
                    String[] data = line.split(",\"");
                    String[] info = data[0].split(",");
                    if (info[0].charAt(0) == 'h') {
                        if(line.toLowerCase().contains(k.toLowerCase())){
                            System.out.println(i + ". " + info[0]);
                            i++;
                        }
                    }
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(MySmallSearchEngine.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MySmallSearchEngine.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(MySmallSearchEngine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
