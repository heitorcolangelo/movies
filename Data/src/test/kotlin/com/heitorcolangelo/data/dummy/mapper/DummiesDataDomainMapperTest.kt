package com.heitorcolangelo.data.dummy.mapper

import com.heitorcolangelo.data.factory.DummyDataModelFactory
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test

class DummiesDataDomainMapperTest {

    private val dummyMapper: DummyDataDomainMapper = mockk(relaxed = true)
    private val mapper = DummiesDataDomainMapper(dummyMapper)
    private val elementsCount = 3
    private val entityList = DummyDataModelFactory.makeList(elementsCount)

    @Test
    fun mapToDomainModel() {
        val dummiesDomainModel = mapper.mapToDomainModel(entityList)

        verify(exactly = elementsCount) { dummyMapper.mapToDomainModel(any()) }
        assertEquals(elementsCount, dummiesDomainModel.dummyList.size)
    }

    @Test
    fun mapToDataModelList() {
        val dummiesDomainModel = mapper.mapToDomainModel(entityList)

        val entities = mapper.mapToDataModelList(dummiesDomainModel)

        verify(exactly = elementsCount) { dummyMapper.mapToDataModel(any()) }
        assertEquals(elementsCount, entities.size)
    }
}