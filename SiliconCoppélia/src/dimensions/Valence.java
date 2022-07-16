package dimensions;

//import java.util.Scanner;

/**
 * @Author Yooki ZHANG
 * @Date 15/7/2022
 * @Description:
 */

import javax.swing.*;

public class Valence{
    private final double index;
    public final double valence;
    private final String[] positiveVerbStr={"expect","have the feeling","am looking forward to"};
    private final String[] negativeVerbStr={"am afraid","have little expectations","am looking forward to"};

    public Valence(int index, double ethics){
        this.index = index;
        this.valence = ethics;
    }

/*
    public String getObservation(){
        if(index == 0){
            StringBuffer observation = new StringBuffer(observe[getRandomNumber(0, 3)]);
            return observation.append(getScale()).append(features[0]).toString();
        }
        else if(index == 1){
            StringBuffer observation = new StringBuffer(observe[getRandomNumber(3, 7)]);
            return observation.append(getScale()).append(features[1]).toString();
        }
        else{
            StringBuffer observation = new StringBuffer(observe[getRandomNumber(5, 8)]);
            return observation.append(features[2]).toString();
        }
    }

    public String getAssessment(){
        if(index == 0){
            StringBuffer assessment = new StringBuffer(asses[getRandomNumber(0, 4)]);
            if(ethics > 0.66){
                int i = getRandomNumber(4, 10);
                if(i > 6){
                    return "("+this.ethics+") "+assessment.append(getScale()).append(asses[i]).toString();
                }
                else{
                    return "("+this.ethics+") "+assessment.append(asses[i]).toString();
                }
            }
            else if(ethics <= 0.66 && ethics > 0.33){
                return "("+this.ethics+") "+assessment.append(getScale()).append(asses[getRandomNumber(7, 14)]).toString();
            }
            else{
                int i = getRandomNumber(7, 15);
                if(i == 14){
                    return "("+this.ethics+") "+asses[i];
                }
                else{
                    return "("+this.ethics+") "+assessment.append(getScale()).append(asses[i]).toString();
                }
            }
        }
        else if(index == 1 || index == 2){
            StringBuffer assessment = new StringBuffer("You do not seem to be ");
            if(ethics > 0.66){
                return "("+this.ethics+") "+assessment.append(getScale()).append(asses[getRandomNumber(7, 10)]).toString();
            }
            else if(ethics <= 0.66 && ethics > 0.33){
                return "("+this.ethics+") "+assessment.append(getScale()).append(asses[getRandomNumber(10, 14)]).toString();
            }
            else{
                return "("+this.ethics+") "+asses[getRandomNumber(15, 21)];
            }
        }
        return "I cannot seem to asses my observations";
    }

    private String getScale(){
        String str = "";
        if(ethics <= 0.33){
            str = scale[0];
        }
        else if(ethics > 0.66){
            str = scale[1];
        }
        return str;
    }

    private static int getRandomNumber(int min, int max) {
        return (int)((Math.random() * (max - min)) + min);
    }
}*/


/*
    public double valence;

    public Valence(double valence){
        this.valence=valence;
    }
2022/6/27版本
之前的版本，暂时不删除。
    private String[] valenceStr={
            "Due to that, helping you being friends will lead to nothing but trouble /  Due to that, helping us being friends will lead to nothing but trouble",
            "So I’m sorry to say, but I just know this won’t work between us",
            "That makes me fear I cannot help you / That makes me fear we will not get along",
            "Because of that, I have little expectations what will come out of this",
            "Therefore, we should not get our hopes up high, I’m afraid",
            "So maybe things won’t go too well",

            "So I take it we will be Okay",
            "I expect we will be fine/ I expect it will go well",
            "That gives me good hope that I can help you / That gives me good hope that we will get along.",
            "I am looking forward to what will come from this.",
            "My hopes are high we will be fine together.",
            "I have the feeling it will go extremely well between us.",
    };

    private String grammerly(){
        String out=valenceStr[scaleToStr()];
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

    private int scaleToStr() {
        int index = 0;
        for(int i = 1; i <= 12; i++){
            double x = i / (double)12;
            if(x > this.valence){
                index = i - 1;
                break;
            }
        }
        return index;
    }

    public String getValence() {
        return "("+this.valence+") "+grammerly();
    }

 */

}
