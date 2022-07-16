package generateRelated;

/**
 * @Author Yooki ZHANG
 * @Date 12/7/2022
 * @Description: Try to implement some common sentence generating method that could be used in other classes.
 */

public class GenarateSentenceTool {



    //Upper write the first letter of the generated sentence.
    public String upperWritingFirstLetter(String str){
        if(Character.isUpperCase(str.charAt(0))){
            return str;
        }
        else{
            return (new StringBuilder()).append(Character.toUpperCase(str.charAt(0))).append((str.substring(1))).toString();
        }
    }

    public String addPunctuation(int index, String str){
        switch (index){
            case 1:
                return str+",";
            case 2:
                return str+".";
            case 3:
                return str+"?";
            case 4:
                return str+"!";
            default:
                return str;
        }
    }


    //Generate the random integer in generating the sentences
    public int randomInt(int min, int max){
        return (int)((Math.random() * (max - min + 1)) + min);
    }

    //
    public String addEmotion(int status){
        switch(status){
            case 1:
                return "";
            case 2:
                return "";
            default:
                return "";
        }
    }

}
