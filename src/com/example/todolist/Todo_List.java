package com.example.todolist;


import com.todopart2.R;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TimePicker;

public class Todo_List extends Fragment {
	private static final int TIME_DIALOG_ID = 0;
	int mYear;
	int mMonth;
	int mDay;
	int mHour;
	int mMinute;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceStae) {
		//Inflates the view from the xml layout file
		View view = inflater.inflate(R.layout.fragment_todo_list, container, false);
		
		ListView myListView = (ListView) view.findViewById(R.id.myListView);
		
		
		//binding the adapter to the view
		myListView.setAdapter(((MainActivity)getActivity()).getAdapter());
		
		return view;
	}
	
	private DatePickerDialog.OnDateSetListener mDateSetListerner = 
			new DatePickerDialog.OnDateSetListener() {
				
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear,
						int dayOfMonth) {
					mYear = year;
					mMonth = monthOfYear;
					mDay = dayOfMonth;
					updateDateTimeDisplay();
					
				}
			};
	private TimePickerDialog.OnTimeSetListener mTimeSetListener = 
			new TimePickerDialog.OnTimeSetListener() {
				
				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
					mHour = hourOfDay;
					mMinute = minute;
					updateDateTimeDisplay();
				}
			};
	
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case TIME_DIALOG_ID:
				return new TimePickerDialog(getParent(),
						mTimeSetListener, mHour, mMinute, false);
		case DATE_DIALOG_ID:
				return new DatePickerDialog(getParent(),
						mDateSetListerner,
						mYear, mMonth, mDay);
		}
	}
}
