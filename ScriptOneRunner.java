class ScriptOneRunner 
{ 
    public static void main(String[] args) 
    { 
        FileBuilderFactory fb = new FileBuilder(); 
        ScriptOne sone = new ScriptOne(fb); 
  
        sone.runScriptOne();
    } 
} 