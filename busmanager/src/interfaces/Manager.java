package interfaces;

import java.util.List;

import entity.Bus;

/**
 * 
 * @author Wangshirong
 *
 * @param <T>
 * 
 * 所有管理器的接口
 */

public interface Manager<T> {
	public void addData(T newData);

	public void delDataById(String id);


	public void changeInfo(T newData);

	public void printAllInfo();
}
