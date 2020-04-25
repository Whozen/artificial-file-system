public class HeaderTreeDecorator extends TreeDecorator {
	//Constructor
	public HeaderTreeDecorator(DirectoryTreeDisplay dirTree){
		super(dirTree);   	
	}

	//Integrate the header design to the File Structure Heirarchy
	public void display() {
		this.printHeader();
		super.display();
	}

	//Design for the header
	public void printHeader() {
		System.out.println("--------File Structure Heirarchy--------\n-----------------Header-----------------\n");
	}
}