package dimensions;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Anthony Z.
 * @Date 27/6/2022
 * @Description:
 *
 * 我認爲可以傳入4個元素的美感 從零到一
 * 然後下次再討論設計出一個邏輯來返回值
 */
public class Aesthetics{
    private double eyes;
    private double hair;
    private double lips;
    private double voice;

    Map<Integer, String> statementMap;
    Map<Integer, String> assessmentMap;

    public Aesthetics(double eyes, double hair, double lips, double voice){
        this.eyes = eyes;
        this.hair = hair;
        this.lips = lips;
        this.voice = voice;
        this.statementMap = new HashMap<>();
        this.assessmentMap = new HashMap<>();
        this.initialize();
    }
    private void initialize(){
        statementMap.put(4, "I see you have almond eyes");
        statementMap.put(3, "You have wavy hair");
        statementMap.put(2, "You have wide lips");
        statementMap.put(1, "I hear you have a warm voice");

        assessmentMap.put(10, "You are gorgeous ");
        assessmentMap.put(9, "You are very attractive ");
        assessmentMap.put(8, "You are good looking");
        assessmentMap.put(7, "You are attractive to me ");
        assessmentMap.put(6, "You look nice");
        assessmentMap.put(5, "You are not so good looking");
        assessmentMap.put(4, "Your looks are but so-so.");
        assessmentMap.put(3, "You are not really attractive to me ");
        assessmentMap.put(2, "That is not to my taste");
        assessmentMap.put(1, "I think you are unappealing");

    }


    public String getStatement() {
//        return statementMap.get(Math.ceil(this..*4));
        return null;
    }


    public String getAssessment() {
//        return assessmentMap.get(Math.ceil(this...*10));
        return null;
    }
}
