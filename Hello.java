
// equivalent C program
//
//int main() {
//    printf("hello, world\n");
//}

public class Hello {

    public static void method(Integer param) {
        System.out.println(param);
    }

    public static void anothermethod(int param) {
        System.out.println(param);
    }
    
    // hello, world and autoboxing
    public static void main(String args[]) {
        int a = 3;
        Integer another = 3;
        method(a);
        method(another);
        anothermethod(a);
        anothermethod(another);
        System.out.println("hello, world");
    }

}
