public abstract class FileSystem {

	//Accept a Visitor as parameter
	public void accept(Visitor visitor) {
		throw new UnsupportedOperationException();
	}

	//Accept a Visitor and FileSystem as a paramter
	public void accept(Visitor visitor, FileSystem fs) {
		throw new UnsupportedOperationException();
	}

	//Accept a Visitor and integer as a paramter
	public void accept(Visitor visitor, int newSize) {
		throw new UnsupportedOperationException();
	}

	//Get the deletion status of FileSystem
	public int getDelStatus() { 
	    throw new UnsupportedOperationException();
	}

	//Set the deletion status of FileSystem
	public void setDelStatus(int newDelStatus) { 
	    throw new UnsupportedOperationException();
	}

	//Add FileSystem to the current FileSystem
	public void add(FileSystem newFileSystem) {
		throw new UnsupportedOperationException();
	}
	
	//Remove a FileSystem to the current FileSystem
	public void remove(FileSystem newFileSystem) {
		throw new UnsupportedOperationException();
	}
		
	//Get FileSystem object in the current FileSystem using name as parameter
	public FileSystem getFileSystem(String name) {
		throw new UnsupportedOperationException();
	}
	
	//Get name of FileSystem
	public String getName() {
		throw new UnsupportedOperationException();
	}

	//Get size of FileSystem
	public int getSize() {
		throw new UnsupportedOperationException();
	}

	//Set size of FileSystem
	public void reSize() {
		throw new UnsupportedOperationException();
	}

	//Display sizes of the FileSystem
	public void printSize() {
		throw new UnsupportedOperationException();
	}
	
	//Display information of the FileSystem
	public void displayFileInfo() {
		throw new UnsupportedOperationException();
	} 
}