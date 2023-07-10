package com.illusory.core;

/**
 * 操作属性
 */
public interface AttributeAccessor {

	void setAttribute(String name,  Object value);

	Object getAttribute(String name);

	Object removeAttribute(String name);

	boolean hasAttribute(String name);

	String[] attributeNames();

}
