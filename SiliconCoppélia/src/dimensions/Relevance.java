package dimensions;

//import java.util.Scanner;

public class Relevance {

    private double relevance;
    private String goal;//"help you" or "be your friend"
    private final String[] rel=new String[]{
            "This is totally trivial with respect to my concern to",
            "That is beside the point of",
            "That has little to do with",
            "I think it’s irrelevant for",

            "I think it’s relevant for",
            "I find that quite important so to",
            "That is essential for",
            "This is critical to my concern to"
    };

    public Relevance(double RELEVANCE, String goal){
        this.relevance=RELEVANCE;
        this.goal=goal;
    }
    private String grammerly(){
        String out=rel[scaleToStr()];
        if(out.substring(out.lastIndexOf(" ")+1).equals("to")){// ending with "to"
            out+=" "+this.goal+".";
        }
        else{
            int indexAddING=(this.goal.indexOf("be")==0 ? 2 : 4);
            out+=" "+this.goal.substring(0,indexAddING)+"ing"+this.goal.substring(indexAddING)+".";
        }
        return out;
    }

    private int scaleToStr() {
        int index = 0;
        for(int i = 1; i <= 8; i++){
            double x = i / (double)8;
            if(x > this.relevance){
                index = i - 1;
                break;
            }
        }
        return index;
    }

    public String getRelevance(){
        return this.grammerly();
    }

    /*
    public String getLevel(){
        if(relevance<=0.25){
            level="very unimportant";
        }else if(relevance<=0.5){
            level="somewhat unimportant";
        }else if(relevance<=0.75){
            level="somewhat important";
        }else{
            level="very important";
        }
        return level;
    }*/
}