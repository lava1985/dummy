package listener;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
@BeforeSuite
public void suteSetUP()
{
	System.out.println(" @MathodSuite");
	}
@BeforeTest

public void testSetUP ()
{
	System.out.println("@MathodTest");
	}
@BeforeClass
public void classSetUP()
{
	System.out.println("@MathodClass");
	}
@BeforeMethod
public void mathodSetUP()
{
	System.out.println("@beforeMethod");
	}

@AfterMethod
public void  methodTearDown()
{
	System.out.println("after@Mathod");
	}
@AfterClass
public void ClassTearDown()
{
	System.out.println("AfterClass");
	}
@AfterTest
public void testTearDown ()
{
	System.out.println("AfterTest");
	}

@AfterSuite
public void suiteTearDown ()
{
	System.out.println("AfterSuite");
	}
}
