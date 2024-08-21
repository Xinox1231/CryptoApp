package com.example.mycrypto.data.mapper

import com.example.mycrypto.data.remote.dto.CoinDetailsDto
import com.example.mycrypto.data.remote.dto.CoinDto
import com.example.mycrypto.data.remote.dto.TeamMemberDto
import com.example.mycrypto.domain.model.Coin
import com.example.mycrypto.domain.model.CoinDetails
import com.example.mycrypto.domain.model.TeamMember
import javax.inject.Inject

class CoinMapper @Inject constructor() {

    fun mapCoinDtoToCoin(dto: CoinDto): Coin = Coin(
        id = dto.id,
        isActive = dto.isActive,
        isNew = dto.isNew,
        name = dto.name,
        rank = dto.rank,
        symbol = dto.symbol
    )

    fun mapCoinDetailsDtoToCoinDetails(dto: CoinDetailsDto) = CoinDetails(
        id = dto.id,
        isActive = dto.isActive,
        isNew = dto.isNew,
        name = dto.name,
        rank = dto.rank,
        symbol = dto.symbol,
        tags = dto.tags.map { it.name },
        team = dto.team.map {
            mapTeamMemberDtoToTeamMember(it)
        }
    )

    private fun mapTeamMemberDtoToTeamMember(dto: TeamMemberDto) = TeamMember(
        id = dto.id,
        name = dto.name,
        position = dto.position
    )
}