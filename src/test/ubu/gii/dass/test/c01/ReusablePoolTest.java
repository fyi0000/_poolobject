/**
 *
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
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
		assertNotNull(poolTests1);
		assertNotNull(poolTests2);
		assertTrue(poolTests1 instanceof ReusablePool);
		assertTrue(poolTests2 instanceof ReusablePool);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		boolean flag = true;
		int sizeReusable = 0;

		try {
			Vector<Reusable> reusables = new Vector<>();
			while (flag) {
				sizeReusable++;
				assertNotNull(reusables.add(poolTests1.acquireReusable()));
				assertNotNull(reusables.add(poolTests2.acquireReusable()));

			}
		} catch (NotFreeInstanceException ex) {
			sizeReusable++;
			flag = false;
			assertFalse(flag);
		}
		assertEquals(2, sizeReusable);
	}

	/**
	 * Test method for
	 * {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		Reusable reusableNoExistente = new Reusable(); // reusable not in reusables
		Reusable reusableNoExistente2 = new Reusable();// reusable not in reusables
		Vector<Reusable> reusables = new Vector<>();
		try {
			poolTests2.releaseReusable(reusableNoExistente);
			poolTests2.releaseReusable(reusableNoExistente2);
			while (true) {
				reusables.add(poolTests2.acquireReusable());
			}
		} catch (DuplicatedInstanceException | NotFreeInstanceException ex) {
			assertEquals(reusables.size(), 4);
		}
	}

}
