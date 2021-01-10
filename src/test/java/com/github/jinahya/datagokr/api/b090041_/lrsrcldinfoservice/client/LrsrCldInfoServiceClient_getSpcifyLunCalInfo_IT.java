package com.github.jinahya.datagokr.api.b090041_.lrsrcldinfoservice.client;

import com.github.jinahya.datagokr.api.b090041_.lrsrcldinfoservice.client.message.Response.Body.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.EnabledIf;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class LrsrCldInfoServiceClient_getSpcifyLunCalInfo_IT extends LrsrCldInfoServiceClientIT {

    // -----------------------------------------------------------------------------------------------------------------
    @EnabledIf("#{systemProperties['" + SYSTEM_PROPERTY_SERVICE_KEY + "'] != null}")
    @DisplayName("getSpcifyLunCalInfo(fromSolarYear, toSolarYear, lunarMonth, lunarDayOfMonth, lunarLeapMonth)")
    @Test
    void getSpcifyLunCalInfo_() {
        final Item item = clientInstance().getLunCalInfo(LocalDate.now().withDayOfMonth(1)).get(0);
        final Month lunarMonth = item.getLunarMonth();
        final int lunarDayOfMonth = item.getLunarDayOfMonth();
        final List<Item> items = clientInstance().getSpcifyLunCalInfo(
                item.getSolarYear().minusYears(1L), item.getSolarYear().plusYears(1L), lunarMonth, lunarDayOfMonth,
                item.getLunarLeapMonth());
        assertThat(items).isNotNull().isNotEmpty().doesNotContainNull().allSatisfy(i -> {
            assertThat(i.getLunarMonth()).isNotNull().isEqualTo(lunarMonth);
            assertThat(i.getLunarDayOfMonth()).isNotNull().isEqualTo(lunarDayOfMonth);
        });
    }
}
