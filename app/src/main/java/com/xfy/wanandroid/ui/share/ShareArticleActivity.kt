package com.xfy.wanandroid.ui.share

import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.baselibrary.utils.ToastUtils
import com.xfy.wanandroid.R
import com.xfy.wanandroid.base.AppBaseActivity
import com.xfy.wanandroid.utils.DialogUtils
import kotlinx.android.synthetic.main.activity_share_articel.*

/**
 * 分享文章
 * @author zs
 * @date 2020-03-18
 */
class ShareArticleActivity : AppBaseActivity<ShareContract.Presenter<ShareContract.View>>(),
    ShareContract.View, View.OnClickListener {


    override fun init(savedInstanceState: Bundle?) {
        ivBack.setOnClickListener(this)
        btShare.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.ivBack->finish()
            R.id.btShare->{
                DialogUtils.loading(this,"正在分享")
                val title = etTitle.text.toString()
                val link = etLink.text.toString()
                presenter?.share(title,link)
            }
        }
    }

    override fun shareSuccess() {
        DialogUtils.dismiss()
        finish()
    }


    override fun onError(error: String) {
        DialogUtils.dismiss()
        ToastUtils.show(error)
    }



    override fun createPresenter(): ShareContract.Presenter<ShareContract.View>? {
        return SharePresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_share_articel
    }

    override fun getContext(): Context? {
        return this
    }


}
