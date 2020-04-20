import java.util.ArrayList;
import java.util.Iterator;

public class Directories extends FileSystem {
	
	// Contains any Songs or Directories that are added
	// to this ArrayList
	
	ArrayList fileSystems = new ArrayList();
	
	String directoryName;
	
	public Directories(String newDirectoryName) {
		directoryName = newDirectoryName;
	}
	
	public String getName() { return directoryName; }

	public int getSize() { return 100; }

	
	public void add(FileSystem newFileSystem) {
		
		fileSystems.add(newFileSystem);
		
	}
	
	public void remove(FileSystem newFileSystem) {
		
		fileSystems.remove(newFileSystem);
		
	}


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
	
	public void displayFileInfo(){
		
		System.out.println(directoryName + "\n");
		
		Iterator fileIterator = fileSystems.iterator();
		
		while(fileIterator.hasNext()) { 
			
			FileSystem fileInfo = (FileSystem) fileIterator.next();
			
			fileInfo.displayFileInfo();
			
		}
		
	}



	public void printSize(){
		
		Iterator fileIterator = fileSystems.iterator();
		
		while(fileIterator.hasNext()) { 
			
			FileSystem fileInfo = (FileSystem) fileIterator.next();
			
			System.out.println(fileInfo.getSize());
			
		}
		
	}

}