package unit;


import utils.ReadFile;

import org.testng.annotations.Test;

import constants.IFile;

public class ReadFileTest {
@Test(enabled=true)
public void readFileTest() {
	ReadFile readFile=new ReadFile(IFile.MENU);
	System.out.println(readFile.getList());
}
}
