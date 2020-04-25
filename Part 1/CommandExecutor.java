public class CommandExecutor {
    
    //Get instance of CommandExecutor class
    private static CommandExecutor instance = new CommandExecutor();
    
    //Cannot be initialized
    private CommandExecutor(){}
    private static FileBuilderFactory fileBuilder;
    private String[] input;
    

    /*
    Function Name:  getInstance
    Input Parameter:FileBuilderFactory
    Return:         CommandExecuter instance
    Description:    This function assigns the filebuilder object instance to the object classes
                    own object and returns the instance of this class
    */
    public static CommandExecutor getInstance(FileBuilderFactory fb){
        fileBuilder = fb; 
        return instance;
    }


    /*
    Function Name:  runCommandExecutor
    Input Parameter:String command which consists of a single command and arguments
    Return:         void
    Description:    This function takes a single command as input and calls the method in FileSystem
                    accordingly.
    */
    public void runCommandExecutor(String command) {
        input = command.split(" ");

        switch (input[0]) {
            case "mkdir":
                this.fileBuilder.mkdir(input[1]);
                break;
            case "create":
                this.fileBuilder.create(input[1], Integer.parseInt(input[2]));
                break;
            case "size":
                this.fileBuilder.size(input[1]);
                break;
            case "del":
                this.fileBuilder.del(input[1]);
                break;
            case "cd":
                this.fileBuilder.cd(input[1]);
                break;
            case "ls":
                if(input.length == 1){
                    this.fileBuilder.ls();
                } else {
                    this.fileBuilder.ls(input[1]);
                }
                break;
            case "exit":
                this.fileBuilder.exit();
                break;
        }
    } 

    
    //Run the script1 commands
    // public void runCommandExecutor() 
    // {
    //     this.fileBuilder.mkdir("App");
    //     this.fileBuilder.mkdir("Course");
    //     this.fileBuilder.mkdir("Code");
    //     this.fileBuilder.cd("Code");
    //     this.fileBuilder.mkdir("CSci41");
    //     this.fileBuilder.mkdir("CSci250");
    //     this.fileBuilder.cd("CSci41");
    //     this.fileBuilder.create("roster.txt", 30);
    //     this.fileBuilder.create("grade.txt", 40);
    //     this.fileBuilder.create("exam.txt", 50);
    //     this.fileBuilder.del("grade.txt");
    //     this.fileBuilder.ls("grade.txt");
    //     this.fileBuilder.cd("..");
    //     this.fileBuilder.cd("CSci250");
    //     this.fileBuilder.create("project1.txt", 20);
    //     this.fileBuilder.create("project2.txt", 40);
    //     this.fileBuilder.create("quiz1.txt", 30);
    //     this.fileBuilder.size("quiz1.txt");
    //     this.fileBuilder.cd("..");
    //     this.fileBuilder.size("CSci41");
    //     this.fileBuilder.ls("CSci41");
    //     this.fileBuilder.del("CSci41");
    //     this.fileBuilder.cd("..");
    //     this.fileBuilder.size("Course");
    //     this.fileBuilder.exit();
    // } 
}