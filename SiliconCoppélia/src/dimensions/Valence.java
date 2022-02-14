package dimensions;

//import java.util.Scanner;

import javax.swing.*;

public class Valence{
    private float ETHICS;
    private int[] valOfFeatures = new int[4]; // result
    private String[] Level = {"", "", "", ""};
    private int[] affordanceFeatures; // used in constructor

    public Valence(float ETHICS, int[] affordanceFeatures){
        this.ETHICS = ETHICS;
        this.affordanceFeatures = affordanceFeatures;
    }

    public int[] ValOfFeatures(){ // convert three affordance features to Level represented by integer
        if(this.ETHICS <= 0.3) valOfFeatures[0] = -2;
        else if(this.ETHICS <= 0.5) valOfFeatures[0] = -1;
        else if(this.ETHICS <= 0.7) valOfFeatures[0] = 1;
        else if(this.ETHICS <= 1) valOfFeatures[0] = 2;

        for(int i = 1; i < this.affordanceFeatures.length + 1; i++){
            switch (i){
                case 1:
                    if(this.affordanceFeatures[i - 1] < 14 || this.affordanceFeatures[i - 1] > 55) valOfFeatures[i] = -2;
                    else if(this.affordanceFeatures[i - 1] > 14 && this.affordanceFeatures[i - 1] < 21) valOfFeatures[i] = 1;
                    else if(this.affordanceFeatures[i - 1] > 21 && this.affordanceFeatures[i - 1] < 33) valOfFeatures[i] = 2;
                    else if(this.affordanceFeatures[i - 1] > 33 && this.affordanceFeatures[i - 1] < 55) valOfFeatures[i] = -1;
                    break;
                case 2:
                    if(this.affordanceFeatures[i - 1] < 2000) valOfFeatures[i] = -2;
                    else if(this.affordanceFeatures[i - 1] < 5000) valOfFeatures[i] = -1;
                    else if(this.affordanceFeatures[i - 1] < 10000) valOfFeatures[i] = 1;
                    else if(this.affordanceFeatures[i - 1] < 50000) valOfFeatures[i] = 1;
                    else valOfFeatures[i] = 2;
                    break;
                case 3:
                    if(this.affordanceFeatures[i - 1] == 1 || this.affordanceFeatures[i - 1] == 2) valOfFeatures[i] = 2;
                    else if(this.affordanceFeatures[i - 1] ==0 || this.affordanceFeatures[i - 1] == 3 || this.affordanceFeatures[i - 1] == 4) valOfFeatures[i] = -1;
                    else valOfFeatures[i] = -2;
                    break;
            }
        }

        return valOfFeatures;
    }

    public String[] getLevel(){

        for(int i = 0; i < ValOfFeatures().length; i++){
            if(this.valOfFeatures[i] == -2){
                Level[i]="much worries";
            }
            else if(this.valOfFeatures[i] == -1){
                Level[i]="some worries";
            }
            else if(this.valOfFeatures[i] == 1){
                Level[i]="some hope";
            }
            else if(this.valOfFeatures[i] == 2){
                Level[i]="much hope";
            }
        }
        /* // For debugging
        for(int i = 0; i < valOfFeatures.length; i++){
            System.out.println(valOfFeatures[i]);
        }
        for(int i = 0; i < Level.length; i++){
            System.out.println(Level[i]);
        }*/
        return Level;
    }


}
