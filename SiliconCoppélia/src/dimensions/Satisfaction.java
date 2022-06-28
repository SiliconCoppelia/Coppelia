package dimensions;

public class Satisfaction {

    private String[] SatisfactionStr={
            "No. You’re a total failure / I think you are a loser",
            "I must say, I am pretty displeased about you / You are a big disappointment / I really dislike you",
            "Actually, I feel quite dissatisfied with you / Your performance is weak",
            "All of this is quite mediocre don’t you think?",
            "I think you’re doing so-so",
            "I believe you could do better / I believe you can be better than this",

            "You’re not half bad",
            "You’re doing fine I guess",
            "I think you are Okay / I quite like you",
            "I truly appreciate you / I really like you / I thank you so much!",
            "I am so happy with you / You make me happy!",
            "I am totally satisfied with you / You are awesome! / You are absolutely great!"
    };
    private int index;
    private double num;

    public Satisfaction(double SATISFACTION){
        this.num=SATISFACTION;
        //this.goal=goal;
    }

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

    public String getSatisfaction() {
        return grammerly();

        /*if(this.num>0.5){
            return useIntentionPositive[(int)((this.num-0.5)*2.5)];
        }
        else{
            return useIntentionNegative[(int)(this.num*2.5)];
        }*/

    }
}
