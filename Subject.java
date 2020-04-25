public class Subject {
    private FileBuilderFactory fileBuilder;
    private DirectoryTreeDisplay tree;

    public Subject(FileBuilderFactory fb) {
        this.fileBuilder = fb;
        this.tree = TreeConfiguration.getDecoratedTree(fb);
    }

    
    public void execute() {
        this.tree.display();
    }
}