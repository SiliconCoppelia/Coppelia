package generateRelated;
/**
 * @Author Yooki ZHANG
 * @Date 13/7/2022
 * @Description: Try to enum the component in the sentences.
 */

public class SentenceComponents {
    //主语（subject）、谓语（predicate）、表语（predicative）、宾语（object）、定语（attribute）、状语(adverbial) 和补语（complement）
    /*SUBJECT(1),
    OBJECT(2),
    ATTRIBUTE(3),
    PREDICATIVE(4),
    PREDICATE(5),
    ADVERBIAL(6),
    COMPLEMENT(7);*/


    /*public SentenceComponents() {
        //this.index = index;
    }*/


    //not satisfy all the situations
    public String verbPlus_S(String verbStr){
        verbStr+=verbStr.endsWith("s")?"es":"s";
        return verbStr;
    }

    //contact all the component to generate a sentence.
    public String concatTheSentence(String... args){
        String str="";
        for(String arg : args) {
            str+=" "+arg;
        }
        return str.substring(1);
    }

    //主谓
    public String SV(Pronouns pronouns, String verbStr){
        if(pronouns.getPlus_S()){
            verbStr=verbPlus_S(verbStr);
        }
        return concatTheSentence(pronouns.getSubjectStr(), verbStr);
    }

    //主 系 表
    public String SVP(Pronouns pronouns, String predicative){
        String beStr;
        switch (pronouns.getIndex()){
            case 1:
                return concatTheSentence(pronouns.getSubjectStr(), "am", predicative);
            case 2:
            case 4:
                return concatTheSentence(pronouns.getSubjectStr(), "are", predicative);
            case 3:
                return concatTheSentence(pronouns.getSubjectStr(), "is", predicative);
            default:
                return "";

        }
    }

    //主 谓 宾
    public String SVO(Pronouns sub, String verbStr, Pronouns obj){
        if(sub.getPlus_S()){
            verbStr=verbPlus_S(verbStr);
        }
        return concatTheSentence(sub.getSubjectStr(),verbStr,obj.getObjectStr());
    }

    //主 谓 宾语从句
    public String SVO(Pronouns sub, String verbStr, String str){
        if(sub.getPlus_S() && verbStr.indexOf("with")<0){
            verbStr=verbPlus_S(verbStr);
        }
        return concatTheSentence(sub.getSubjectStr(),verbStr,str);
    }

    //主 谓 间宾 直宾
    public String SVOO(Pronouns sub, String verbStr, Pronouns obj, String objStr){
        if(sub.getPlus_S()){
            verbStr=verbPlus_S(verbStr);
        }
        return concatTheSentence(sub.getSubjectStr(),verbStr,obj.getObjectStr(),objStr);
    }

    //主 谓 宾 宾补
    public String SVOC(Pronouns sub, String verbStr, String objStr, String complStr){
        if(sub.getPlus_S()){
            verbStr=verbPlus_S(verbStr);
        }
        return concatTheSentence(sub.getSubjectStr(),verbStr,objStr,complStr);
    }

    //it is adj to do ....
    public String itBeAdj(Pronouns sub, String adjStr, String preposition, String verbStr){
        //String beStr="";
        switch (sub.getIndex()){
            case 1:
                return concatTheSentence(sub.getSubjectStr(), "am", adjStr, preposition, verbStr);
            case 2:
            case 4:
                return concatTheSentence(sub.getSubjectStr(), "are", adjStr, preposition, verbStr);
            case 3:
                return concatTheSentence(sub.getSubjectStr(), "is", adjStr, preposition, verbStr);
            default:
                return concatTheSentence(sub.getSubjectStr(), adjStr, preposition, verbStr);
        }
        //return concatTheSentence(sub.getSubjectStr(), beStr, adjStr, preposition, verbStr);
    }

}
