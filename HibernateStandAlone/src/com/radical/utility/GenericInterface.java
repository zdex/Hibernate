package com.radical.utility;

public interface GenericInterface<E> {
	public void save(E o);

	public void update(E o);

	public void saveOrUpdate(E o);
}
