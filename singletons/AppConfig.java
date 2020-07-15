package singletons;
public class AppConfig {
    private AppConfig(){    //Making the default connstructor private. 
    }                    // Now obj of this class can not be made from outside this class.
    
    private static AppConfig objMain = null; // Ensuring even this single obj is also not formed until someone require it.
    
    public static AppConfig getInstance(){   // Here AppConfig is return type of getInstance mtd.
        if(objMain == null){           //objMain will be formed only when someone needs this. Had it been initialized in
            objMain = new AppConfig(); // line5, objMain will form always once...also when no one needs it.
        }
        return objMain;
    }
}
