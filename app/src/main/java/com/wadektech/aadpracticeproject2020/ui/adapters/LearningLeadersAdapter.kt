package com.wadektech.aadpracticeproject2020.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.wadektech.aadpracticeproject2020.data.domainModels.LearningLeaders
import com.wadektech.aadpracticeproject2020.databinding.LearningLeadersListItemsBinding

class LearningLeadersAdapter :
    PagedListAdapter<LearningLeaders, LearningLeadersAdapter.LearnersViewHolder>(LearnersDiffUtil()) {

    class LearnersDiffUtil : DiffUtil.ItemCallback<LearningLeaders>() {
        override fun areItemsTheSame(oldItem: LearningLeaders, newItem: LearningLeaders): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: LearningLeaders, newItem: LearningLeaders): Boolean {
           return oldItem.name == newItem.name
        }
    }

    class LearnersViewHolder private constructor(private val binding: LearningLeadersListItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(learningLeaders: LearningLeaders){
                binding.learners = learningLeaders
                binding.executePendingBindings()
            }

        companion object{
            fun from(viewGroup: ViewGroup) : LearnersViewHolder {
                val layoutInflater = LayoutInflater.from(viewGroup.context)
                val binding = LearningLeadersListItemsBinding.inflate(layoutInflater, viewGroup, false)
                return LearnersViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnersViewHolder {
        return LearnersViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LearnersViewHolder, position: Int) {
        val learners = getItem(position)
        if (learners != null){
            holder.bind(learners)
        }
    }
}