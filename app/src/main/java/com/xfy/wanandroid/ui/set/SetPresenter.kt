package com.xfy.wanandroid.ui.set

import com.example.baselibrary.base.BasePresenter
import com.xfy.wanandroid.http.HttpDefaultObserver
import com.xfy.wanandroid.http.RetrofitHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SetPresenter(view:SetContract.View)
    :BasePresenter<SetContract.View>(view),SetContract.Presenter<SetContract.View> {

    override fun logout() {
        RetrofitHelper.getApiService()
            .logout()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : HttpDefaultObserver<Any>(){
                override fun disposable(d: Disposable) {
                    addSubscribe(d)
                }
                override fun onSuccess(t: Any) {
                    view?.logoutSuccess()
                }
                override fun onError(errorMsg: String) {
                }
            })
    }
}