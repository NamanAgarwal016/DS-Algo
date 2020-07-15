public class delete {
    public static void main(String[] args) {
        int[] a ={9,1,9,1,9};
        int max = 0;
        int count = 0;
        for(int i=0; i<5; i++){
            if(max < a[i]){
                max = a[i];
                count = 1;
            }
            else if(max == a[i]){
                count++;
            }
            else continue;
        }
        System.out.println("max no. is " + max + " and it appears "+ count + " times");
    }
}
