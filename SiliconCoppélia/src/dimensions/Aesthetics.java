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
    double aes;
    /**
     * Statement:
     * 0->0.25
     * 0.26->0.5
     * 0.51->0.75
     * 0.76->1.0
     *
     * the aes locates in any interval, say the aes is 0.23 which
     * is in first interval, and it means that eyes feature most.
     *
     * Assessment:
     * In every interval above, the larger, the more attractive.
     */

    Map<Integer, String> statementMap;
    Map<Integer, String> assessmentMap;

    public Aesthetics(double aes){
        this.aes = aes;
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
        return statementMap.get(Math.ceil(this.aes*4));
    }


    public String getAssessment() {
        return assessmentMap.get(Math.ceil((this.aes%0.25)*10));

    }
}
