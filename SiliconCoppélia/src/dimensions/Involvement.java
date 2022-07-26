package dimensions;


public class Involvement{
    private final double involvement;
    private final String[] scale = new String[] {"somehow ", "eagerly "};
    private final String[] invl = new String[] {"struggle ", "try hard ", "try out ", "try ", "willing ", "love "};
    private final String[] starting = new String[] {
            "I think I am ",
            "I think I will ",
            "I will ",
            "I think I would like to "
    };
    private final String[] goal = new String[] {
            "to be your friend",
            "to be friends with you",
            "to make friends with you",
            "to be your cuddle buddies"};
    private final StringBuffer response = new StringBuffer("");

    public Involvement(double involvement){
        this.involvement = involvement;
    }

    public String getInvolvement(){
        if(this.involvement <= 0.17){
            response.append(starting[getRandomNumber(1, 3)]).append(getScale()).append(invl[0]);
        }
        else if(this.involvement > 0.17 && this.involvement <= 0.34){
            response.append(starting[getRandomNumber(1, 4)]).append(getScale()).append(invl[1]);
        }
        else if(this.involvement > 0.34 && this.involvement <= 0.51){
            response.append(starting[getRandomNumber(1, 4)]).append(getScale()).append(invl[2]);
        }
        else if(this.involvement > 0.51 && this.involvement <= 0.68){
            response.append(starting[getRandomNumber(1, 4)]).append(getScale()).append(invl[3]);
        }
        else if(this.involvement > 0.68 && this.involvement <= 0.85){
            response.append(starting[0]).append(getScale()).append(invl[4]);
        }
        else{
            response.append(starting[getRandomNumber(1, 3)]).append(getScale()).append(invl[5]);
        }

        // the Goal
        if(this.involvement < 0.75){
            response.append(goal[getRandomNumber(0, 3)]);
        }
        else{
            response.append(goal[getRandomNumber(0, 4)]);
        }

        return response.append(" (").append(this.involvement).append(")").toString();
    }

    private String getScale(){
        String str = "";
        if(involvement <= 0.33){
            str = scale[0];
        }
        else if(involvement > 0.66){
            str = scale[1];
        }
        return str;
    }

    private static int getRandomNumber(int min, int max) {
        return (int)((Math.random() * (max - min)) + min);
    }

    public double getter(){
        return this.involvement;
    }
}
