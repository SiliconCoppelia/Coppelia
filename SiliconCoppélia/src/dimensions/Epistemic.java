package dimensions;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Anthony Z.
 * @Date 27/6/2022
 * @Description:
 */
public class Epistemic{
    private double trueDegreeOfStatement;

    Map<Integer, String> statementMap;
    Map<Integer, String> assessmentMap;

    public Epistemic(double trueDegreeOfStatement){
        this.trueDegreeOfStatement = trueDegreeOfStatement;
        this.statementMap = new HashMap<>();
        this.assessmentMap = new HashMap<>();
        this.initialize();
    }
    private void initialize() {
        statementMap.put(5, "I see what you are doing");
        statementMap.put(4, "That is not your real identity");
        statementMap.put(3, "I see you beautified your photo");
        statementMap.put(2, "You are an avatar ");
        statementMap.put(1, "You made a comparison");

        assessmentMap.put(10, "You are absolutely right");
        assessmentMap.put(9, "I know what you say is true");
        assessmentMap.put(8, "I believe what you say is true");
        assessmentMap.put(7, "That is kind of correct");
        assessmentMap.put(6, "That may be probably so");
        assessmentMap.put(5, "Perhaps so but I doubt it ");
        assessmentMap.put(4, "It may seem realistic but I don’t believe it");
        assessmentMap.put(3, "I can hardly believe what you say ");
        assessmentMap.put(2, "I believe what you say is false");
        assessmentMap.put(1, "I know what you say is false.");

    }

    public String getStatement() {
//        return statementMap.get(Math.ceil(this..*5));
        return null;
    }


    public String getAssessment() {
//        return assessmentMap.get(Math.ceil(this...*10));
        return null;
    }



}
