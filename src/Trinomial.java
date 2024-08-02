public class Trinomial {
    public double a;
    public double b;
    public double c;

    public Trinomial(double... coefficients) {
        this.a = coefficients[0];
        this.b = coefficients[1];
        this.c = coefficients[2];
    }

    public String standardForm() {
        return a + "\u00b2 + " + b + "x + " + c;
    }

    public double evaluate(double value) {
        return (value*value*a) + (value*b) + c;
    }  

    public double calculateDiscriminant() {
        double discriminant = b*b - (4*a*c);
        return discriminant;
    }

    public double[] calculateRoots() throws RuntimeException {
        double discriminant = this.calculateDiscriminant();
        double[] roots;
        if (discriminant == 0) {
            return new double[]{(-b + Math.sqrt(discriminant)) / (2*a)};
        }
        if (discriminant > 0) {
            double x1 = (-b - Math.sqrt(discriminant)) / (2*a);
            double x2 = (-b + Math.sqrt(discriminant)) / (2*a);
            roots = new double[2];
            roots[0] = x1;
            roots[1] = x2;
            return roots;
        }
        else throw new RuntimeException("NO REAL ROOTS");
    }

    public String factor()throws RuntimeException {
        double[] roots = this.calculateRoots();
        if ((int)roots[0] != roots[0]) throw new RuntimeException("IRRATIONAL ROOTS!");
        if (roots.length == 1) {
            if (roots[0] > 0) return "(x - " + roots[0] + ")\u00b2";
            if (roots[0] < 1) return "(x + " + -roots[0] + ")\u00b2";
            else return "x\u00b2";
        } 
        else {
            StringBuilder factoredTrinomial = new StringBuilder();
            for (int i = 0; i < roots.length; i++) {
                if (roots[i] > 0) {
                    factoredTrinomial.append("(x - ");
                    factoredTrinomial.append((int)roots[i]);
                }
                if (roots[i] < 0) {
                    factoredTrinomial.append("(x + ");
                    factoredTrinomial.append(-(int)roots[i]);
                }
                factoredTrinomial.append(")");
            }
            return factoredTrinomial.toString();
        }
    }
}
