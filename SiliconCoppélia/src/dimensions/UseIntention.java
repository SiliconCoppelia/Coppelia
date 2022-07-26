package dimensions;

import generateRelated.*;

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
            "it pains me to say that", "sorry","actually","OK","yes","perhaps"
    };
    private String[] degreeStr={"don't","hardly","really"};
    public String[] personVerbStr={
            "have little use", "feel little need to",
            "feel much about", "feel need to", "want to", "feel like", "wish to", "will", "would like to"};
    private String[] againStr={"again","one more time","another time"};
    private String[] singleSentence={
            //negative
            "you have to sort this out yourself",
            "you’re on your own now"
    };

    public String[][][] goalStr={
            {//goalIndex=1
                    {"meet", "meeting"}, {"play with","playing with"}, {"support","supporting"}
            },
            {//goal=2
                    {"help","helping"},{"reach out and lend a helping hand","reaching out and lend a helping hand"},{"assist","assisting"}
            }
    };

    public void generate(){
        GenarateSentenceTool genarateSentenceTool=new GenarateSentenceTool();
        SentenceComponents sentenceComponents=new SentenceComponents();

        if(this.num<0.5){
            //adding feelingStr
            if(genarateSentenceTool.randomInt(0,1)==1){
                this.str=sentenceComponents.concatTheSentence(feelingsStr[genarateSentenceTool.randomInt(0,2)]);
                if(!this.str.contains("pains")){//"sorry" or "actually"
                    this.str=genarateSentenceTool.addPunctuation(1,this.str);
                }
            }
            if(this.num<0.2){
                //use simple sentence
                if(genarateSentenceTool.randomInt(0,1)==1){
                    if(this.str==null){
                        this.str=singleSentence[genarateSentenceTool.randomInt(0,1)];
                    }
                    else{
                        this.str=sentenceComponents.concatTheSentence(this.str,singleSentence[genarateSentenceTool.randomInt(0,1)]);
                    }
                }
                // begin with I don't....
                else{
                    String basicStr=sentenceComponents.concatTheSentence(degreeStr[0],personVerbStr[genarateSentenceTool.randomInt(2,6)]);
                    if(basicStr.contains("about")||basicStr.contains("like")){
                        basicStr=sentenceComponents.concatTheSentence(basicStr,goalStr[this.goal-1][genarateSentenceTool.randomInt(0,2)][1]);
                    }
                    else{
                        basicStr=sentenceComponents.concatTheSentence(basicStr,goalStr[this.goal-1][genarateSentenceTool.randomInt(0,2)][0]);
                    }

                    //adding you or not
                    if(basicStr.contains("reach")){
                        basicStr= sentenceComponents.SV(Pronouns.FIRST_PERSON,basicStr);
                    }
                    else{
                        basicStr= sentenceComponents.SVO(Pronouns.FIRST_PERSON,basicStr,Pronouns.SECOND_PERSON);
                    }

                    if(this.str==null){
                        this.str=basicStr;
                    }
                    else{
                        this.str=sentenceComponents.concatTheSentence(this.str,basicStr);
                    }
                }
            }
            else{//this.num>0.2
                String basicStr=sentenceComponents.concatTheSentence(degreeStr[1],personVerbStr[genarateSentenceTool.randomInt(2,6)]);
                if(basicStr.contains("about")||basicStr.contains("like")){
                    basicStr=sentenceComponents.concatTheSentence(basicStr,goalStr[this.goal-1][genarateSentenceTool.randomInt(0,2)][1]);
                }
                else{
                    basicStr=sentenceComponents.concatTheSentence(basicStr,goalStr[this.goal-1][genarateSentenceTool.randomInt(0,2)][0]);
                }

                //adding you or not
                if(basicStr.contains("reach")){
                    basicStr= sentenceComponents.SV(Pronouns.FIRST_PERSON,basicStr);
                }
                else{
                    basicStr= sentenceComponents.SVO(Pronouns.FIRST_PERSON,basicStr,Pronouns.SECOND_PERSON);
                }

                if(this.str==null){
                    this.str=basicStr;
                }
                else{
                    this.str=sentenceComponents.concatTheSentence(this.str,basicStr);
                }
            }

            if(!this.isFirstTime){
                this.str=sentenceComponents.concatTheSentence(this.str,againStr[genarateSentenceTool.randomInt(0,2)]);
            }
            this.str=genarateSentenceTool.upperWritingFirstLetter(this.str);
            this.str=genarateSentenceTool.addPunctuation(2,this.str);
        }

        else{//this.num>0.5
            //adding feelingStr
            if(genarateSentenceTool.randomInt(0,1)==1){
                this.str=sentenceComponents.concatTheSentence(feelingsStr[genarateSentenceTool.randomInt(3,5)]);
                if(!this.str.contains("perhaps")){//"ok" or "yes"
                    this.str=genarateSentenceTool.addPunctuation(1,this.str);
                }
            }

            if(this.num<0.8){
                String basicStr=personVerbStr[genarateSentenceTool.randomInt(2,6)];
                if(basicStr.contains("about")||basicStr.contains("like")){
                    basicStr=sentenceComponents.concatTheSentence(basicStr,goalStr[this.goal-1][genarateSentenceTool.randomInt(0,2)][1]);
                }
                else{
                    basicStr=sentenceComponents.concatTheSentence(basicStr,goalStr[this.goal-1][genarateSentenceTool.randomInt(0,2)][0]);
                }

                //adding you or not
                if(basicStr.contains("reach")){
                    basicStr= sentenceComponents.SV(Pronouns.FIRST_PERSON,basicStr);
                }
                else{
                    basicStr= sentenceComponents.SVO(Pronouns.FIRST_PERSON,basicStr,Pronouns.SECOND_PERSON);
                }

                if(this.str==null){
                    this.str=basicStr;
                }
                else{
                    this.str=sentenceComponents.concatTheSentence(this.str,basicStr);
                }
            }
            else{//this.num>0.8
                String basicStr=sentenceComponents.concatTheSentence(degreeStr[2],personVerbStr[genarateSentenceTool.randomInt(2,6)]);
                if(basicStr.contains("about")||basicStr.contains("like")){
                    basicStr=sentenceComponents.concatTheSentence(basicStr,goalStr[this.goal-1][genarateSentenceTool.randomInt(0,2)][1]);
                }
                else{
                    basicStr=sentenceComponents.concatTheSentence(basicStr,goalStr[this.goal-1][genarateSentenceTool.randomInt(0,2)][0]);
                }

                //adding you or not
                if(basicStr.contains("reach")){
                    basicStr= sentenceComponents.SV(Pronouns.FIRST_PERSON,basicStr);
                }
                else{
                    basicStr= sentenceComponents.SVO(Pronouns.FIRST_PERSON,basicStr,Pronouns.SECOND_PERSON);
                }

                if(this.str==null){
                    this.str=basicStr;
                }
                else{
                    this.str=sentenceComponents.concatTheSentence(this.str,basicStr);
                }
            }

            if(!this.isFirstTime){
                this.str=sentenceComponents.concatTheSentence(this.str,againStr[genarateSentenceTool.randomInt(0,2)]);
            }
            this.str=genarateSentenceTool.upperWritingFirstLetter(this.str);
            this.str=genarateSentenceTool.addPunctuation(2,this.str);
        }

    }

    public UseIntention(int goal, double userIntention, Boolean isFirstTime){
        this.goal=goal;
        this.num=userIntention;
        this.isFirstTime=isFirstTime;
        this.generate();
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