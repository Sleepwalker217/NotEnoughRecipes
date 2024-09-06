package com.sgromov.notenoughrecipes.data.network

import com.sgromov.notenoughrecipes.data.model.MealRecipeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealDbApi {
    @GET("/api/json/v1/1/search.php")
    suspend fun searchByName(@Query("s") name: String): Result<MealRecipeResponse>

    @GET("/api/json/v1/1/lookup.php")
    suspend fun searchById(@Query("i") id: String): Result<MealRecipeResponse>

    @GET("/api/json/v1/1/random.php")
    suspend fun getRandom(): Result<MealRecipeResponse>

    @GET("api/json/v1/1/filter.php?")
    suspend fun searchWithFilters(
        @Query("i") ingredient: String?,
        @Query("c") category: String?,
        @Query("a") area: String?): Result<MealRecipeResponse>
}

