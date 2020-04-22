public class Enter { 

    public static void main(String[] args) {
        // FileSystem mainDir = new Directory("Root");
        // FileSystem appDir = new Directory("App");
        // FileSystem courseDir = new Directory("Course");
        // FileSystem firstFile = new File("First File", 30);
        // FileSystem secondFile = new File("Second File", 40);

        // mainDir.add(appDir);
        // mainDir.add(courseDir);
        // courseDir.add(firstFile);
        // courseDir.add(secondFile);

        // SizeVisitor sVisit = new SizeVisitor();
        // mainDir.accept(sVisit);

        // ResizeVisitor resVisit = new ResizeVisitor();
        // firstFile.accept(resVisit, 20);

        // LsVisitor lsVisit = new LsVisitor();
        // mainDir.accept(lsVisit);

        // DeleteVisitor rVisit = new DeleteVisitor();
        // mainDir.accept(rVisit, appDir);


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