public class TreeConfiguration {

	//This function returns the File Structure Heirarchy integrated with Header and Footer design
	//The current FileBuilder is passed as parameter which consists of all the FileSystem structure
	public static DirectoryTreeDisplay getDecoratedTree(FileBuilderFactory fb) {
		return
			new HeaderTreeDecorator(
			new FooterTreeDecorator(
			new DirectoryBrowserAdapter(fb) ));
	}
}