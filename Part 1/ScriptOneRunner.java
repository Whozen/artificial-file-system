class ScriptOneRunner { 
	
    public static void main(String[] args) { 
        FileBuilderFactory fb = new FileBuilder();

        // Old non singleton code
        // ScriptOne sone = new ScriptOne(fb); 
        // sone.runScriptOne();

        //Get instance of ScriptOne class
        ScriptOne runner = ScriptOne.getInstance(fb);

        //Run script One
		runner.runScriptOne();
    } 
} 