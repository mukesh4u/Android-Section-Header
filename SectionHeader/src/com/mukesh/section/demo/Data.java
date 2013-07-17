package com.mukesh.section.demo;

import android.os.*;
import android.util.*;

import java.util.*;

public class Data {
	public static final String TAG = Data.class.getSimpleName();
	
	public static List<Pair<String, List<Composer>>> getAllData() {
		List<Pair<String, List<Composer>>> res = new ArrayList<Pair<String, List<Composer>>>();
		
		for (int i = 0; i < 4; i++) {
			res.add(getOneSection(i));
		}
		
		return res;
	}
	
	public static List<Composer> getFlattenedData() {
		 List<Composer> res = new ArrayList<Composer>();
		 
		 for (int i = 0; i < 4; i++) {
			 res.addAll(getOneSection(i).second);
		 }
		 
		 return res;
	}
	
	public static Pair<Boolean, List<Composer>> getRows(int page) {
		List<Composer> flattenedData = getFlattenedData();
		if (page == 1) {
			return new Pair<Boolean, List<Composer>>(true, flattenedData.subList(0, 5));
		} else {
			SystemClock.sleep(2000); // simulate loading
			return new Pair<Boolean, List<Composer>>(page * 5 < flattenedData.size(), flattenedData.subList((page - 1) * 5, Math.min(page * 5, flattenedData.size())));
		}
	}
	
	public static Pair<String, List<Composer>> getOneSection(int index) {
		String[] titles = {"Assam", "Goa", "Jharkhand","Maharashtra", "Uttar Pradesh"};
		Composer[][] composerss = {
			{
				new Composer("Abhayapuri", "3669"),
				new Composer("Barama", "3623"),
				new Composer("Bihupuria", "3759"),
				new Composer("Bijni", "3668"),
			},
			{
				new Composer("Canacona", "8346"),
				new Composer("Margaon", "8342"),
				new Composer("Panji", "832"),
				new Composer("Ponda", "8343"),
			},
			{
				new Composer("Basia", "6533"),
				new Composer("Bokaro", "6542"),
				new Composer("Chaibasa", "6582"),
				new Composer("Chandil", "6591"),
			},
			{
				new Composer("Achalpur", "7223"),
				new Composer("Ahmednagar", "241"),
				new Composer("Ajara", "2323"),
				new Composer("Akola", "724"),
			},
			{
				new Composer("Agra", "562"),
				new Composer("Akbarpur", "5111"),
				new Composer("Aligarh", "571"),
				new Composer("Allahabad", "532"),
			},
		};
		return new Pair<String, List<Composer>>(titles[index], Arrays.asList(composerss[index]));
	}
}
