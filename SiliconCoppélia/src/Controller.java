import dimensions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.util.*;


public class Controller {

    private static final String[] ethics = new String[] {"smiles", "shows an angry face", "cheats"};
    private static final String[] affordance = new String[] {
            "acts fast", "acts slow", "is accurate", "has high IQ score", "has low IQ score"};
    private static final String[] goal = new String[] {"help you", "be your friend"};
    private static final String[] causalPhrases = new String[] {"So, ", "Therefore, ", "This is why, ",
            "For that reason, ", "Which means that ", "In all, ", "On the whole, "};
    private static final List<String> Responses = new ArrayList<String>();
    private static StringBuffer response = new StringBuffer("");

    public static void main(String[] args){

        File output = new File("output.txt");

        System.out.println("Hi, I'm Coppélia.\n");

        /*
            https://www.freecodecamp.org/news/generate-random-numbers-java/
            https://www.baeldung.com/java-generating-random-numbers-in-range
            Java Random int -> Greater or equal to 0 and Less than 1
            The max should not be length - 1, or it will never reach the largest
        */
        int ethicInd = getRandomNumber(0, ethics.length);
        int affInd = getRandomNumber(0, affordance.length);
        Responses.add("** Agency " + ethics[ethicInd] + " **");


        Ethics eth = new Ethics(ethicInd, Math.random());
        Relevance ethRel = new Relevance(Math.random(), goal[getRandomNumber(0, 2)]);
        Valence ethVal = new Valence(Math.random());

        Responses.add("** Coppélia wishes to " + ethRel.getGoal() + " **");     // Make goal explicit
        Responses.add(eth.getObservation());    // Ethics Observation
        Responses.add(eth.getAssessment());     // Ethics Assessment
        Responses.add(ethRel.getRelevance());   // Determine the Relevance
        Responses.add(ethVal.getValence());     // Determine the Valence

        storeOutput(output, Responses);
        //sentenceFormulation();

        System.exit(0);
    }

    private static int getRandomNumber(int min, int max) {
        return (int)((Math.random() * (max - min)) + min);
    }

    private static void storeOutput(File file, List<String> str){
        // Reference: https://www.journaldev.com/881/java-append-to-file
        try {
            FileWriter write = new FileWriter(file, true);
            for(int i = 0; i < str.size(); i++){
                write.write(str.get(i) + "\n");
                System.out.println(str.get(i));
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

        if(){
        }
        response.append(Responses.get(3)).append("\n");      // Append Ethics Assessment
    }
}
