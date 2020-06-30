package com.xfy.wanandroid.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.donkingliang.labels.LabelsView
import com.xfy.wanandroid.R
import com.xfy.wanandroid.entity.SystemListEntity

/**
 * 体系 适配器
 * @author xfy
 * @date 2020-03-16
 */
class SystemAdapter(layoutId:Int) :BaseQuickAdapter<SystemListEntity,BaseViewHolder>(layoutId){

    private var systemClickListener:OnSystemClickListener? = null
    fun setOnSystemClickListener(systemClickListener:OnSystemClickListener?){
        this.systemClickListener = systemClickListener
    }
    override fun convert(helper: BaseViewHolder, item: SystemListEntity?) {
        item?.let {
            helper.setText(R.id.tvTitle,item.name)
            helper.getView<LabelsView>(R.id.labelsView).apply {
                setLabels(item.children) { _, _, data ->
                    data.name
                }
                //标签的点击监听
                setOnLabelClickListener { _, _, position ->
                    systemClickListener?.onCollectClick(helper,helper.adapterPosition,position)
                }
            }
        }
    }

}