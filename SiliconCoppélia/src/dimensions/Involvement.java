package dimensions;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Anthony Z.
 * @Date 22/6/2022
 * @Description: always related to being friends
 */
public class Involvement {

    private double index;

    private Map<Integer, String> involvementMap;

    public Involvement(double index){
        if(index<0 || index>1){
            throw new InvalidParameterException();
        }
        this.index = index;
        involvementMap = new HashMap<>();
        this.initialize();
    }

    private void initialize() {
        involvementMap.put(5, "I am your best friend forever!");
        involvementMap.put(4, "I am your good friend");
        involvementMap.put(3, "I am your friend.");
        involvementMap.put(2, "I have warm feelings for you");
        involvementMap.put(1, "I feel friendly towards you");

    }


    public String getStatement() {
        return involvementMap.get(Math.ceil(this.index*5));
    }



}
