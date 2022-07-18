package dimensions;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Anthony Z.
 * @Date 22/6/2022
 * @Description: 
 */
public class Affordance {
    private double aff; // from 0 to 1
    Map<Integer, String> statementMap;
    Map<Integer, String> assessmentMap;
    

    // 傳1個參數的constructor
    public Affordance(double aff){
        if(aff<0 || aff>1){
            throw new InvalidParameterException();
        }
        this.aff = aff;
        this.statementMap = new HashMap<>();
        this.assessmentMap = new HashMap<>();
        this.initialize();
    }

    private void initialize() {

        statementMap.put(5, "I see you work quickly.");
        statementMap.put(4, "You are quite slow.");
        statementMap.put(3, "You do that accurately.");
        statementMap.put(2, "That is sloppy work.");
        statementMap.put(1, "You scored low.");

        assessmentMap.put(10, "Genius!");
        assessmentMap.put(9, "Good Job! You are so intelligent");
        assessmentMap.put(8, "I think you are quite smart.");
        assessmentMap.put(7, "That was clever");
        assessmentMap.put(6, "You thought well");
        assessmentMap.put(5, "Emm.. That wasn’t very clever ");
        assessmentMap.put(4, "You’re a bit clumsy");
        assessmentMap.put(3, "I think you are pretty stupid");
        assessmentMap.put(2, "Are you insane?");
        assessmentMap.put(1, "You’re an idiot! You’re a total moron.");

    }


    public String getStatement() {
        return statementMap.get(Math.ceil(this.aff*5));
    }


    public String getAssessment() {
        return assessmentMap.get(Math.ceil(this.aff*10));
    }
}
