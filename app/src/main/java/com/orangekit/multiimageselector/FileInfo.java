package com.orangekit.multiimageselector;

public class FileInfo {

	private String fileName;
	private String filePath;

	public FileInfo(String fileName, String filePath) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getFilePath() {
		return filePath;
	}

}
