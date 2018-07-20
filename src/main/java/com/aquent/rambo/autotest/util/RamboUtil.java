package com.aquent.rambo.autotest.util;

import java.io.File;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.testng.Assert;

public class RamboUtil {

	// page string format "of 12"
	public static int getMaxPages(String pageString) {

		if (pageString == null) {
			return 1; // no paging
		}
		String[] tokens = pageString.split(" ");
		if (tokens.length == 2) {
			return Integer.valueOf(tokens[1]);
		}

		return 1; // no paging
	}

	public static void pause(long millis) {

		try {
			Thread.sleep(millis);
		}
		catch (InterruptedException e) {
		}
	}

	public static long randomNumber() {

		long n3 = Math.round(Math.random()*1000);
		return n3;
	}

	public static String startDates()
	{
		LocalDate date = LocalDate.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		String formattedStringToday = date.format(formatter);

		return formattedStringToday;

	}
	
	public static String changeDate(int day)
	{
		LocalDate date = LocalDate.now();
		LocalDate Afterdate = date.plusDays(day);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		String formattedStringToday = Afterdate.format(formatter);
		
		return formattedStringToday;

	}


	public static String EndDates()
	{
		LocalDate date = LocalDate.now();
		LocalDate Afterdate = date.plusDays(7);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		String formattedStringAfter = Afterdate.format(formatter);

		return formattedStringAfter;

	}

	public static String previousDate()
	{
		LocalDate date = LocalDate.now();
		LocalDate Previousdate = date.minusDays(7);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		String formattedStringAfter = Previousdate.format(formatter);

		return formattedStringAfter;

	}

	public static long getDaysDiff(String a, String b)
	{

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

		Date d1 = null;
		Date d2 = null;

		try {

			d1 = format.parse(b);
			d2 = format.parse(a);

			long diff = d1.getTime() - d2.getTime();
			long diffdays = diff/ (24 * 60 * 60 * 1000);

			return diffdays;

		} catch (Exception e) {
			return 0;
		}

	}

	public static String getConvertedDate(String date)
	{
		System.out.println(date);
		String month = date.substring(0, 2);
		int m = Integer.parseInt(month);
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		String monthName = months[--m];
		String actualDate = monthName.substring(0, 3).concat(date.substring(2).replace("/"," "));
		System.out.println(actualDate);
		return actualDate;
	}
	
	public static String getMonthAndYear()
	{
		java.sql.Date date1 = new java.sql.Date((new Date()).getTime());

		SimpleDateFormat formatNowMonth = new SimpleDateFormat("MM");
		SimpleDateFormat formatNowYear = new SimpleDateFormat("YYYY");


		String currentMonth = formatNowMonth.format(date1);
		String year = formatNowYear.format(date1);
		String month = currentMonth.substring(0, 2);

		int m = Integer.parseInt(month);
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		String monthName = months[--m];
		String actualDate = monthName.concat(" "+year);
		return actualDate;
	}

	public static String getUserResourceStartDate(String date)
	{
		String startDate = date.substring(0, 11);
		System.out.println(startDate);
		return startDate;
	}

	public static String getUserResourceDueDate(String date)
	{
		String dueDate = date.substring(13, 25).trim();
		System.out.println(dueDate);

		return dueDate;
	}

	public static String getAddTofavoriteListProjectName(String names)
	{

		String[] bits = names.split(" ");
		String actualName = bits[bits.length-2];
		System.out.println(actualName);
		return actualName;

	}
	
	public static String getAddToFavoriteListTaskName(String names)
	{
	
		String[] arr = names.split(" ",2);
		String actualName = arr[1];
		return actualName;
	}
	
	public static String getExactText(String name,int i,int j)
	{
		String[] arr = name.split(" ",i);
		String actualName = arr[j];
		return actualName;
	}

	public static boolean verifyFileDownload(String downloadPath,String ExpectedFileName)
	{
		
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		System.out.println(fileName);
		Assert.assertTrue(fileName.equals(ExpectedFileName), "Downloaded file name is not matching with expected file name");
		return true;
	}


	public static File getLatestFilefromDir(String dirPath){
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
	
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		  File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i < dirContents.length; i++) {
		      if (dirContents[i].getName().equals(fileName)) {
		          // File has been found, it can now be deleted:
		    	  System.out.println(dirContents[i]);
		          dirContents[i].delete();
		          return true;
		      }
		          }
		      return false;
		  }


public static void main(String[] args) {
	// TODO Auto-generated method stub
	

}

}
