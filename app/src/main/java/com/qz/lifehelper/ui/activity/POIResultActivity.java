package com.qz.lifehelper.ui.activity;

import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.qz.lifehelper.R;
import com.qz.lifehelper.business.POIBusiness;
import com.qz.lifehelper.entity.City;
import com.qz.lifehelper.entity.POIResult;
import com.qz.lifehelper.event.GetPOIResultEvent;
import com.qz.lifehelper.presentation.adapter.POIResultListAdpater;

/**
 * Created by kohoh on 15/3/19.
 */
@EActivity(R.layout.activity_poi_result)
public class POIResultActivity extends ActionBarActivity {

	@ViewById(R.id.poi_result_lv)
	public ListView poiResultLv;

	public static final String LOCATION = "LOCATION";
	public static final String CATEGORY = "CATEGORY";

	@Extra(LOCATION)
	String currentLocation;

	@Extra(CATEGORY)
	String category;

	/**
	 * 生成跳转到POIResultActivity的Intent
	 * 
	 * @param location
	 *            查询信息的位置
	 * @param category
	 *            查询信息的类别
	 */
	static public Intent generateIntent(Context context, String location, String category) {
		Intent intent = new Intent(context, POIResultActivity_.class);
		intent.putExtra(LOCATION, location);
		intent.putExtra(CATEGORY, category);
		return intent;
	}

	@Bean
	POIBusiness poiBusiness;

	POIResultListAdpater adpater;

	@Override
	protected void onStart() {
		super.onResume();
		registerEventBus();
	}

	@Override
	protected void onStop() {
		super.onPause();
		unregisterEventBus();
	}

	private void registerEventBus() {
		poiBusiness.getEventBus().register(this);
	}

	private void unregisterEventBus() {
		poiBusiness.getEventBus().unregister(this);
	}

    /**
     * 当收到POI查询结果事件，则更新adapter
     */
	public void onEventMainThread(GetPOIResultEvent event) {
		List<POIResult> poiResults = event.poiResults;
		if (poiResults == null || poiResults.size() == 0) {
			onLoadPOIDataFial();
		} else {
			adpater.setData(poiResults);
			adpater.notifyDataSetChanged();
			onLoadPOIDataSuccess();
		}
	}

	/**
	 * 设置POI结果列表
	 */
	@AfterViews
	public void setPoiResltLv() {
		adpater = new POIResultListAdpater(this);
		poiResultLv.setAdapter(adpater);
		poiBusiness.loadPOIData(City.generateCity(currentLocation), category);
		onStarLoadPOIData();
	}

	/**
	 * 当开始加载数据时被调用
	 */
	void onStarLoadPOIData() {

	}

	/**
	 * 当成功加载数据时被调用
	 */
	void onLoadPOIDataSuccess() {

	}

	/**
	 * 当加载数据失败时被调用
	 */
	void onLoadPOIDataFial() {

	}

}