import java.util.Scanner;

class Trinomial2 {
    public static double[] getRoots(float... floats) {
        if (floats.length == 1) {
            System.out.println(floats.length);

        }


        float a = floats[0];
        float b = floats[1];
        float discriminant = floats[2];

        double x1 = (-b - Math.sqrt(discriminant))/(2*a);
        double x2 = (-b + Math.sqrt(discriminant))/(2*a);

        double[] roots;
        roots = new double[2];
        roots[0] = x1;
        roots[1] = x2;
        return roots;
    }

    public static double getRoot(float... floats) {
        float b = floats[1];
        float discriminant = floats[2];

        double x = (-b + Math.sqrt(discriminant))/2; 

        return x;
    }
    public static float calculateDiscriminant(float... floats) {
        float a = floats[0];
        float b = floats[1];
        float c = floats[2];

        float discriminant = b*b - (4*a*c);

       return discriminant;
    }

    public static float[] determineTrinomial() {
        try (Scanner inputBot = new Scanner(System.in)) {
            System.out.println("ENTER 'A' TERM");
            float a = inputBot.nextFloat();

            System.out.println("ENTER 'B' TERM");
            float b = inputBot.nextFloat();

            System.out.println("ENTER 'C' TERM");
            float c = inputBot.nextFloat();

            String trinomial_string = a + "\u00b2 + " + b + "x + " + c;
            System.out.println(trinomial_string);
            System.out.println("IS THIS YOUR TRINOMIAL? Y / N");
            String response = inputBot.next();
            if (response.equalsIgnoreCase("n") == true) {
                determineTrinomial();
            }

            float[] trinomial;
            trinomial = new float[3];
            trinomial[0] = a;
            trinomial[1] = b;
            trinomial[2] = c;
            return trinomial;
        }
    }
    public static void welcome() {
        System.out.println("TRINOMIAL BOT!");
        System.out.println("PROVIDING ROOTS TO YOUR QUADRATIC QUANDRIES SINCE 2024!");
        System.out.println("TRINOMIALS MUST BE GIVEN IN THE FORM Ax\u00b2 + Bx + C");
        System.out.println("IF A TERM IS NOT PRESENT, ENTER ZERO FOR THAT COEFFICIENT");
    }
    public static void main(String[] args) {
        welcome();
        float[] coefficients = determineTrinomial();

        float a = coefficients[0];
        float b = coefficients[1];
        float c = coefficients[2];

        float discriminant = calculateDiscriminant(a, b, c);

        if (discriminant < 0) {
            System.out.println("NO REAL SOLUTIONS FOR THIS TRINOMIAL");
        }

        if (discriminant == 0) {
            double root = getRoot(a, b, discriminant);
            System.out.println("ONE REAL ROOT: " + root);
        }

        if (discriminant > 0) {
            double[] roots = getRoots(a, b, discriminant);
            System.out.println("TWO REAL ROOTS: " + roots[0] + ", " + roots[1]);
        }
    } 
}