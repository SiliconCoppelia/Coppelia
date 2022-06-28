package dimensions;

//import java.util.Scanner;

import javax.swing.*;

public class Valence{
    private float ETHICS;
    private int[] valOfFeatures = new int[4]; // result
    private String[] Level = {"", "", "", ""};
    private int[] affordanceFeatures; // used in constructor

    //add 2022/6/27
    private int num;

    public Valence(float ETHICS, int[] affordanceFeatures){
        this.ETHICS = ETHICS;
        this.affordanceFeatures = affordanceFeatures;
    }

    private String[] valenceStr={
            "Due to that, helping you being friends will lead to nothing but trouble /  Due to that, helping us being friends will lead to nothing but trouble",
            "So I’m sorry to say, but I just know this won’t work between us",
            "That makes me fear I cannot help you / That makes me fear we will not get along",
            "Because of that, I have little expectations what will come out of this",
            "Therefore, we should not get our hopes up high, I’m afraid",
            "So maybe things won’t go too well",

            "So I take it we will be Okay",
            "I expect we will be fine/ I expect it will go well",
            "That gives me good hope that I can help you / That gives me good hope that we will get along.",
            "I am looking forward to what will come from this.",
            "My hopes are high we will be fine together.",
            "I have the feeling it will go extremely well between us.",
    };

    private String grammerly(){
        String out=valenceStr[(int)(this.num*12)-1];
        if(out.contains("/")){
            String[] sentences=new String[5];
            sentences=out.split("/");
            int count=0;
            int index=0;
            while((index=out.indexOf("/",index))!=-1){
                index = index+1;
                count++;
            }
            int random=(int)(Math.random() * (count-1));
            return sentences[random];
        }
        return out;
    }

    public String getValence() {
        return grammerly();
    }

    /*
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
        return Level;
    }*/


}
