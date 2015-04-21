package com.qz.lifehelper.ui.fragment;

import android.widget.EditText;
import android.widget.ImageView;

import com.qz.lifehelper.R;
import com.qz.lifehelper.business.DialogBusiness;
import com.qz.lifehelper.entity.P2PItemBean;
import com.qz.lifehelper.service.P2PService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import bolts.Continuation;
import bolts.Task;

/**
 * 修改P2PItem
 */
@EFragment(R.layout.fragment_p2p_alter)
public class P2PAlterFragment extends BaseFragment {

    /**
     * 当完成操作后会回调该接口
     */
    public interface Callback {
        /**
         * 当修改成功后会回调该接口
         */
        public void onAlterSuccess(P2PItemBean p2pItemBean);

        /**
         * 当删除成功后会回调该接口
         */
        public void onDeleteSuccess(P2PItemBean p2pItemBean);
    }

    static public class Builder {
        private P2PAlterFragment fragment = new P2PAlterFragment_.FragmentBuilder_().build();

        public Builder setP2PItemBean(P2PItemBean p2pItemBean) {
            fragment.p2pItemBean = p2pItemBean;
            return this;
        }

        public Builder setCallback(Callback callback) {
            fragment.callback = callback;
            return this;
        }

        public P2PAlterFragment create() {
            if (fragment.p2pItemBean == null) {
                throw new IllegalStateException("没有设置p2pItemBean");
            }

            if (fragment.callback == null) {
                throw new IllegalStateException("没有设置Callback");
            }

            return fragment;
        }
    }

    private P2PItemBean p2pItemBean;

    private Callback callback;

    @ViewById(R.id.image_iv)
    ImageView imageIV;

    @ViewById(R.id.title_et)
    EditText titleEt;

    @ViewById(R.id.detail_et)
    EditText detailEt;

    @ViewById(R.id.address_et)
    EditText addEt;

    @ViewById(R.id.tel_et)
    EditText telEt;

    @ViewById(R.id.price_et)
    EditText priceEt;

    @AfterViews
    void setData() {
        //TOODO 设置图片
        titleEt.setText(p2pItemBean.title);
        detailEt.setText(p2pItemBean.detail);
        addEt.setText(p2pItemBean.address);
        telEt.setText(p2pItemBean.tel);
        priceEt.setText(p2pItemBean.price);
    }

    @Bean
    P2PService p2pService;

    @Bean
    DialogBusiness dialogBusiness;

    @Click(R.id.image_iv)
    void changeImage() {
        //重新设置图片
    }

    @Click(R.id.alter_bn)
    void alter() {
        //TODO 设置图片
        P2PItemBean p2pItemBean = new P2PItemBean()
                .setTitle(titleEt.getText().toString())
                .setDetail(detailEt.getText().toString())
                .setAddress(addEt.getText().toString())
                .setTel(telEt.getText().toString())
                .setPrice(priceEt.getText().toString())
                .setId(this.p2pItemBean.id)
                .setCategoryBean(this.p2pItemBean.categoryBean);

        dialogBusiness.showDialog(getFragmentManager()
                , new DialogBusiness.ProgressDialogBuilder().create()
                , "p2p_alter");
        p2pService.alterP2PItem(p2pItemBean).onSuccess(new Continuation<P2PItemBean, Void>() {
            @Override
            public Void then(Task<P2PItemBean> task) throws Exception {
                dialogBusiness.hideDialog("p2p_alter");
                callback.onAlterSuccess(task.getResult());
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    @Click(R.id.delete_bn)
    void delete() {
        dialogBusiness.showDialog(getFragmentManager()
                , new DialogBusiness.ProgressDialogBuilder().create()
                , "p2p_delete");
        p2pService.deleteP2PItem(p2pItemBean).onSuccess(new Continuation<P2PItemBean, Void>() {
            @Override
            public Void then(Task<P2PItemBean> task) throws Exception {
                dialogBusiness.hideDialog("p2p_delete");
                callback.onDeleteSuccess(task.getResult());
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

}