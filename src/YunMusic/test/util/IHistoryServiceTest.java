package YunMusic.test.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import YunMusic.VO.History;
import YunMusic.factory.ServiceFactory;
import junit.framework.TestCase;
/**
 * 播放列表业务层自动测试类
 * @author MG
 * @version 1.0
 */
class IHistoryServiceTest {

	@Test
	void testAddMusic()
	{
		History h=new History();
		h.setId("1");
		h.setUname("小苹果");
		h.setUsername("sdfsdfd");
		try {
			TestCase.assertTrue(new ServiceFactory().getIHistoryServiceInstance().AddMusic(h));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testDelMusic()
	{
		History h=new History();
		h.setId("1");
		h.setUname("小苹果");
		h.setUsername("sdfsdfd");
		try {
			TestCase.assertTrue(new ServiceFactory().getIHistoryServiceInstance().DelMusic(h));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void testfindMusicF() {
		String s="erf";
		try {
			TestCase.assertNotNull(new ServiceFactory().getIHistoryServiceInstance().findMusicF(s));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void testfindMusicS() {
		String s="bo1018";
		try {
			TestCase.assertNotNull(new ServiceFactory().getIHistoryServiceInstance().findMusicS(s));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}