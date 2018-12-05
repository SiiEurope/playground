/* Copyright (c) 2018 by net-linx; All rights reserved */
package com.sii.playground.web;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author Stefan Stiller
 */
public class ServletUtils
{
	private ServletUtils()
	{
	}

	public static String property(Object value)
	{
		if (value==null) return "";
		String text=value.toString();
		if (text==null) return "";
		return StringEscapeUtils.escapeHtml(text);
	}

	public static Long toLong(String s)
	{
		if (s==null || s.isEmpty()) return null;
		try
		{
			return Long.valueOf(s);
		}
		catch (NumberFormatException e)
		{
			return null;
		}
	}

	public static boolean toBoolean(String s)
	{
		return Boolean.parseBoolean(s);
	}

	public static String formatInt(Number value, Locale locale)
	{
		if (value!=null) 
		{
			return NumberFormat.getIntegerInstance(locale).format(value);
		}
		return "";
	}

	public static Integer parseInt(String value, Locale locale) throws ParseException
	{
		if (!StringUtils.isBlank(value)) 
		{
			return NumberFormat.getIntegerInstance(locale).parse(value).intValue();
		}
		return null;
	}
}
