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
import java.util.List;

public class FixBackupFail {

	static int countDel = 0;
	static int countRen = 0;
	static int countErr = 0;

	public FixBackupFail() {
	}

	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length > 0) {
			final File folder = new File(args[0]);
			analisarArquivosNoDiretorio(folder);

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
	public static void analisarArquivosNoDiretorio(File folder) {

		for (final File entry : folder.listFiles()) {

			if (entry.isDirectory()) {
				
				
				System.out.println("Current directory... " + entry.getName());
				
				for(File file : entry.listFiles()){
					tratarArquivosDuplicadosPadronizados(file);
				}
				
				/*if(entry.getName().equals(".svn")){
					System.out.println("[EXCLUIR .svn] - Diretório '".concat(entry.getName()).concat("' será removido."));
					
					deleteDirectoryAndFiles(entry);
				}*/
				
				analisarArquivosNoDiretorio(entry);
			}
		}
	}

	/**
	 * 
	 * @param file
	 */
	public static void printDetele(File file) {
		System.out.println("Deleting... " + file.getAbsolutePath());
	}

	
	public static void deleteDirectoryAndFiles(File dir) {
		
		if (dir.isDirectory()) {
	        for (File sub : dir.listFiles()) {
	            delete(sub);
	        }
	    }
		
	    dir.delete();
	}
	
	/**
	 * Delete file
	 * 
	 * @param file
	 */
	public static void delete(File file) {

		printDetele(file);
		
		try {

			FileInputStream fis = new FileInputStream(file);
			fis.close();

			file.delete();// Now the file will get deleted
			System.gc();
			

		} catch (NoSuchFileException x) {
			System.err.format("%s: no such" + " file or directory%n", Paths.get(file.getPath()));
		} catch (DirectoryNotEmptyException x) {
			System.err.format("%s not empty%n", Paths.get(file.getPath()));
		} catch (IOException x) {
			// File permission problems are caught here.
			System.err.println(x);
		}

		countDel++;
	}
	
	public static void limparNomeFileConfiguracao(File file) {
		
		String nameFileOri = file.getName();
		
		//para arquivos que n contém extensão
		if(nameFileOri.contains(".")){
			
			String dir = file.getParent();
			String extesionFileConfiguration = nameFileOri.substring(nameFileOri.lastIndexOf("."), nameFileOri.length());			
			String newName = nameFileOri.substring(0, nameFileOri.indexOf(" "));
			
			File copy = null;
			
			if(nameFileOri.substring(0, nameFileOri.lastIndexOf(".")).equals("(2016_04_13 16_25_18 UTC)")){
				copy = new File(dir.concat(File.separator).concat(extesionFileConfiguration));
				
			} else {
				copy = new File(dir.concat(File.separator).concat(newName).concat(extesionFileConfiguration));
				
			}
			
			try {
				Files.move(Paths.get(file.getAbsolutePath()), Paths.get(copy.getAbsolutePath()),
						StandardCopyOption.ATOMIC_MOVE);
				System.gc();
				
				countRen++;
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}			
		}
	}
	
	public static void limparNomeFilePadrinizado(File file) {
		
		String nameFileOri = file.getName();
		String dir = file.getParent();
		String  extensao = nameFileOri.substring(nameFileOri.lastIndexOf("."), nameFileOri.length());
		
		File copy = new File(dir.concat(File.separator).concat(nameFileOri.substring(0, nameFileOri.indexOf(" ")).concat(extensao)));
		
		try {
			Files.move(Paths.get(file.getAbsolutePath()), Paths.get(copy.getAbsolutePath()),
					StandardCopyOption.ATOMIC_MOVE);
			System.gc();
			
			countRen++;
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static List<Arquivo> tratarArquivosDuplicadosPadronizados(File file) {
		
		if(!file.isFile())
			return null;
		
		/*if(file.getName().contains(".svn"))
			return null;*/
		
		List<Arquivo> dupli = new ArrayList<Arquivo>();
		
		if(file.getName().contains(" (2016_01_15 14_30_27 UTC)") || file.getName().contains("(2016_01_15 14_30_27 UTC)")){
			System.out.println("[EXCLUIR] - O arquivo '".concat(file.getName()).concat("' foi indentificado como alvo."));
			
			delete(file);
		}
		
		if(file.getName().contains(" (2016_01_21 22_33_35 UTC)") || file.getName().contains("(2016_01_21 22_33_35 UTC)")){
			System.out.println("[EXCLUIR] - O arquivo '".concat(file.getName()).concat("' foi indentificado como alvo."));
			
			delete(file);
		}
		
		if(file.getName().contains(" (2016_01_28 21_08_36 UTC)") || file.getName().contains("(2016_01_28 21_08_36 UTC)")){
			System.out.println("[EXCLUIR] - O arquivo '".concat(file.getName()).concat("' foi indentificado como alvo."));
			
			delete(file);
		}
		
		// o que deve permanecer
		if(file.getName().contains(" (2016_04_13 16_25_18 UTC)") || file.getName().contains("(2016_04_13 16_25_18 UTC)")){
			System.out.println("[TRATAR] - O arquivo '".concat(file.getName()).concat("' foi indentificado como alvo."));
			
			if(!possuiNomeAntesExtensao(file)){
				
				if(file.getName().contains(".")){
					limparNomeFileConfiguracao(file);
					
				} else {
					System.out.println("[WINDOWS] - O  arquivo '".concat(file.getName()).concat("' não poderá ser recuperação no Windows."));
					delete(file);
					
					return null;
				}
				
			}
			
			if(isFileConfiguration(file)){
				System.out.println("[CONFIGURATION] - Arquivo '".concat(file.getName()).concat("' de configuração de projeto."));
				limparNomeFileConfiguracao(file);
				
				return null;
			}
			
			limparNomeFilePadrinizado(file);
		}
		
		return dupli;
	}
	
	private static boolean isFileConfiguration(File file) {
		
		if(file.getName().contains(".")){
			String fileName = file.getName().substring(file.getName().lastIndexOf("."), file.getName().length());
			
			if(fileName.length() > 0){
				return true;
			}			
		}
		
		return false;
	}
	
	private static boolean possuiNomeAntesExtensao(File file) {
		
		if(file.getName().contains(".")){
			String fileName = file.getName().substring(0, file.getName().lastIndexOf("."));
			
			if(fileName.length() > 0){
				return true;
			}			
		}
		
		return false;
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
}
