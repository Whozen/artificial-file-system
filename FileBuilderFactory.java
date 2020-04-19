public interface FileBuilderFactory 
{ 	
	// public FileSystem getFile();
    
    public void mkdir(String fileName); 
  
    public void create(String fileName, int fileSize); 
  
    public void cd(String fileName); 
  
    public void rmdir(String fileName); 
  
    public void del(String fileName); 

    public void size(String fileName);

    public void ls(String fileName); 

    public int exit(); 
} 