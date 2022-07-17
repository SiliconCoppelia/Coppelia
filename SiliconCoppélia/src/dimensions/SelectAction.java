package dimensions;

import generateRelated.GenarateSentenceTool;
import generateRelated.SentenceComponents;

/**
 * @Author Yooki ZHANG
 * @Date 15/7/2022
 * @Description:
 */

//The sentence component in this class is too complicated to implement the method
public class SelectAction {
    private float num;
    private double actTendency;
    private String str;
    private int goal;

    public SelectAction(double actTendency, int goal){
        this.actTendency=actTendency;
        this.goal=goal;
        this.generate();
    }

    public String[] stayStill = {
            "Stop. I won’t move a finger",
            "I will do nothing",
            "I don’t think any action is required",
            "Let’s wait, see how things develop",
            "Let’s see what happens ",
            "Please, let it rest",
            "Please, let it be",
            "Take it easy. No worries. Relax"
    };

    public String[] change = {
            "Really, this is not the way. Please follow my lead",
            "Take notice. I will teach you a lesson",
            "Let me tell you how to do it well this time",
            "Please do after me",
            "I will show you how to do it",
            "Look how I am doing it"
    };

    public String[] avoid = {
            "I am out of here",
            "Please, get out of my way",
            "Please, stay away from me",
            "I will leave the conversation now",
            "Can we change the subject, please?",
            "Shall we maybe not talk about that?",
            "Sometimes, it is best to look away",
            "Sometimes, it is best to close our eyes",
            "Please, I don’t want to talk about it"

};

    public String[] positiveApproach = {
            "Give me a kiss!",
            "Give me a hug!",
            "You deserve a pat on the back",
            "Let’s shake hands",
            "I send you beautiful wishes",
            "I congratulate you with your achievement", /* when related to helping */
            "I compliment you on your social skills"/* when related to friendship */
    };

    public String[] negativeApproach = {
            "I would like to slap you in the face",
            "You should be punished for that",
            "I wish ill on you",
            "I oppose you for your faults",
            "I criticize you for such poor performance", /* when related to helping */
            "I criticize you for the person that you are",/* when related to friendship */
            "I disapprove of your behavior",
            "I disapprove of your attitude",
            "You can expect my negative review",
            "You can expect my negative evaluation",
            "I feel like arguing with you"
    };

    public void generate(){

        GenarateSentenceTool genarateSentenceTool=new GenarateSentenceTool();
        SentenceComponents sentenceComponents=new SentenceComponents();

        if(this.actTendency<0.2){
            this.str=negativeApproach[genarateSentenceTool.randomInt(0,10)];
        }
        else if(this.actTendency<0.4){
            this.str=avoid[genarateSentenceTool.randomInt(0,8)];
        }
        else if(this.actTendency<0.6){
            this.str=stayStill[genarateSentenceTool.randomInt(0,7)];
        }
        else if(this.actTendency<0.8){
            this.str=change[genarateSentenceTool.randomInt(0,5)];
        }
        else{
            this.str=positiveApproach[genarateSentenceTool.randomInt(0,6)];
        }
        if(this.str.endsWith("?")){
            this.str=genarateSentenceTool.addPunctuation(4,this.str);
        }

    }


    public String getSelectAction() {
        return this.str;
    }
}
