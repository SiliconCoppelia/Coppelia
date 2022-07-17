package dimensions;

//import java.util.Scanner;

/**
 * @Author Yooki ZHANG
 * @Date 15/7/2022
 * @Description:
 */

import generateRelated.GenarateSentenceTool;
import generateRelated.SentenceComponents;

import javax.swing.*;

public class Valence{
    private double valence;
    public String str;
    public String valStr;
    //private final String[] positiveVerbStr={"expect","have the feeling","am looking forward to"};
    //private final String[] negativeVerbStr={"am afraid","have little expectations","am looking forward to"};

    public String[] objectiveStr={
            "what will come out of this",
            "what will come from this",
            "it will get along",
            "it will get fun",
    };

    public String[] valenceStr={};

    public String[] reasonStr={"so","because of that","therefore","due to that"};
    public String[] personVerbStr={"fear","am afraid of", "have little expectations","expect","have expectations","have the feeling","am looking forward to"};
    public String[] degreeStr={"some", "quite", "rather", "tremendously", "very", "totally", "enormously"};

    public Valence(double ethics){
        this.valence = ethics;
        this.valStr = chooseValence();
    }

    public String chooseValence(){
        GenarateSentenceTool genarateSentenceTool=new GenarateSentenceTool();
        SentenceComponents sentenceComponents=new SentenceComponents();
        String finalRel;

        //negative
        if(this.valence<0.5){
            finalRel=personVerbStr[0];
        }

        //positive
        else{
            finalRel=personVerbStr[1];
        }
        return finalRel;
    }

    public void generate(){

    }

    public String getValence(){
        return this.str;
    }

}
