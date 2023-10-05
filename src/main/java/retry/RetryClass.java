package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int count = 0;
		int retryLen = 2;
		if (count < retryLen) {
			count++;
			return true;
		}
		return false;
	}

}
