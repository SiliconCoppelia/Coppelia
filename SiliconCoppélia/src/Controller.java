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
        greetings();

        // Step 2: self-introduction from the agent
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
        System.out.println(eth.compare());
        sentenceFormulation(aff, val, rel);     // Ethics, Affordances, Relevance, Valence
        invlNdistFormulation(invl, dist, useInt);    // Involvement, Distance
        System.out.println(sent1.toString()); System.out.println("\n");
        System.out.println(sent2.toString()); System.out.println(sent3.toString()); System.out.println("\n");
        System.out.println(sent4.toString());

        System.exit(0);
    }

/* ----------------------------------------------------------------------------------------------------------------------------------------------- */
/* ----------------------------------------------------------------------------------------------------------------------------------------------- */
/* ----------------------------------------------------------------------------------------------------------------------------------------------- */

    private static void greetings() throws Exception{
        System.out.println("Hi, I'm Coppélia.\nI want to go on a date with you.\n");

        // Currently analyze the agent by prompting self-introduction
    }

    private static void usrIntro(){

        JFrame jFrame = new JFrame(); // https://www.delftstack.com/howto/java/java-pop-up-window/
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //jFrame.setSize(1000,900);
        affordanceFeatures[0] = parseInt(JOptionPane.showInputDialog(jFrame, "What is your age?"));
        affordanceFeatures[1] = parseInt(JOptionPane.showInputDialog(jFrame, "What is your monthly income?"));
        affordanceFeatures[2] = parseInt(JOptionPane.showInputDialog(jFrame, "How many pets do you have?"));
        /*
        System.out.println(getMessage);
        for(int i = 0; i < affordanceFeatures.length; i++){
            System.out.println(affordanceFeatures[i]);
        }
        */
    }

    private static void sentenceFormulation(Affordance aff, Valence val, Relevance[] rel){
        countPos(aff);
        if(num == 3){
            sent1.append("not only ").append(aff.compare()[0]).append(" and ").append(aff.compare()[1]).append(" but also keeping ");
            if(affordanceFeatures[2] == 1) sent1.append(String.valueOf(affordanceFeatures[2])).append(" pet.");
            else sent1.append(String.valueOf(affordanceFeatures[2])).append(" pets.");

            // sent3 num == 3
            // +    +    +
            if(val.ValOfFeatures()[0] > 0 /* Ethics */)sent3.append(valence[0]).append("gives me ").append(val.getLevel()[0]).append(". ");
            if(count2s(aff) == 1){
                // sent3 num == 3
                // 1    1    2
                sent3.append(valence[3]).append("gives me ").append(val.getLevel()[3]).append(" that we will get along very well. ");
                sent3.append(valence[1]).append("and ").append(valence[2].toLowerCase()).append("give me ").append(val.getLevel()[1]).append(" that we will be good. ");
            }
            else if(count2s(aff) == 2){
                if(aff.ValOfFeatures()[0] == 2){
                    // sent3 num == 3
                    // 2    1    2
                    sent3.append(valence[1]).append("and ").append(valence[3].toLowerCase()).append("give me ").append(val.getLevel()[3]).append(" that we will get along very well. ");
                    sent3.append(valence[2]).append("gives me ").append(val.getLevel()[2]).append(" that we will be good. ");
                }
                else if(aff.ValOfFeatures()[1] == 2){
                    // sent3 num == 3
                    // 1    2    2
                    sent3.append(valence[2]).append("and ").append(valence[3].toLowerCase()).append("give me ").append(val.getLevel()[3]).append(" that we will get along very well. ");
                    sent3.append(valence[1]).append("gives me ").append(val.getLevel()[1]).append(" that we will be good. ");
                }
            }
            else{
                // sent3 num == 3
                // 2    2    2
                sent3.append(valence[1]).append(", ").append(valence[2]).append(", and ").append(valence[3].toLowerCase()).append("give me ").append(val.getLevel()[3]).append(" that we will get along very well. ");
            }
            if(val.ValOfFeatures()[0] < 0 /* Ethics */)sent3.append("Yet, ").append(valence[0].toLowerCase()).append("gives me ").append(val.getLevel()[0]).append(" that makes me fear a bad outcome.");
        }
        else if(num == 0){
            sent1.append(aff.compare()[0]).append(", ").append(aff.compare()[1]);
            //System.out.print(affordanceFeatures[2]); // For debugging
            if(affordanceFeatures[2] == 0) sent1.append(", and you don't keep pets.");
            else sent1.append(", and you keep ").append(String.valueOf(affordanceFeatures[2])).append(" pets.");

            // sent3 num == 0
            // -1/-2   -1/-2   -1/-2
            if(val.ValOfFeatures()[0] > 0 /* Ethics */) sent3.append(valence[0]).append("gives me ").append(val.getLevel()[0]).append(". Yet, ");
            else if(val.ValOfFeatures()[0] < 0 /* Ethics */) sent3.append(valence[0]).append("gives me ").append(val.getLevel()[0]).append(". ");
            sent3.append(valence[1]).append("gives me ").append(val.getLevel()[1]).append(", ").append(valence[2].toLowerCase()).append("gives me ").append(val.getLevel()[2]).append(", and ").append(valence[3].toLowerCase()).append("gives me ").append(val.getLevel()[3]);
            sent3.append(" which make me fear a bad outcome");
        }
        else if(num == 2){
            if(negIndex(aff) == 0){
                sent1.append(aff.compare()[1]).append(" and you keep ");
                if(affordanceFeatures[2] == 1) sent1.append(String.valueOf(affordanceFeatures[2])).append(" pet");
                else sent1.append(String.valueOf(affordanceFeatures[2])).append(" pets");
                sent1.append(" but you are ").append(aff.compare()[0]).append(".");

                // sent3 num == 2
                // +    +    -
                if(val.ValOfFeatures()[0] > 0 /* Ethics */)sent3.append(valence[0]).append("gives me ").append(val.getLevel()[0]).append(". ");
                // -1/-2    2    2
                if(aff.ValOfFeatures()[1] == aff.ValOfFeatures()[2]){
                    sent3.append(valence[2]).append("and ").append(valence[3].toLowerCase()).append("give me ").append(val.getLevel()[3]).append(" that we will get along well. ");
                }
                // -1/-2    2    1
                else if(aff.ValOfFeatures()[1] != aff.ValOfFeatures()[2]){
                    sent3.append(valence[2]).append("gives me ").append(val.getLevel()[2]).append(". ");
                    sent3.append(valence[3]).append("gives me ").append(val.getLevel()[3]).append(". ");
                }
                sent3.append("Yet, ").append(valence[1]).append("gives me ").append(val.getLevel()[1]);
                if(val.ValOfFeatures()[0] < 0 /* Ethics */)sent3.append(" and ").append(valence[0].toLowerCase()).append("gives me ").append(val.getLevel()[0]).append(" that make me fear a bad outcome.");
                else sent3.append(" that makes me fear a bad outcome. ");
            }
            else if(negIndex(aff) == 1){
                sent1.append(aff.compare()[0]).append(" and you keep ");
                if(affordanceFeatures[2] == 1) sent1.append(String.valueOf(affordanceFeatures[2])).append(" pet");
                else sent1.append(String.valueOf(affordanceFeatures[2])).append(" pets");
                sent1.append(" but you are ").append(aff.compare()[1]).append(".");

                // sent3 num == 2
                // +    +    -
                if(val.ValOfFeatures()[0] > 0 /* Ethics */)sent3.append(valence[0]).append("gives me ").append(val.getLevel()[0]).append(". ");
                // 2    -1/-2    2
                if(aff.ValOfFeatures()[0] == aff.ValOfFeatures()[2]){
                    sent3.append(valence[1]).append("and ").append(valence[3].toLowerCase()).append("give me ").append(val.getLevel()[3]).append(" that we will get along well. ");
                }
                // 2    -1/-2    1
                else if(aff.ValOfFeatures()[0] != aff.ValOfFeatures()[2]){
                    sent3.append(valence[1]).append("gives me ").append(val.getLevel()[1]).append(". ");
                    sent3.append(valence[3]).append("gives me ").append(val.getLevel()[3]).append(". ");
                }
                sent3.append("Yet, ").append(valence[2]).append("gives me ").append(val.getLevel()[2]);
                if(val.ValOfFeatures()[0] < 0 /* Ethics */)sent3.append(" and ").append(valence[0].toLowerCase()).append("gives me ").append(val.getLevel()[0]).append(" that make me fear a bad outcome.");
                else sent3.append(" that makes me fear a bad outcome. ");
            }
            else if(negIndex(aff) == 2){
                sent1.append(aff.compare()[0]).append(" and ").append(aff.compare()[1]).append(" but you ");
                if(affordanceFeatures[2] == 0) sent1.append("don't keep pets.");
                else sent1.append("keep ").append(String.valueOf(affordanceFeatures[2])).append(" pets.");

                // sent3 num == 2
                // +    +    -
                if(val.ValOfFeatures()[0] > 0 /* Ethics */)sent3.append(valence[0]).append("gives me ").append(val.getLevel()[0]).append(". ");
                // 2        2    -1/-2
                if(aff.ValOfFeatures()[0] == aff.ValOfFeatures()[1]){
                    sent3.append(valence[1]).append("and ").append(valence[2].toLowerCase()).append("give me ").append(val.getLevel()[2]).append(" that we will get along well. ");
                }
                // 1       2    -1/-2
                else if(aff.ValOfFeatures()[0] != aff.ValOfFeatures()[1]){
                    sent3.append(valence[1]).append("gives me ").append(val.getLevel()[1]).append(". ");
                    sent3.append(valence[2]).append("gives me ").append(val.getLevel()[2]).append(". ");
                }
                sent3.append("Yet, ").append(valence[3]).append("gives me ").append(val.getLevel()[3]);
                if(val.ValOfFeatures()[0] < 0 /* Ethics */)sent3.append(" and ").append(valence[0].toLowerCase()).append("gives me ").append(val.getLevel()[0]).append(" that make me fear a bad outcome.");
                else sent3.append(" that makes me fear a bad outcome. ");
            }
        }
        else if(num == 1){
            if(posIndex(aff) == 0){
                sent1.append(aff.compare()[0]).append(" yet you are ").append(aff.compare()[1]).append(" and you ");
                if(affordanceFeatures[2] == 0) sent1.append("don't keep pets.");
                else sent1.append("have ").append(String.valueOf(affordanceFeatures[2])).append(" pets.");

                // sent3 num == 1
                // +    -    -
                if(val.ValOfFeatures()[0] > 0 /* Ethics */)sent3.append(valence[0]).append("gives me ").append(val.getLevel()[0]).append(". ");
                // 2       -1       -1
                if(aff.ValOfFeatures()[1] == aff.ValOfFeatures()[2]){
                    sent3.append(valence[1]).append("gives me ").append(val.getLevel()[1]).append(". ");
                    sent3.append("Yet, ").append(valence[2].toLowerCase()).append("and ").append(valence[3].toLowerCase()).append("give me ").append(val.getLevel()[2]).append(" that make me fear a bad outcome. ");
                }
                // 2       -2       -1
                else if(aff.ValOfFeatures()[1] != aff.ValOfFeatures()[2]){
                    sent3.append(valence[1]).append("gives me ").append(val.getLevel()[1]).append(". ");
                    sent3.append("Yet, ").append(valence[2].toLowerCase()).append("gives me ").append(val.getLevel()[2]).append(" and ").append(valence[3].toLowerCase()).append("gives me ").append(val.getLevel()[3]).append(" that make me fear a bad outcome. ");
                }
                if(val.ValOfFeatures()[0] < 0 /* Ethics */)sent3.append(valence[0]).append("gives me ").append(val.getLevel()[0]).append(" that makes me hesitate.");
            }
            else if(posIndex(aff) == 1){
                sent1.append(aff.compare()[1]).append(" yet you are ").append(aff.compare()[0]).append(" and you ");
                if(affordanceFeatures[2] == 0) sent1.append("don't keep pets.");
                else sent1.append("have ").append(String.valueOf(affordanceFeatures[2])).append(" pets.");

                // sent3 num == 1
                // -    +    -
                if(val.ValOfFeatures()[0] > 0 /* Ethics */)sent3.append(valence[0]).append("gives me ").append(val.getLevel()[0]).append(". ");
                // -1       2       -1
                if(aff.ValOfFeatures()[0] == aff.ValOfFeatures()[2]){
                    sent3.append(valence[2]).append("gives me ").append(val.getLevel()[2]).append(". ");
                    sent3.append("Yet, ").append(valence[1].toLowerCase()).append("and ").append(valence[3].toLowerCase()).append("give me ").append(val.getLevel()[3]).append(" that make me fear a bad outcome. ");
                }
                // -1       2       -2
                else if(aff.ValOfFeatures()[0] != aff.ValOfFeatures()[2]){
                    sent3.append(valence[2]).append("gives me ").append(val.getLevel()[2]).append(". ");
                    sent3.append("Yet, ").append(valence[1].toLowerCase()).append("gives me ").append(val.getLevel()[1]).append(" and ").append(valence[3].toLowerCase()).append("gives me ").append(val.getLevel()[3]).append(" that make me fear a bad outcome. ");
                }
                if(val.ValOfFeatures()[0] < 0 /* Ethics */)sent3.append(valence[0]).append("gives me ").append(val.getLevel()[0]).append(" that makes me hesitate.");
            }
            else if(posIndex(aff) == 2){
                sent1.append(aff.compare()[0]).append(" and ").append(aff.compare()[1]).append(" but you keep ");
                if(affordanceFeatures[2] == 1) sent1.append(String.valueOf(affordanceFeatures[2])).append(" pet.");
                else sent1.append(String.valueOf(affordanceFeatures[2])).append(" pets.");

                // sent3 num == 1
                // -    -    +
                if(val.ValOfFeatures()[0] > 0 /* Ethics */)sent3.append(valence[0]).append("gives me ").append(val.getLevel()[0]).append(". ");
                // -1       -1       2
                if(aff.ValOfFeatures()[0] == aff.ValOfFeatures()[1]){
                    sent3.append(valence[3]).append("gives me ").append(val.getLevel()[3]).append(". ");
                    sent3.append("Yet, ").append(valence[1].toLowerCase()).append("and ").append(valence[2].toLowerCase()).append("give me ").append(val.getLevel()[2]).append(" that make me fear a bad outcome. ");
                }
                // -1       -2       2
                else if(aff.ValOfFeatures()[0] != aff.ValOfFeatures()[1]){
                    sent3.append(valence[3]).append("gives me ").append(val.getLevel()[3]).append(". ");
                    sent3.append("Yet, ").append(valence[1].toLowerCase()).append("gives me ").append(val.getLevel()[1]).append(" and ").append(valence[2].toLowerCase()).append("gives me ").append(val.getLevel()[2]).append(" that make me fear a bad outcome. ");
                }
                if(val.ValOfFeatures()[0] < 0 /* Ethics */)sent3.append(valence[0]).append("gives me ").append(val.getLevel()[0]).append(" that makes me hesitate.");
            }
        }

        // sent2
        num = 0;
        for(int i = 0; i < rel.length; i++){
            if(rel[i].relevance > 0.5){
                num++;
            }
        }
        if(num == 4){sent2.append("not only ").append(features[0]).append(rel[0].getLevel()).append(" and ").append(features[1]).append(rel[1].getLevel()).append(" but also ").append(features[2]).append(rel[2].getLevel()).append(" and ").append(features[3]).append(rel[3].getLevel()).append(".");}
        else if(num == 3){
            for(int i = 0; i < rel.length; i++){
                if(rel[i].relevance < 0.5){index = i; continue;}
                sent2.append(features[i]).append(rel[i].getLevel()).append(", ");
                num--;
                if(num == 1) sent2.append("and ");
            }
            sent2.append("yet ").append(features[index]).append(rel[index].getLevel()).append(".");
        }
        //else if(num == 2){}
        //else if(num == 1){}
        else{sent2.append("not only ").append(features[0]).append(rel[0].getLevel()).append(" and ").append(features[1]).append(rel[1].getLevel()).append(" but also ").append(features[2]).append(rel[2].getLevel()).append(" and ").append(features[3]).append(rel[3].getLevel()).append(".");}
    }

    private static int countPos(Affordance aff){
        num = 0;
        for(int i = 0; i < aff.ValOfFeatures().length; i++){
            if(aff.ValOfFeatures()[i] > 0) num++;
        }
        //System.out.print(num); System.out.println("\n"); // For debugging
        return num;
    }

    private static int posIndex(Affordance aff){
        for(int i = 0; i < aff.ValOfFeatures().length; i++){
            if(aff.ValOfFeatures()[i] > 0) index = i;
        }

        return index;
    }
    private static int negIndex(Affordance aff){
        for(int i = 0; i < aff.ValOfFeatures().length; i++){
            if(aff.ValOfFeatures()[i] < 0) index = i;
        }
        //System.out.print(index); //For debugging

        return index;
    }

    private static int count2s(Affordance aff){
        num = 0;
        for(int i = 0; i < aff.ValOfFeatures().length; i++){
            if(aff.ValOfFeatures()[i] == 2) num++;
        }
        //System.out.print(num); System.out.println("\n"); // For debugging
        return num;
    }

    private static void invlNdistFormulation(Involvement invl, Distance dist, UseIntention useInt){
        sent4.append(invl.getDistance()).append(". Yet, ").append(dist.getDistance()).append(".\n");
        sent4.append(useInt.getUseIntention());
        // aff.convert(affordanceFeatures[i], i)
        // i = 0, 1, 2
    }
}
