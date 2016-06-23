package com.CCL.util.glj;

import java.text.DateFormat;   
import java.text.ParseException;   
import java.text.SimpleDateFormat;   
import java.util.Calendar;   
import java.util.Date;   
public class DateUtils {   
/**  
* һ����������һ����������  
*/   
public static final int BEFORE_START_DATE = -2;   
  
/**  
* һ�����ڵ���һ����������Ŀ�ʼ����  
*/   
public static final int EQUAL_START_DATE = -1;   
  
/**  
* һ��������һ����������֮��  
*/   
public static final int BETWEEN_TOW_DATE = 0;   
  
/**  
* һ�����ڵ���һ����������Ľ�������  
*/   
public static final int EQUAL_END_DATE = 1;   
  
/**  
* һ����������һ����������  
*/   
public static final int AFTER_END_DATE = 2;   
  
/**  
* �����������  
*/   
public static final int TREE_DATE_EQUAL = 3;   
  
/**  
* ��ͨ���ڸ�ʽ  
*/   
public static final String NORMAL_DATE_PATTERN = "yyyy-MM-dd";   
  
public static final String ZHCN_DATE_PATTERN = "yyyy��MM��dd��";   
  
public static final String ZHCN_DATE_TIME_PATTERN = "yyyy��MM��dd�� HH:mm:ss";   
  
public static void main(String[] args) {
	 
	Date s = DateUtil.paseDate("2016-6-12");
	Date in = DateUtil.paseDate("2016-6-15");
	Date e = DateUtil.paseDate("2016-6-16");
	
	System.out.println(DateUtils.betweenTowDate(s, e,in));
//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     
//java.util.Date now;   
//try {   
//now = df.parse("2012-12-10 13:31:34");   
//
//java.util.Date date=DateUtils.getCurrentlyDate();   
//
//      long l=now.getTime()-date.getTime();     
//      
//      long day=l/(24*60*60*1000);     
//        
//      long hour=(l/(60*60*1000)-day*24);     
//        
//      long min=((l/(60*1000))-day*24*60-hour*60);     
//        
//      long s=(l/1000-day*24*60*60-hour*60*60-min*60);    
//         
//      System.out.println(""+day+"��"+hour+"Сʱ"+min+"��"+s+"��");     
//} catch (ParseException e) {   
////TODO Auto-generated catch block   
//e.printStackTrace();   
}     
// } 


private DateUtils() {   
}   
  
/**  
*  
* @Description:�ж�<firstDate>ʱ����Ƿ���<secondDate>ʱ���֮ǰ  
* ����� firstDate ��ʱ���ڲ���<secondDate>��ʾ��ʱ��֮ǰ���򷵻�С�� 0 ��ֵ  
* @param firstDate  
* @param secondDate  
* @return  
* @ReturnType boolean  
* @author:  
* @Created 2012 2012-9-20����08:40:33  
*/   
public static boolean isBefore(Date firstDate, Date secondDate) {   
  
return compare(firstDate, secondDate) < 0 ? true : false;   
}   
  
   /**  
    *  
    * @Description:�ж�<firstDate>ʱ����Ƿ���<secondDate>ʱ���֮��  
    * ����� firstDate ��ʱ���ڲ���<secondDate>��ʾ��ʱ��֮���򷵻ش��� 0 ��ֵ  
    * @param firstDate  
    * @param secondDate   
    * @ReturnType boolean  
    * @author:  
    * @Created 2012 2012-9-20����08:38:48  
    */   
public static boolean isAfter(Date firstDate, Date secondDate) {   
  
return compare(firstDate, secondDate) > 0 ? true : false;   
}   
  
/**  
*  
* @Description:�Ƚ�����ʱ����Ƿ����  
* @param firstDate  
* @param secondDate  
* @ReturnType boolean  
* @author:  
* @Created 2012 2012-9-20����08:37:30  
*/   
public static boolean isEqual(Date firstDate, Date secondDate) {   
  
return compare(firstDate, secondDate) == 0 ? true : false;   
}   
  
/**  
*  
* @Description:�Ƚ�����ʱ���  
* ���secondDate��ʾ��ʱ����ڴ� firstDate ��ʾ��ʱ�䣬�򷵻� 0 ֵ��  
* ����� firstDate ��ʱ���ڲ���<secondDate>��ʾ��ʱ��֮ǰ���򷵻�С�� 0 ��ֵ��  
* ����� firstDate ��ʱ���ڲ���<secondDate>��ʾ��ʱ��֮���򷵻ش��� 0 ��ֵ  
* @param firstDate  
* @param secondDate  
* @ReturnType int  
* @author:  
* @Created 2012 2012-9-20����08:34:33  
*/   
public static int compare(Date firstDate, Date secondDate) {   
  
Calendar firstCalendar = null;   
/**ʹ�ø����� Date ���ô� Calendar ��ʱ�䡣**/   
if (firstDate != null) {   
firstCalendar = Calendar.getInstance();   
firstCalendar.setTime(firstDate);   
}   
  
Calendar secondCalendar = null;   
/**ʹ�ø����� Date ���ô� Calendar ��ʱ�䡣**/   
if (firstDate != null) {   
secondCalendar = Calendar.getInstance();   
secondCalendar.setTime(secondDate);   
}   
  
try {   
/**  
* �Ƚ����� Calendar �����ʾ��ʱ��ֵ������Ԫ�����ڵĺ���ƫ��������  
* ���������ʾ��ʱ����ڴ� Calendar ��ʾ��ʱ�䣬�򷵻� 0 ֵ��  
* ����� Calendar ��ʱ���ڲ�����ʾ��ʱ��֮ǰ���򷵻�С�� 0 ��ֵ��  
* ����� Calendar ��ʱ���ڲ�����ʾ��ʱ��֮���򷵻ش��� 0 ��ֵ  
* **/   
return firstCalendar.compareTo(secondCalendar);   
} catch (NullPointerException e) {   
throw new IllegalArgumentException(e);   
} catch (IllegalArgumentException e) {   
throw new IllegalArgumentException(e);   
}   
}   
  
/**  
*  
* @Description:  
* @param startDate  
* @param endDate  
* @param inDate  
* @return  
* @ReturnType int  
* @author:  
* @Created 2012 2012-9-20����08:42:06  
*/   
public static int betweenTowDate(Date startDate, Date endDate, Date inDate) {   
  
/**  
* �ж�<endDate>ʱ����Ƿ���<startDate>ʱ���֮ǰ  
* ���Ϊ���ʾ<endDate>ʱ�����<startDate>ʱ���֮ǰ���׳��쳣  
* ������ʱ���ڿ�ʼʱ��֮ǰ�ǲ�������  
*/   
if (isBefore(endDate, startDate)) {   
throw new IllegalArgumentException(   
"endDate can not before startDate!");   
}   
  
/**  
* �Ƚ�����ʱ���<inDate>��<startDate>  
     * ���inDate��ʾ��ʱ����ڴ� startDate ��ʾ��ʱ�䣬�򷵻� 0 ֵ��  
     * ����� inDate ��ʱ���ڲ���<startDate>��ʾ��ʱ��֮ǰ���򷵻�С�� 0 ��ֵ��  
     * ����� inDate ��ʱ���ڲ���<startDate>��ʾ��ʱ��֮���򷵻ش��� 0 ��ֵ  
*/   
int sflag = compare(inDate,startDate);   
  
/**  
* �Ƚ�����ʱ���<inDate>��<endDate>  
     * ���inDate��ʾ��ʱ����ڴ� endDate ��ʾ��ʱ�䣬�򷵻� 0 ֵ��  
     * ����� inDate ��ʱ���ڲ���<endDate>��ʾ��ʱ��֮ǰ���򷵻�С�� 0 ��ֵ��  
     * ����� inDate ��ʱ���ڲ���<endDate>��ʾ��ʱ��֮���򷵻ش��� 0 ��ֵ  
*/   
int eflag = compare(inDate,endDate);   
  
int flag = 0;   
          
/**����� inDate ��ʱ���ڲ���<startDate>��ʾ��ʱ��֮ǰ���򷵻�С�� 0 ��ֵ**/   
if (sflag < 0){   
/**һ����������һ����������**/   
flag = DateUtils.BEFORE_START_DATE;   
}else if (sflag == 0) { /**���inDate��ʾ��ʱ����ڴ� startDate ��ʾ��ʱ�䣬�򷵻� 0 ֵ��**/   
/**���inDate��ʾ��ʱ����ڴ� endDate ��ʾ��ʱ�䣬�򷵻� 0 ֵ��**/   
if (eflag == 0) {   
/**�����������**/   
flag = DateUtils.TREE_DATE_EQUAL;   
}else {   
/**һ�����ڵ���һ����������Ŀ�ʼ����**/   
flag = DateUtils.EQUAL_START_DATE;   
}   
}else if (sflag > 0 && eflag < 0) {/**����-inDate ��ʱ���ڲ���<startDate>��ʾ��ʱ��֮�󣬺� inDate ��ʱ���ڲ���<endDate>��ʾ��ʱ��֮ǰ**/   
/**һ��������һ����������֮��**/   
flag = DateUtils.BETWEEN_TOW_DATE;   
} else if (eflag == 0) {/**���inDate��ʾ��ʱ����ڴ� endDate ��ʾ��ʱ��**/   
/**һ�����ڵ���һ����������Ľ�������**/   
flag = DateUtils.EQUAL_END_DATE;   
} else if (eflag > 0) {/**����inDate ��ʱ���ڲ���<endDate>��ʾ��ʱ��֮��**/   
/**һ����������һ����������**/   
flag = DateUtils.AFTER_END_DATE;   
}   
return flag;   
}   
  
/**  
*  
* @Description:�ֱ��жϵ�ǰ��������һ�������������������Ƚ�  
* ��1�� һ����������һ����������  
* ��2�������������  
* ��3��һ�����ڵ���һ����������Ŀ�ʼ����  
* ��4��һ��������һ����������֮��  
* ��5��һ�����ڵ���һ����������Ľ�������  
* ��6��һ����������һ����������  
* @param startDate  
* @param endDate  
* @return  
* @ReturnType int  
* @author:  
* @Created 2012 2012-9-20����09:00:31  
*/   
public static int betweenTowDate(Date startDate, Date endDate) {   
return betweenTowDate(startDate, endDate, new Date());   
}   
  
  
/**  
* ��Date��ת��ΪString��  
*  
* @param dtDate  
*            Date Ҫת����ʱ��  
* @param strPattern  
*            String ת���ĸ�ʽ  
* @return String ת�����ʱ�� ˵������ʽ����Ϊ yyyy-MM-dd HH:mm:ss�ȣ���������ϣ��� yyyy��MM��dd��  
*         yyyy������ MM������ dd������ HH hh kk����Сʱ mm������� ss�������� format  
*/   
public static String dateToString(Date dtDate, String strPattern) {   
SimpleDateFormat lsdfDate = new SimpleDateFormat(strPattern);   
return lsdfDate.format(dtDate);   
}   
  
  
/**  
*  
* @Description:��������Ӧ��ʽ���ַ���ת��Ϊ���� <��ʽ�Զ���>  
* @param dateStr �����ַ���  
* @param pattern ���ڸ�ʽ  
* @ReturnType Date �����ִ�Ϊ�ջ��߲��������ڸ�ʽʱ����null  
* @author:  
* @Created 2012 2012-9-20����09:06:00  
*/   
public static Date getDate(String dateStr, String pattern) {   
  
return getDate(dateStr, pattern, null);   
}   
  
  
/**  
* ��������Ӧ��ʽ���ַ���ת��Ϊ���� ��ʽ�Զ���  
*  
* @param dateStr  
*            �����ַ���  
* @param pattern  
*            ���ڸ�ʽ  
* @param defaultDate  
*            Ĭ������  
* @return �����ִ�Ϊ�ջ��߲��������ڸ�ʽʱ����defaultDate  
*/   
public static Date getDate(String dateStr, String pattern, Date defaultDate) {   
  
if (dateStr != null && pattern != null) {   
SimpleDateFormat sdf = new SimpleDateFormat(pattern);   
try {   
return sdf.parse(dateStr);   
} catch (ParseException e) {   
  
}   
}   
return defaultDate;   
}   
  
  
  
/**  
*  
* @Description:��ĳ������ת����ָ����ʽ���������� <��ȡ��Ӧ��ʽ��Date>  
* @param date          ��Ҫ��ʽ�����ڲ���  
* @param pattern       ���ڸ�ʽ  
* @ReturnType Date  
* @author:  
* @Created 2012 2012-9-20����09:08:24  
*/   
public static Date getFormatDate(Date date, String pattern) {   
  
if (date == null) {   
throw new IllegalArgumentException("date can not be null!");   
}   
  
if (pattern == null) {   
pattern = NORMAL_DATE_PATTERN;   
}   
  
SimpleDateFormat sdf = new SimpleDateFormat(pattern);   
  
String dateStr = sdf.format(date);   
try {   
return sdf.parse(dateStr);   
} catch (ParseException e) {   
  
}   
return date;   
}   
  
  
/**  
*  
* @Description:��������Ӧ��ʽ���ַ���ת��Ϊ���� ��ʽ yyyy-MM-dd  
* @param dateStr  
* @return �����ִ�Ϊ�ջ��߲��������ڸ�ʽʱ����null  
* @ReturnType Date  
* @author:  
* @Created 2012 2012-9-20����09:04:28  
*/   
public static Date getDate(String dateStr) {   
return getDate(dateStr, DateUtils.NORMAL_DATE_PATTERN);   
}   
  
  
/**  
*  
* @Description:����ǰ����ת�����ַ��� ��ʽ yyyy-MM-dd  
* @ReturnType String  
* @author:  
* @Created 2012 2012-9-19����05:54:42  
*/   
public static String datetoStr() {   
SimpleDateFormat sdf = new SimpleDateFormat(NORMAL_DATE_PATTERN);   
String curDate = sdf.format(new Date());   
return curDate;   
}   
  
  
/**  
*  
* @Description: ��ȡ��������,���ڸ�ʽΪYYYYMMDD  
* @ReturnType String  
* @author:  
* @Created 2012 2012-9-20����09:17:19  
*/   
public static String getIntraday() {   
Calendar date = Calendar.getInstance();// ��õ�ǰ����   
int year = date.get(Calendar.YEAR);   
int month = date.get(Calendar.MONTH) + 1;   
int day = date.get(Calendar.DAY_OF_MONTH);   
String updateFileDate = new String(new Integer(year).toString()   
+ new Integer(month).toString() + new Integer(day).toString());   
return updateFileDate;   
}   
  
/**  
*  
* @Description:��ȡ�������ڣ����ڸ�ʽΪYYYY-MM-DD HH:mm:ss  
* @return  
* @ReturnType Date  
* @author:  
* @Created 2012 2012-9-20����09:58:36  
*/   
public static Date getCurrentlyDate(){   
Date currentDate=new Date();   
return getFormatDate(currentDate,"yyyy-MM-dd HH:mm:ss");   
}   
  
  
/**  
*  
* @Description: ��ȡʱ���Сʱ����24Сʱ�ƣ�  
* @param date  
* @return  
* @ReturnType int  
* @author:  
* @Created 2012 2012-9-25����08:33:44  
*/   
public static int getTime24Hour() {   
  
Calendar calender = Calendar.getInstance();   
calender.setTime(getCurrentlyDate());   
return calender.get(Calendar.HOUR_OF_DAY);   
}   
  
/**  
*  
* @Description:��ȡǰһ��  
* @param date  
* @return  
* @ReturnType Date  
* @author:  
* @Created 2012 2012-9-25����08:32:00  
*/   
public static Date getBeforeDate(Date date) {   
Calendar calender = Calendar.getInstance();   
calender.setTime(date);   
calender.add(calender.DATE, -1);   
return calender.getTime();   
    }   
  
/**  
*  
* @Description:ȡ�õ�ǰ���ڵ���һ��  
* @ReturnType String  
* @author:  
* @Created 2012 2012-9-20����09:12:06  
*/   
public static String getTomorrowDate(){   
Date myDate=new Date();     
Calendar calender = Calendar.getInstance();     
calender.setTime(myDate);     
calender.add(calender.DATE,1);     
return dateToString(calender.getTime(),"yyyy-MM-dd");    
}   
  
/**  
*  
* @Description:ȡ��ǰ���ں�ĵڶ���  
* @return  
* @ReturnType String  
* @author:  
* @Created 2012 2012-9-20����10:37:47  
*/   
    public static String getNextTomorrowDate(){   
  
DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");   
  
Date myDate=new Date();   
  
long myTime=(myDate.getTime()/1000)-60*60*24*365;   
  
myDate.setTime(myTime*1000);   
  
String mDate=formatter.format(myDate);   
  
myTime=(myDate.getTime()/1000)+60*60*24;   
  
myDate.setTime(myTime*1000);   
  
mDate=formatter.format(myDate);   
  
return mDate;   
}   
      
      
    /**  
     *  
     * @Description:��ȡ��ǰ�����ڵ�ǰ�·��еĵڼ�������  
     * @param date  
     * @return  
     * @ReturnType int  
     * @author:  
     * @Created 2012 2012-10-29����11:45:13  
     */   
    public static int getTimeWeekOfMonth(Date date) {       
    Calendar calender = Calendar.getInstance();   
    calender.setTime(date);   
    return calender.get(Calendar.WEEK_OF_MONTH);   
    }   
      
      
    /**  
    *  
    * ������������ȡʱ���ڵ�ǰ���ڵĵڼ���  
    *  
    * @author    
    * <p>�������� ��2012 2012-10-29����11:45:52</p>  
    *  
    * @param date  
    * @return ����������,����: 1��ʾ����һ, ...7��ʾ������  
    *  
    * <p>�޸���ʷ ��(�޸��ˣ��޸�ʱ�䣬�޸�ԭ��/����)</p>  
    */   
    public  static int getTimeDateOfWeek(Date date) {      
    Calendar calender = Calendar.getInstance();   
    calender.setTime(date);   
    int week = calender.get(Calendar.DAY_OF_WEEK) - 1;   
    if(week == 0)   
    week = 7;   
    return week;   
    }   
      
      
      
    /**  
     *  
     * ������������ȡʱ���ڵ�ǰ���ڵĵڼ���  
     *  
     * @author    
     * <p>�������� ��2012 2012-10-29����11:45:52</p>  
     *  
     * @param date  
     * @return ����������,����: 7��ʾ������..1��ʾ������  
     *  
     * <p>�޸���ʷ ��(�޸��ˣ��޸�ʱ�䣬�޸�ԭ��/����)</p>  
     */   
     public  static int getQuartzTimeDateOfWeek(Date date) {      
     Calendar calender = Calendar.getInstance();   
     calender.setTime(date);   
     int week = calender.get(Calendar.DAY_OF_WEEK);       
     return week;   
     }   
      
     /**  
      *  
      * @Description:ĳ��ʱ���뵱ǰʱ��������  
      * @param date  
      * @return  
      * @ReturnType long  
      * @author:  
      * @Created 2012 2012-12-12����01:00:53  
      */   
     public static long getAppointTimeDifference(Date startDate,Date endDate){     
          long l=endDate.getTime()-startDate.getTime();             
          long day=l/(24*60*60*1000);   
  return day;   
     }   
       
       
     /**  
      *  
      * @Description:ĳ��ʱ���뵱ǰʱ��������  
      * @param date  
      * @return  
      * @ReturnType long  
      * @author:  
      * @Created 2012 2012-12-12����01:00:53  
      */   
     public static long getTimeDifference(Date date){      
      /**��ȡ��ǰϵͳʱ��**/   
  java.util.Date currentlyDate=DateUtils.getCurrentlyDate();   
    
          long l=date.getTime()-currentlyDate.getTime();     
          
          long day=l/(24*60*60*1000);   
            
          long hour=(l/(60*60*1000)-day*24);     
            
          long min=((l/(60*1000))-day*24*60-hour*60);     
            
          long s=(l/1000-day*24*60*60-hour*60*60-min*60);   
             
          System.out.println(""+day+"��"+hour+"Сʱ"+min+"��"+s+"��");            
return day;   
     }   
       
     
      
  
    /**  
     *  
     * @Description:��ȡʱ��ķ���  
     * @param date   
     * @ReturnType int  
     * @author:  
     * @Created 2012 2012-10-29����11:45:13  
     */   
    public static int getTimeMinute(Date date) {       
    Calendar calender = Calendar.getInstance();   
    calender.setTime(date);   
    return calender.get(Calendar.MINUTE);   
    }   
      
/**  
* ����ʱ��ָ�ʽת��ʱ�䵥λ  
* @param time  String ; 12:20:30  
* @return String ;12h20m30s  
*/   
public static String getTimeUnit(String time){   
time = time.replaceFirst(":", "h");   
time = time.replaceFirst(":", "m")+"s";   
return time;   
}   
  
  
  /**   
    * ���ݵ�ǰ���ڼ����������õ���Ӧ����   
    * @param s   
    * @param n   
    * @return   
    * @throws Exception   
    */    
    public static String addDay(String s,int n) {            
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");     
    Calendar cd = Calendar.getInstance();     
    try{         
    cd.setTime(sdf.parse(s));     
    cd.add(Calendar.DATE, n);     
    }catch(Exception e){}     
    return sdf.format(cd.getTime());     
   } 
    
} 