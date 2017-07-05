package br.com.oryaj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class P {

	static int countDel = 0;
	static int countRen = 0;
	static int countErr = 0;

	public P() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		if (args.length > 0) {
			final File folder = new File(args[0]);
			listFilesForFolder(folder);

			System.out.println("Files deletaded: " + countDel);
			System.out.println("Files renamed: " + countRen);
			System.out.println("Files with error: " + countErr);

		} else {
			System.out.println("Info path of directory.");
			System.exit(0);
		}

	}

	public static void listFilesForFolder(File folder) {

		File newFile = null;
		File currDir = null;

		for (final File fileEntry : folder.listFiles()) {

			if (fileEntry.isDirectory()) {
				System.out.println("Current directory... " + fileEntry.getName());
				currDir = fileEntry;

				GenericExtFilter g = new GenericExtFilter(fileEntry);

				if (g.accept(fileEntry, null)) {
					g.print(); // print values

					if (g.get().size() > 0)

						for (File f : g.get()) {

							delete(f); // delete file

						}

				}

				listFilesForFolder(fileEntry);

			} else {

				newFile = new File(P.rename(fileEntry));
				
				if (newFile.exists()) // file exist
					continue;

				try {

					if (!newFile.exists()) { // file not exist
							currDir = new File(fileEntry.getAbsoluteFile().getParentFile().getAbsolutePath());
							newFile.setWritable(true);
							
							if(fileEntry.renameTo(newFile))
								System.out.println("File renamed...: " + fileEntry.getName() + " to " + newFile.getName() + " in " + currDir.getName());
							
							else{
					            System.out.println("File already exists.");
					          }
							
							countRen++;
						
					}

				} catch (Exception e) {
					countErr++;
					System.err.println(e.getLocalizedMessage() + ": " + e.getMessage());
				}

			}

		}

	}

	/**
	 * 
	 * @param f1
	 */
	public static void print(File f1) {
		System.out.println("Deleting... " + f1.getAbsolutePath());
	}

	/**
	 * Delete file
	 * 
	 * @param f1
	 */
	public static void delete(File f1) {

		try {

			FileInputStream fis = new FileInputStream(f1);
			fis.close();

			f1.delete();// Now the file will get deleted

		} catch (NoSuchFileException x) {
			System.err.format("%s: no such" + " file or directory%n", Paths.get(f1.getPath()));
		} catch (DirectoryNotEmptyException x) {
			System.err.format("%s not empty%n", Paths.get(f1.getPath()));
		} catch (IOException x) {
			// File permission problems are caught here.
			System.err.println(x);
		}

		countDel++;

	}

	public static String rename(File file) {

		//if (file.exists() & file.getName().contains("(2016_04_13 16_25_18 UTC)")) {

			String nameFileOri = file.getName();
			
			if(nameFileOri.contains("(") && nameFileOri.contains("UTC")) {
			
				int indexIni = nameFileOri.indexOf("(");
				int indexDot = nameFileOri.lastIndexOf(".");
				if (indexDot != -1) {

					String sfinal = nameFileOri.substring(indexDot);
					String path = file.getAbsoluteFile().getParentFile().getAbsolutePath();
					return path + "\\" + nameFileOri.substring(0, indexIni).trim() + sfinal;
				}
			}

			

		//}

		return file.getPath();
	}
}
