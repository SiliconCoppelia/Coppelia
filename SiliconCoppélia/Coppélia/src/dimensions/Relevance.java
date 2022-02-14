package dimensions;

//import java.util.Scanner;
//

public class Relevance {

    private int index;
    private float num;
    private String level;
    //private String[] rel=new String[]{"cheat on exams","cooking for home"};
    public double relevance;

    public Relevance(double RELEVANCE){
        this.relevance=RELEVANCE;
    }


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
    }
}