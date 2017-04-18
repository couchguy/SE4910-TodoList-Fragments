package com.example.todolist;

import com.todopart2.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class Todo_Text extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceStae) {
		View view = inflater.inflate(R.layout.fragment_todo_text, container, false);
		
		final EditText myEditText = (EditText) view.findViewById(R.id.myEditText);
		
		
		//the listener for waiting for the enter key press.
		myEditText.setOnKeyListener( new View.OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				
				if( event.getAction() == KeyEvent.ACTION_DOWN) {
					
					//Looks for the key press
					if( (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
							(keyCode == KeyEvent.KEYCODE_ENTER)) {
						
						//Gets the String value from the edittext and 
						//converts it to a string
						String temp = myEditText.getText().toString();
						
						//calls main activities's setItem function
						//to add it to the array list.
						((MainActivity) getActivity()).setItem(temp);
						
						//clears the entry after it has been added to the arraylist.
						myEditText.setText("");
						return true;
					}
				}
				return false;
			}
		});
		
		return view;
	}
	
	
	
}