package dimensions;
import java.lang.Math;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

/**
 * Similarity -- to calculate the similarity of target and Coppelia
 * version 1.2 allow user can call Builder model outside package
 */
public class Similarity {
    // pre-defined and never changed instance
    private final String gender = "female";
    private final int age = 30;
    // instances waiting for assigning
    private String targetG;
    private final int targetAge;
    private final double kindness;
    private final double similarity;
    HashMap<String, Double> factors = new HashMap<>();

    /**
     * SimilarityBuilder -- auxiliary class supporting partial instance input initialization of Similarity
     * @version 1.0
     * @author Qi Shihao
     */
    public static class Builder{
        private String targetG = "Unknown";
        private int targetAge = -1;
        private double kindness = 0.0;
        public final double similarityGrade;

        public Builder(double Similarity) {
            this.similarityGrade = Similarity;
        }

        public Similarity build() {
            return new Similarity(this.targetG, this.targetAge, this.kindness, this.similarityGrade);
        }

        public Builder targetG(String targetG) {
            this.targetG = targetG;
            return this;
        }

        public Builder targetAge(int targetAge) {
            this.targetAge  = targetAge;
            return this;
        }

        public Builder kindness(double kindness) {
            this.kindness = kindness;
            return  this;
        }
    }

    /**
     * Here we do not allow any instance variable to be change once they are assigned.
     * @param tarGender target gender, support default setting if you call SimilarityBuilder to initialize this class
     * @param tarAge target age, default set as -1 if you call SimilarityBuilder to initialize this class
     * @param similarity grades from underling AI structure, necessary arguments when call SimilarityBuilder
     */
    public Similarity(String tarGender, int tarAge, double kindness, double similarity){
        this.targetG = tarGender;
        this.targetAge = tarAge;
        this.kindness = kindness;
        this.similarity = similarity;
    }

    public void genderJudge() {
        this.targetG = this.targetG.toLowerCase(Locale.ROOT);
        if (this.targetG.contentEquals(this.gender)) factors.put(this.gender, 0.65);
        else if (this.targetG.contentEquals("male")) factors.put(this.targetG, 0.35);
        else factors.put(this.targetG, 0.0);
    }

    public void ageJudge() {
        if (this.targetAge == -1) this.factors.put(Integer.toString(this.targetAge), 0.0);
        else this.factors.put(Integer.toString(this.targetAge), Math.abs((this.targetAge - this.age) / 100.00));
    }

    /**
     * after tests, it is believed adding kindness may increase the final grades,
     * which means Coppelia may more tend to think "we" are alike...
     */
    public void kindJudge() {factors.put("kindness", this.kindness);}

    public double weightCalculator() {
        double grades = 0;
        for (double value : this.factors.values()) grades += value;
        return grades != 0 ? grades * 0.4 + similarity * 0.6 : similarity;
    }

    /**
     * no longer auto output in there, instead will return the output as String
     * @return String
     */
    public String speakOut() {
        double impression = weightCalculator();
        if (0 < impression && impression < 0.33)
            return  "But we are not so alike, that makes me doubt a little about us";
        else if (0.33 <= impression && impression < 0.67)
            return "Also, we are quite alike, that makes me convinced about us";
        else if (0.67 <= impression && impression < 1)
            return  "Yes, we are much alike, that makes me even more convinced about us";
        else throw new NumberFormatException("Hey, total weight has over 1!");
    }

    /**
     * OK, you can consider this as the "controller", which will properly invoke
     * the methods in this class to achieve output.
     */
    public String console() {
        genderJudge();
        ageJudge();
        kindJudge();
        weightCalculator();
        return speakOut();
    }

}
