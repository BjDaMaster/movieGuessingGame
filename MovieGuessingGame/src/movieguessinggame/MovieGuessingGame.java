/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieguessinggame;

import java.io.FileNotFoundException;

/**
 *
 * @author fornebra
 */
public class MovieGuessingGame {
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Game movie = new Game();
        movie.pickMovie();
        
        
       
    }
    
}