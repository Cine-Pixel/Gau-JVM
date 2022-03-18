public class Class2 {
    public int x;

    public Class2() {}

    public Class2(int x) {
        this.x = x;
    }

    public boolean method1() {
        if(x >= 5 && x <= 24) {
            return true;
        }
        return false;
    }
}
