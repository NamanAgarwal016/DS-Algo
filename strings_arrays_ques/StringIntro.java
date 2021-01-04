package strings_arrays_ques;

public class StringIntro {
    public static void main(String[] args) {
        // String is non primitive datatype(made up of primitive datatype)
        String name = "Naman"; //Initialization by literals (stored in string pool area)
        String name1 = new String("Naman"); 
//Initialization by making object (stored in heap memory and a copy is made in string pool area)
        
// Heap memory: where all variables are stored
// String Pool Area: A special memory space allocated for Strings ...caching of memory
// therefore always initialize strings by literals so that optimization happens 
// if there is already same string stored in pool area then it is replaced..means no repetition
// but if it is stored in heap(by obj init.) then repitition is allowed
// So when string is init. by obj then 2 strings are made(in heap + in pool)..provided same string is not present in pool
        
        System.out.println(name == name1); //false bcoz not stored in same location
        String name2 = "Naman";
        System.out.println(name == name2); //true bcoz there are replaced
        
//Strings are immutable(never changed in memory) : once stored they will remain till garbage collector runs
// when garbage collector sees that a variable doesn't have any refrence over it or becomes null , then it removes it
    }
}
