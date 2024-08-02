public class Main {
    public static void main(String[] args) {
        Trinomial quadBoi = new Trinomial(1, 0, -1);
        String factored = quadBoi.factor();
        System.out.println(factored);
    }
}
