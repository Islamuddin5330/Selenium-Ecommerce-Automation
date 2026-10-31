package com.commerce.utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryTransformer implements IAnnotationTransformer{

	@Override
	public void transform( ITestAnnotation annotation,
            Class testClass,
            Constructor testConstructor,
            Method testMethod) {
		//This line automatically attaches your RetryAnalyzer to every TestNG @Test method.
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		
	}
}
