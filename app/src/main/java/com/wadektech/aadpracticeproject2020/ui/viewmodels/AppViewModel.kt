package com.wadektech.aadpracticeproject2020.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.wadektech.aadpracticeproject2020.data.domainModels.LearningLeadersItem
import com.wadektech.aadpracticeproject2020.data.domainModels.SkillIqLeadersItem
import com.wadektech.aadpracticeproject2020.data.repository.AppRepository
import kotlinx.coroutines.launch

class AppViewModel
@ViewModelInject
constructor(
    private val appRepository: AppRepository
) : ViewModel()
{

    private var _learningLeadersPagedList : LiveData<PagedList<LearningLeadersItem>>
    private var _skillIQLeadersPagedList : LiveData<PagedList<SkillIqLeadersItem>>

    init {
        getAllSkilledLeadersByIq()
        getAllLearningLeaders()

        val learners : DataSource.Factory<Int, LearningLeadersItem> = appRepository.getAllLearningLeadersFromLocal()
        val skills : DataSource.Factory<Int, SkillIqLeadersItem> = appRepository.getAllSkillIqLeadersFromLocal()

        val livePagedListBuilderForLearners : LivePagedListBuilder<Int, LearningLeadersItem> = LivePagedListBuilder(learners, 25)
        _learningLeadersPagedList = livePagedListBuilderForLearners.build()

        val livePagedListBuilderSkillsByIQ : LivePagedListBuilder<Int, SkillIqLeadersItem> = LivePagedListBuilder(skills,25)
        _skillIQLeadersPagedList = livePagedListBuilderSkillsByIQ.build()
    }

    private fun getAllSkilledLeadersByIq() = viewModelScope.launch {
        appRepository.getAllSkillIqLeadersFromRemote()
    }

    private fun getAllLearningLeaders() = viewModelScope.launch {
        appRepository.getAllLearningLeadersFromRemote()
    }

    fun getAllSkilledLeadersByIQ() : LiveData<PagedList<SkillIqLeadersItem>>{
        return _skillIQLeadersPagedList
    }

    fun getAllLearningLeadersByHours() : LiveData<PagedList<LearningLeadersItem>>{
        return _learningLeadersPagedList
    }

}