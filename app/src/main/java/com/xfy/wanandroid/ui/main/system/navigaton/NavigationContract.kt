package com.xfy.wanandroid.ui.main.system.navigaton

import com.example.baselibrary.base.IBasePresenter
import com.example.baselibrary.base.IBaseView
import com.xfy.wanandroid.entity.NavigationEntity


/**
 * des 导航列表
 * @author xfy
 * @date 2020-03-16
 */
interface NavigationContract {
    interface View: IBaseView {
        fun showList(list: MutableList<NavigationEntity>)
    }

    interface Presenter<T>: IBasePresenter<View> {
        fun loadData()
    }
}