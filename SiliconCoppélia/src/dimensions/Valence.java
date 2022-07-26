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
    private String str;
    private String valStr;

    private String[] objectiveStr={
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

    private String[] reasonStr={"so","because of that","therefore","due to that","I am sorry to say"};
    private String[] personVerbStr={"fear","am afraid of","just know","have no expectation", "have little expectations","expect","have expectations","take it","have the feeling","am looking forward to"};
    private String[] degreeStr={ "tremendously", "totally","extremely", "enormously"};

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
    private void generate(){
        GenarateSentenceTool genarateSentenceTool=new GenarateSentenceTool();
        SentenceComponents sentenceComponents=new SentenceComponents();

        //String goal=this.chooseGoal();


        if(this.valence<0.5){
            //generate the most basic sentence
            this.str=sentenceComponents.concatTheSentence(reasonStr[genarateSentenceTool.randomInt(0,4)]);
            this.str=genarateSentenceTool.addPunctuation(1,this.str);
            String personVerb=personVerbStr[genarateSentenceTool.randomInt(0,4)];
            String objective;
            if(personVerb.contains("expectation")){
                objective=objectiveStr[genarateSentenceTool.randomInt(4,5)];
            }
            else{
                objective=objectiveStr[genarateSentenceTool.randomInt(0,3)];
            }
            this.str=sentenceComponents.concatTheSentence(this.str,sentenceComponents.SVO(Pronouns.FIRST_PERSON,personVerb,objective));
            //adding the degree
            if(this.valence<0.25){
                this.str=sentenceComponents.concatTheSentence(this.str,degreeStr[genarateSentenceTool.randomInt(0,3)]);
            }

        }
        else{
            //generate the most basic sentence
            if(genarateSentenceTool.randomInt(0,1)==1){
                this.str=sentenceComponents.concatTheSentence("so");
                this.str=genarateSentenceTool.addPunctuation(1,this.str);
            }
            String personVerb=personVerbStr[genarateSentenceTool.randomInt(5,9)];
            String objective;
            if(personVerb.contains("expect")){
                objective=objectiveStr[genarateSentenceTool.randomInt(4,5)];
            }
            else if(personVerb.contains("take it")){
                objective=objectiveStr[genarateSentenceTool.randomInt(8,9)];
            }
            else{
                objective=objectiveStr[genarateSentenceTool.randomInt(6,9)];
            }
            if(this.str==null){
                this.str=sentenceComponents.SVO(Pronouns.FIRST_PERSON,personVerb,objective);
            }
            else{
                this.str=sentenceComponents.concatTheSentence(this.str,sentenceComponents.SVO(Pronouns.FIRST_PERSON,personVerb,objective));
            }

            //adding the degree
            if(this.valence>0.75){
                this.str=sentenceComponents.concatTheSentence(this.str,degreeStr[genarateSentenceTool.randomInt(1,3)]);
            }

        }
        this.str=genarateSentenceTool.upperWritingFirstLetter(this.str);
        this.str=genarateSentenceTool.addPunctuation(2,this.str);

    }

    public String getValence(){
        return this.str+" ("+this.valence+")";
    }

}
