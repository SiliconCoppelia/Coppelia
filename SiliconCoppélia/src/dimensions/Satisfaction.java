package dimensions;

import generateRelated.*;
/**
 * @Author Yooki ZHANG
 * @Date 17/7/2022
 * @Description:
 */

public class Satisfaction {

    private double satisfaction;
    private String str;
    private String valStr;

    private String[] objectiveStr={
            //adding degreeStr
            "you're a failure",
            "you are a loser",
            "you a big disappointment",
            "your performance is weak",

            "you're doing so so",
            "it is mediocre",

            //adding "than this"
            "you could do better",
            "you can be better",


            "not half bad",
            "doing fine",
            "OK",

            "making me happy",
            "great",
            "awesome"
    };

    //the simple sentence that do not use the structure of "you are xxx"
    private String[] simpleStr={
            "feel quite dissatisfied with",
            "am pretty displeased with",
            "really dislike",

            //adding levelStr
            "like",
            "appreciate",
            "thank",
            "am satisfied with"
    };

    //public String[] valenceStr={};

    private String[] emotionStr={"no","actually","I must say","great","perfect","excellent"};
    private String[] personVerbStr={"think","believe","guess","know", "feel"};
    //after objective sentence
    private String[] degreeStr={"tremendously", "totally", "extremely", "enormously", "absolutely"};
    //after subjective sentence "I truly/totally..."
    private String[] levelStr={"truly","totally","quite","really"};


    public Satisfaction(double SATISFACTION){
        this.satisfaction=SATISFACTION;
        this.generation();
    }

    private void generation(){
        GenarateSentenceTool genarateSentenceTool=new GenarateSentenceTool();
        SentenceComponents sentenceComponents=new SentenceComponents();
        if(this.satisfaction<0.5){

            //adding emotionalStr
            if(genarateSentenceTool.randomInt(0,1)==1){
                this.str=genarateSentenceTool.addPunctuation(1,emotionStr[genarateSentenceTool.randomInt(0,2)]);
            }

            //choose 3 sentenceStructure from 3 types
            int random=genarateSentenceTool.randomInt(1,3);

            //I xxx you
            if(random==1){
                if(this.str==null){
                    this.str=sentenceComponents.SVO(Pronouns.FIRST_PERSON,simpleStr[genarateSentenceTool.randomInt(0,2)],Pronouns.SECOND_PERSON);
                }
                else{
                    this.str=sentenceComponents.concatTheSentence(this.str,sentenceComponents.SVO(Pronouns.FIRST_PERSON,simpleStr[genarateSentenceTool.randomInt(0,2)],Pronouns.SECOND_PERSON));
                }
            }

            //you are xxx
            else if(random==2){
                String basicSentence;
                if(this.satisfaction<0.125){
                    basicSentence=sentenceComponents.concatTheSentence(degreeStr[genarateSentenceTool.randomInt(0,4)],objectiveStr[genarateSentenceTool.randomInt(0,3)]);

                }
                else if(this.satisfaction<0.25){
                    basicSentence=objectiveStr[genarateSentenceTool.randomInt(0,3)];
                }
                else if(this.satisfaction<0.375){
                    basicSentence=objectiveStr[genarateSentenceTool.randomInt(4,5)];
                }
                else{
                    basicSentence=objectiveStr[genarateSentenceTool.randomInt(6,7)];
                    if(genarateSentenceTool.randomInt(0,1)==1){
                        basicSentence=sentenceComponents.concatTheSentence(basicSentence,"than this");
                    }
                }
                if(this.str==null){
                    this.str=basicSentence;
                }
                else{
                    this.str=sentenceComponents.concatTheSentence(this.str,basicSentence);
                }
            }

            //I think you are xxx
            else{

                if(this.str==null){
                    this.str=sentenceComponents.concatTheSentence(Pronouns.FIRST_PERSON.getSubjectStr(),personVerbStr[genarateSentenceTool.randomInt(0,4)]);
                }
                else{
                    this.str=sentenceComponents.concatTheSentence(this.str,Pronouns.FIRST_PERSON.getSubjectStr(),personVerbStr[genarateSentenceTool.randomInt(0,4)]);
                }

                String basicSentence;
                if(this.satisfaction<0.125){
                    basicSentence=sentenceComponents.concatTheSentence(degreeStr[genarateSentenceTool.randomInt(0,4)],objectiveStr[genarateSentenceTool.randomInt(0,3)]);

                }
                else if(this.satisfaction<0.25){
                    basicSentence=objectiveStr[genarateSentenceTool.randomInt(0,3)];
                }
                else if(this.satisfaction<0.375){
                    basicSentence=objectiveStr[genarateSentenceTool.randomInt(4,5)];
                }
                else{
                    basicSentence=objectiveStr[genarateSentenceTool.randomInt(6,7)];
                    if(genarateSentenceTool.randomInt(0,1)==1){
                        basicSentence=sentenceComponents.concatTheSentence(basicSentence,"than this");
                    }
                }
                this.str=sentenceComponents.concatTheSentence(this.str, basicSentence);
            }
        }

        //>0.5
        else{
            //adding emotionalStr
            if(genarateSentenceTool.randomInt(0,1)==1){
                this.str=genarateSentenceTool.addPunctuation(4,emotionStr[genarateSentenceTool.randomInt(3,5)]);
            }

            //choose 3 sentenceStructure from 3 types
            int random=genarateSentenceTool.randomInt(1,3);

            //I xxx you
            if(random==1){
                String simpleString;

                //adding level string
                if(this.satisfaction>0.75){
                    simpleString= sentenceComponents.concatTheSentence(levelStr[genarateSentenceTool.randomInt(0,3)],simpleStr[genarateSentenceTool.randomInt(3,6)]);
                }
                else{
                    simpleString=simpleStr[genarateSentenceTool.randomInt(3,6)];
                }
                if(this.str==null){
                    this.str=sentenceComponents.SVO(Pronouns.FIRST_PERSON,simpleString,Pronouns.SECOND_PERSON);
                }
                else{
                    this.str=sentenceComponents.concatTheSentence(this.str,genarateSentenceTool.upperWritingFirstLetter(sentenceComponents.SVO(Pronouns.FIRST_PERSON,simpleString,Pronouns.SECOND_PERSON)));
                }

            }

            //you are xxx
            else if(random==2){
                String basicSentence;
                if(this.satisfaction<0.625){
                    basicSentence=objectiveStr[genarateSentenceTool.randomInt(8,10)];
                }
                else if(this.satisfaction<0.75){
                    basicSentence=sentenceComponents.concatTheSentence(degreeStr[genarateSentenceTool.randomInt(0,4)],objectiveStr[genarateSentenceTool.randomInt(8,10)]);
                }
                else if(this.satisfaction<0.875){
                    basicSentence=objectiveStr[genarateSentenceTool.randomInt(11,13)];
                }
                else{
                    basicSentence=sentenceComponents.concatTheSentence(degreeStr[genarateSentenceTool.randomInt(0,4)],objectiveStr[genarateSentenceTool.randomInt(11,13)]);
                }
                if(this.str==null){
                    this.str=sentenceComponents.SVP(Pronouns.SECOND_PERSON,basicSentence);
                }
                else{
                    this.str=sentenceComponents.concatTheSentence(this.str,genarateSentenceTool.upperWritingFirstLetter(sentenceComponents.SVP(Pronouns.SECOND_PERSON,basicSentence)));
                }
            }

            //I think you are xxx
            else{

                if(this.str==null){
                    this.str=sentenceComponents.concatTheSentence(Pronouns.FIRST_PERSON.getSubjectStr(),personVerbStr[genarateSentenceTool.randomInt(0,4)]);
                }
                else{
                    this.str=sentenceComponents.concatTheSentence(this.str,Pronouns.FIRST_PERSON.getSubjectStr(),personVerbStr[genarateSentenceTool.randomInt(0,4)]);
                }

                String basicSentence;
                if(this.satisfaction<0.625){
                    basicSentence=objectiveStr[genarateSentenceTool.randomInt(8,10)];
                }
                else if(this.satisfaction<0.75){
                    basicSentence=sentenceComponents.concatTheSentence(degreeStr[genarateSentenceTool.randomInt(0,4)],objectiveStr[genarateSentenceTool.randomInt(8,10)]);
                }
                else if(this.satisfaction<0.875){
                    basicSentence=objectiveStr[genarateSentenceTool.randomInt(11,13)];
                }
                else{
                    basicSentence=sentenceComponents.concatTheSentence(degreeStr[genarateSentenceTool.randomInt(0,4)],objectiveStr[genarateSentenceTool.randomInt(11,13)]);
                }

                this.str=sentenceComponents.concatTheSentence(this.str, sentenceComponents.SVP(Pronouns.SECOND_PERSON,basicSentence));
            }
        }

        this.str=genarateSentenceTool.upperWritingFirstLetter(this.str);
        this.str=genarateSentenceTool.addPunctuation(2,this.str);
    }
    /*
        private String grammerly(){
            String out=SatisfactionStr[(int)(this.num*12)-1];
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
    */
    public String getSatisfaction() {
        return this.str + " (" + getter() + ") ";
    }
    public double getter(){ return this.satisfaction; }
}

