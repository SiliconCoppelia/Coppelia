package dimensions;

//import java.util.Scanner;

public class Affordance{

    private double num;
    private int[] affordanceFeatures;
    private int[] valOfFeatures = new int[3];
    private String[] features = new String[2];
    private String[] age = new String[]{
            "a child",
            "an adolescent",
            "young",
            "mature",
            "old"
    };
    private String[] monthlyIncome = new String[]{
            "poor",
            "relatively poor",
            "well-off",
            "relatively wealthy",
            "wealthy"
    };

    public Affordance(int[] affordanceFeatures){
        this.affordanceFeatures=affordanceFeatures;
    }

    public String[] compare(){
        for(int i = 0; i < this.affordanceFeatures.length - 1; i++){
            switch (i){
                case 0:
                    if(this.affordanceFeatures[i] < 14) features[i] = age [0];
                    else if(this.affordanceFeatures[i] < 21) features[i] = age [1];
                    else if(this.affordanceFeatures[i] < 33) features[i] = age [2];
                    else if(this.affordanceFeatures[i] < 55) features[i] = age [3];
                    else features[i] = age [4];
                    break;
                case 1:
                    if(this.affordanceFeatures[i] < 2000) features[i] = monthlyIncome [0];
                    else if(this.affordanceFeatures[i] < 5000) features[i] = monthlyIncome [1];
                    else if(this.affordanceFeatures[i] < 10000) features[i] = monthlyIncome [2];
                    else if(this.affordanceFeatures[i] < 50000) features[i] = monthlyIncome [3];
                    else features[i] = monthlyIncome [4];
                    break;
            }
        }
        return features;
    }
    public int[] ValOfFeatures(){
        for(int i = 0; i < this.affordanceFeatures.length; i++){
            switch (i){
                case 0:
                    if(this.affordanceFeatures[i] < 14 || this.affordanceFeatures[i] > 55) valOfFeatures[i] = -2;
                    else if(this.affordanceFeatures[i] > 14 && this.affordanceFeatures[i] < 21) valOfFeatures[i] = 1;
                    else if(this.affordanceFeatures[i] > 21 && this.affordanceFeatures[i] < 33) valOfFeatures[i] = 2;
                    else if(this.affordanceFeatures[i] > 33 && this.affordanceFeatures[i] < 55) valOfFeatures[i] = -1;
                    break;
                case 1:
                    if(this.affordanceFeatures[i] < 2000) valOfFeatures[i] = -1;
                    else if(this.affordanceFeatures[i] < 5000) valOfFeatures[i] = -1;
                    else if(this.affordanceFeatures[i] < 10000) valOfFeatures[i] = 1;
                    else if(this.affordanceFeatures[i] < 50000) valOfFeatures[i] = 1;
                    else valOfFeatures[i] = 2;
                    break;
                case 2:
                    if(this.affordanceFeatures[i] == 1 || this.affordanceFeatures[i] == 2) valOfFeatures[i] = 2;
                    else if(this.affordanceFeatures[i] ==0 || this.affordanceFeatures[i] == 3 || this.affordanceFeatures[i] == 4) valOfFeatures[i] = -1;
                    else valOfFeatures[i] = -1;
                    break;
            }
        }
        return valOfFeatures;
    }

    public double convert(int feature, int FEATURES){
        if(FEATURES == 0){
            if(feature < 14 || feature > 55) num = 0;
            else if(feature > 14 && feature < 21) num = 0.75;
            else if(feature > 21 && feature < 33) num = 1;
            else if(feature > 33 && feature < 55) num = 0.25;
        }
        else if(FEATURES == 1){
            if(feature < 2000) num = 0.2;
            else if(feature < 5000) num = 0.4;
            else if(feature < 10000) num = 0.6;
            else if(feature < 50000) num = 0.8;
            else num = 1;
        }
        else if(FEATURES == 2){
            if(feature == 1 || feature == 2) num = 1;
            else if(feature == 3 || feature == 4 || feature == 0) num = 0.75;
            else num = 0.25;
        }
        return num;
    }
}