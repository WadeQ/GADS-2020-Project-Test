package com.wadektech.aadpracticeproject2020.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wadektech.aadpracticeproject2020.data.domainModels.LearningLeaders
import com.wadektech.aadpracticeproject2020.data.domainModels.SkillIqLeaders
import com.wadektech.aadpracticeproject2020.ui.adapters.LearningLeadersAdapter
import com.wadektech.aadpracticeproject2020.ui.adapters.SkillsLeadersAdapter
import timber.log.Timber


@BindingAdapter("badgeImage")
fun bindBadgeImages(imageView: AppCompatImageView, imageUrl: String?){
    imageUrl?.let {
        val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imageUri)
            .into(imageView)
    }
}

@BindingAdapter("bindLearnersAdapter")
fun bindLearningAdapter(recyclerView: RecyclerView, pagedList: PagedList<LearningLeaders>?) {
    val adapter = recyclerView.adapter as LearningLeadersAdapter
    Timber.d("binding learning adapter list size is: ${pagedList?.size}")
    adapter.submitList(pagedList)
}

@BindingAdapter("bindSkillIqAdapter")
fun bindSkillIqAdapter(recyclerView: RecyclerView, skillsPagedList: PagedList<SkillIqLeaders>?) {
    val adapter = recyclerView.adapter as SkillsLeadersAdapter
    Timber.d("binding skill  adapter list size is: ${skillsPagedList?.size}")
    adapter.submitList(skillsPagedList)
}