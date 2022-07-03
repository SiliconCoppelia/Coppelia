package dimensions;

//import java.util.Scanner;

import javax.swing.*;

public class Valence{

    //add 2022/6/27
    private double valence;

    public Valence(double valence){
        this.valence=valence;
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
        String out=valenceStr[scaleToStr()];
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

    private int scaleToStr() {
        int index = 0;
        for(int i = 1; i <= 12; i++){
            double x = i / (double)12;
            if(x > this.valence){
                index = i - 1;
                break;
            }
        }
        return index;
    }

    public String getValence() {
        return grammerly();
    }

}
