import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends FileSystem { 
    
    ArrayList fileSystems = new ArrayList();
    String directoryName;
    int delStatus = 0;
    
    //Constructor
    public Directory(String newDirectoryName) {
        directoryName = newDirectoryName;
    }


    //Accept a Visitor as parameter
    public void accept(Visitor visitor) { 
        visitor.visit(this); 
    } 


    //Accept a Visitor and FileSystem as a paramter
    public void accept(Visitor visitor, FileSystem fs) { 
        visitor.visit(this, fs); 
    }


    //Get Directory Name
    public String getName() { 
        return directoryName; 
    }


    //Get Directory delete status
    public int getDelStatus() { 
        return delStatus;
    }


    //Set Directory delete status
    public void setDelStatus(int newDelStatus) { 
        delStatus = newDelStatus;
    }


    //Add new FileSystem passed from parameter to the current Directory
    public void add(FileSystem newFileSystem) {
        fileSystems.add(newFileSystem);
    }
    
    
    //If the realDelete paramter is 0, pretend to delete the FileSystem passed from parameter 
    //from the current Directory by setting the delete status of the FileSystem object to 1 
    //and diplaying delete message. (Del command)
    //If the realDelete paramter is 1, remove the FileSystem passed from parameter in the current 
    //Directory and display real delete message. (Exit command)
    public void remove(FileSystem newFileSystem, int realDelete) {
        if(realDelete == 1) {
            fileSystems.remove(newFileSystem);
            System.out.println(newFileSystem.getName() + " deleted for real\n");
        } else {
            newFileSystem.setDelStatus(1);
            System.out.println(newFileSystem.getName() + " deleted\n");
        }
    }


    //Iterate through the current Directory to get the FileSystem with name given in parameter
    public FileSystem getFileSystem(String name) { 
        Iterator fileIterator = fileSystems.iterator();
        
        while(fileIterator.hasNext()) { 
            FileSystem fileInfo = (FileSystem)fileIterator.next();
            String fName = fileInfo.getName();
            int fStatus = fileInfo.getDelStatus();
            if( (fName.equals(name)) && ( fStatus== 0) ) {
                return fileInfo;
            }
        }

        throw new UnsupportedOperationException();
    }
    

    //Iterate through the current Directory to display the FileSystems in it
    public void displayFileInfo() {
        System.out.println(directoryName + "\n");       
        Iterator fileIterator = fileSystems.iterator();
    
        while(fileIterator.hasNext()) { 
            FileSystem fileInfo = (FileSystem) fileIterator.next();
            fileInfo.displayFileInfo();
        }
    }


    //Iterate through the current Directory to display the size of all the FileSystems in it
    public void printSize(){
        System.out.println("Size inside " + directoryName + "\n");  

        Iterator fileIterator = fileSystems.iterator();
        
        while(fileIterator.hasNext()) { 
            FileSystem fileInfo = (FileSystem) fileIterator.next();
            fileInfo.printSize();
        }
    }
   
}