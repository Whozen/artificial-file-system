public interface FileBuilderFactory 
{ 	
	// public FileSystem getFile();
    
    public void mkdir(String fileName); 
  
    public void create(String fileName, int fileSize); 
  
    public void cd(String fileName); 
  
    public void del(String fileName); 

    public void size(String fileName);

    public void resize(String fileName, int newSize);

    public void ls(String fileName); 

    public void exit(); 
} 