public class TreeConfiguration {

	//This function returns the File Heirarchy with Header and Footer design pattern returned by
	//the adapter
	public static DirectoryTreeDisplay getDecoratedTree(FileBuilderFactory fb) {
		return
			new HeaderTreeDecorator(
			new FooterTreeDecorator(
			new DirectoryBrowserAdapter(fb) ));
	}
}