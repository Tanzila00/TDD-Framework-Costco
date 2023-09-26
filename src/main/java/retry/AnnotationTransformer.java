package retry;

import java.awt.JobAttributes.DefaultSelectionType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer{
	//this method is from Iannotation Transformer
	@Override//manuallly 
public void transform(  ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod){
	annotation.setRetryAnalyzer(RetryClass.class);
}

}