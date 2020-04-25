public interface FileBuilderFactory 
{ 	
	//Create directory in the current directory
    public void mkdir(String fileName); 
    
    //Create a new file in the current directory
    public void create(String fileName, int fileSize); 
    
    //Change directory to the given filename
    public void cd(String fileName); 
    
    //Remove a file or directory in the current directory
    public void del(String fileName); 

    //Get size of file or directory
    public void size(String fileName);

    //Set new size of the File with newSize
    public void resize(String fileName, int newSize);

    //Display the file info or display all the files in the Directory 
    public void ls(String fileName); 

    //Display all the files in the current Directory
    public void ls(); 

    //Display the File Heirarchy of the current FileSystem
    public void displayFileHeirarchy(); 

    //Delete all the FileSystems defered by the Delete Proxy pattern and exit the program
    public int exit(); 
} 