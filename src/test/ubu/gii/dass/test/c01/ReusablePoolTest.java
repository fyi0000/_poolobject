/**
 *
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.ReusablePool;

/**
 * @author <a href="mailto:fyi0000@alu.ubu.es">Fco Javier Yague Izquierdo<a>
 * @author <a href="mailto:jaa0124@alu.ubu.es">Johnson Arrobo Acaro<a>
 *
 */
public class ReusablePoolTest {

	private ReusablePool poolTests1;
	private ReusablePool poolTests2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		poolTests1 = ReusablePool.getInstance();
		poolTests2 = ReusablePool.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		poolTests1 = poolTests2 = null;
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		fail("Not yet implemented");
	}

}
