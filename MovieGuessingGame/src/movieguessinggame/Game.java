/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieguessinggame;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fornebra
 */
public class Game {
    int badGuesses = 0; 
    boolean won = false; 
    String randMovie;
    /**
     * Method to pick a movie from the list
     * @return 
     */
    public ArrayList<String> readMovies(){
        ArrayList<String> movies = new ArrayList<>(); 
       
        try {
            Scanner scan = new Scanner(new File("movieList.txt"));
            
            while(scan.hasNextLine()){
                movies.add(scan.nextLine()); 
                
            }      
        } catch (FileNotFoundException e) {
            out.println("A movies file was not found. Please put a file called movieList.txt in your "
                    + "project folder. "); 
        }
        
        return movies; 
        
    }
    
    private String getRandomMovie() {
        ArrayList<String>movies = readMovies();
        int movieIndex = (int)(Math.random()*((movies.size() - 0) + 1)) + 0;  
        return movies.get(movieIndex); 
    }
    
    private String obscureMovie(String movieTitle) {
        return movieTitle.replaceAll("[a-zA-Z]", "_"); 
    }
    
    public String inputLetter() {
        System.out.println("Guess a letter"); 
        Scanner scan = new Scanner(System.in); 
        
        String letter = scan.next().toLowerCase();
        
        if(!letter.matches("[a-z]")){
            out.println("This is not a letter"); 
            return inputLetter();
        }
        
        return letter; 
    }
    
    /**
     * Checks if user guess is in movie title
     * @param movieTitle
     * @param guess
     * @return boolean
     */
    public boolean checkGuess(String movieTitle, String guess){
        return movieTitle.contains(guess); 
    }
    
    public void initGame(){
        String movie = getRandomMovie();
        String wrongLetters;
        String correctLetters; 
        
        String guess = inputLetter();
        
        System.out.println("You are guessing:" + obscureMovie(movie)); 
        
        checkGuess(movie, guess); 
    }
}
