package dimensions;
import java.util.Scanner;

public class MatrixComputation {
    private int m,n;
    private double[][] arr;

    public MatrixComputation(int m,int n, double[][]a){ //m row; n column
        this.m=m;
        this.n=n;
        this.arr=a;
    }

    public double[][] getArr() {
        return arr;
    }

    public int getRow() {
        return this.m;
    }

    public int getColumn() {
        return this.n;
    }

/*
    public void display()
    {
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("-----"+arr.length+"*"+arr[0].length);
    }
*/



    public static double[][] multiple(MatrixComputation a,MatrixComputation b){
        if(a.getColumn()!=b.getRow())
            System.out.print("Error! "+ a.getColumn() + " is not equal to " + b.getRow());

        double[][] end=new double[a.getRow()][b.getColumn()];
        //System.out.println("a.getRow() is "+ a.getRow());
        //System.out.println("b.getRow() is "+ b.getRow());
        //System.out.println("a.getColumn() is "+ a.getColumn());
        //System.out.println("b.getColumn() is "+ b.getColumn());


        int i=0,j=0,c=0;
        double num;
        for(i=0; i<a.getRow(); i++){
            num=0;
            for(j=0; j<b.getColumn(); j++) {
                for(c=0; c<a.getColumn(); c++){
                    //System.out.println("-----"+"["+i+","+j+"] "+c+"/// ");
                    //System.out.println("a.getArr()[i][j]"+a.getArr()[i][c]);
                    //System.out.println("b.getArr()[j][c]"+b.getArr()[c][j]);
                    num+=a.getArr()[i][c]*b.getArr()[c][j];
                    //System.out.println("num:"+num);
                    //System.out.println("------");
                    //System.out.println("-----"+"["+i+","+j+"] "+c+"/// "+a.getArr()[i][j]+"*"+b.getArr()[j][c]+"="+num);
                }
                //System.out.println("["+i+"] ["+j+"] :"+num);
                end[i][j]=num;
            }

        }
        //System.out.println("matrix result "+"");
        return end;
    }
}