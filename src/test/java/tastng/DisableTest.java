package tastng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DisableTest {
@Test(invocationCount=-1)
public void demo1() {
	Reporter .log("Demo1", true);
	
}
@Test(enabled = false)
public void demo2() {
	Reporter .log("Demo2", true);
	
}
@Test(invocationCount=1)
public void demo3() {
	Reporter .log("Demo3", true);
	
}

}
