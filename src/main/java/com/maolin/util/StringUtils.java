package com.maolin.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * <PRE>
 * 字符串工具类
 * </PRE>
 * <B>项	       目：</B>latico-utils
 * <B>技术支持：</B>latico (c)
 * @version   <B>V1.0 2017年6月17日</B>
 * @author    <B><a href="mailto:latico@qq.com"> latico </a></B>
 * @since     <B>JDK1.6</B>
 */
public class StringUtils {

	/**
	 * 空字符串
	 */
	public static final String EMPTY = "";

	/** common HTML和Java字符对应表 */
	public static String common[][] = {{"&nbsp;", " "},
	        {"<br>", System.getProperty("line.separator")},
	        {"&lt;", "<"}, {"&gt;", ">"}, {"&amp;", "&"}, {"&quot;", "\""},
	        {"&prime;", "\'"}, {"&ensp;", " "}, {"&emsp;", "　"}};

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// System.out.println(isDouble(""));
		// System.out.println(isNull("b"));
//		Object s = new Object();
//		System.out.println(isEmpty(s));
//		String s = "ja$123$jg$123$jgagg$123$ahad";
//		System.out.println(replaceStrByRegexStrSurroundWithDollar(s, "123", "35345"));
//		System.out.println(separateSubStrs(s, "$123"));
//		System.out.println(Arrays.toString(delimiterStrToArray("$123", s)));
//		String s = "agag\ragg\nagag\r\nagjakhg";
//		System.out.println(Arrays.toString(splitByLine(s)));
		
		System.out.println(insertStr("643e8cbb4689", 4, "-"));

	}

	/**
	 * 把html字符串的常用字符代号转换成java中可视的符号
	 * 
	 * @param htmlString
	 * @return
	 */
	public static String convertCharHtml2Java(String htmlString) {
		if(isEmpty(htmlString)) {
			return htmlString;
		}
		String javaString = htmlString;
		for (int i = 0; i < common.length; i++) {
			javaString = javaString.replace(common[i][0], common[i][1]);
		}
		return javaString;
	}

	/**
	 * 把java中的可视的常用符号转换成html中页面表达的字符
	 * 
	 * @param javaString
	 * @return
	 */
	public static String convertCharJava2Html(String javaString) {
		if(isEmpty(javaString)) {
			return javaString;
		}
		String htmlString = javaString;
		for (int i = 0; i < common.length; i++) {
			htmlString = htmlString.replace(common[i][1], common[i][0]);
		}
		return htmlString;
	}

	/**
	 * 判断是否是整数字符串
	 * @param s 字符串
	 * @return 
	 */
	public static boolean isIntegerStr(String s) {
		boolean flag = false;
		if (s == null || "".equals(s)) {
			flag = false;
		} else {
			flag = s.matches("[+-]?\\d+");
		}
		return flag;
	}

	/**
	 * 判断是否是浮点型字符串
	 * @param s
	 * @return
	 */
	public static boolean isFloatStr(String s) {
		boolean flag = false;
		if (s == null || "".equals(s)) {
			flag = false;
		} else {
			flag = s.matches("[+-]?\\d+[\\.]?\\d*");
		}
		return flag;
	}

	/**
	 * 判断输入的字符串是否是整数，包括正负整数的判别
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isInt(String str) {

		// 如果是空串或者null，或者只有则没有长度，不可以进行下面的判断
		if (str == null || str.equals("") || str.matches("-+$")) {
			return false;
		} else {
			char[] ch = str.toCharArray();
			// 过滤正负数，若第一个字符又不是“-”又不是0~9的字符，或者虽然第一个是“-”字符，但是后面没有字符了，都不是整数
			if (str.matches("-+$")
			        || ch[0] != '-' && (ch[0] < '0' || ch[0] > '9')) {
				return false;
			}
			for (int i = 1; i < ch.length; i++) {
				if (ch[i] < '0' || ch[i] > '9') {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 判断一个字符串是否是double类型
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDouble(String str) {

		if (str != null) {
			try {
				Double.parseDouble(str);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}

		}
		return false;
	}

	/**
	 * <p>
	 * 字符串拼接
	 * </p>
	 * <p>
	 * No delimiter is added before or after the
	 * list. Null objects or empty strings within
	 * the iteration are represented by empty
	 * strings.
	 * </p>
	 * <p>
	 * See the examples here:
	 * {@link #join(Object[],char)}.
	 * </p>
	 * 
	 * @param iterator the {@code Iterator} of
	 *            values to join together, may be
	 *            null
	 * @param separator the separator character to
	 *            use
	 * @return the joined String, {@code null} if
	 *         null iterator input
	 * @since 2.0
	 */
	public static String join(Iterator<?> iterator, char separator) {

		// handle null, zero and one elements
		// before building a buffer
		if (iterator == null) {
			return null;
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		Object first = iterator.next();
		if (!iterator.hasNext()) {
			return toString(first);
		}

		// two or more elements
		StringBuilder buf = new StringBuilder(256); // Java
		                                            // default
		                                            // is
		                                            // 16,
		                                            // probably
		                                            // too
		                                            // small
		if (first != null) {
			buf.append(first);
		}

		while (iterator.hasNext()) {
			buf.append(separator);
			Object obj = iterator.next();
			if (obj != null) {
				buf.append(obj);
			}
		}

		return buf.toString();
	}

	/**
	 * 将字符数组转换成指定编码的字符串
	 * 
	 * @param bytes 字符数组
	 * @param charsetName 编码名称
	 * @return 编码后的字符串
	 * @throws UnsupportedEncodingException
	 *             不支持编码类型异常
	 * @throws NullPointerException 空参数异常
	 * @since 3.1
	 */
	public static String toString(byte[] bytes, String charsetName)
	        throws UnsupportedEncodingException {

		return charsetName == null
		        ? new String(bytes)
		        : new String(bytes, charsetName);
	}

	public static String toString(Object obj) {

		return obj == null ? "" : obj.toString();
	}

	public static String join(final Collection<?> list,
	        final String separator) {
		if(list == null || separator == null){
			return null;
		}
		return join(list.iterator(), separator);
	}
	
	public static String join(final Object[] list,
			String separator) {
		if (list != null && list.length >= 1) {
			StringBuilder sb = new StringBuilder();
			separator = (separator == null ? "" : separator);
			for (Object str : list) {
				if (str == null) {
					continue;
				}
				sb.append(str).append(separator);
			}
			if(isEmpty(separator)){
				return sb.toString();
				
			}else{
				return sb.toString().replaceAll(separator + "$", "");
			}
		}
		return "";
	}
	public static String join(final Iterator<?> iterator,
	        final String separator) {

		// handle null, zero and one elements
		// before building a buffer
		if (iterator == null) {
			return null;
		}
		if (!iterator.hasNext()) {
			return EMPTY;
		}
		final Object first = iterator.next();
		if (!iterator.hasNext()) {

			final String result = first == null ? "" : first.toString();
			return result;
		}

		// two or more elements
		final StringBuilder buf = new StringBuilder(256);
		if (first != null) {
			buf.append(first);
		}

		while (iterator.hasNext()) {
			if (separator != null) {
				buf.append(separator);
			}
			final Object obj = iterator.next();
			if (obj != null) {
				buf.append(obj);
			}
		}
		return buf.toString();
	}

	/**
	 * 把第一个字符大写
	 * 
	 * @param source
	 * @return
	 */
	public static String firstCharToUp(String source) {

		String first = source.substring(0, 1);
		String other = source.substring(1, source.length());
		String result = (new StringBuilder(String.valueOf(first.toUpperCase())))
		        .append(other).toString();
		return result;
	}

	public static boolean isEmpty(Object obj) {
		if (obj == null || obj.toString().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	/**
	 * 判断输入的字符串是否是整数
	 * @param str 被判断的字符串
	 * @return
	 */
	public static boolean isNumber(String str) {
		boolean isNumber = false;
		if (str == null || str.length() == 0) {
			isNumber = false;
		} else {
			try {
				Long.parseLong(str);
				isNumber = true;
			} catch (NumberFormatException e) {
				try {
					Double.parseDouble(str);
					isNumber = true;
				} catch (NumberFormatException e1) {
					isNumber = false;
				}
			}

		}

		return isNumber;
	}

	/**
	 * 连接多个对象为一个字符串
	 * @param objlist 多个对象
	 * @return 依次连接所有对象的字符串
	 */
	public static String concat(Object... objlist) {

		StringBuilder sb = new StringBuilder();
		for (Object o : objlist) {
			if (o == null) {
				continue;
			}
			sb.append(o.toString());
		}
		return sb.toString();
	}
	
	/**
	 * 使用指定分隔符连接字符串
	 * @param list 字符串列表
	 * @param separator 分隔符
	 * @return 依次连接所有字符串的字符串
	 */
	public static String join(List<String> list, String separator) {

		if (list != null && list.size() >= 1) {
			StringBuilder sb = new StringBuilder();
			separator = (separator == null ? "" : separator);
			for (String str : list) {
				if (str == null) {
					continue;
				}
				sb.append(str).append(separator);
			}
			
			if(isEmpty(separator)){
				return sb.toString();
				
			}else{
				return sb.toString().replaceAll(separator + "$", "");
			}
		}
		return "";
	}

	/**
	 * 例子，对于一个集合装着的String，
	 * 会组拼出所有对所有元素添加头尾并用分隔符分隔的字符串
	 * 如：'abc', 'bcd', 'cdf'
	 * @param before
	 * @param behind
	 * @param separate
	 * @param objs
	 * @return
	 */
	public static String concatWithBeforeAndBehind(String before, String behind,
	        String separate, Collection<?> objs) {
		if (objs == null) {
			return "";
		}
		if (before == null) {
			before = "";
		}
		if (behind == null) {
			behind = "";
		}
		if (separate == null) {
			separate = "";
		}
		StringBuffer sb = new StringBuffer();
		for (Object obj : objs) {
			sb.append(before).append(obj.toString()).append(behind)
			        .append(separate);
		}
		String s = sb.toString();
		if (s.length() >= separate.length()) {
			s = s.substring(0, s.length() - separate.length());
		}
		return s;

	}

	/**
	 * 判断集合中是否包含元素，并且可以选择是否字符串比较时忽略大小写
	 * @param obj
	 * @param objs
	 * @param ignoreCase 
	 * @return
	 */
	public static boolean containsOrEquals(Object obj, Collection<?> objs,
	        boolean ignoreCase) {
		boolean flag = false;
		if (obj == null || objs == null) {
			return flag;
		}

		// 如果直接包含
		if (objs.contains(obj)) {
			flag = true;

			// 对比toString方法
		} else {
			for (Object o : objs) {
				if (o == null) {
					continue;
				}

				// 如果忽略大小写的话
				if (ignoreCase) {
					if (o.toString().equalsIgnoreCase(obj.toString())) {
						flag = true;
						break;
					}
				} else {
					if (o.toString().equals(obj.toString())) {
						flag = true;
						break;
					}
				}
			}

		}

		return flag;
	}

	/**
	 * 包含或者忽略大小写比较
	 * @param obj
	 * @param objs
	 * @return
	 */
	public static boolean containsOrEqualsIgnoreCase(Object obj,
	        Collection<?> objs) {
		return containsOrEquals(obj, objs, true);
	}

	/**
	 * 包含或者不忽略大小写比较
	 * @param obj
	 * @param objs
	 * @return
	 */
	public static boolean containsOrEquals(Object obj, Collection<?> objs) {
		return containsOrEquals(obj, objs, false);
	}

	/**
	 * 判断某字符串是否在另外一个中
	 * @param oriStr 源字符串
	 * @param contain 被包含的字符串
	 * @return
	 */
	public static boolean contains(String oriStr, String contain) {
		if (oriStr != null && oriStr.contains(contain)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 通过常用的分隔符来切割数据，包括：;；、,，
	 * @param str
	 * @return
	 */
	public static Set<String> splitByCommonDelimit(String str) {
		Set<String> set = new HashSet<String>();
		String[] arr = splitByCommonDelimitReturnArray(str);
		for (String s : arr) {
			s = s.trim();
			if (StringUtils.isEmpty(s)) {
				continue;
			}
			set.add(s);
		}
		return set;
	}
	
	public static List<String> splitByCommonDelimitReturnList(String str) {
		List<String> list = new ArrayList<String>();
		String[] arr = splitByCommonDelimitReturnArray(str);
		for (String s : arr) {
			s = s.trim();
			if (StringUtils.isEmpty(s)) {
				continue;
			}
			list.add(s);
		}
		return list;
	}

	/**
	 * 通过常用的分隔符来切割数据，包括：;；、,，
	 * @param str
	 * @return
	 */
	public static String[] splitByCommonDelimitReturnArray(String str) {

		if (StringUtils.isEmpty(str)) {
			return new String[]{};
		}
		String[] arr = str.split("[,，;；、。]+");
		return arr;
	}

	public static boolean isEquals(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		} else if (s1 == null || s2 == null) {
			return false;
		}
		if (s1.equals(s2)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNotEquals(Object obj1, Object obj2) {
		return !isEquals(obj1, obj2);
	}
	
	public static boolean isEquals(Object obj1, Object obj2) {
		if (obj1 == null && obj2 == null) {
			return true;
		} else if (obj1 == null || obj2 == null) {
			return false;
		}
		if (obj1 == obj2) {
			return true;
		}
		if (obj1.equals(obj2)) {
			return true;
		}
		if (obj1.toString().equals(obj2.toString())) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNotEqualsIgnoreCase(Object obj1, Object obj2) {
		return isEqualsIgnoreCase(obj1, obj2);
	}
	public static boolean isEqualsIgnoreCase(Object obj1, Object obj2) {
		if (obj1 == null && obj2 == null) {
			return true;
		} else if (obj1 == null || obj2 == null) {
			return false;
		}
		if (obj1 == obj2) {
			return true;
		}
		if (obj1.equals(obj2)) {
			return true;
		}
		if (obj1.toString().equalsIgnoreCase(obj2.toString())) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNotEqualsIgnoreCase(String s1, String s2) {
		return isEqualsIgnoreCase(s1, s2);
	}
	
	public static boolean isEqualsIgnoreCase(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return true;
		} else if (s1 == null || s2 == null) {
			return false;
		}
		if (s1.equalsIgnoreCase(s2)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 使用$符号包起来字符串，应用场景是包装配置文件的替换字符
	 * @param included 被包的字符串
	 * @return 包装后的字符
	 */
	public static CharSequence includeBy$(String included) {
		StringBuffer sb = new StringBuffer();
		sb.append("$").append(included).append("$");
		return sb.toString();
	}

	/**
	 * 获取字节数组的16进制字符串
	 * @param bytes
	 * @return 
	 */
	public static String getHexString(byte[] bytes) {
		if (bytes != null) {
			StringBuffer hexString = new StringBuffer();
			for (byte by : bytes) {
				hexString.append(getHexString(by));
			}
			return hexString.toString();
		} else {
			return null;
		}

	}
	
	/**
	 * 判断字符串类型是不是公共的true，如果是true或者1就是true
	 * @param str
	 * @return 
	 */
	public static boolean isTrue(Object str){
		if(str == null){
			return false;
		}else if(str.toString().trim().matches("(?i)true")){
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 判断字符串类型是不是公共的true，如果是true或者1就是true
	 * @param str
	 * @return 
	 */
	public static boolean isTrueOr1(Object str){
		if(str == null){
			return false;
		}else if(str.toString().trim().matches("(?i)(true|1)")){
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 判断字符串类型是不是公共的true，如果是true或者1就是true
	 * @param str
	 * @return 
	 */
	public static boolean isFalse(Object str){
		if(str == null){
			return false;
		}else if(str.toString().trim().matches("(?i)false")){
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 判断字符串类型是不是公共的true，如果是true或者1就是true
	 * @param str
	 * @return 
	 */
	public static boolean isFalseOr0(Object str){
		if(str == null){
			return false;
		}else if(str.toString().trim().matches("(?i)(false|0)")){
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 获取字节的16进制字符串
	 * @param by
	 * @return 
	 */
	public static String getHexString(byte by) {
		return Integer.toHexString(by | 0xFFFFFF00).substring(6);
	}
	
	/**
	 * 任意一个为空
	 * @param objs
	 * @return
	 */
	public static boolean anyoneEmpty(Object... objs){
		if(isEmpty(objs)){
			return true;
		}else{
			for(Object obj : objs){
				if(isEmpty(obj)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 所有不为空
	 * @param objs
	 * @return
	 */
	public static boolean allNotEmpty(Object... objs){
		return !anyoneEmpty(objs);
	}
	
	/**
	 * 利用$符号包装起来入参，然后返回忽略大小写的正则串
	 * @param str
	 * @return
	 */
	public static String getRegexStrSurroundWithDollar(String str) {
		return regexSurroundWith(str, "\\$");
	}

	/**
	 * 包裹字符串
	 * @param str
	 * @return
	 */
	public static String regexSurroundWith(String str, String surroundChar) {
		return new StringBuffer().append("(?i)").append(surroundChar).append(str).append(surroundChar).toString();
	}
	
	/**
	 * 利用$符号包裹字符串，同时利用正则替换目标
	 * @param src 原文本
	 * @param surroundedStr 会被$符号包裹的字符串，
	 * @param target 被替换的目标字符串
	 * @return 替换后的字符串
	 */
	public static String replaceStrByRegexStrSurroundWithDollar(String src, String surroundedStr, String target){
		return src.replaceAll(getRegexStrSurroundWithDollar(surroundedStr), target);
	}
	
	public static String replaceStrByRegexStrSurround(String src, String surroundedStr, String surroundChar, String target){
		return src.replaceAll(regexSurroundWith(surroundedStr, surroundChar), target);
	}
	
	/**
	 * 用头尾包裹字符串后替换掉新的值
	 * @param src 源字符串
	 * @param surroundedStr 被包裹字符串变量名称
	 * @param headChar 变量的头部包裹符
	 * @param tailChar 变量的尾部包裹符
	 * @param target 替换变量值
	 * @return
	 */
	public static String replaceStrByStrSurround(String src, String surroundedStr, String headChar, String tailChar, String target){
		return src.replace(getSurroundWithHeadTail(surroundedStr, headChar, tailChar), target);
	}
	
	/**
	 * 把原字符串替换变量后返回
	 * @param src 原字符串
	 * @param surroundedStr 被包含的字符串
	 * @param headCharRegex 变量的头正则
	 * @param tailCharRegex 变量的尾正则
	 * @param target 被替换的目标字符串
	 * @return 替换变量后的字符串
	 */
	public static String replaceStrByRegexStrSurround(String src, String surroundedStr, String headCharRegex, String tailCharRegex, String target){
		return src.replaceAll(getSurroundWithHeadTailRegex(surroundedStr, headCharRegex, tailCharRegex), target);
	}
	
	/**
	 * 用忽略大小写的形式获取包裹变量的正则
	 * @param surroundedStr
	 * @param headCharRegex
	 * @param tailCharRegex
	 * @return
	 */
	private static String getSurroundWithHeadTailRegex(String surroundedStr,
	        String headCharRegex, String tailCharRegex) {
		return new StringBuffer().append("(?i)").append(headCharRegex).append(surroundedStr).append(tailCharRegex).toString();
	}
	
	private static String getSurroundWithHeadTail(String surroundedStr, String headChar, String tailChar) {
		return new StringBuffer().append(headChar).append(surroundedStr).append(tailChar).toString();
	}

	/**
	 * 	 * 把一个字符串，根据指定的分割字符串，切割成多个子字符串,
	 * 切割后不包含delimiter
	 * @param delimiter
	 * @param str
	 * @return
	 */
	public static String[] delimiterStrToArray(String delimiter, String str){
		StringTokenizer st = new StringTokenizer(str, delimiter);
		String buf[] = new String[st.countTokens()];
		int i = 0;
		while(st.hasMoreTokens()) 
		    buf[i++] = st.nextToken();
		return buf;
	}
	
	/**
	 * 把一个字符串，根据指定的分割字符串，切割成多个子字符串,
	 * 切割后还会包含separateFlag，
	 * @param str
	 * @param separateFlag
	 */
	public static List<String> separateSubStrs(String str, final String separateFlag) {
		final int flagLen = separateFlag.length();
		int startIndex = str.indexOf(separateFlag);
		int nextIndex = startIndex;
		if(str.length() > separateFlag.length()){
			nextIndex = str.indexOf(separateFlag, startIndex + 1);
			if(nextIndex == -1){
				nextIndex = str.length();
			}
		}
		
		//先切割成几个
		List<String> strs = new ArrayList<String>();
		String tmp = str;
		while(startIndex != -1){
			if(nextIndex == tmp.length()){
				strs.add(tmp.substring(startIndex, nextIndex));
				break;
			}else{
				
				strs.add(tmp.substring(startIndex, nextIndex));
				tmp = tmp.substring(nextIndex);
				startIndex = tmp.indexOf(separateFlag);
				if(tmp.length() > flagLen){
					nextIndex = tmp.indexOf(separateFlag, flagLen);
				}else{
					nextIndex = tmp.length();
				}
				if(nextIndex == -1){
					nextIndex = tmp.length();
				}
			}
				
			
		}
		return strs;
	}

	/**
	 * 通过换行符切割字符串
	 * @param data
	 * @return
	 */
	public static String[] splitByLine(String data) {
		if(data == null){
			return new String[]{data};
		}
		String[] arr = data.split("[\r\n]+");
		return arr;
	}

	/**
	 * 指定长度切割字符串
	 * @param spiltLen
	 * @param tmp
	 */
	public static List<String> splitByAssignLen(final int splitLen, String str) {
		List<String> list = new ArrayList<String>();
		if(splitLen <= 0){
			list.add(str);
			return list;
		}
		
		while(true){
			int curLen = str.length();
			if(curLen > splitLen){
				list.add(str.substring(0, splitLen));
				str = str.substring(splitLen, curLen);
			}else{
				list.add(str);
				break;
			}
		}
		return list;
	}
	
	/**
	 * 对srcStr每隔segmentSize个字符就加insertStr
	 * @param srcStr
	 * @param segmentSize
	 * @param insertStr
	 * @return
	 */
	public static String insertStr(String srcStr, int segmentSize, String insertStr) {
		if(isEmpty(srcStr) || isEmpty(insertStr)){
			return srcStr;
		}
		List<String> list = splitByAssignLen(segmentSize, srcStr);
		
		return join(list, insertStr);
	}
	
}
