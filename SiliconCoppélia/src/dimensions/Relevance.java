package dimensions;
import generateRelated.*;
/**
 * @Author Yooki ZHANG
 * @Date 15/7/2022
 * @Description:
 */
//import java.util.Scanner;

public class Relevance {

    private double relevance;
    private int goalIndex;
    private String relStr;
    private String preposition;
    private String str;//the final out string
    private String[] personVerbStr={"think","find"};
    private String[] relevanceStr={"irrelevant","has little to do","trivial with respect to my concern","beside the point of","relevant","important","essential","critical"};

    private String[][][] goalStr={
            {//goalIndex=1
                    {"be friends", "being friends"},
                    {"be your friend", "being your friend"},
                    {"be friends with you", "being friends with you"},
                    {"become friend", "becoming friend"},
                    {"become your friend", "becoming your friend"},
                    {"become friend with you", "becoming friend with you"}
            },

            {//goal=2
                    {"help you", "helping you"}
            }
    };

    private String[] degreeStr={"quite", "rather", "tremendously", "very", "totally", "enormously"};
    private String[] modalParticle={"trust me", "believe me", "really"};

    public Relevance(double RELEVANCE, int goal){//1 for help, 2 for make friends
        this.relevance=RELEVANCE;
        this.goalIndex=goal;
        this.relStr=chooseRelevance();
        this.generate();
    }

    private void setPreposition(String preposition){
        this.preposition=preposition;
    }
    private String getPreposition(){
        return this.preposition;
    }

    private String chooseRelevance(){
        GenarateSentenceTool genarateSentenceTool=new GenarateSentenceTool();
        SentenceComponents sentenceComponents=new SentenceComponents();
        String finalRel;
        int random;
        if(this.relevance<0.5){
            if(this.relevance<0.125){
                random=genarateSentenceTool.randomInt(0,3);
                if(random==1){
                    finalRel=relevanceStr[random];
                }
                else{
                    finalRel=sentenceComponents.concatTheSentence(degreeStr[genarateSentenceTool.randomInt(4,5)],relevanceStr[random]);
                }
            }
            else if(this.relevance<0.25){
                random=genarateSentenceTool.randomInt(0,3);
                if(random==1){
                    finalRel=relevanceStr[random];
                }
                else{
                    finalRel=sentenceComponents.concatTheSentence(degreeStr[genarateSentenceTool.randomInt(2,3)],relevanceStr[random]);
                }
            }
            else if(this.relevance<0.375){
                finalRel=relevanceStr[genarateSentenceTool.randomInt(0,3)];
            }
            else{
                random=genarateSentenceTool.randomInt(0,3);
                if(random==1){
                    finalRel=relevanceStr[random];
                }
                else{
                    finalRel=sentenceComponents.concatTheSentence(degreeStr[genarateSentenceTool.randomInt(0,1)],relevanceStr[random]);
                }
            }
        }
        else{
            if(this.relevance<0.625){
                finalRel=sentenceComponents.concatTheSentence(degreeStr[genarateSentenceTool.randomInt(0,1)],relevanceStr[genarateSentenceTool.randomInt(4,7)]);
            }
            else if(this.relevance<0.75){
                finalRel=relevanceStr[genarateSentenceTool.randomInt(4,7)];
            }
            else if(this.relevance<0.875){
                finalRel=sentenceComponents.concatTheSentence(degreeStr[genarateSentenceTool.randomInt(2,3)],relevanceStr[genarateSentenceTool.randomInt(4,7)]);
            }
            else{
                finalRel=sentenceComponents.concatTheSentence(degreeStr[genarateSentenceTool.randomInt(4,5)],relevanceStr[genarateSentenceTool.randomInt(4,7)]);
            }
        }
        return finalRel;
    }

    public String chooseGoal(boolean isExternal){
        GenarateSentenceTool genarateSentenceTool=new GenarateSentenceTool();
        if(isExternal){
            if(this.goalIndex==1){
                return goalStr[0][genarateSentenceTool.randomInt(0,5)][0];
            }
            else{
                return goalStr[1][0][0];
            }
        }
        else{
            if(this.goalIndex==1){
                if(this.relStr.contains("has little to do")){
                    setPreposition("with");
                    return goalStr[0][genarateSentenceTool.randomInt(0,5)][1];
                }
                else if(this.relStr.contains("relevant")){
                    setPreposition("for");
                    return goalStr[0][genarateSentenceTool.randomInt(0,5)][1];
                }
                else{
                    this.preposition="to";
                    return goalStr[0][genarateSentenceTool.randomInt(0,5)][0];
                }
            }

            else{
                if(this.relStr.contains("has little to do")){
                    setPreposition("with");
                    return goalStr[1][0][1];
                }
                else if(this.relStr.contains("relevant")){
                    setPreposition("for");
                    return goalStr[1][0][1];
                }
                else{
                    this.preposition="to";
                    return goalStr[1][0][0];
                }
            }
        }
    }

    private void generate(){
        SentenceComponents sentenceComponents=new SentenceComponents();
        GenarateSentenceTool genarateSentenceTool=new GenarateSentenceTool();


        //choose it/this/that
        int random = genarateSentenceTool.randomInt(1,3);
        Pronouns pronouns= Pronouns.THIS;
        switch (random){
            case 1:
                pronouns= Pronouns.THIRD_PERSON_O;
            case 2:
                pronouns= Pronouns.THIS;
            case 3:
                pronouns= Pronouns.THAT;
            default:
                pronouns= Pronouns.THIRD_PERSON_O;
        }


        String goal=this.chooseGoal(false);
        //generate the most basic sentence
        if(this.relStr.contains("has little to do")){
            this.str=sentenceComponents.SVO(pronouns, sentenceComponents.concatTheSentence(this.relStr, getPreposition()), goal);
        }
        else{
            this.str=sentenceComponents.itBeAdj(pronouns, this.relStr, getPreposition(), goal);
        }


        // choose basic(It is ...) / complex sentence(I think it...)
        if(genarateSentenceTool.randomInt(0, 1)==1){
            this.str=sentenceComponents.SVO(Pronouns.FIRST_PERSON, personVerbStr[genarateSentenceTool.randomInt(0,1)], this.str);
        }

        //choose if add the modal particle
        int add=genarateSentenceTool.randomInt(0,1);
        if(add==1){
            this.str=genarateSentenceTool.addPunctuation(1,this.str);
            this.str+=" "+modalParticle[genarateSentenceTool.randomInt(0, 2)];
            //upwriting the first letter
            this.str=genarateSentenceTool.upperWritingFirstLetter(this.str);
            this.str=genarateSentenceTool.addPunctuation(4,this.str);
        }
        else{
            //upwriting the first letter
            this.str=genarateSentenceTool.upperWritingFirstLetter(this.str);
            this.str=genarateSentenceTool.addPunctuation(2,this.str);
        }


    }

    public String getRelevance(){
        return this.str+" ("+this.relevance+")";
    }

    public double getter(){
        return this.relevance;
    }
}