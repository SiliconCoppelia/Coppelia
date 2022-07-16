package dimensions;

public class SelectAction {
    private float num;
    private String level;

    public String[] stayStill = {
            "Stop. I won’t move a finger",
            "I will do nothing",
            "I don’t think any action is required",
            "Let’s wait, see how things develop",
            "Let’s see what happens / Please, let it rest / let it be",
            "Take it easy. No worries. Relax!"
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
            "Please, get out of my way / stay away from me",
            "I will leave (the conversation) now",
            "Can we change the subject, please?",
            "Shall we maybe not talk about that? / Sometimes, it is best to look away / to close our eyes",
            "Please, I don’t want to talk about it"

};

    public String[] positiveApproach = {
            "Give me a kiss!",
            "Give me a hug!",
            "You deserve a pat on the back",
            "Let’s shake hands",
            "I send you beautiful wishes /* also, print an emoticon: , <3, thumbs up */",
            "I congratulate you with your achievement /* when related to helping */",
            "I compliment you on your social skills /* when related to friendship */"
    };

    public String[] negativeApproach = {
            "I would like to slap you in the face",
            "You should be punished for that",
            "I wish ill on you /* also, print an emoticon: , turd, thumbs down */",
            "I oppose you for your faults",
            "I criticize you for such poor performance /* when related to helping */",
            "I criticize you for the person that you are /* when related to friendship */",
            "I disapprove of your behavior / your attitude / You can expect my negative review / evaluation",
            "I feel like arguing with you"
    };

    public String[] negativeActWord ={"oppose","criticise","disapprove"};





    public String getSelectAction() {
        //对应前面那版本文档，暂时没想到怎么实现这一部分。
        //private String[];
        return null;
    }
}
