package dimensions;

//import java.util.Scanner;


public class Ethics{

    private int index;
    private float num;
    private String[] ethics = {"I think you look mad and angry.",
            "I think you look angry.",
            "I think you seemed a bit angry.",
            "I think you appear to be somehow a kind person.",
            "I think you seemed kind",
            "I think you seemed very kind."};

    public Ethics(float ETHICS){
        this.num=ETHICS;
    }


    public String compare() {
        if(this.num < 0.1){
            this.index = 0;
        }
        else if(this.num < 0.3){
            this.index = 1;
        }else if(this.num<0.5){
            this.index = 2;
        }else if(this.num<0.7){
            this.index = 3;
        }else if(this.num<0.9){
            this.index = 4;
        }else{
            this.index = 5;
        }
        return ethics[this.index];
    }
}
