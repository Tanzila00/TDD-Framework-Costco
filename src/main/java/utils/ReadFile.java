package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import reports.Loggers;

public class ReadFile {
	private String fileName;// location for the file
	private List<String> list;// stores the list
	BufferedReader reader;// read the file

	public ReadFile(String fileName) {// param constructor used because there are multiple files using string we
										// differentiate fileName
		this.fileName = fileName;// reading this fileName
		//reader = readerFile();
		readerFile();
	}

	public String getFileName() {// getter to get access for private variable
		return fileName;
	}

	public List<String> getList() {
		return list;

	}

	private BufferedReader readerFile() {
		try {
			reader = new BufferedReader(new FileReader(getFileName()));
			generateList(reader);
		} catch (IOException e) {
			e.printStackTrace();
			Loggers.log("File not found ---> " + getFileName());
		}
		return reader;

	}

	// public void generateList() {
	// for (WebElement e : headLineMenu) {
	// Loggers.log("Menu List:" + e.getText());
//
//	}
//	Loggers.log("Test Completed");
//}
	// }

	@SuppressWarnings("unused")
	private void generateList(BufferedReader reader) {
		// List<String>(already declared!) list=new ArrayList<>();
		list = new ArrayList<>(); // creating obj name list and storing the list in array

		String line;// to read line by line
		try {
			// list object created will read the arrays stored in add method
			// line reads the arraylist from buffered reader in built calling readLine in
			// built method to read
			while ((line = reader.readLine()) != null) {// criteria=not equals to null
				list.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
			Loggers.log("File Not found" + getFileName());
		}

	}

	public void getSize() {
		System.out.println(list.size());
	}

	public void closeResource() {//to close the 
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}