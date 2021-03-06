package dimensions;
import java.lang.Math;
import java.util.HashMap;
import java.util.Random;

/**
 * SimilarityBuilder -- auxiliary class supporting partial instance input initialization of Similarity
 * @version 1.0
 * @author Qi Shihao
 */
class SimilarityBuilder{
    private String targetG = "Unknown";
    private int targetAge = -1;
    public final double similarityGrade;

    public SimilarityBuilder(double Similarity) {
        this.similarityGrade = Similarity;
    }

    public Similarity buildSimilarity() {
        return new Similarity(this.targetG, this.targetAge, this.similarityGrade);
    }

    public SimilarityBuilder targetG(String targetG) {
        this.targetG = targetG;
        return this;
    }

    public SimilarityBuilder targetAge(int targetAge) {
        this.targetAge  = targetAge;
        return this;
    }
}

/**
 * Similarity -- to calculate the similarity of target and Coppelia
 * version 1.0
 */
public class Similarity {
    // pre-defined and never changed instance
    private final String gender = "Female";
    private final int age = 30;
    // instances waiting for assigning
    private final String targetG;
    private final int targetAge;
    private final double similarity;
    HashMap<String, Double> factors = new HashMap<>();

    /**
     * Here we do not allow any instance variable to be change once they are assigned.
     * @param tarGender target gender, support default setting if you call SimilarityBuilder to initialize this class
     * @param tarAge target age, default set as -1 if you call SimilarityBuilder to initialize this class
     * @param similarity grades from underling AI structure, necessary arguments when call SimilarityBuilder
     */
    public Similarity(String tarGender, int tarAge, double similarity){
        this.targetG = tarGender;
        this.targetAge = tarAge;
        this.similarity = similarity;
    }

    public void genderJudge() {
        if (this.targetG.contentEquals(this.gender)) factors.put(this.gender, 0.65);
        else if (this.targetG.contentEquals("Male")) factors.put(this.targetG, 0.35);
        else factors.put(this.targetG, 0.0);
    }

    public void ageJudge() {
        if (this.targetAge == -1) this.factors.put(Integer.toString(this.targetAge), 0.0);
        else this.factors.put(Integer.toString(this.targetAge), Math.abs((this.targetAge - this.age) / 100.00));
    }

    public double weightCalculator() {
        double grades = 0;
        for (double value : this.factors.values()) grades += value;
        return grades != 0 ? grades * 0.4 + similarity * 0.6 : similarity;
    }

    public void speakOut() {
        double impression = weightCalculator();
        if (0 < impression && impression < 0.33)
            System.out.println("But we are not so alike, that makes me doubt a little about us");
        else if (0.33 <= impression && impression < 0.67)
            System.out.println("Also, we are quite alike, that makes me convinced about us");
        else if (0.67 <= impression && impression < 1)
            System.out.println("Yes, we are much alike, that makes me even more convinced about us");
        else throw new NumberFormatException("Hey, total weight has over 1!");
    }

    /**
     * OK, you can consider this as the "controller", which will properly invoke
     * the methods in this class to achieve output.
     */
    public void console() {
        genderJudge();
        ageJudge();
        weightCalculator();
        speakOut();
    }

}

/**
 * invoke--test set
 */
class invoke{
    public static void main (String[] args) {
        Random generator = new Random();
        double ran = generator.nextDouble();
        System.out.println(ran);
        Similarity test = new SimilarityBuilder(ran).buildSimilarity();
        ran = generator.nextDouble();
        System.out.println(ran);
        Similarity test1 = new SimilarityBuilder(ran).targetG("Male").targetAge(60).buildSimilarity();
        test.console();
        test1.console();
    }
}