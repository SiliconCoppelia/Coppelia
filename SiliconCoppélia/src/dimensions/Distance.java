package dimensions;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Anthony Z.
 * @Date 22/6/2022
 * @Description: always related to not being friends
 */
public class Distance{


    private double index;

    private Map<Integer, String> distanceMap;

    public Distance(double index){
        this.index = index;
        this.distanceMap = new HashMap<>();
    }

    private void initialize() {
        distanceMap.put(6, "I don’t know about you, I’ll keep my distance. ");
        distanceMap.put(5, "I have strong reservations about you. ");
        distanceMap.put(4, "We won’t be friends, I’m afraid.");
        distanceMap.put(3, "I feel nothing for you, you are a stranger to me. ");
        distanceMap.put(2, "Please don’t bother me anymore. ");
        distanceMap.put(1, "Please don’t bother me anymore. ");
    }

    public String getStatement()
    {
        return distanceMap.get(Math.ceil(this.index*6));
    }



}
