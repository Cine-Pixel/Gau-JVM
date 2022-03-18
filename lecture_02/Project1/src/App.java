public class App {
    public static void main(String[] args) throws Exception {
        A a = new A();
        a.method1();
        a.method2();
        System.out.println(a.method3());

        B b = new B();
        b.method1();
        b.method2();
        System.out.println(b.method3());

        C c = new C();
        c.method1();
        System.out.println(c.method2());
        System.out.println(c.method3());
        System.out.println(c.method4());
        c.method5();
        c.method6();
    }
}
