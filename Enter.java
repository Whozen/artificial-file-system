public class Enter { 

    public static void main(String[] args) {

        FileBuilderFactory fb = new FileBuilder();

        //Get instance of ScriptOne class
        ScriptOne runner = ScriptOne.getInstance(fb);

        //Run script One
        runner.runScriptOne();
        runner.displayTree();
    }  
   
} 