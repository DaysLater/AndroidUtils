package com.example.user.utils.weight.animator;

import java.util.ArrayList;
import java.util.List;
import android.util.Log;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.AnimatorSet.Builder;
import com.nineoldandroids.animation.AnimatorSet;


public class AnimationEngine {
	private AnimatorSet animationSet;
	public static final String TAG=AnimationEngine.class.getSimpleName();
	private Interpolator interpolator;
	private long duration;
	private ArrayList<Animator> lits=new ArrayList<Animator>();
	public AnimationEngine(){
		animationSet=new AnimatorSet();
		interpolator=new LinearInterpolator();
		duration=5000;
	}
	public void startTogetherByLink(AnimatorListener listener,AnimatorValue...animatorValues){
		if(animationSet==null){
			Log.d(TAG, "δ�ܳ�ʼ��");
			return;
		}
		animationSet.removeAllListeners();
		if(listener!=null){
			animationSet.addListener(listener);
		}
		if (animatorValues != null) {
			Builder lastBuilder=null;
            for (int i = 0; i < animatorValues.length; i++) {
            	Builder curBuilder = animationSet.play(animatorValues[i].getAnimator());
                if(animatorValues[i].getBeforeAnimator()!=null){
                	curBuilder.after(animatorValues[i].getBeforeAnimator());
                }else if(lastBuilder!=null){
                	lastBuilder.with(animatorValues[i].getAnimator());		
                }
                	lastBuilder=curBuilder;
            }
        }else{
        	Log.d(TAG, "���������ǿ�");
			return;
        }
		//animationSet.setDuration(duration/animatorValues.length);
		animationSet.setInterpolator(interpolator);
		animationSet.start();
	}
	
	public void startTogether(long duration,AnimatorListener listener,List<AnimatorValue> animatorValues){
		if(animationSet==null){
			Log.d(TAG, "δ�ܳ�ʼ��");
			return;
		}
		if(listener!=null){
			animationSet.addListener(listener);
		}
		lits.clear();
		for(AnimatorValue animatorValue:animatorValues){
			if(animatorValue.getAnimator()!=null){
				lits.add(animatorValue.getAnimator());
			}
		}
		if(lits.isEmpty()){
			Log.d(TAG, "���������ǿ�");
			return;
		}
		animationSet.playTogether(lits);
		animationSet.setDuration(duration);
		animationSet.setInterpolator(interpolator);
		animationSet.start();
	}
	
	
	
	public void startTogether(long duration,AnimatorListener listener,AnimatorValue...animatorValues){
		if(animationSet==null){
			Log.d(TAG, "δ�ܳ�ʼ��");
			return;
		}
		if(listener!=null){
			animationSet.addListener(listener);
		}
		lits.clear();
		for(AnimatorValue animatorValue:animatorValues){
			if(animatorValue.getAnimator()!=null){
				lits.add(animatorValue.getAnimator());
			}
		}
		if(lits.isEmpty()){
			Log.d(TAG, "���������ǿ�");
			return;
		}
		animationSet.playTogether(lits);
		animationSet.setDuration(duration);
		animationSet.setInterpolator(interpolator);
		animationSet.start();
	}
	
	
	public void startSequentially(long duration,AnimatorListener listener,AnimatorValue...animatorValues){
		if(animationSet==null){
			Log.d(TAG, "δ�ܳ�ʼ��");
			return;
		}
		if(listener!=null){
			animationSet.addListener(listener);
		}
		animationSet.setDuration(duration);
		animationSet.setInterpolator(interpolator);
		lits.clear();
		for(AnimatorValue animatorValue:animatorValues){
			if(animatorValue.getAnimator()!=null){
				lits.add(animatorValue.getAnimator());
			}
		}
		if(lits.isEmpty()){
			Log.d(TAG, "���������ǿ�");
			return;
		}
		animationSet.playSequentially(lits);
		animationSet.setDuration(duration);
		animationSet.setInterpolator(interpolator);
		animationSet.start();
	}
	
	public void reverse(){
		
	}
	
	
	public void cancel(){
		if(animationSet!=null){
			animationSet.cancel();
		}
	}
	
	public void stop(){
		if(animationSet!=null){
			animationSet.end();
		}
	}
	
	public boolean isRuning(){
		if(animationSet!=null){
			return animationSet.isRunning();
		}else{
			return false;
		}
	}
	
	public boolean isStarted(){
		if(animationSet!=null){
			return animationSet.isStarted();
		}else{
			return false;
		}
	}
	
	public Interpolator getInterpolator() {
		return interpolator;
	}
	public void setInterpolator(Interpolator interpolator) {
		this.interpolator = interpolator;
	}	
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}

}
