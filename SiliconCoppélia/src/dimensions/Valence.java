package dimensions;

//import java.util.Scanner;

/**
 * @Author Yooki ZHANG
 * @Date 15/7/2022
 * @Description:
 */

import generateRelated.*;

import javax.swing.*;

public class Valence{
    private double valence;
    public String str;
    public String valStr;

    public String[] objectiveStr={
            "it will lead to nothing but trouble",
            "things won't go well",
            "we will not get along",
            "I cannot help you",
            "what will come out of this",
            "what will come from this",
            "it will get along",
            "it will get fun",
            "we will get along",
            "we will be OK",
    };

    //public String[] valenceStr={};

    public String[] reasonStr={"so","because of that","therefore","due to that","I am sorry to say"};
    public String[] personVerbStr={"fear","am afraid of","just know","have no expectation", "have little expectations","expect","have expectations","take it","have the feeling","am looking forward to"};
    public String[] degreeStr={ "tremendously", "totally","extremely", "enormously"};

    public Valence(double ethics){
        this.valence = ethics;
        this.generate();
        //this.valStr = chooseValence();
    }

    /*
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
*/
    public void generate(){
        GenarateSentenceTool genarateSentenceTool=new GenarateSentenceTool();
        SentenceComponents sentenceComponents=new SentenceComponents();

        //String goal=this.chooseGoal();


        if(this.valence<0.5){
            //generate the most basic sentence
            String personVerb=personVerbStr[genarateSentenceTool.randomInt(0,4)];
            String objective;
            if(personVerb.indexOf("expectation")>=0){
                objective=objectiveStr[genarateSentenceTool.randomInt(4,5)];
            }
            else{
                objective=objectiveStr[genarateSentenceTool.randomInt(0,3)];
            }
            this.str=sentenceComponents.SVO(Pronouns.FIRST_PERSON,personVerb,objective);
            //adding the degree
            if(this.valence<0.25){
                this.str=sentenceComponents.concatTheSentence(this.str,degreeStr[genarateSentenceTool.randomInt(0,3)]);
            }

            sentenceComponents.concatTheSentence(genarateSentenceTool.addPunctuation(1,reasonStr[genarateSentenceTool.randomInt(0,4)]),this.str);

        }
        else{
            //generate the most basic sentence
            String personVerb=personVerbStr[genarateSentenceTool.randomInt(5,9)];
            String objective;
            if(personVerb.indexOf("expect")>=0){
                objective=objectiveStr[genarateSentenceTool.randomInt(4,5)];
            }
            else{
                objective=objectiveStr[genarateSentenceTool.randomInt(6,9)];
            }
            this.str=sentenceComponents.SVO(Pronouns.FIRST_PERSON,personVerb,objective);
            //adding the degree
            if(this.valence>0.75){
                this.str=sentenceComponents.concatTheSentence(this.str,degreeStr[genarateSentenceTool.randomInt(0,3)]);
            }

            if(genarateSentenceTool.randomInt(0,1)==1){
                sentenceComponents.concatTheSentence(genarateSentenceTool.addPunctuation(1,"so"),this.str);
            }

            this.str=genarateSentenceTool.upperWritingFirstLetter(this.str);
            this.str=genarateSentenceTool.addPunctuation(2,this.str);
        }

    }

    public String getValence(){
        return this.str;
    }

}
