package interfaces;

import java.util.List;

import entity.Bus;

/**
 * 
 * @author Wangshirong
 *
 * @param <T>
 * 
 * ���й������Ľӿ�
 */

public interface Manager<T> {
	public void addData(T newData);

	public void delDataById(String id);


	public void changeInfo(T newData);

	public void printAllInfo();
}
