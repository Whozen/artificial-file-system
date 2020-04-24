import java.util.ArrayList;
import java.util.Iterator;

public class FileBuilder implements FileBuilderFactory { 
    private FileSystem mainDir;
    private FileSystem subDir;
    private FileSystem subFile;
    private FileSystem rootDir;
    private FileSystem delFile;
    private FileIterator showAll;
    private FileIterator tempShowAll;

    private Visitor sizeVisit = new SizeVisitor();

    private Visitor resVisit = new ResizeVisitor();
    //firstFile.accept(resVisit, 20);

    private Visitor lsVisit = new LsVisitor();
    //mainDir.accept(lsVisit);

    private Visitor delVisit = new DeleteVisitor();
    //mainDir.accept(delVisit, appDir);

    private Visitor delProxy = new ProxyDelete();

    private Visitor exitVisitor = new ExitVisitor();

    private ArrayList<FileSystem> myPath = new ArrayList<FileSystem>();
    private ArrayList<FileSystem> deletedFileSystems = new ArrayList<FileSystem>();
    //private FileSystem[] path;
    
    private int pathPointer;
  
    public FileBuilder() { 
        this.mainDir = new Directory("Root");
        this.rootDir = this.mainDir;
        this.showAll = new FileIterator(this.mainDir);
        //this.path = new FileSystem[10];
        //this.path[0] = this.mainDir;
        this.myPath.add(this.mainDir);
        this.pathPointer = 0;

    }
    

    //Create directory in the current directory
    public void mkdir(String dirName) {
        this.mainDir.add( new Directory(dirName) );
        System.out.println( "Mkdir: " + dirName + " Directory created\n" );
    } 


    //Create a new file in the current directory
    public void create(String fileName, int fileSize) {
        this.mainDir.add( new File(fileName, fileSize ) );
        System.out.println( "Create: " + fileName + " file created\n" );
    } 
    

    //Remove a file or directory in the current directory
    public void del(String fileName) {   
        try {
            this.subFile = this.mainDir.getFileSystem(fileName);
            //this.mainDir.accept(delVisit, subFile);
            this.deletedFileSystems.add(this.subFile);
            this.mainDir.accept(this.delProxy, this.subFile);
            
            
            // this.mainDir.remove(this.subFile);
            // System.out.println( "Del: " + fileName + " has successfully been removed.\n" );
        } catch (UnsupportedOperationException e) {
            System.out.println( "Del:" + fileName + " not found.\n" );
        }
    }


    //Get size of file or directory
    public void size(String fileName) {
        try {
            this.subDir = this.mainDir.getFileSystem(fileName);
            this.subDir.accept(this.sizeVisit);
        } catch (UnsupportedOperationException e) {
            System.out.println( "Size: " + fileName + " not found.\n" );
        }
    }


    public void resize(String fileName, int newSize) {
        try {
            this.subFile = this.mainDir.getFileSystem(fileName);
            this.subFile.accept(this.resVisit, newSize);
        } catch (UnsupportedOperationException e) {
            System.out.println( "Size: " + fileName + " not found.\n" );
        }
    }


    //Change directory
    public void cd(String fileName) {
        if( fileName.equals("..") ) {
            //this.path[this.pathPointer] = null;
            this.myPath.remove(this.pathPointer);
            this.pathPointer--;
            this.mainDir = this.myPath.get(this.pathPointer);
            this.showAll = new FileIterator(this.mainDir);
            System.out.println("Cd: Directory Changed to " + this.mainDir.getName() + "\n");
        } else {
            this.subDir = this.mainDir.getFileSystem(fileName);
            this.mainDir = this.subDir;
            this.showAll = new FileIterator(this.mainDir);
            //this.path[++this.pathPointer] = this.mainDir;
            this.pathPointer++;
            this.myPath.add(this.mainDir);
            System.out.println("Cd: Directory Changed to " + fileName + '\n');
        }
        System.out.println( "Current Path:" );
        for (int i = 0; i < this.myPath.size(); i++) {
            System.out.print( this.myPath.get(i).getName() + "/" );
        }
        System.out.println("\n");
    }


    //Display all the contents in the Directory
    public void ls(String fileName) {
        System.out.println( "Current Path:" );
        for (int i = 0; i < this.myPath.size(); i++) {
            System.out.print( this.myPath.get(i).getName() + "/" );
        }
        System.out.println("\n");

        if( fileName != null ) {
            try {
                this.subDir = this.mainDir.getFileSystem(fileName);
                this.subDir.accept(lsVisit);
                // this.tempShowAll = new FileIterator(this.subDir);
                // this.tempShowAll.getFileList();
            } catch (UnsupportedOperationException e) {
                System.out.println( fileName + " not found.\n" );
            }
        } else {
            this.showAll.getFileList();
        }
        mainDir.accept(lsVisit);
    }


    //Exit the program
    public int exit() {
        for(int i = 0; i < this.deletedFileSystems.size(); i++) {   
            this.delFile = this.deletedFileSystems.get(i);
            this.mainDir = this.myPath.get(0);
            this.mainDir.accept(this.exitVisitor,this.delFile);
        }
        System.out.println( "Exiting the system\n" );
        return 0;
    }
} 