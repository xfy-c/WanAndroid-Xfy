package com.example.baselibrary.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.example.baselibrary.R
import com.wang.avi.AVLoadingIndicatorView
import com.xfy.wanandroid.weight.ReloadListener

/**
 * des 辅助站位图
 *
 * @author xfy
 * @date 2020-03-12
 */
class LoadingTip : RelativeLayout {

    private var llEmpty: LinearLayout? = null
    private var indicatorView: AVLoadingIndicatorView? = null
    private var llInternetError: LinearLayout? = null

    private var reloadListener: ReloadListener? = null

    constructor(context: Context) : super(context) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context)
    }

    private fun initView(context: Context) {
        var view = View.inflate(context, R.layout.loading_tip, this)
        llEmpty = view.findViewById(R.id.llEmpty)
        indicatorView = view.findViewById(R.id.indicatorView)
        llInternetError = view.findViewById(R.id.llInternetError)

        indicatorView?.run {
            setIndicatorColor(context.getColor(R.color.red))
            setIndicator("LineSpinFadeLoaderIndicator")

        }
        llInternetError?.setOnClickListener {
            reloadListener?.reload()
        }
    }

    fun setReloadListener(reloadListener: ReloadListener){
        this.reloadListener = reloadListener
    }

    /**
     * 显示空白页
     */
    fun showEmpty() {
        visibility = View.VISIBLE
        llEmpty?.visibility = View.VISIBLE
        indicatorView?.visibility = View.GONE
        indicatorView?.hide()
        llInternetError?.visibility = View.GONE
    }

    /**
     * 显示网络错误
     */
    fun showInternetError() {
        visibility = View.VISIBLE
        llInternetError?.visibility = visibility
        llEmpty?.visibility = View.GONE
        indicatorView?.visibility = View.GONE
        indicatorView?.hide()
    }

    /**
     * 加载
     */
    fun loading() {
        visibility = View.VISIBLE
        indicatorView?.visibility = View.VISIBLE
        indicatorView?.show()
        llInternetError?.visibility = View.GONE
        llEmpty?.visibility = View.GONE

    }

    /**
     * 隐藏loadingTip
     */
    fun dismiss() {
        indicatorView?.hide()
        visibility = View.GONE
    }
}