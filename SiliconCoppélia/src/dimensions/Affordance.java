package dimensions;


public class Affordance{
    private final double index;
    private final double affordance;
    private final String[] scale = new String[] {"somewhat ", "very "};
    private final String[] features = new String[] {
            "fast", "slow", "work quickly", "accurate", "smart", "scored high", "dumb",
            "scored low"};
    private final String[] observe = new String[] {
            "I see a ", "You seem to have a ", "I found you with a ", "You seem to be ",
            "You look ", "I think you are ", "I found you ", "You are "};
    private final String[] asses = new String[] {
            "You are ",
            "I think you are ",
            "You seem to be ",
            "It seems you are ",
            "a saint", "an angel", "too good a person", "kind", "friendly", "gentle",
            "a good person", "a kind character", "a mild personality", "in a good mood", "I do believe there is some good in you",
            "It seems you have a bad temper", "I don’t like your attitude", "Your behavior is unacceptable", "You seem to have a mean streak",
            "You are a bad person", "You are evil"};

    public Affordance(int index, double affordance){
        this.index = index;
        this.affordance = affordance;
    }


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
            if(affordance > 0.66){
                int i = getRandomNumber(4, 10);
                if(i > 6){
                    return assessment.append(getScale()).append(asses[i]).toString()+" ("+this.affordance+")";
                }
                else{
                    return assessment.append(asses[i]).toString()+" ("+this.affordance+")";
                }
            }
            else if(affordance <= 0.66 && affordance > 0.33){
                return assessment.append(getScale()).append(asses[getRandomNumber(7, 14)]).toString()+" ("+this.affordance+")";
            }
            else{
                int i = getRandomNumber(7, 15);
                if(i == 14){
                    return asses[i]+" ("+this.affordance+")";
                }
                else{
                    return assessment.append(getScale()).append(asses[i]).toString()+" ("+this.affordance+")";
                }
            }
        }
        else if(index == 1 || index == 2){
            StringBuffer assessment = new StringBuffer("You do not seem to be ");
            if(affordance > 0.66){
                return assessment.append(getScale()).append(asses[getRandomNumber(7, 10)]).toString()+" ("+this.affordance+")";
            }
            else if(affordance <= 0.66 && affordance > 0.33){
                return assessment.append(getScale()).append(asses[getRandomNumber(10, 14)]).toString()+" ("+this.affordance+")";
            }
            else{
                return asses[getRandomNumber(15, 21)]+" ("+this.affordance+")";
            }
        }
        return "I cannot seem to asses my observations";
    }

    private String getScale(){
        String str = "";
        if(affordance <= 0.33){
            str = scale[0];
        }
        else if(affordance > 0.66){
            str = scale[1];
        }
        return str;
    }

    private static int getRandomNumber(int min, int max) {
        return (int)((Math.random() * (max - min)) + min);
    }

    public double getter(){
        return this.affordance;
    }
}
