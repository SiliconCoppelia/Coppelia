package dimensions;


public class Ethics{
    private double index;
    private double scaleN;
    private String[] scale = {"somewhat ", "very "};
    private String[] features = {"friendly face", "angry", "cheating"};
    private String[] observe = {"I see a ", "You seem to have a ", "I found you with a ", "You seem to be ", "You look ", "I think you are ", "I found you ", "You are "};

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
        return null;
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
