public class App {
    public static void main(String[] args) throws Exception {
        Class1 c1 = new Class1(5);
        System.out.println(c1.method1());

        Class2 c2 = new Class2(12);
        System.out.println(c2.method1());

        Class5 c5 = new Class5(2.5f, 6.6f);
        System.out.println(c5.method1());
        System.out.println(c5.method2());
    }
}
