import dimensions.*;

import java.lang.*;

import static java.lang.Integer.parseInt;

public class Controller {

    private static String[] ethics = {"smiles", "shows an angry face", "cheats"};
    private static String[] affordance = {"acts fast", "acts slow", "is accurate", "has high IQ score", "has low IQ score"};

    private static StringBuffer sent1 = new StringBuffer("You are ");               // Ethics and Affordances
    private static StringBuffer sent2 = new StringBuffer("I find ");                // Relevance: What is important and what is not
    private static StringBuffer sent3 = new StringBuffer("");                       // Valence: hope/fear a pos/neg outcome
    private static StringBuffer sent4 = new StringBuffer("Therefore, ");            // Involvement and Distance

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
        System.out.println("Agency " + ethics[ethicInd]);

        Ethics eth = new Ethics(ethicInd, Math.random());
        Relevance ethRel = new Relevance(Math.random());
        Valence ethVal = new Valence(Math.random());
        Similarity ethSim = new Similarity(Math.random());
        Affordance aff = new Affordance(affInd, Math.random());


        // Step 4: sentence formulation
        System.out.println(eth.getResponse());
        System.out.println(aff.getResponse());

        System.exit(0);
    }

    private static int getRandomNumber(int min, int max) {
        return (int)((Math.random() * (max - min)) + min);
    }
}
