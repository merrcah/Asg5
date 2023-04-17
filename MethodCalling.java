public class MethodCalling {

    int val = 0;

    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        System.out.println(somefunc(a, b));
        System.out.println(a); // this will still display 3 b/c of call by value
        System.out.println(b);

        MethodCalling anInstance = new MethodCalling();
        anInstance.val = 3;
        System.out.println(anotherfunc(anInstance));
        System.out.println(anInstance.val);
    }

    // all function calls in java are call by value ... BUT that value can be a reference to a class instance
    public static int anotherfunc(MethodCalling inst) {
        int retval = inst.val;
        //inst = new MethodCalling();
        inst.val = 4;
        return retval;
    }

    // all function calls in java are call by value
    public static int somefunc(int a, int b) {
        a = 7;
        b = 8;
        return a + b;
    }

}
