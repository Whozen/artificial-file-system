public class FileBuilder implements FileBuilderFactory
{ 
    private FileSystem mainDir;
    private FileSystem subDir;
    private FileSystem subFile;
    private FileSystem rootDir;
    private FileIterator showAll;
    private FileIterator tempShowAll;

    private FileSystem[] path;
    
    private int pathPointer;
  
    public FileBuilder()  
    { 
        this.mainDir = new Directories("Root");
        this.rootDir = this.mainDir;
        this.showAll = new FileIterator(this.mainDir);
        this.path = new FileSystem[10];
        this.path[0] = this.mainDir;
        this.pathPointer = 0;

    }
    

    //Create directory in the current directory
    public void mkdir(String dirName)  
    {
        this.mainDir.add( new Directories(dirName) );
        System.out.println( dirName + " Directory created\n" );
    } 


    //Create a new file in the current directory
    public void create(String fileName, int fileSize)  
    {
        this.mainDir.add( new File(fileName, fileSize ) );
        System.out.println( fileName + " file created\n" );
    } 


    //Remove a directory in the current directory
    // public void rmdir(String fileName)  
    // {   
    //     try {
    //         this.subDir = this.mainDir.getFileSystem(fileName);
    //         this.mainDir.remove(this.subDir);

    //         System.out.println( fileName + " Directory removed\n" );
    //     } catch (UnsupportedOperationException e) {
    //         System.out.println( fileName + " not found.\n" );
    //     }
    // } 
    

    //Remove a file or directory in the current directory
    public void del(String fileName)  
    {   
        try {
            this.subFile = this.mainDir.getFileSystem(fileName);
            this.mainDir.remove(this.subFile);
            System.out.println( fileName + " has successfully been removed.\n" );
        } catch (UnsupportedOperationException e) {
            System.out.println( fileName + " not found.\n" );
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
    public void size(String fileName)  
    {
        if( fileName.contains(".txt") ) {
            try {
                this.subFile = this.mainDir.getFileSystem(fileName);
                System.out.println( this.subFile.getSize() + "\n");
            } catch (UnsupportedOperationException e) {
                System.out.println( fileName + " not found.\n" );
            } 
        } else {
            try {
                System.out.println( "Directory has no size.\n" );
                // this.subDir = this.rootDir.getFileSystem(fileName);
                // this.subDir.printSize();
            } catch (UnsupportedOperationException e) {
                System.out.println( fileName + " not found.\n" );
            }
        }
    }


    //Change directory
    public void cd(String fileName)  
    {
        if( fileName.equals("..") ) {
            this.path[this.pathPointer] = null;
            this.mainDir = this.path[--this.pathPointer];
            this.showAll = new FileIterator(this.mainDir);
            System.out.println("Directory Changed to " + this.mainDir.getName() + "\n");
        } else {
            this.subDir = this.mainDir.getFileSystem(fileName);
            this.mainDir = this.subDir;
            this.showAll = new FileIterator(this.mainDir);
            this.path[++this.pathPointer] = this.mainDir;
            System.out.println("Directory Changed to " + fileName + '\n');
        }
    }


    //Display all the contents in the Directory
    public void ls(String fileName)  
    {
        if( (fileName != null) && (fileName.contains(".txt")) ) {
            try {
                this.subFile = this.mainDir.getFileSystem(fileName);
                System.out.println( this.subFile.getName() );
                System.out.println( this.subFile.getSize() );
            } catch (UnsupportedOperationException e) {
                System.out.println( fileName + " not found.\n" );
            }
        } else if( fileName != null ) {
            try {
                // subDir = mainDir.getFileSystem(fileName);
                // subDir.displayFileContents();

                this.subDir = this.rootDir.getFileSystem(fileName);
                this.tempShowAll = new FileIterator(this.subDir);
                this.tempShowAll.getFileList();
            } catch (UnsupportedOperationException e) {
                System.out.println( fileName + " not found.\n" );
            }
        } else {
            this.showAll.getFileList();

            //mainDir.displayFileContents();
        }
    }


    //Exit the program
    public int exit()  
    {
        return 0;
    }
} 