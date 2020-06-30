package com.example.baselibrary.http

import java.io.IOException

/**
 * 用来封装业务错误信息
 *
 * @author xfy
 * @date 2020-03-08
 */
class BusinessHttpException(val businessMessage: String, val businessCode: Int) :
    IOException()