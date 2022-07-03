package dimensions;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Anthony Z.
 * @Date 22/6/2022
 * @Description: Observe feature (e.g., friendly smile,
 * angry face, an illegal move in a game)
 *
 */
public class Ethics{
    private double index; // the degree of happiness judged from the appearance
    private boolean ifIllegal;
    Map<Integer, String> statementMap;
    Map<Integer, String> assessmentMap;

    // 多個參數的constructor先留著，下次討論
    public Ethics(double index, boolean ifIllegal){
        this.index = index;
        this.ifIllegal = ifIllegal;
        this.statementMap = new HashMap<>();
        this.assessmentMap = new HashMap<>();
        this.initialize();
    }

    public Ethics(double index){
        if(index<0 || index>1){
            throw new InvalidParameterException();
        }
        this.index = index;
        this.statementMap = new HashMap<>();
        this.assessmentMap = new HashMap<>();
        this.initialize();
    }

    private void initialize() {
        statementMap.put(3, "I see you have a friendly face");
        statementMap.put(2, "I can see you are angry");
        statementMap.put(1, "You are cheating");

        assessmentMap.put(10, "You seem to be very kind, like an angel!");
        assessmentMap.put(9, "you have a kind character");
        assessmentMap.put(8, "You seem to be a mild personality");
        assessmentMap.put(7, "It seems you are in a good mood");
        assessmentMap.put(6, "I do believe there is some good in you");
        assessmentMap.put(5, "You do not seem to be very kind");
        assessmentMap.put(4, "I don’t like your attitude");
        assessmentMap.put(3, "Your behavior is unacceptable");
        assessmentMap.put(2, "You seem to have a mean streak");
        assessmentMap.put(1, "You are a bad person");

    }


    public String getStatement(){
        return statementMap.get(Math.ceil(this.index*3));
    }

    public String getAssessment(){
        return assessmentMap.get(Math.ceil(this.index*10));
    }
}
