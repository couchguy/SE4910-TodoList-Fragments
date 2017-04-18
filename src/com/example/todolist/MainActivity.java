package com.example.todolist;

import java.util.ArrayList;
import com.todopart2.R;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;

public class MainActivity extends Activity {

	/*
	 * Global Variables. 
	 */
	private ArrayList<String> todolist;
	private ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Creates the Array List
		todolist = new ArrayList<String>();
		//Creates the Array Adapter
		adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, todolist);
		
		//sets the content view and then here is where the
		//frag's onCreates are called 
		setContentView(R.layout.activity_main);		
	}
	
	/**
	 * setItem is used to get a string from the viewText
	 * when an item is entered. and then it adds it to
	 * the arraylist. and then has the adapter 
	 * notify that there was a change of data
	 * 
	 * @param item String
	 */
	public void setItem(String item) {
		todolist.add(item);
		adapter.notifyDataSetChanged();
	}
	
	/**
	 * A get function for the Array Adapter
	 * @return adapter
	 */
	public ArrayAdapter<String> getAdapter() {
		return adapter;
	}
	

}
