public class Subject {
    private FileBuilderFactory fileBuilder;
    private DirectoryTreeDisplay tree;

    //Constructor
    //Initializes the fileBuilder object with the currently running FileBuilder instance
    //Calls the getDecoratedTree() function to get the decorated File Tree Heirarchy instance
    public Subject(FileBuilderFactory fb) {
        this.fileBuilder = fb;
        this.tree = TreeConfiguration.getDecoratedTree(fb);
    }

    //Executes the observer's update function which is display in this case.
    public void execute() {
        this.tree.display();
    }
}