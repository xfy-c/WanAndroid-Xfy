package com.xfy.wanandroid.ui.main.system.navigaton

import com.example.baselibrary.base.BasePresenter
import com.xfy.wanandroid.entity.NavigationEntity
import com.xfy.wanandroid.http.HttpDefaultObserver
import com.xfy.wanandroid.http.RetrofitHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**
 * des 导航
 * @author zs
 * @date 2020-03-16
 */
class NavigationPresenter (view: NavigationContract.View): BasePresenter<NavigationContract.View>(view)
    , NavigationContract.Presenter<NavigationContract.View> {

    override fun loadData() {
        RetrofitHelper.getApiService()
            .getNavigation()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : HttpDefaultObserver<MutableList<NavigationEntity>>() {
                override fun disposable(d: Disposable) {
                    addSubscribe(d)
                }

                override fun onSuccess(t: MutableList<NavigationEntity>) {
                    view?.showList(t)
                }

                override fun onError(errorMsg: String) {
                    view?.onError(errorMsg)
                }

            })
    }
}