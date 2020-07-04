package YunMusic.Dao;

/**
 * �������ݲ�Ĺ�������
 * @author MG
 * @param <V> Ҫ������vo����
 * @version 1.0
 */
public interface IDAO<V>{
	/**
	 * �������Ӳ���
	 * @param v ������Ҫ��ӵ�������Ϣ
	 * @return ���������ӳɹ�������true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public boolean doCreate(V v) throws Exception;
	
	/**
	 * ����ɾ������
	 * @param v ������Ҫɾ����������Ϣ
	 * @return �������ɾ���ɹ�������true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException,���SQL�������׳�SQLException
	 */
	public boolean doRemove(V v) throws Exception;
}
