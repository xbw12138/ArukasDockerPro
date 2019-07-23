package com.xbw.arukas;

import android.os.Bundle;

import com.xbw.arukas.Left.SwipeBackActivity;
import com.xbw.arukas.Left.SwipeBackLayout;


public class BaseLeftActivity extends SwipeBackActivity {
	private SwipeBackLayout mSwipeBackLayout;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mSwipeBackLayout = getSwipeBackLayout();
	}

}
