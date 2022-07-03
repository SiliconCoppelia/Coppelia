import dimensions.*;

import java.lang.*;


public class Controller {

    private static final String[] ethics = new String[] {"smiles", "shows an angry face", "cheats"};
    private static final String[] affordance = new String[] {
            "acts fast", "acts slow", "is accurate", "has high IQ score", "has low IQ score"};
    private static final String[] goal = new String[] {"help you", "be your friend"};

    public static void main(String[] args){

        System.out.println("Hi, I'm Coppélia.\n");

        /*
            https://www.freecodecamp.org/news/generate-random-numbers-java/
            https://www.baeldung.com/java-generating-random-numbers-in-range
            Java Random int -> Greater or equal to 0 and Less than 1
            The max should not be length - 1, or it will never reach the largest
        */
        int ethicInd = getRandomNumber(0, ethics.length);
        int affInd = getRandomNumber(0, affordance.length);
        System.out.println("** Agency " + ethics[ethicInd] + " **");

        Ethics eth = new Ethics(ethicInd, Math.random());
        Relevance ethRel = new Relevance(Math.random(), goal[getRandomNumber(0, 2)]);
        Valence ethVal = new Valence(Math.random());


        // Step 4: sentence formulation
        System.out.println(eth.getObservation());
        System.out.println(eth.getAssessment());
        System.out.println(ethRel.getRelevance());
        System.out.println(ethVal.getValence());

        System.exit(0);
    }

    private static int getRandomNumber(int min, int max) {
        return (int)((Math.random() * (max - min)) + min);
    }
}
