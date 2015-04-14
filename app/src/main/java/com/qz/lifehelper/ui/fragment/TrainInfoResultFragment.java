package com.qz.lifehelper.ui.fragment;

import android.support.v4.app.ListFragment;

import com.qz.lifehelper.business.TrainBusiness;
import com.qz.lifehelper.entity.CityBean;
import com.qz.lifehelper.entity.TrainInfoBean;
import com.qz.lifehelper.ui.adapter.TrainInfoAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bolts.Continuation;
import bolts.Task;

/**
 * 火车票信息搜索结果页
 */
@EFragment
public class TrainInfoResultFragment extends ListFragment {

    /**
     * 出发火车站
     */
    private CityBean startCity;
    /**
     * 目的地火车站
     */
    private CityBean endCity;
    /**
     * 出发日期
     */
    private Date dateStart;


    /**
     * 生成TrainInfoResultFragment
     *
     * @param startCity 出发火车站
     * @param endCity   目的地火车站
     * @param dateStart    出发日期
     */
    public static TrainInfoResultFragment generateFragment(CityBean startCity, CityBean endCity, Date dateStart) {

        TrainInfoResultFragment fragment = new TrainInfoResultFragment_();
        fragment.startCity = startCity;
        fragment.endCity = endCity;
        fragment.dateStart = dateStart;
        return fragment;
    }

    @Bean
    TrainBusiness trainBusiness;

    @Bean
    TrainInfoAdapter adapter;

    List<TrainInfoBean> data = new ArrayList<>();

    /**
     * 配置火车票信息搜索结果列表
     */
    @AfterViews
    public void setListView() {
        setListAdapter(adapter);

        trainBusiness.getTrainInfo(startCity, endCity, dateStart).onSuccess(new Continuation<List<TrainInfoBean>, Void>() {
            @Override
            public Void then(Task<List<TrainInfoBean>> task) throws Exception {
                data.clear();
                data.addAll(task.getResult());
                adapter.setData(data);
                adapter.notifyDataSetChanged();
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }
}