package com.lzy.demo.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ListView;

/**
 *
 */
@SuppressLint("NewApi")
public class MyListView extends ListView{

	public interface OnScroll2TopListener{
		void scroll2Top();
	}

	private OnScroll2TopListener listener;
	
	public void setOnScroll2TopListener(OnScroll2TopListener listener) {
		this.listener = listener;
	}
	
	@Override
	protected boolean overScrollBy(int deltaX, int deltaY, int scrollX,
			int scrollY, int scrollRangeX, int scrollRangeY,
			int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
//		listener.scroll2Top();
		return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX,
				scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
	}
	
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		Log.e("MyListView", " t: " + t 
			+ " oldt: " + oldt + ": " + 
				getScrollY());
	}
	
	public MyListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	/**
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec
			(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
		
	}
}
