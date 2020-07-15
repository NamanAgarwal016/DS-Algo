public class JustNote {
    public static void main(String[] args) {
        int a=0, b=0, c=0, x=0;
        // ++  and  +1  both have different meaning
        System.out.println(a+1);  // 1
        System.out.println(a);    // 0   +1 doesn't change the value
        System.out.println(b++);  // 0  first use then increase
        System.out.println(b);    // 1    ++ changes the value
        System.out.println(++c);  // 1  increase then use
        System.out.println(c);    // 1     ++ changed the value already
      //  System.out.println(+1x);  // invalid
        System.out.println(x);    // 0 normal
    }    
}
