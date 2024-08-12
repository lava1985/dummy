package listener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listener.ListenerImplemention.class)
public class TestClass extends BaseClass {
@Test
public void demo()
{
	System.out.println("@test");
}
}
