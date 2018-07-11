/**
 * 
 */
package br.com.oryaj;

import java.io.File;
import java.nio.file.attribute.FileTime;

/**
 * @author Jayro Rodrigues
 *
 */
public class Arquivo implements Comparable<Arquivo> {

	
	private FileTime fileTime;
	
	private File file;
	
	/**
	 * 
	 */
	public Arquivo() {
		// TODO Auto-generated constructor stub
	}

	public Arquivo(FileTime fileTime, File file) {
		super();
		this.fileTime = fileTime;
		this.file = file;
	}

	@Override
	public int compareTo(Arquivo a) {
		return getFileTime().compareTo(a.getFileTime());
	}

	public FileTime getFileTime() {
		return fileTime;
	}

	public void setFileTime(FileTime fileTime) {
		this.fileTime = fileTime;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
