class ScriptOneRunner 
{ 
    public static void main(String[] args) 
    { 
        FileBuilderFactory fb = new FileBuilder();

        // Old non singleton code
        // ScriptOne sone = new ScriptOne(fb); 
  
        // sone.runScriptOne();


        ScriptOne runner = ScriptOne.getInstance(fb);

		runner.runScriptOne();
    } 
} 