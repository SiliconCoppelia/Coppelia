import dimensions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.util.*;


public class Controller {

    // All Strings
    private static final String[] ethics = new String[] {"smiles", "shows an angry face", "cheats"};
    private static final String[] affordance = new String[] {
            "acts fast", "acts slow", "is accurate", "has high IQ score", "has low IQ score"};
    //private static final String[] goal = new String[] {"help you", "be your friend"};
    private static final String[] causalPhrases = new String[] {"So, ", "Therefore, ", "This is why, ",
            "For that reason, ", "Which means that ", "In all, ", "On the whole, "};
    private static final String[] transitions = new String[] {"Even though ", "Though ", "Although ",
            "Despite the fact that ", "Admittedly, "};


    // Required Integers
    private static final int ethicInd = getRandomNumber(0, ethics.length);
    private static final int preference = 0;    //0 for kind person; 1 for bad personality; and 3 for evil ppl
    private static final int affInd = getRandomNumber(0, affordance.length);
    private static final int causalPhrInd = getRandomNumber(0, causalPhrases.length);
    private static final int transitionsInd = getRandomNumber(0, transitions.length);

    // Objects
    private static final Ethics eth = new Ethics(ethicInd, Math.random());
    private static Relevance ethRel;
    private static Valence ethVal;

    // Responses and final Sentence Construction
    private static final List<String> Responses = new ArrayList<String>();
    private static final StringBuffer response = new StringBuffer("");

    public static void main(String[] args){

        File output = new File("output.txt");

        System.out.println("Hi, I'm Coppélia.\n");

        //Determine Ethics Relevance and Valence
        if(ethicInd == preference){
            //ethRel = new Relevance(0.1 * getRandomNumber(5, 10), goal[getRandomNumber(0, 2)]);
            ethRel = new Relevance(0.1 * getRandomNumber(5, 10), getRandomNumber(0, 2));
            ethVal = new Valence(0.1 * getRandomNumber(5, 10));
        }
        else{
            //ethRel = new Relevance(Math.random(), goal[getRandomNumber(0, 2)]);
            ethRel = new Relevance(Math.random(), getRandomNumber(0, 2));
            if(ethRel.relevance > 0.5){
                ethVal = new Valence(0.1 * getRandomNumber(0, 5));
            }
            else{
                ethVal = new Valence(0.1 * getRandomNumber(5, 10));
            }
        }

        Responses.add("** Agency " + ethics[ethicInd] + " **");
        Responses.add("** Coppélia wishes to " + ethRel.chooseGoal() + " **");     // Make goal explicit
        Responses.add(eth.getObservation());    // Ethics Observation
        Responses.add(eth.getAssessment());     // Ethics Assessment
        Responses.add(ethRel.getRelevance());   // Determine the Relevance
        Responses.add(ethVal.getValence());     // Determine the Valence

        //storeOutput(output, Responses);
        sentenceFormulation();

        System.exit(0);
    }

    private static int getRandomNumber(int min, int max) {
        /*
            https://www.freecodecamp.org/news/generate-random-numbers-java/
            https://www.baeldung.com/java-generating-random-numbers-in-range
            Java Random int -> Greater or equal to 0 and Less than 1
            The max should not be length - 1, or it will never reach the largest
        */
        return (int)((Math.random() * (max - min)) + min);
    }

    private static void storeOutput(File file, List<String> str){
        // Reference: https://www.journaldev.com/881/java-append-to-file
        try {
            FileWriter write = new FileWriter(file, true);
            for (String s : str) {
                write.write(s + "\n");
                System.out.println(s);
            }
            write.write("\n");
            write.close();
        } catch (IOException e) {
            System.out.println("Fail to write to file");
            e.printStackTrace();
        }
    }

    private static void sentenceFormulation(){
        response.append(Responses.get(0)).append("\n");      // Append Agency Features
        response.append(Responses.get(1)).append("\n");      // Append Coppélia goal
        response.append(Responses.get(2)).append("\n");      // Append Ethics Observation

        // Append Ethics Assessment
        if(eth.ethics > 0.5 && ethRel.relevance > 0.5){
            response.append(Responses.get(3)).append("\n").append(causalPhrases[causalPhrInd]).append(Responses.get(4)).append("\n");
        }
        else if(eth.ethics > 0.5 && ethRel.relevance < 0.5){
            response.append(transitions[transitionsInd]).append(Responses.get(3)).append("\n");
            if(transitionsInd == 4){
                response.append("but ").append(Responses.get(4)).append("\n");
            }
            else{
                response.append(Responses.get(4)).append("\n");
            }
        }
        else if(eth.ethics < 0.5 && ethRel.relevance < 0.5){
            response.append(Responses.get(3)).append("\n").append("but ").append(Responses.get(4)).append("\n");
        }
        else{
            response.append(Responses.get(3)).append("\n").append(Responses.get(4)).append("\n");
        }

        //Valence: The current setting assumes Coppélia prefers a kind personality
        response.append(Responses.get(5));

        //Add Similarity
        //response.append(Responses.get(6));

        System.out.println(response.toString());
    }
}
