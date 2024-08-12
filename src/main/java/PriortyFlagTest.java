import org.testng.Reporter;
import org.testng.annotations.Test;

public class PriortyFlagTest {

	@Test(priority=-1)
	public void demo1() {
		Reporter .log("Demo1", true);
	}
		@Test(priority=1)
		public void demo2() {
			Reporter .log("Demo2", true);
		}
			@Test
			public void demo3() {
				Reporter .log("Demo3", true);
			}
				@Test
				public void demo4() {
					Reporter .log("Demo4", true);
				}
					@Test(priority=-2)
					public void demo5() {
						Reporter .log("Demo5", true);
					}
}
