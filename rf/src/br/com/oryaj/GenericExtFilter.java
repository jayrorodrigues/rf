package br.com.oryaj;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GenericExtFilter {

	private List<File> files;

	private File dir;
	
	public GenericExtFilter(File dir) {
		this.dir = dir;
	}

	
	public boolean accept(File dir, String name) {
		
		if(dir != null && name != null){
			
			//map(dir, name);
			
			if(!files.isEmpty())
				return true;
			
		} else {
			
			//map(this.dir, null);
			if(!files.isEmpty())
				return true;
		}
		
		return false;
	}
	
	private void get(File dir){
		files = new ArrayList<File>();
		
		for(File f : dir.listFiles()){
			
			if ((f.isFile() && f.getName().contains("UTC"))) {
					
				if(C0.get(identifica(f))){
					
					//System.out.println(C0.get());
					files.add(f);
				}
					
				
			}
		}
	}
	
	public String identifica(File file) {

		String nameFileOri = file.getName();
		int i =nameFileOri.indexOf(")"); 
		
		if(nameFileOri.contains("UTC"))
			nameFileOri = nameFileOri.substring(nameFileOri.indexOf(" "), i+1);
		
		return nameFileOri;
	}

	/**
	 * 
	 * @return
	 */
	public List<File> get() {

		if(files == null)
			get(dir);
		
		return files;
	}

	/**
	 * 
	 */
	public void print() {

		for (File path : files) {
			System.out.println("File for deletion: " +path.getAbsolutePath());
			;
		}

	}

}
