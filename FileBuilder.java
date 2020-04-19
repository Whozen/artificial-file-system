/* "Abstract Builder" */
public abstract class FileBuilder {
    protected FileSystem fileSystem;

    public Pizza getFile() {
        return fileSystem;
    }

    public void createNewFileSystem() {
        fileSystem = new Pizza();
    }

    public abstract void makeDir();
    public abstract void changeDir();
    public abstract void createFile();
    public abstract void deleteFile();
    public abstract void listAll();
    public abstract void getSize();
    public abstract void exitAll();
}

/* "ConcreteBuilder" */
class ScriptOne extends FileBuilder {
    public void makeDir() {
    }

    public void changeDir() {
    }

    public void createFile() {
    }

    public void deleteFile() {
    }

    public void listAll() {
    }

    public void getSize() {
    }

    public String exitAll() {
    }
}