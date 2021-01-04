package strings_arrays_ques;

                                      // All most Important Functions are discussed here
public class StringFunctions {

    public static void main(String[] args) {
        String name = "Naman Agarwal";
        
        System.out.println(name.charAt(8)); // give letter of string at given index(position).....here a
        System.out.println(name.length());  // gives length of string...here 13
        System.out.println(name.substring(6));//give letters of string starting at index 6..6th including..here Agarwal
        System.out.println(name.substring(6,9)); // give letters starting from index 6 to 8...6th include 9th exclude..here Aga
                                              // here last index can go upto length (6, 13)=correct ; (6,14)=error
                                              // (0, 0)=leaves one blank line; (0, length)=return entire string
        System.out.println(name.contains("an A")); // returns boolean value... here true
                                                  // input of contains func must be charSequence and not char.
        String name1 = new String("Naman Agarwal");
        System.out.println(name == name1); // returns boolean by checking object refrence...here false
        System.out.println(name1.equals(name)); // returns boolean by checking values...here true
        System.out.println(name.isEmpty()); // checks if it is empty...here false
        
        name = name + " bits"; // + operator is overloaded by the string...means it concatenates with other string
        System.out.println(name.concat(" pilani")); // used to concatenate...here Naman Agarwal bits pilani
        System.out.println(name.replace("man", "xxxx")); // ...here Naxxxx Agarwal bits 
        
        String cars = "Hyundai,maruti,Swift,Wagonr"; // split func returns strings separated around given string(here ",")
        String[] allCars = cars.split(","); // ,store them in array of datatype strings...here names of all cars get printed
        for(String var: allCars){           // ,each in new line.
            System.out.println(var);
        }
        
        System.out.println(name.indexOf("a")); //gives index of first occurence of give string...here 1
                                              //  most imp.... if nothing find then returns -1
        System.out.println(name.toLowerCase()); //....here naman agarwal bits
        System.out.println(name.toUpperCase()); // ...here NAMAN AGARWAL BITS
        
        String str = "     space   more   space     ";
        System.out.println(str.trim()); // trim only the starting and ending spaces...here space   more   space
        
    }
}
