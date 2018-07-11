package br.com.oryaj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2 {

	static int countDel = 0;
	static int countRen = 0;
	static int countErr = 0;

	public P2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * 
	 * @param args
	 */
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

	/**
	 * 
	 * 
	 * @param folder
	 */
	public static void listFilesForFolder(File folder) {

		for (final File fileEntry : folder.listFiles()) {

			if (fileEntry.isDirectory()) {
				System.out.println("Current directory... " + fileEntry.getName());
				
				//String[] c = fileEntry.list(new GenericExtFilter(fileEntry)); 
				
				List<File> contaminados  = new GenericExtFilter(fileEntry).get();
				
				for(File f : fileEntry.listFiles()){
					listDuplicados(f);
					P2.limparNomeFile(f);
						
				}
				
				listFilesForFolder(fileEntry);
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
			System.gc();

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

	public static void limparNomeFile(File file) {

		//if (file.exists() & file.getName().contains("(2016_04_13 16_25_18 UTC)")) {

			String nameFileOri = file.getName();
			String dir = file.getParent();
			String extensao = null;
			
		if (nameFileOri.contains(".")) {

			extensao = nameFileOri.substring(nameFileOri.lastIndexOf("."), nameFileOri.length());
		}

		if(extensao.length() == 4 || extensao.equals(".properties")){
			
			//int indexIni = nameFileOri.indexOf("(2016");
			int indexFim = nameFileOri.indexOf(" ");
			
			File newFile = null;
			
			//padrao inicio
			if(nameFileOri.contains("(2016_")){
				newFile = new File(dir.concat(File.separator)
						.concat(nameFileOri.substring(26, nameFileOri.indexOf(".")).concat(extensao != null ? extensao : "")));
				
			}
			
			//padro fim
			if(nameFileOri.contains(" (2016_")){
				newFile = new File(dir.concat(File.separator)
						.concat(nameFileOri.substring(0, nameFileOri.indexOf(" ") - 1).concat(extensao != null ? extensao : "")));
				
			}
			
			newFile.canWrite();
			
			if(!newFile.exists()){
				
				try {
					Files.move(Paths.get(file.getAbsolutePath()), Paths.get(newFile.getAbsolutePath()),
							StandardCopyOption.REPLACE_EXISTING);
					System.gc();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} 
			} else {
				delete(file);
			}
		}

	}
	
	private static List<Arquivo> listDuplicados(File file) {
		
		if(!file.isFile())
			return null;
		
		File tmp = file;
		Arquivo a = null;
		List<Arquivo> dupli = new ArrayList<Arquivo>();
		
		try {
			dupli.add(new Arquivo(getCreationTime(file), tmp));
			
		} catch (IOException e1) {
			System.out.println("Falha ao ler o arquivo: ".concat(file.getAbsolutePath()));
		}
		
		for(File f : file.getParentFile().listFiles()){
			
			//if(file.getName().equals(f.getName()) && !f.getAbsolutePath().equals(tmp.getAbsolutePath())){
			
			try {
				a = new Arquivo(getCreationTime(f), f);
			} catch (IOException e1) {
				System.out.println("Falha ao ler o arquivo: ".concat(file.getAbsolutePath()));
			}
			
			//if(dupli.contains(a)){
			if(a.getFile().getName().contains(" (2016_")){
				
				System.out.println("Arquivo ".concat(file.getName()).concat(" duplicado com: ").concat(tmp.getName()));
				System.out.println("Adicionado para limpeza.");
				a.setFile(f);
				
				try {
					a.setFileTime(getCreationTime(f));
					
				} catch (Exception e) {
					System.out.println("Falha ao ler o arquivo: ".concat(file.getAbsolutePath()));
				}
				
				dupli.add(a);
				
				
			}
		}
		
		if(dupli.size()>0)
			dupli.remove(tmp);
			//limparNomeFile(file);
			Collections.sort(dupli);
		
		return dupli;
	}
	
	public static FileTime getCreationTime(File file) throws IOException {
	    Path p = Paths.get(file.getAbsolutePath());
	    BasicFileAttributes view
	        = Files.getFileAttributeView(p, BasicFileAttributeView.class)
	                    .readAttributes();
	    FileTime fileTime=view.creationTime();
	    //  also available view.lastAccessTine and view.lastModifiedTime
	    return fileTime;
	  }
	
	private static void limparNomeFileMetaDataProject(File file) {


			String nameFileOri = file.getName();
			String dir = file.getParent();
			String extensao = null;
			
		if (nameFileOri.contains(".")) {

			extensao = nameFileOri.substring(nameFileOri.lastIndexOf("."), nameFileOri.length());
		}
		
		if(extensao.length() > 4){
			delete(file);
		}

	}
}
