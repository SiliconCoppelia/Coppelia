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
    private static int num = 0;
    private static int index = 0;
    private static String[] features = {"a friendly appearance ", "a young age ", "a wealthy income status ", "keeping one or two pets "};
    private static String[] valence = {"Your appearance ", "Your age ", "Your income status ", "The number of pets you have "};

    private static StringBuffer sent1 = new StringBuffer("You are ");               // Ethics and Affordances
    private static StringBuffer sent2 = new StringBuffer("I find ");                // Relevance: What is important and what is not
    private static StringBuffer sent3 = new StringBuffer("");                       // Valence: hope/fear a pos/neg outcome
    private static StringBuffer sent4 = new StringBuffer("Therefore, ");            // Involvement and Distance

    public static void main(String[] args) throws Exception {

        // Step 1: greetings from Coppélia
        System.out.println("Hi, I'm Coppélia.\n");

        // Step 2: Random generate Agent feature (Ethics and Affordances)
        usrIntro();

        // Step 3: Create all object and pass parameters for processing
        Random rd = new Random(); ETHICS = rd.nextFloat(); Ethics eth = new Ethics(ETHICS); // Random Ethics
        Affordance aff = new Affordance(affordanceFeatures);
        Valence val = new Valence(ETHICS, affordanceFeatures);
        // feature-1: ethics   feature-2: age  feature-3: income  feature-4: pet
        // For Users: All relevance can be changed here
        Relevance[] rel = {new Relevance(0.657), new Relevance(0.9), new Relevance(0.312), new Relevance(0.76)};
        Involvement invl = new Involvement(ETHICS, aff.convert(affordanceFeatures[0], 0), aff.convert(affordanceFeatures[1], 1), aff.convert(affordanceFeatures[2], 2),  0.75,  0.4);
        Distance dist = new Distance(ETHICS, aff.convert(affordanceFeatures[0], 0), aff.convert(affordanceFeatures[1], 1), aff.convert(affordanceFeatures[2], 2),  0.25,  0.4);
        UseIntention useInt = new UseIntention(ETHICS, aff.convert(affordanceFeatures[0], 0), aff.convert(affordanceFeatures[1], 1), aff.convert(affordanceFeatures[2], 2));

        // Step 4: sentence formulation

        System.exit(0);
    }

    /* ----------------------------------------------------------------------------------------------------------------------------------------------- */
    /* ----------------------------------------------------------------------------------------------------------------------------------------------- */
    /* ----------------------------------------------------------------------------------------------------------------------------------------------- */

    private static void usrIntro(){
        
    }
}
