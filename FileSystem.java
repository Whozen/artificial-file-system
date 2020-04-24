public abstract class FileSystem {
	public void accept(Visitor visitor) {}

	public void accept(Visitor visitor, FileSystem fs) {
		throw new UnsupportedOperationException();
	}

	public void accept(Visitor visitor, int newSize) {
		throw new UnsupportedOperationException();
	}

	public int getDelStatus() { 
	    throw new UnsupportedOperationException();
	}

	public void setDelStatus(int newDelStatus) { 
	    throw new UnsupportedOperationException();
	}

	// This allows me to add components
	public void add(FileSystem newFileSystem) {
		throw new UnsupportedOperationException();
	}
	
	// This allows me to remove components
	public void remove(FileSystem newFileSystem) {
		throw new UnsupportedOperationException();
	}

	public void removeAll() {
		throw new UnsupportedOperationException();
	}
		
	// This allows me to get components
	public FileSystem getFileSystem(String name) {
		throw new UnsupportedOperationException();
	}
	
	// This allows me to retrieve song names
	public String getName() {
		throw new UnsupportedOperationException();
	}

	public int getSize() {
		throw new UnsupportedOperationException();
	}

	public void reSize() {
		throw new UnsupportedOperationException();
	}


	// This allows me to retrieve band names
	public void printSize() {
		throw new UnsupportedOperationException();
	}
	
	
	// When this is called by a class object that extends
	// FileSystem it will print out information
	// specific to the Song or SongGroup
	public void displayFileInfo() {
		throw new UnsupportedOperationException();
	} 
}