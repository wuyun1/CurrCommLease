package com.CCL.Dao.base;

import java.util.List;
import java.util.Map;

/**
 * ���������ݷ��ʲ����Ľӿ�
 * 
 * @author Jonney
 *
 * @param <T>
 *            Bean��ľ�������
 */
public interface BaseDaoInterface<T> {

	/**
	 * ����ID��ȡĳһ���ݿ����
	 * 
	 * @param id
	 * @return ���ظ����ݿ��ѯ�����װ��Ķ���
	 */
	T get(int id);

	/**
	 * ��ѯ���Զ���
	 * 
	 * @return ��������Bean��List�ļ���
	 */
	List<T> queryAll();

	/**
	 * ��ѯ���������
	 * 
	 * @return �����������ݿ�ļ�¼����
	 */
	long count();

	/**
	 * ����IDɾ��ĳһ���ݼ�¼
	 * 
	 * @param id
	 *            ����ID
	 * @return ɾ���Ƿ�ɹ�
	 */
	boolean remove(int id);

	/**
	 * �����ݶ��󱣴浽���ݿ�,�����ݳ־û�
	 * 
	 * @param obj
	 *            ����������ݶ���
	 * @return �Ƿ���ӳɹ�
	 */
	boolean add(T obj);

	/**
	 * �������ݿ��еĶ��� ������Ϊ����
	 * 
	 * @param obj
	 * @return �Ƿ���³ɹ�
	 */
	boolean update(T obj);

	// ͨ�������ѯ
	List<T> queryByExample(T instance);

	/**
	 * ����ĳ���ؼ���ģ��ƥ���ѯ ,�����ݷ�ҳ��������ָ��ҳ�����ݼ���
	 * 
	 * @param property
	 *            ƥ��������ֶ� �����ݿ���ֶ�Ϊ׼
	 * @param value
	 *            ����ģ��ƥ��Ĺؼ��ֵ�ֵ
	 * @param pageSize
	 *            ��ҳ��С
	 * @param pageNumber
	 *            �ڼ�ҳ
	 * @return �������������ݼ���
	 */
	List<T> queryByUseLikeAndPage(String property, String value, int pageSize, int pageNumber);

	/**
	 * ���ݶ���ؼ���ͬʱ������ģ��ƥ���ѯ ,�����ݷ�ҳ��������ָ��ҳ�����ݼ���
	 * 
	 * @param entrys
	 *            ������ֵ�� ��ֵ��
	 * @param pageSize
	 *            ��ҳ��С
	 * @param pageNumber
	 *            �ڼ�ҳ
	 * @return �������������ݼ���
	 */
	List<T> queryByUseLikeAndPage(Map<String, String> entrys, int pageSize, int pageNumber);

	/**
	 * ����ĳ���ؼ��־�ȷƥ���ѯ ,�����ݷ�ҳ��������ָ��ҳ�����ݼ���
	 * 
	 * @param property
	 *            ƥ��������ֶ� �����ݿ���ֶ�Ϊ׼
	 * @param value
	 *            ����ģ��ƥ��Ĺؼ��ֵ�ֵ
	 * @param pageSize
	 *            ��ҳ��С
	 * @param pageNumber
	 *            �ڼ�ҳ
	 * @return �������������ݼ���
	 */
	public List<T> queryByUsePage(String property, Object value, int pageSize, int pageNumber);

	/**
	 * ���ݶ���ؼ���ͬʱ�����ľ�ȷƥ���ѯ ,�����ݷ�ҳ��������ָ��ҳ�����ݼ���
	 * 
	 * @param entrys
	 *            ������ֵ�� ��ֵ��
	 * @param pageSize
	 *            ��ҳ��С
	 * @param pageNumber
	 *            �ڼ�ҳ
	 * @return �������������ݼ���
	 */
	public List<T> queryByUsePage(Map<String, Object> entrys, int pageSize, int pageNumber);

}
