package com.romanbialek.mvvmtest.domain.usecase


import com.romanbialek.mvvmtest.domain.model.GetCharactersListResponse
import com.romanbialek.mvvmtest.domain.model.base.BaseResponse
import com.romanbialek.mvvmtest.domain.repository.CharactersListRepository
import com.romanbialek.mvvmtest.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject


class GetCharactersUseCase @Inject constructor(private val repository: CharactersListRepository) : SingleUseCase<BaseResponse<GetCharactersListResponse>>() {

    private var offset: Int = 0

    fun setOffset(newValue: Int){
        this.offset = newValue
    }

    override fun buildUseCaseSingle(): Single<BaseResponse<GetCharactersListResponse>> {
        return repository.getCharacters(offset)
    }

}