
package YunMusic.test.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import YunMusic.VO.userlist;
import YunMusic.factory.ServiceFactory;
import junit.framework.TestCase;

/**
 * 用户业务层自动测试类
 * @author MG
 * @version 1.0
 */
class IUserServiceTest {

	@Test
	void testEnter()
	{
		userlist ul=new userlist();
		ul.setPassword("sdfsd3433");
		ul.setQq("234234325");
		ul.setUsername("fdsf");
		try {
			TestCase.assertTrue(new ServiceFactory().getIUserServiceInstance().enter(ul.getUsername(),ul.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testRegister()
	{
		userlist ul=new userlist();
		ul.setPassword("sdfsd343d3");
		ul.setQq("2342333325");
		ul.setUsername("dddd");
		try {
			TestCase.assertTrue(new ServiceFactory().getIUserServiceInstance().register(ul));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testFindPassword()
	{
		String qq="23423433";
		try {
			TestCase.assertNotNull(new ServiceFactory().getIUserServiceInstance().findPassword(qq));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}