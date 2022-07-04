package dimensions;


public class Ethics{
    private final double index;
    private final double scaleN;
    private final String[] scale = new String[] {"somewhat ", "very "};
    private final String[] features = new String[] {"friendly face", "angry", "cheating"};
    private final String[] observe = new String[] {"I see a ", "You seem to have a ", "I found you with a ", "You seem to be ", "You look ", "I think you are ", "I found you ", "You are "};
    private final String[] asses = new String[] {
            "You are ",
            "I think you are ",
            "You seem to be ",
            "It seems you are ",
            "a saint", "an angel", "too good a person", "kind", "friendly", "gentle",
            "a good person", "a kind character", "a mild personality", "in a good mood", "I do believe there is some good in you",
            "It seems you have a bad temper", "I don’t like your attitude", "Your behavior is unacceptable", "You seem to have a mean streak",
            "You are a bad person", "You are evil"};

    public Ethics(int index, double scaleN){
        this.index = index;
        this.scaleN = scaleN;
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
            if(scaleN > 0.66){
                int i = getRandomNumber(4, 10);
                if(i > 6){
                    return "("+this.scaleN+") "+assessment.append(getScale()).append(asses[i]).toString();
                }
                else{
                    return "("+this.scaleN+") "+assessment.append(asses[i]).toString();
                }
            }
            else if(scaleN <= 0.66 && scaleN > 0.33){
                return "("+this.scaleN+") "+assessment.append(getScale()).append(asses[getRandomNumber(7, 14)]).toString();
            }
            else{
                int i = getRandomNumber(7, 15);
                if(i == 14){
                    return "("+this.scaleN+") "+asses[i];
                }
                else{
                    return "("+this.scaleN+") "+assessment.append(getScale()).append(asses[i]).toString();
                }
            }
        }
        else if(index == 1 || index == 2){
            StringBuffer assessment = new StringBuffer("You do not seem to be ");
            if(scaleN > 0.66){
                return "("+this.scaleN+") "+assessment.append(getScale()).append(asses[getRandomNumber(7, 10)]).toString();
            }
            else if(scaleN <= 0.66 && scaleN > 0.33){
                return "("+this.scaleN+") "+assessment.append(getScale()).append(asses[getRandomNumber(10, 14)]).toString();
            }
            else{
                return "("+this.scaleN+") "+asses[getRandomNumber(15, 21)];
            }
        }
        return "I cannot seem to asses my observations";
    }

    private String getScale(){
        String str = "";
        if(scaleN <= 0.33){
            str = scale[0];
        }
        else if(scaleN > 0.66){
            str = scale[1];
        }
        return str;
    }

    private static int getRandomNumber(int min, int max) {
        return (int)((Math.random() * (max - min)) + min);
    }
}
