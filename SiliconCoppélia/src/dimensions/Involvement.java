package dimensions;

//import java.util.Scanner;

/**
 * @Author: Anthony, Yooki
 * @Date: 01/07/2022
 * @Description:
 */
public class Involvement{

    private int index;
    public double num;
    private String[] invl =new String[]{
            "I feel you as my extremely friend",
            "I feel you as my close friend",
            "I feel you as my friend",
            "I somewhat feel you as my friend",
            "I can hardly feel you as my friend"
    };

    public Involvement(double ethics, double age, double income, double pet, double relevance, double valence){

        double [][] arr={{ethics,age,income,pet,relevance,valence}};
        double weight=(double) 1/(double) 6;
        double [][] B_i={{weight},{weight},{weight},{weight},{weight},{weight}};
        MatrixComputation counterIndicative=new MatrixComputation(1,6, arr);
        MatrixComputation involvement=new MatrixComputation(6,1, B_i);
        //System.out.println("invl is "+involvement.multiple(involvement,counterIndicative));
        //System.out.println("Involvement");
        this.num = involvement.multiple(counterIndicative,involvement)[0][0];
        //System.out.println("The num is "+this.num);
        //System.out.println();
    }

    public String getDistance() {

        return invl[(int)(this.num*5)];
    }


/*
    public String compare() {
        if(this.num < 0.2) this.index = 4;
        else if(this.num<0.4) this.index = 3;
        else if(this.num<0.6) this.index = 2;
        else if(this.num<0.8) this.index = 1;
        else this.index = 0;
        return this.invl[this.index];
    }
 */
}