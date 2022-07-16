package generateRelated;

/**
 * @Author Yooki ZHANG
 * @Date 13/7/2022
 * @Description: Try to enum the pronouns that will be used in the sentences.
 */

public enum Pronouns {
    FIRST_PERSON   (false, 1,"I",    "me",   "my",   "mine"),
    FIRST_PERSONS  (false, 4,"we",   "us",   "our",  "ours"),
    SECOND_PERSON  (false, 2,"you",  "you",  "your", "yours"),
    SECOND_PERSONS (false, 2,"you",  "you",  "your", "yours"),
    THIRD_PERSON_G (true,  3,"she",  "her",  "her",  "hers"),
    THIRD_PERSON_B (true,  3,"he",   "him",  "him",  "his"),
    THIRD_PERSON_O (true,  3,"it",   "it",   "its",  "its"),
    THIRD_PERSONS  (false, 4,"they", "them", "their","theirs"),
    THIS           (true,  3,"this", "this", "this", "this"),
    THAT           (true,  3,"that", "that", "that", "that");


    private String subjectStr;
    private String objectStr;
    private String attributeStr;
    private String nounStr;
    private Boolean plus_S;

    private int index;

    // constructor
    private Pronouns(Boolean plus_S, int index, String subject, String object, String attribute, String noun) {
        this.plus_S = plus_S;
        this.subjectStr=subject;
        this.objectStr=object;
        this.attributeStr=attribute;
        this.nounStr=noun;
        this.index=index;
    }

    // get set 方法
    public Boolean getPlus_S(){
        return plus_S;
    }

    public int getIndex(){
        return this.index;
    }

    public String getSubjectStr() {
        return subjectStr;
    }

    public String getObjectStr() {
        return objectStr;
    }

    public String getAttributeStr() {
        return attributeStr;
    }

    public String getNounStr() {
        return nounStr;
    }

}