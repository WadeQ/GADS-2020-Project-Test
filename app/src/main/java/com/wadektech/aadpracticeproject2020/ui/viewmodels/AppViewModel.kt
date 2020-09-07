package com.wadektech.aadpracticeproject2020.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.wadektech.aadpracticeproject2020.data.domainModels.LearningLeaders
import com.wadektech.aadpracticeproject2020.data.domainModels.SkillIqLeaders
import com.wadektech.aadpracticeproject2020.data.repository.AppRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class AppViewModel
@ViewModelInject
constructor(
    private val appRepository: AppRepository
) : ViewModel()
{

    private var _learningLeadersPagedList : LiveData<PagedList<LearningLeaders>>
    private var _skillIQLeadersPagedList : LiveData<PagedList<SkillIqLeaders>>

    init {
        getAllSkilledLeadersByIq()
        getAllLearningLeaders()

        val learners : DataSource.Factory<Int, LearningLeaders> = appRepository.getAllLearningLeadersFromLocal()
        val skills : DataSource.Factory<Int, SkillIqLeaders> = appRepository.getAllSkillIqLeadersFromLocal()

        val livePagedListBuilderForLearners : LivePagedListBuilder<Int, LearningLeaders> = LivePagedListBuilder(learners, 50)
        _learningLeadersPagedList = livePagedListBuilderForLearners.build()

        val livePagedListBuilderSkillsByIQ : LivePagedListBuilder<Int, SkillIqLeaders> = LivePagedListBuilder(skills,50)
        _skillIQLeadersPagedList = livePagedListBuilderSkillsByIQ.build()
    }

    private fun getAllSkilledLeadersByIq() = viewModelScope.launch {
        appRepository.getAllSkillIqLeadersFromRemote()
    }

    private fun getAllLearningLeaders() = viewModelScope.launch {
        appRepository.getAllLearningLeadersFromRemote()
    }

    fun getAllSkilledLeadersByIQ() : LiveData<PagedList<SkillIqLeaders>>{
        return _skillIQLeadersPagedList
    }

    fun getAllLearningLeadersByHours() : LiveData<PagedList<LearningLeaders>>{
        return _learningLeadersPagedList
    }

    override fun onCleared() {
        super.onCleared()
    }
}