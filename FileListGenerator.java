import java.util.Scanner; 

public class FileListGenerator {
	
	public static void main(String[] args){
		int x = 0;

		// Top level component that holds everything
		FileSystem mainDir = new Directories("Root");
		FileSystem subDir;
		FileSystem subFile;
		FileSystem rootDir = mainDir;
		FileIterator showAll = new FileIterator(mainDir);
		FileIterator tempShowAll;

		FileSystem[] path = new FileSystem[10];
		path[0] = mainDir;
		int pathPointer = 0;
		//String parentName;

		while( x == 0 ) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Command: ");  
			String ip = sc.nextLine();
			System.out.print("\n \n");  
			String[] cmd_arr = ip.split(" ");

			switch (cmd_arr[0]) {
				case "mkdir":
				    mainDir.add(new Directories(cmd_arr[1]));
				  	System.out.println( cmd_arr[1] + " Directory created\n" );
				    break;

				case "create":
					mainDir.add(new File(cmd_arr[1], Integer.parseInt(cmd_arr[2]) ) );
					System.out.println( cmd_arr[1] + " File created\n" );
					break;

				case "cd":
					if( cmd_arr[1].equals("..") ) {
						path[pathPointer] = null;
						mainDir = path[--pathPointer];
						showAll = new FileIterator(mainDir);
						System.out.println("Directory Changed to " + mainDir.getName() + "\n");
					} else {
						try {
						    subDir = mainDir.getFileSystem(cmd_arr[1]);
							mainDir = subDir;
							showAll = new FileIterator(mainDir);
							path[++pathPointer] = mainDir;
							System.out.println("Directory Changed to " + cmd_arr[1] + '\n');
						} catch (UnsupportedOperationException e) {
						    System.out.println( cmd_arr[1] + " not found.\n" );
						}
					}

				    break;

				case "rmdir":
					try {
					    subDir = mainDir.getFileSystem(cmd_arr[1]);
						mainDir.remove(subDir);

					    System.out.println( cmd_arr[1] + " Directory removed\n" );
					} catch (UnsupportedOperationException e) {
					    System.out.println( cmd_arr[1] + " not found.\n" );
					}
					
				    break;

				case "del":
					try {
					    subDir = mainDir.getFileSystem(cmd_arr[1]);
						mainDir.remove(subDir);
					    System.out.println( cmd_arr[1] + " has successfully been removed.\n" );
					} catch (UnsupportedOperationException e) {
					    System.out.println( cmd_arr[1] + " not found.\n" );
					}
					

					// if( cmd_arr[1].contains(".txt") ) {
					// 	subFile = mainDir.getFileSystem(cmd_arr[1]);
					// 	mainDir.remove(subFile);
					// } else {
					// 	// subDir = rootDir.getFileSystem(cmd_arr[1]);
					// 	// subDir.removeAll();
					// }
					break;

				case "size":
					try {
					    subDir = mainDir.getFileSystem(cmd_arr[1]);
						subDir.printSize();
					} catch (UnsupportedOperationException e) {
					    System.out.println( cmd_arr[1] + " not found.\n" );
					}
					
					// if( cmd_arr[1].contains(".txt") ) {
					// 	subFile = mainDir.getFileSystem(cmd_arr[1]);
					// 	System.out.println( subFile.getSize() );
					// } else {
					// 	subDir = rootDir.getFileSystem(cmd_arr[1]);
					// 	subDir.printSize();
					// }
					break;

				case "ls":
					if( cmd_arr.length == 2 ) {
						try {
						    subDir = mainDir.getFileSystem(cmd_arr[1]);
							tempShowAll = new FileIterator(subDir);
							tempShowAll.getFileList();
						} catch (UnsupportedOperationException e) {
						    System.out.println( cmd_arr[1] + " not found.\n" );
						}
					} else {
					    showAll.getFileList();
					}

					// if( (cmd_arr.length == 2) && (cmd_arr[1].contains(".txt")) ) {
					// 	subFile = mainDir.getFileSystem(cmd_arr[1]);
					// 	System.out.println( subFile.getName() );
					// 	System.out.println( subFile.getSize() );
					// } else if( cmd_arr.length == 2 ) {
					// 	subDir = mainDir.getFileSystem(cmd_arr[1]);
					// 	tempShowAll = new FileIterator(subDir);
					// 	tempShowAll.getFileList();
					// } else {
					// 	showAll.getFileList();
					// }
					break;

			    case "exit":
			    	x++;
			    	break;
			    	
			    default:
			    	System.out.println("Incorrect Command\n");
			    	break;
			}	
		}
		
	}
	
}