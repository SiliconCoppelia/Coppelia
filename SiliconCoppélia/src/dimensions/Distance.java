package dimensions;

//import java.util.Scanner;

public class Distance{
    private int index;
    public double num;
    private String[] distance = {
            "I still have extremely reservations about you",
            "I still have much reservations about you",
            "I still have reservations about you",
            "I still somewhat have reservations about you",
            "I still have little reservations about you"
    };

    public Distance(double ethics, double age, double income, double pet, double irrelevance, double valence){
        double [][] arr={{ethics,age,income,pet,irrelevance,valence}};
        double weight=(double) 1/(double) 6;
        double [][] B_d={{weight},{weight},{weight},{weight},{weight},{weight}};
        MatrixComputation counterIndicative=new MatrixComputation(1,6, arr);
        MatrixComputation distance=new MatrixComputation(6,1, B_d);
        //System.out.println("Distance");
        this.num = distance.multiple(counterIndicative, distance)[0][0];
        //System.out.println("The num is "+this.num);
        //System.out.println();
    }

    public String getDistance() {
        return distance[(int)(this.num*5)];
    }

    /*
    public String compare(){
        if(this.num < 0.2 && this.num >= 0) this.index = 4;
        else if (this.num < 0.4 && this.num >= 0.2) this.index = 3;
        else if (this.num < 0.6 && this.num >= 0.4) this.index = 2;
        else if (this.num < 0.8 && this.num >= 0.6) this.index = 1;
        else  this.index = 0;
        return this.distance[this.index];
    }*/
}