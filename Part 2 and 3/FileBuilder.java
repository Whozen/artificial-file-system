import java.util.ArrayList;
import java.util.Iterator;

public class FileBuilder implements FileBuilderFactory { 
    private FileSystem mainDir;
    private FileSystem rootDir;
    private FileSystem subDir;
    private FileSystem subFile;
    private FileSystem delFile;

    //Initialize the subject for the Observer Pattern.
    private Subject subj = new Subject(this);

    private Visitor sizeVisit = new SizeVisitor();

    private Visitor resVisit = new ResizeVisitor();

    private Visitor lsVisit = new LsVisitor();

    private Visitor delVisit = new DeleteVisitor();

    private Visitor delProxy = new ProxyDelete();

    private Visitor exitVisitor = new ExitVisitor();

    //A FileSystem array used to store path of the current FileSystem
    private ArrayList<FileSystem> myPath = new ArrayList<FileSystem>();
    
    //Pointer of the current path of FileSystem
    private int pathPointer;

    //A FileSystem array used to store FileSystem whose deletion has been defered
    private ArrayList<FileSystem> deletedFileSystems = new ArrayList<FileSystem>();
    
  
    //Constructor
    //Initializes the FileSystem with Root Directory
    //Adds the Root Directory to the path array and updates pathPointer
    public FileBuilder() { 
        this.mainDir = new Directory("Root");
        this.rootDir = this.mainDir;
        this.myPath.add(this.mainDir);
        this.pathPointer = 0;

    }
    

    //Create a new directory in the current directory with directory name given in parameter
    public void mkdir(String dirName) {
        this.mainDir.add( new Directory(dirName) );
        System.out.println( "Mkdir: " + dirName + " Directory created\n" );
        System.out.println("------------------------------------\n");
    } 


    //Create a new file in the current directory with file name and size given in parameter 
    public void create(String fileName, int fileSize) {
        this.mainDir.add( new File(fileName, fileSize ) );
        System.out.println( "Create: " + fileName + " file created\n" );
        System.out.println("------------------------------------\n");
    } 
    

    //Remove a file or directory in the current directory
    //Get the FileSystem with name provided in parameter and call the accept() function of the
    //FileSystem and pass the Delete Proxy and FileSystem to be deleted
    //Also, add the file to be deleted to the deletedFileSystems array to be deleted later
    public void del(String fileName) {   
        try {
            this.subFile = this.mainDir.getFileSystem(fileName);
            this.deletedFileSystems.add(this.subFile);
            this.mainDir.accept(this.delProxy, this.subFile);
        } catch (UnsupportedOperationException e) {
            System.out.println( "Del:" + fileName + " not found.\n" );
        }
        System.out.println("------------------------------------\n");
    }


    //Get the FileSystem with name provided in parameter and call the accept() function of the
    //FileSystem and pass the Size Visitor as the parameter
    public void size(String fileName) {
        try {
            this.subDir = this.mainDir.getFileSystem(fileName);
            this.subDir.accept(this.sizeVisit);
        } catch (UnsupportedOperationException e) {
            System.out.println( "Size: " + fileName + " not found.\n" );
        }
        System.out.println("------------------------------------\n");
    }


    //Get the FileSystem with name provided in parameter and call the accept() function of the
    //FileSystem and pass the Resize Visitor and the new size as the parameter
    //After resizing is done, call the execute function of the Subject of the Observer pattern
    //to display the File Structure Heirarchy
    public void resize(String fileName, int newSize) {
        try {
            this.subFile = this.mainDir.getFileSystem(fileName);
            this.subFile.accept(this.resVisit, newSize);

            this.subj.execute();
        } catch (UnsupportedOperationException e) {
            System.out.println( "Size: " + fileName + " not found.\n" );
        }
        System.out.println("------------------------------------\n");
    }


    //If the parameter given is "..", remove the current FileSystem pointed by pathPointer and
    //set the pathPointer to the previous FileSystem which sets new path in the FileSystem. 
    //If parameter is a filename, get the FileSystem in the current FileSystem using name given
    //in parameter and add it to the path.
    //Display the current path in either case using path array and update the showAll Iterator 
    //with the current FileSystem
    public void cd(String fileName) {
        if( fileName.equals("..") ) {
            this.myPath.remove(this.pathPointer);
            this.pathPointer--;
            this.mainDir = this.myPath.get(this.pathPointer);
            System.out.println("Cd: Directory Changed to " + this.mainDir.getName() + "\n");
        } else {
            try {
                this.subDir = this.mainDir.getFileSystem(fileName);
                this.mainDir = this.subDir;
                this.pathPointer++;
                this.myPath.add(this.mainDir);
                System.out.println("Cd: Directory Changed to " + fileName + '\n');
            } catch (UnsupportedOperationException e) {
                System.out.println( fileName + " not found.\n" );
            }
        }
        //Display the new path of the FileSystem
        System.out.println( "Current Path:" );
        for (int i = 0; i < this.myPath.size(); i++) {
            System.out.print( this.myPath.get(i).getName() + "/" );
        }
        System.out.println("\n\n------------------------------------\n");
    }


    //Display all the contents in the Directory or display the information of the file by 
    //calling accept function and passing Ls Visitor
    public void ls(String fileName) {
        try {
            this.subDir = this.mainDir.getFileSystem(fileName);
            this.subDir.accept(lsVisit);
        } catch (UnsupportedOperationException e) {
            System.out.println( fileName + " not found.\n" );
        }
        System.out.println("------------------------------------\n");
    }


    //Display all the contents in the current FileSystem by calling accept function and passing
    //Ls Visitor
    public void ls() {
        this.mainDir.accept(lsVisit);
        System.out.println("------------------------------------\n");
    }


    //Call the accept function of root directory and pass Ls Visitor
    public void displayFileHeirarchy() {
        this.rootDir.accept(lsVisit);
    }


    //Delete all the FileSystems defered by the Delete Proxy pattern.
    //Display appropriate message and exit the program
    public int exit() {
        for(int i = 0; i < this.deletedFileSystems.size(); i++) {   
            this.delFile = this.deletedFileSystems.get(i);
            this.mainDir = this.myPath.get(0);
            this.mainDir.accept(this.exitVisitor,this.delFile);
        }
        System.out.println( "Exiting the system\n" );
        System.out.println("------------------------------------\n");
        return 0;
    }
} 