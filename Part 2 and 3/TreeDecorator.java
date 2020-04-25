public class TreeDecorator implements DirectoryTreeDisplay {
	private DirectoryTreeDisplay dirDisplay;

	public TreeDecorator() { 
		dirDisplay = null;
	}

	//Initialize the DirectoryTreeDisplay for decorating the File Structure Heirarcy with the 
	//DirectoryBrowserAdapter object passed as parameter
	public TreeDecorator(DirectoryTreeDisplay dtd) { 
		this.dirDisplay = dtd;
	}

	//Call the display function of the adapter object
	public void display() { 
		if(this.dirDisplay != null) {
			this.dirDisplay.display();
		}
	}
}