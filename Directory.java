import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends FileSystem { 
    ArrayList fileSystems = new ArrayList();
    String directoryName;
    
    //Constructor
    public Directory(String newDirectoryName) {
        directoryName = newDirectoryName;
    }

    public void accept(Visitor visitor) { 
        visitor.visit(this); 
    } 

    public void accept(Visitor visitor, FileSystem fs) { 
        visitor.visit(this, fs); 
    } 
    
    //Get Directory Name
    public String getName() { return directoryName; }

    //Get Directory Size
    //public int getSize() { return 100; }

    //Add new FileSystem passed from parameter to the current FileSystem
    public void add(FileSystem newFileSystem) {
        fileSystems.add(newFileSystem);
    }
    
    //Delete the FileSystem passed from parameter from the current FileSystem
    public void remove(FileSystem newFileSystem) {
        fileSystems.remove(newFileSystem);
        System.out.println(newFileSystem.getName() + " deleted\n"); 
    }

    //Iterate through the current FileSystem to get the FileSystem with name given in parameter
    public FileSystem getFileSystem(String name) {  
        Iterator fileIterator = fileSystems.iterator();
        
        while(fileIterator.hasNext()) { 
            FileSystem fileInfo = (FileSystem)fileIterator.next();
            String fName = fileInfo.getName();
            if( fName.equals(name) ) {
                return fileInfo;
            }
        }

        throw new UnsupportedOperationException();
    }
    
    //Iterate through the current FileSystem to display the FileSystems in it
    public void displayFileInfo() {
        System.out.println(directoryName + "\n");       
        Iterator fileIterator = fileSystems.iterator();
    
        while(fileIterator.hasNext()) { 
            FileSystem fileInfo = (FileSystem) fileIterator.next();
            fileInfo.displayFileInfo();
        }
    }


    //Iterate through the current FileSystem to display the size of all the FileSystems in it
    public void printSize(){
        System.out.println("Size inside " + directoryName + "\n");  

        Iterator fileIterator = fileSystems.iterator();
        
        while(fileIterator.hasNext()) { 
            FileSystem fileInfo = (FileSystem) fileIterator.next();
            fileInfo.printSize();
        }
    }
   
}