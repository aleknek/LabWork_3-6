
public class MyClass {

    private int a;
    public String b;

    public void test(){
        System.out.println("inside test");
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "a=" + a +
                ", b='" + b + '\'' +
                '}';
    }
}
