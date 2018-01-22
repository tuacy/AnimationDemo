package com.tuacy.animationdemo.propertyanimation;


import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tuacy.animationdemo.R;

public class PropertyAnimationActivity extends AppCompatActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, PropertyAnimationActivity.class));
	}

	private Context  mContext;
	private TextView mViewMove;
	private Button   mButtonXml;
	private Button   mButtonJava;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_animaiton);
		mContext = this;
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mViewMove = findViewById(R.id.view_property_move);
		mButtonXml = findViewById(R.id.button_property_xml);
		mButtonJava = findViewById(R.id.button_property_java);
	}

	private void initEvent() {
		mButtonXml.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startXmlProperty();
			}
		});
		mButtonJava.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startJavaProperty();
			}
		});
	}

	private void initData() {
	}

	private void startXmlProperty() {
		AnimatorSet animationSet = (AnimatorSet) AnimatorInflater.loadAnimator(mContext, R.animator.property_set);
		animationSet.setTarget(mViewMove);
		animationSet.start();
	}

	private void startJavaProperty() {

	}
}
