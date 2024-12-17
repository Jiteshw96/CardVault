package com.app.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.domain.model.Benefit
import com.app.presentation.R
import com.app.presentation.databinding.RewardItemBinding

class RewardAdapter(
    private val rewardsList: List<Benefit>
) : RecyclerView.Adapter<RewardAdapter.RewardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardViewHolder {
        val mBinding = DataBindingUtil.inflate<RewardItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.reward_item,
            parent,
            false
        )
        return RewardViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: RewardViewHolder, position: Int) {
        holder.bindData(reward = rewardsList[position])
    }

    override fun getItemCount(): Int = rewardsList.size

    inner class RewardViewHolder(private val mBinding: RewardItemBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        fun bindData(reward: Benefit) {
            mBinding.cityName.text = reward.name
            mBinding.cityDetail.text = reward.description
            mBinding.cityImage.setBackgroundResource(reward.image)
        }
    }
}