import java.util.ArrayList;
import java.util.Iterator;

public class FileBuilder implements FileBuilderFactory { 
    private FileSystem mainDir;
    private FileSystem subDir;
    private FileSystem subFile;
    private FileSystem rootDir;
    private FileIterator showAll;
    private FileIterator tempShowAll;

    private ArrayList<FileSystem> myPath = new ArrayList<FileSystem>();
    //private FileSystem[] path;
    
    private int pathPointer;
  
    public FileBuilder() { 
        this.mainDir = new Directories("Root");
        this.rootDir = this.mainDir;
        this.showAll = new FileIterator(this.mainDir);
        //this.path = new FileSystem[10];
        //this.path[0] = this.mainDir;
        this.myPath.add(this.mainDir);
        this.pathPointer = 0;

    }
    

    //Create directory in the current directory
    public void mkdir(String dirName) {
        this.mainDir.add( new Directories(dirName) );
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
            this.mainDir.remove(this.subFile);
            System.out.println( "Del: " + fileName + " has successfully been removed.\n" );
        } catch (UnsupportedOperationException e) {
            System.out.println( "Del:" + fileName + " not found.\n" );
        }

        // if( fileName.contains(".txt") ) {
        //     try {
        //         this.subFile = this.mainDir.getFileSystem(fileName);
        //         this.mainDir.remove(this.subFile);
        //         System.out.println( fileName + " has successfully been removed.\n" );
        //     } catch (UnsupportedOperationException e) {
        //         System.out.println( fileName + " not found.\n" );
        //     }
        // } else {
        //     try {
        //         this.subDir = this.mainDir.getFileSystem(fileName);
        //         this.mainDir.remove(this.subDir);
        //         System.out.println( fileName + " has successfully been removed.\n" );
        //     } catch (UnsupportedOperationException e) {
        //         System.out.println( fileName + " not found.\n" );
        //     }
        // }
    }


    //Get size of file or directory
    public void size(String fileName) {
        try {
            this.subDir = this.mainDir.getFileSystem(fileName);
            this.subDir.printSize();
        } catch (UnsupportedOperationException e) {
            System.out.println( "Size: " + fileName + " not found.\n" );
        }


        // if( fileName.contains(".txt") ) {
        //     try {
        //         this.subFile = this.mainDir.getFileSystem(fileName);
        //         System.out.println( this.subFile.getSize() + "\n");
        //     } catch (UnsupportedOperationException e) {
        //         System.out.println( fileName + " not found.\n" );
        //     } 
        // } else {
        //     try {
        //         System.out.println( "Directory has no size.\n" );
        //         // this.subDir = this.rootDir.getFileSystem(fileName);
        //         // this.subDir.printSize();
        //     } catch (UnsupportedOperationException e) {
        //         System.out.println( fileName + " not found.\n" );
        //     }
        // }
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
        for (int i = 0; i < myPath.size(); i++) {
            System.out.print( myPath.get(i).getName() + "/" );
        }
        System.out.println("\n");
    }


    //Display all the contents in the Directory
    public void ls(String fileName) {
        System.out.println( "Current Path:" );
        for (int i = 0; i < myPath.size(); i++) {
            System.out.print( myPath.get(i).getName() + "/" );
        }
        System.out.println("\n");

        if( fileName != null ) {
            try {
                this.subDir = this.mainDir.getFileSystem(fileName);
                this.tempShowAll = new FileIterator(this.subDir);
                this.tempShowAll.getFileList();
            } catch (UnsupportedOperationException e) {
                System.out.println( fileName + " not found.\n" );
            }
        } else {
            this.showAll.getFileList();
        }

        // if( (fileName != null) && (fileName.contains(".txt")) ) {
        //     try {
        //         this.subFile = this.mainDir.getFileSystem(fileName);
        //         System.out.println( this.subFile.getName() );
        //         System.out.println( this.subFile.getSize() );
        //     } catch (UnsupportedOperationException e) {
        //         System.out.println( fileName + " not found.\n" );
        //     }
        // } else if( fileName != null ) {
        //     try {
        //         // subDir = mainDir.getFileSystem(fileName);
        //         // subDir.displayFileContents();

        //         this.subDir = this.rootDir.getFileSystem(fileName);
        //         this.tempShowAll = new FileIterator(this.subDir);
        //         this.tempShowAll.getFileList();
        //     } catch (UnsupportedOperationException e) {
        //         System.out.println( fileName + " not found.\n" );
        //     }
        // } else {
        //     this.showAll.getFileList();

        //     //mainDir.displayFileContents();
        // }
    }


    //Exit the program
    public int exit() {
        System.out.println( "Exiting the system\n" );
        return 0;
    }
} 