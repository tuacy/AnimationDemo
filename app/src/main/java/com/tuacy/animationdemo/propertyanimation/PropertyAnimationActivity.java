package com.tuacy.animationdemo.propertyanimation;


import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.squareup.picasso.Picasso;
import com.tuacy.animationdemo.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class PropertyAnimationActivity extends AppCompatActivity {

	public static void startUp(Context context) {
		context.startActivity(new Intent(context, PropertyAnimationActivity.class));
	}

	private Context         mContext;
	private CircleImageView mImageView;
	private Button          mButtonXml;
	private Button          mButtonJava;

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
		mImageView = findViewById(R.id.image_icon);
		Picasso.with(mContext)
			   .load("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1960816299,803825902&fm=27&gp=0.jpg")
			   .into(mImageView);
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
		animationSet.setTarget(mImageView);
		animationSet.start();
	}

	private void startJavaProperty() {
		AnimatorSet animatorSet = new AnimatorSet();
		ObjectAnimator objectXAnimator = ObjectAnimator.ofFloat(mImageView, "rotation", 0f, 360f);
		objectXAnimator.setDuration(10000);
		animatorSet.playTogether(objectXAnimator);
		ObjectAnimator objectAlphaAnimator = ObjectAnimator.ofFloat(mImageView, "alpha", 0f, 1f);
		objectAlphaAnimator.setDuration(10000);
		AnimatorSet animatorSetResult = new AnimatorSet();
		animatorSetResult.playTogether(animatorSet, objectAlphaAnimator);
		animatorSetResult.start();
	}
}
