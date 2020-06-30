package com.xfy.wanandroid.ui.collect

import com.example.baselibrary.base.IBasePresenter
import com.example.baselibrary.base.IBaseView
import com.xfy.wanandroid.entity.CollectEntity

/**
 * @author xfy
 * @date 2020-03-13
 */
interface CollectContract {
    interface View: IBaseView {
        fun showList(list: MutableList<CollectEntity.DatasBean>)
        fun cancelCollectSuccess()
    }

    interface Presenter<T> : IBasePresenter<View> {
        fun loadData(page:Int)
        fun cancelCollect(id:Int)
    }
}