package com.unity3d.ads.example.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.example.R;

public class TestInterstitialActivity extends AppCompatActivity {

	static String LOGTAG = "TestInterstitialActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_interstitial);

	    UnityAds.load("video", new IUnityAdsLoadListener() {
		    @Override
		    public void onUnityAdsAdLoaded(String placementId) {
			    Log.v(LOGTAG, "Ad for " + placementId + " loaded");
				showAdNow();
		    }

		    @Override
		    public void onUnityAdsFailedToLoad(String placementId, UnityAds.UnityAdsLoadError error, String message) {
			    Log.e(LOGTAG, "Ad for " + placementId + " failed to load: [" + error + "] " + message);
		    }
	    });

    }

	void showAdNow() {
		UnityAds.show(this, "video", new UnityAdsShowOptions(), new IUnityAdsShowListener() {
			@Override
			public void onUnityAdsShowFailure(String placementId, UnityAds.UnityAdsShowError error, String message) {
				Log.e(LOGTAG, "onUnityAdsShowFailure: " + error + " - " + message);
			}

			@Override
			public void onUnityAdsShowStart(String placementId) {
				Log.v(LOGTAG, "onUnityAdsShowStart: " + placementId);
			}

			@Override
			public void onUnityAdsShowClick(String placementId) {
				Log.v(LOGTAG,"onUnityAdsShowClick: " + placementId);
			}

			@Override
			public void onUnityAdsShowComplete(String placementId, UnityAds.UnityAdsShowCompletionState state) {
				Log.v(LOGTAG,"onUnityAdsShowComplete: " + placementId);
			}
		});
	}
}