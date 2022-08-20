package dimensions;
import org.jetbrains.annotations.NotNull;

import java.lang.Math;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

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
            return new Similarity(this.targetG, this.targetAge, this
                    .kindness, this.similarityGrade);
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
        if (0 < impression && impression <= 0.25)
            return  "We are totally not alike, that makes me doubt a lot about us";
        else if (0.26 < impression && impression <= 0.5)
            return "We are a bit different with each other, that makes me somehow doubt about us";
        else if (0.5 < impression && impression <= 0.75)
            return "We are somehow alike, that makes me quite convinced about us";
        else if (0.75 < impression && impression <= 1)
            return  "We are very alike, that makes me totally convinced about us";
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
        return speakOut() + " (" + this.similarity + ")";
    }
}

class Coppelia {
    public Coppelia () {}
    private final String Gender = "female";
    private final Age youth = Age.young;
    final Attractiveness beauty = Attractiveness.attractive;
    final String condition = "Invulnerable to all poisons";
}

class Outsider {

    public Outsider() {

    }

}

enum Age{
    child(IntStream.range(0, 15)),
    adolescent(IntStream.range(12, 22)),
    young(IntStream.range(18, 34)),
    mature(IntStream.range(28, 56)),
    old(IntStream.range(50, 100));

    private IntStream range = null;
    Age(IntStream kRange) {
        this.range = kRange;
    }

    public IntStream intersection(Age comparable) {
        IntPredicate testOne = argument -> {
            for (int num : comparable.range.toArray())
                if (argument != num) return false;
            return true;
        };
        return this.range.filter(testOne);
    }
}

enum Attractiveness {
    ugly(1.0),
    unsightly(2.0),
    average(3.0),
    attractive(4.0),
    beautiful(5.0);

    private double proportion = 0.0;
    Attractiveness (double partial) {
        this.proportion = partial;
    }

    public double intersection(double mu, double times, @NotNull Attractiveness target) {
        if (target.proportion > this.proportion) return  (target.proportion - this.proportion) / times * mu;
        return (this.proportion - target.proportion) / times * mu;
    }
}

class MatrixReader{

    // user input value
    private double muD;
    private double alpha;
    private double beta;
    private double[][] variables;

    public MatrixReader(double muD, double alpha, double beta, double[][] variables){
        this.muD = muD;
        this.alpha = alpha;
        this.beta = beta;
        this.variables = variables;
    }

    public double AhatIntersectBhat() {

        return 0.0;
    }

}