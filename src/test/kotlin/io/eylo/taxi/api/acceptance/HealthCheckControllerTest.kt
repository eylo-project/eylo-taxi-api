package io.eylo.taxi.api.acceptance

import org.junit.jupiter.api.Test
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

internal class HealthCheckControllerTest : AcceptanceTest() {

    @Test
    fun healthCheck() {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/health-check"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().string("Eylo Taxi API Server"))
            .andDo(document("health-check-api"))
    }
}
