package dimensions;

import generateRelated.GenarateSentenceTool;
import generateRelated.SentenceComponents;

/**
 * @Author Yooki ZHANG
 * @Date 15/7/2022
 * @Description:
 */

//import java.util.Scanner;

public class UseIntention{

    private String str;
    private int index;
    private double num;
    //private double valenceNum;
    private int goal;
    //private Boolean isAction;
    private Boolean isFirstTime;
    private String[] feelingsStr={
            "it pains me to say that", "sorry, ","actually, ","OK, ","yes, "
    };
    private String[] degreeStr={"hardly","little","really"};
    public String[] personVerbStr={"have use on","feel need to","want to","wish to","will","would like to", "feel like"};
    private String[] againStr={"again","one more time","another time"};

    private final String[] useIntentionStr= {
            "Sorry, I don’t feel like helping you at all / Sorry, you have to sort this out yourself / Sorry, you’re on your own now.",
            "Actually, I don’t want to help you",
            "I hardly feel like reaching out and lend a helping hand",
            "I feel little need to help you on this",
            "I don’t feel much about assisting you",
            "It pains me to say that I have little use helping you on this",

            "Perhaps I will help you but I’m not sure about it",
            "Okay, I will do it for you, I’ll help you out",
            "I could be of some assistance to you if you will",
            "Yes, I wish to assist you / I would like to try to help you",
            "Please let me help you, I would like that",
            "I really really want to support you!",
};
    //private final String[] useIntentionNegative = {};

    public void generate(){
        GenarateSentenceTool genarateSentenceTool=new GenarateSentenceTool();
        SentenceComponents sentenceComponents=new SentenceComponents();


        if(!this.isFirstTime){
            sentenceComponents.concatTheSentence(this.str,againStr[genarateSentenceTool.randomInt(0,2)]);
        }
        this.str=genarateSentenceTool.upperWritingFirstLetter(this.str);
        this.str=genarateSentenceTool.addPunctuation(2,this.str);

    }

    public UseIntention(int goal, Boolean isFirstTime){
        this.goal=goal;
        this.isFirstTime=isFirstTime;
    }

    public String getUseIntention(){
        return this.str;
    }

    /*
    public UseIntention(int goal, Boolean isFirstTime,double ethics, double age, double income, double pet){
        double [][] arr={{ethics,age,income,pet}};
        double weight=(double) 1/(double) 4;
        double [][] B_ui={{weight},{weight},{weight},{weight}};
        MatrixComputation counterIndicative=new MatrixComputation(1,4, arr);
        MatrixComputation userIntention=new MatrixComputation(4,1, B_ui);
        this.num = userIntention.multiple(counterIndicative, userIntention)[0][0];

        //added on 2022/6/25
        this.goal=goal;
        //this.isAction=isAction;
        this.isFirstTime=isFirstTime;


        //System.out.println(str.append("The input number is: ").append(super.readInput()));    //For Debugging
    }

    public String getUseIntention() {
        return this.str;
    }*/

    /*
    public String compare(){
        double i = 0.25;
        while(i < this.num){
            i = i + 0.25;
        }
        if(i <= 0.25) this.index = 0;
        else if(i <= 0.5) this.index = 1;
        else if(i <= 0.75) this.index = 2;
        else if(i <= 1) this.index = 3;
        if(this.valenceNum > 0){
            return this.useIntentionPositive[this.index];
        }
        else{
            return this.useIntentionNegative[this.index];
        }
    }
 */
}