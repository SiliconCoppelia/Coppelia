package dimensions;


public class Involvement{
    private final double involvement;
    private final int Goal;
    private final String[] scale = new String[] {"somehow ", "eagerly "};
    private final String[] invl = new String[] {"struggle ", "try hard ", "try out ", "try ", "love ", "willing "};
    private final String[] starting = new String[] {
            "think I am ",
            "think I will ",
            "will ",
            "think I would like to ",

            "refuse to ",
            "don't even want to ",
            "can't imagine how I can "
    };
    private final String[] goal = new String[] {
            "to be your friend",
            "to be friends with you",
            "to make friends with you",
            "to be your cuddle buddies",

            "to help you",
            "to assist you",
            "to give you a hand",
            "to help you out"
    };
    private final StringBuffer response = new StringBuffer("I ");

    public Involvement(double involvement, int Goal){
        this.involvement = involvement;
        this.Goal=Goal;
    }

    public String getInvolvement(){
        if(this.involvement <= 0.33){
            response.append(getScale()).append(starting[getRandomNumber(4, 7)]).append(invl[getRandomNumber(0, 4)]);
        }
        else if(this.involvement <= 0.66 && this.involvement > 0.33){
            if(this.involvement < 0.5){
                response.append(getScale()).append(starting[getRandomNumber(4, 7)]).append(invl[getRandomNumber(0, 4)]);
            }
            else{
                int i = getRandomNumber(0, 4);
                if(i == 0){ response.append(starting[i]).append(invl[4]); /* am willing to */ }
                else if(i == 1 || i == 2){ response.append(starting[i]).append(invl[getRandomNumber(0, 5)]); }
                else{ response.append(starting[i]).append(invl[getRandomNumber(0, 4)]); }
            }
        }
        else{
            int i = getRandomNumber(0, 4);
            if(i == 0){ response.append(getScale()).append(starting[i]).append(invl[4]); /* am willing to */ }
            else if(i == 1 || i == 2){ response.append(getScale()).append(starting[i]).append(invl[getRandomNumber(0, 5)]); }
            else{ response.append(getScale()).append(starting[i]).append(invl[getRandomNumber(0, 4)]); }
        }

        // the Goal
        if(this.Goal == 1){
            if(this.involvement < 0.5){
                response.append(goal[getRandomNumber(0, 3)]);
            }
            else{
                response.append(goal[getRandomNumber(0, 4)]);
            }
        }
        else{
            response.append(goal[getRandomNumber(4, 8)]);
        }

        return response.append(" (").append(this.involvement).append(")").toString();
    }

    private String getScale(){
        String str = "";
        if(involvement > 0.33 && involvement <= 0.66){
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
