package com.xfy.wanandroid.utils

import android.content.ClipboardManager
import android.content.Context
import com.example.baselibrary.utils.MmkvUtils
import com.example.baselibrary.utils.ToastUtils
import com.xfy.wanandroid.constants.Constants
import com.xfy.wanandroid.event.LogoutEvent
import org.greenrobot.eventbus.EventBus


/**
 * des app管理类
 *
 * @author xfy
 * @date 2020-03-12
 */
class AppManager {
    companion object{
        /**
         * 登录状态
         */
        fun isLogin():Boolean {
            return MmkvUtils.decodeBoolean(Constants.LOGIN)!!
        }

        /**
         * 退出登录，重置用户状态
         */
        fun resetUser() {
            //发送退出登录消息
            EventBus.getDefault().post(LogoutEvent())
            MmkvUtils.encode(Constants.LOGIN, false)
            MmkvUtils.removeKey(Constants.USER_INFO)
        }

        /**
         * 复制剪切板
         */
        fun copy(context: Context,msg:String){
            var clip = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            clip.text = msg
            ToastUtils.show("已复制")
        }
    }
}