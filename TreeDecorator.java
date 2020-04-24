public class TreeDecorator implements DirectoryTreeDisplay {
	private DirectoryTreeDisplay dirDisplay;

	public TreeDecorator() { 
		dirDisplay = null;
	}

	public TreeDecorator(DirectoryTreeDisplay dtd) { 
		dirDisplay = dtd;
	}

	public void display() { 
		if(dirDisplay != null) {
			dirDisplay.display();
		}
	}
}