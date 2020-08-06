package com.example.baselibrary.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.example.baselibrary.BaseApplication

class NetUtils {

    companion object {
        /**
         * 当前网络是否可用
         */
        val NETWORK_ENABLE: Boolean
            get() {
                val connManager = BaseApplication.getContext()
                    .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val info = connManager.activeNetworkInfo
                return info.state == NetworkInfo.State.CONNECTED
            }

    }
}