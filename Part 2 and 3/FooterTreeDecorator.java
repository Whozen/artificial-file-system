public class FooterTreeDecorator extends TreeDecorator {
	//Constructor
	public FooterTreeDecorator(DirectoryTreeDisplay dirTree){
		super(dirTree);   	
	}

	//Integrate the footer design to the File Structure Heirarchy. It first calls the base classes 
	//display function and then calls its own printFooter function
	public void display() {
		super.display();
		this.printFooter();
	}

	//Displays footer design
	public void printFooter() {
		System.out.println("-----------------Footer-----------------\n--------File Structure Heirarchy--------\n");
	}
}