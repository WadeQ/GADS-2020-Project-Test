package com.wadektech.aadpracticeproject2020.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.wadektech.aadpracticeproject2020.data.domainModels.SkillIqLeaders
import com.wadektech.aadpracticeproject2020.databinding.SkillListItemsBinding

class SkillsLeadersAdapter :
    PagedListAdapter<SkillIqLeaders, SkillsLeadersAdapter.SkillsViewHolder>(SkillsDiffUtil()) {

    class SkillsDiffUtil : DiffUtil.ItemCallback<SkillIqLeaders>(){
        override fun areItemsTheSame(oldItem: SkillIqLeaders, newItem: SkillIqLeaders): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SkillIqLeaders, newItem: SkillIqLeaders): Boolean {
            return oldItem.name == newItem.name
        }

    }

    class SkillsViewHolder private constructor(private val binding: SkillListItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(skillIqLeaders: SkillIqLeaders){
                binding.skills = skillIqLeaders
                binding.executePendingBindings()
            }

        companion object{
            fun from(viewGroup: ViewGroup) : SkillsViewHolder{
                val layoutInflater = LayoutInflater.from(viewGroup.context)
                val binding = SkillListItemsBinding.inflate(layoutInflater, viewGroup, false)
                return SkillsViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsViewHolder {
        return SkillsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SkillsViewHolder, position: Int) {
        val skillsIQ = getItem(position)
        if (skillsIQ != null){
            holder.bind(skillsIQ)
        }
    }
}