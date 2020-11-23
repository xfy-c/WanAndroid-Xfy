package com.xfy.wanandroid.entity

import android.os.Parcel
import android.os.Parcelable

/**
 * des 个人积分
 * @author xfy
 * @date 2020-03-17
 */
class IntegralEntity() : Parcelable {

    /**
     * coinCount : 451
     * rank : 7
     * userId : 2
     * username : x**oyang
     */

    var coinCount: Int = 0
    var rank: Int = 0
    var userId: Int = 0
    var username: String? = null

    constructor(parcel: Parcel) : this() {
        coinCount = parcel.readInt()
        rank = parcel.readInt()
        userId = parcel.readInt()
        username = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(coinCount)
        parcel.writeInt(rank)
        parcel.writeInt(userId)
        parcel.writeString(username)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IntegralEntity> {
        override fun createFromParcel(parcel: Parcel): IntegralEntity {
            return IntegralEntity(parcel)
        }

        override fun newArray(size: Int): Array<IntegralEntity?> {
            return arrayOfNulls(size)
        }
    }
}
