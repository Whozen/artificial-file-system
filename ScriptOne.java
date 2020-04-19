class ScriptOne { 
    private FileBuilderFactory fileBuilder; 
  
    public ScriptOne(FileBuilderFactory fileBuilder) 
    { 
        this.fileBuilder = fileBuilder; 
    } 
  
    public void runScriptOne() 
    {
        this.fileBuilder.mkdir("App");
        this.fileBuilder.mkdir("Course");
        this.fileBuilder.mkdir("Code");
        this.fileBuilder.cd("Code");
        this.fileBuilder.mkdir("CSci41");
        this.fileBuilder.mkdir("CSci250");
        this.fileBuilder.cd("CSci41");
        this.fileBuilder.create("roster.txt", 30);
        this.fileBuilder.create("grade.txt", 40);
        this.fileBuilder.create("exam.txt", 50);
        this.fileBuilder.del("grade.txt");
        this.fileBuilder.ls("grade.txt");
        this.fileBuilder.cd("..");
        this.fileBuilder.cd("CSci250");
        this.fileBuilder.create("project1.txt", 20);
        this.fileBuilder.create("project2.txt", 40);
        this.fileBuilder.create("quiz1.txt", 30);
        this.fileBuilder.size("quiz1.txt");
        this.fileBuilder.cd("..");
        this.fileBuilder.size("CSci41");
        this.fileBuilder.ls("CSci41");
        this.fileBuilder.del("CSci41");
        this.fileBuilder.cd("..");
        this.fileBuilder.size("Course");
        this.fileBuilder.exit();
    } 
}