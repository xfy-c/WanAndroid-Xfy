package com.xfy.wanandroid.ui.main.mine

import com.example.baselibrary.utils.PrefUtils
import com.example.baselibrary.base.BasePresenter
import com.xfy.wanandroid.constants.Constants
import com.xfy.wanandroid.entity.IntegralEntity
import com.xfy.wanandroid.http.HttpDefaultObserver
import com.xfy.wanandroid.http.RetrofitHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @author xfy
 * @date 2020-03-12
 */
class MinePresenter(view: MineContract.View):BasePresenter<MineContract.View> (view),
    MineContract.Presenter<MineContract.View> {


    override fun loadIntegral() {
        RetrofitHelper.getApiService()
            .getIntegral()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : HttpDefaultObserver<IntegralEntity>(){
                override fun disposable(d: Disposable) {
                    addSubscribe(d)
                }

                override fun onSuccess(t: IntegralEntity) {
                    PrefUtils.setObject(Constants.INTEGRAL_INFO,t)
                    view?.showIntegral(t)
                }

                override fun onError(errorMsg: String) {
                    view?.onError(errorMsg)
                }
            })
    }
}