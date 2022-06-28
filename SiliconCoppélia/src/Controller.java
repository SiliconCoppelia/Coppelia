import dimensions.*;

import java.awt.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class Controller {

    private static Scanner scan = new Scanner(System.in);

    private static float ETHICS;
    private static int[] affordanceFeatures = new int[3];

    private static String[] ethics = {"smiles", "shows an angry face", "cheats"};
    private static String[] affordance = {"acts fast", "acts slow", "is accurate", "has low IQ score", "has high IQ score"};

    private static StringBuffer sent1 = new StringBuffer("You are ");               // Ethics and Affordances
    private static StringBuffer sent2 = new StringBuffer("I find ");                // Relevance: What is important and what is not
    private static StringBuffer sent3 = new StringBuffer("");                       // Valence: hope/fear a pos/neg outcome
    private static StringBuffer sent4 = new StringBuffer("Therefore, ");            // Involvement and Distance

    public static void main(String[] args){

        // Step 1: greetings from Coppélia
        System.out.println("Hi, I'm Coppélia.\n");

        // Step 2: Random generate Agent feature (Ethics and Affordances)
        /*
            https://www.freecodecamp.org/news/generate-random-numbers-java/
            https://www.baeldung.com/java-generating-random-numbers-in-range
            Java Random int -> Greater or equal to 0 and Less than 1
            The max should not be length - 1, or it will never reach the largest
        */
        System.out.println("Agency " + ethics[getRandomNumber(0, ethics.length)]);


        // Step 3: Create all object and pass parameters for processing


        // Step 4: sentence formulation

        System.exit(0);
    }

    private static int getRandomNumber(int min, int max) {
        return (int)((Math.random() * (max - min)) + min);
    }
}
