package br.com.oryaj;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GenericExtFilter implements FilenameFilter {

	private List<File> files;

	private File dir;
	
	public GenericExtFilter(File dir) {
		this.dir = dir;
	}

	@Override
	public boolean accept(File dir, String name) {
		
		if(dir != null && name != null){
			
			map(dir, name);
			
			if(!files.isEmpty())
				return true;
			
		} else {
			
			map(this.dir, null);
			if(!files.isEmpty())
				return true;
		}
		
		return false;
	}
	
	private void map(File dir, String name){
		files = new ArrayList<File>();
		
		for(File f : dir.listFiles()){
			
			if (f.isFile()) {
				
				if (Pattern.compile(C1.get()).matcher(f.getName()).find() || Pattern.compile(C2.get()).matcher(f.getName()).find()) {
					
					files.add(new File(f.getAbsolutePath()));
					
				}
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public List<File> get() {

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
