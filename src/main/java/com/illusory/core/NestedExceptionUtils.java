/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.illusory.core;


/**
 * 抽象类是一个用于处理嵌套异常的实用工具类。
 * 提供了一些静态方法，用于处理和分析异常的嵌套结构，其中嵌套结构是指异常中包含其他异常作为其原因或根本原因的情况
 */
public abstract class NestedExceptionUtils {

	/**
	 * 用于构建包含异常信息的详细错误消息
	 * 具体而言，buildMessage方法的作用是将异常的消息和原因异常的消息组合成一个更具表达力的错误消息。
	 * 它接收两个参数：message是异常本身的消息，cause是异常的原因异常。该方法会处理这两个消息并生成一个更详细的错误消息。
	 * 这个方法在异常处理过程中非常有用，它允许我们生成更加信息丰富和有意义的错误消息，以便更好地理解异常的原因和上下文。
	 */

	public static String buildMessage( String message,  Throwable cause) {
		if (cause == null) {
			return message;
		}
		StringBuilder sb = new StringBuilder(64);
		if (message != null) {
			sb.append(message).append("; ");
		}
		sb.append("nested exception is ").append(cause);
		return sb.toString();
	}

	/**
	 * 获取嵌套异常的根本原因。该方法递归地查找嵌套异常的根本原因，即异常链中的最底层异常
	 */

	public static Throwable getRootCause( Throwable original) {
		if (original == null) {
			return null;
		}
		Throwable rootCause = null;
		Throwable cause = original.getCause();
		while (cause != null && cause != rootCause) {
			rootCause = cause;
			cause = cause.getCause();
		}
		return rootCause;
	}

	/**
	 * 获取嵌套异常链中最具体的异常。该方法从异常链中选择最具体的异常作为结果，即异常链中的最后一个非NestedRuntimeException异常。
	 */
	public static Throwable getMostSpecificCause(Throwable original) {
		Throwable rootCause = getRootCause(original);
		return (rootCause != null ? rootCause : original);
	}

}
