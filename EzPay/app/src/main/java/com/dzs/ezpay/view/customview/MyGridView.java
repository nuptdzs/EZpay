package com.dzs.ezpay.view.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;


/**
 * 自定义MyGridView
 * @author ahnw_01
 * @version  
 */
public class MyGridView extends GridView{
	  public MyGridView(Context context, AttributeSet attrs) { 
	        super(context, attrs); 
	    } 
	 
	    public MyGridView(Context context) { 
	        super(context); 
	    } 
	 
	    public MyGridView(Context context, AttributeSet attrs, int defStyle) { 
	        super(context, attrs, defStyle); 
	    } 
	 
	    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
	          int mExpandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);  
	          super.onMeasure(widthMeasureSpec, mExpandSpec);  
	     }
}