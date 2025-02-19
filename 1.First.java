import java.util.*;
class First {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        if((n&1)==1)
        {
            System.out.println("odd");
        }
        else
            System.out.println("Even");
    }
}
