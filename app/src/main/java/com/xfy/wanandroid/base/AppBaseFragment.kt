package com.xfy.wanandroid.base

import android.content.Intent
import android.os.Bundle
import com.example.baselibrary.base.BaseFragment
import com.example.baselibrary.base.IBasePresenter
import com.xfy.wanandroid.ui.login.LoginActivity
import com.xfy.wanandroid.utils.AppManager

/**
 * des 主工程
 * @author zs
 * @date 2020-04-24
 */
abstract class AppBaseFragment<P: IBasePresenter<*>>():BaseFragment<P>() {

    /**
     * 界面跳转
     * @param isLogin 启动界面是否需要登录
     */
    protected fun intent(clazz:Class<*>, isLogin:Boolean){
        //需要登录&&未登录
        if (isLogin && !AppManager.isLogin()) {
            startActivity(Intent(context, LoginActivity::class.java))
        }else{
            startActivity(Intent(context,clazz))
        }
    }

    /**
     * 携带bundle跳转
     * @param isLogin 启动界面是否需要登录
     */
    protected fun intent(bundle: Bundle, clazz:Class<*>, isLogin:Boolean){
        //需要登录&&未登录
        if (isLogin && !AppManager.isLogin()) {
            startActivity(Intent(context, LoginActivity::class.java))
        }else{
            startActivity(Intent(context, clazz).apply {
                putExtras(bundle)
            })
        }
    }
}