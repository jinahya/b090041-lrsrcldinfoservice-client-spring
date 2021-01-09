package com.github.jinahya.datagokr.api.b090041_.lrsrcldinfoservice.client.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.beans.Transient;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.JulianFields;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Setter
@Getter
@Slf4j
public class Response implements Serializable {

    private static final long serialVersionUID = -383243653796767676L;

    // -----------------------------------------------------------------------------------------------------------------
    @XmlAccessorType(XmlAccessType.FIELD)
    @Setter
    @Getter
    @Slf4j
    public static class Header implements Serializable {

        private static final long serialVersionUID = -3266148101861301931L;

        public static final String RESULT_CODE_SUCCESS = "00";

        // -------------------------------------------------------------------------------------------------------------

        @Override
        public String toString() {
            return super.toString() + '{'
                   + "resultCode=" + resultCode
                   + ",resultMsg=" + resultMsg
                   + '}';
        }

        // -------------------------------------------------------------------------------------------------------------
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Header header = (Header) o;
            return Objects.equals(resultCode, header.resultCode) && Objects.equals(resultMsg, header.resultMsg);
        }

        @Override
        public int hashCode() {
            return Objects.hash(resultCode, resultMsg);
        }

        // -------------------------------------------------------------------------------------------------- resultCode
        @Transient
        public boolean isResultCodeSuccess() {
            return RESULT_CODE_SUCCESS.equals(resultCode);
        }

        // --------------------------------------------------------------------------------------------------- resultMsg

        // -------------------------------------------------------------------------------------------------------------
        @JsonbProperty
        @JsonProperty
        @NotBlank
        @XmlElement(required = true)
        private String resultCode;

        @JsonbProperty
        @JsonProperty
        @NotBlank
        @XmlElement(required = true)
        private String resultMsg;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @XmlAccessorType(XmlAccessType.FIELD)
    @Setter
    @Getter
    @Slf4j
    public static class Body implements Serializable {

        private static final long serialVersionUID = -4780774139453333151L;

        // -------------------------------------------------------------------------------------------------------------
        @XmlAccessorType(XmlAccessType.FIELD)
        @Setter
        @Getter
        @Slf4j
        public static class Item implements Serializable, Cloneable {

            private static final long serialVersionUID = -4071620406720872635L;

            // ---------------------------------------------------------------------------------------------------------
            public static final String NORMAL = "\ud3c9";

            public static final String LEAP = "\uc724";

            private static final String PATTERN_REGEXP_NORMAL_OR_LEAP = '[' + NORMAL + LEAP + ']';

            // ---------------------------------------------------------------------------------------------------------

            /**
             * The formatter for {@code solYear} and {@code lunYear}.
             */
            public static final DateTimeFormatter YEAR_FORMATTER = DateTimeFormatter.ofPattern("uuuu");

            /**
             * The formatter for {@code solMonth} and {@code lunMonth}.
             */
            public static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("MM");

            /**
             * The formatter for {@code solDay} and {@code lunDay}.
             */
            public static final DateTimeFormatter DAY_FORMATTER = DateTimeFormatter.ofPattern("dd");

            public static String formatDay(final int dayOfMonth) {
                if (dayOfMonth < 1 || dayOfMonth > 31) {
                    throw new IllegalArgumentException("invalid dayOfMonth: " + dayOfMonth);
                }
                return String.format("%1$02d", dayOfMonth);
            }

            /**
             * The formatter for {@code solWeek}.
             */
            public static final DateTimeFormatter WEEK_FORMATTER = DateTimeFormatter.ofPattern("E", Locale.KOREAN);

            // ---------------------------------------------------------------------------------------------------------
            public static final Comparator<Item> COMPARING_IN_LUNAR = Comparator.comparing(Item::getLunarYear)
                    .thenComparing(Item::getLunMonth)
                    .thenComparing(Item::getLunDay);

            public static final Comparator<Item> COMPARING_IN_SOLAR = Comparator.comparing(Item::getSolarDate);

            // ---------------------------------------------------------------------------------------------------------

            /**
             * Creates a new instance.
             */
            public Item() {
                super();
            }

            // ---------------------------------------------------------------------------------------------------------
            @Override
            public String toString() {
                return super.toString() + '{'
                       + "lunYear=" + lunYear
                       + ",lunMonth=" + lunMonth
                       + ",lunDay=" + lunDay
                       + ",lunLeapmonth=" + lunLeapmonth
                       + ",lunSecha=" + lunSecha
                       + ",lunWolgeon=" + lunWolgeon
                       + ",lunIljin=" + lunIljin
                       + ",lunNday=" + lunNday
                       + ",solYear=" + solYear
                       + ",solMonth=" + solMonth
                       + ",solDay=" + solDay
                       + ",solLeapyear=" + solLeapyear
                       + ",solWeek=" + solWeek
                       + ",solJd=" + solJd
                       + '}';
            }

            // ---------------------------------------------------------------------------------------------------------
            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                final Item cast = (Item) obj;
                return lunNday == cast.lunNday
                       && Objects.equals(lunYear, cast.lunYear)
                       && Objects.equals(lunMonth, cast.lunMonth)
                       && Objects.equals(lunDay, cast.lunDay)
                       && Objects.equals(lunLeapmonth, cast.lunLeapmonth)
                       && Objects.equals(lunSecha, cast.lunSecha)
                       && Objects.equals(lunWolgeon, cast.lunWolgeon)
                       && Objects.equals(lunIljin, cast.lunIljin)
                       && Objects.equals(solYear, cast.solYear)
                       && Objects.equals(solMonth, cast.solMonth)
                       && Objects.equals(solDay, cast.solDay)
                       && Objects.equals(solLeapyear, cast.solLeapyear)
                       && Objects.equals(solWeek, cast.solWeek)
                       && Objects.equals(solJd, cast.solJd);
            }

            @Override
            public int hashCode() {
                return Objects.hash(lunYear, lunMonth, lunDay, lunLeapmonth, lunNday, lunSecha, lunWolgeon, lunIljin,
                                    solYear, solMonth, solDay, solLeapyear, solWeek, solJd);
            }

            // ---------------------------------------------------------------------------------------------------------
            void beforeUnmarshal(final Unmarshaller unmarshaller, final Object parent) {
                // has nothing to do.
            }

            @SuppressWarnings({"java:S1172"})
            void afterUnmarshal(final Unmarshaller unmarshaller, final Object parent) {
                if (lunWolgeon != null && lunWolgeon.trim().isEmpty()) {
                    lunWolgeon = null;
                }
            }

            // ---------------------------------------------------------------------------------------------------------
            @Override
            public Item clone() {
                try {
                    return (Item) super.clone();
                } catch (final CloneNotSupportedException cnse) {
                    throw new AssertionError("failed to clone; " + cnse.getMessage());
                }
            }

            // ------------------------------------------------------------------------------------- lunYear / lunarYear
            @JsonbTransient
            @JsonIgnore
            public Year getLunarYear() {
                return Optional.ofNullable(getLunYear()).map(v -> Year.parse(v, YEAR_FORMATTER)).orElse(null);
            }

            public void setLunarYear(final Year lunarYear) {
                setLunYear(Optional.ofNullable(lunarYear).map(YEAR_FORMATTER::format).orElse(null));
            }

            // ----------------------------------------------------------------------------------- lunMonth / lunarMonth
            @JsonbTransient
            @JsonIgnore
            public Month getLunarMonth() {
                return Optional.ofNullable(getLunMonth()).map(Integer::parseInt).map(Month::of).orElse(null);
            }

            public void setLunarMonth(final Month lunarMonth) {
                setLunMonth(Optional.ofNullable(lunarMonth).map(MONTH_FORMATTER::format).orElse(null));
            }

            // -------------------------------------------------------------------------------- lunDay / lunarDayOfMonth
            @JsonbTransient
            @JsonIgnore
            public Integer getLunarDayOfMonth() {
                return Optional.ofNullable(getLunDay()).map(Integer::parseInt).orElse(null);
            }

            public void setLunarDayOfMonth(final Integer lunarDayOfMonth) {
                setLunDay(Optional.ofNullable(lunarDayOfMonth).map(v -> String.format("%1$02d", v)).orElse(null));
            }

            // --------------------------------------------------------------------------- lunLeapmonth / lunarLeapMonth
            @JsonbTransient
            @JsonIgnore
            public Boolean getLunarLeapMonth() {
                return LEAP.equals(getLunLeapmonth());
            }

            public void setLunarLeapMonth(final Boolean lunarLeapMonth) {
                setLunLeapmonth(Optional.ofNullable(lunarLeapMonth)
                                        .map(v -> v.equals(Boolean.TRUE) ? LEAP : NORMAL)
                                        .orElse(null));
            }

            // ------------------------------------------------------------------------------------------------ lunSecha
            @JsonbTransient
            @JsonIgnore
            public String getLunarGanzhiForYearKore() {
                return Optional.ofNullable(getLunSecha()).map(s -> s.substring(0, 2)).orElse(null);
            }

            @JsonbTransient
            @JsonIgnore
            public String getLunarGanzhiForYearHans() {
                return Optional.ofNullable(getLunSecha()).map(s -> s.substring(3, 5)).orElse(null);
            }

            // ---------------------------------------------------------------------------------------------- lunWolgeon
            @JsonbTransient
            @JsonIgnore
            public String getLunarGanzhiForMonthKore() {
                return Optional.ofNullable(getLunWolgeon()).map(s -> s.substring(0, 2)).orElse(null);
            }

            @JsonbTransient
            @JsonIgnore
            public String getLunarGanzhiForMonthHans() {
                return Optional.ofNullable(getLunWolgeon()).map(s -> s.substring(3, 5)).orElse(null);
            }

            // -----------------------------------------------------------------------------------------------  lunIljin
            @JsonbTransient
            @JsonIgnore
            public String getLunarGanzhiForDayKore() {
                return Optional.ofNullable(getLunIljin()).map(s -> s.substring(0, 2)).orElse(null);
            }

            @JsonbTransient
            @JsonIgnore
            public String getLunarGanzhiForDayHans() {
                return Optional.ofNullable(getLunIljin()).map(s -> s.substring(3, 5)).orElse(null);
            }

            // ------------------------------------------------------------------------------------- solYear / solarYear
            @JsonbTransient
            @JsonIgnore
            public Year getSolarYear() {
                return Optional.ofNullable(getSolYear()).map(v -> Year.parse(v, YEAR_FORMATTER)).orElse(null);
            }

            void setSolarYear(final Year solarYear) {
                setSolYear(Optional.ofNullable(solarYear).map(YEAR_FORMATTER::format).orElse(null));
            }

            // ----------------------------------------------------------------------------------- solMonth / solarMonth
            @JsonbTransient
            @JsonIgnore
            public Month getSolarMonth() {
                return Optional.ofNullable(getSolMonth()).map(Integer::parseInt).map(Month::of).orElse(null);
            }

            void setSolarMonth(final Month solarMonth) {
                setSolMonth(Optional.ofNullable(solarMonth).map(MONTH_FORMATTER::format).orElse(null));
            }

            // -------------------------------------------------------------------------------- solDay / solarDayOfMonth
            @JsonbTransient
            @JsonIgnore
            public Integer getSolarDayOfMonth() {
                return Optional.ofNullable(getSolDay()).map(Integer::parseInt).orElse(null);
            }

            void setSolarDayOfMonth(final Integer solarDayOfMonth) {
                setSolDay(Optional.ofNullable(solarDayOfMonth).map(Item::formatDay).orElse(null));
            }

            // ----------------------------------------------------------------------------------------------- solarDate
            @JsonbProperty
            @JsonProperty
            public LocalDate getSolarDate() {
                return LocalDate.of(getSolarYear().getValue(), getSolarMonth(), getSolarDayOfMonth());
            }

            public void setSolarDate(final LocalDate solarDate) {
                setSolarYear(Optional.ofNullable(solarDate).map(Year::from).orElse(null));
                setSolarMonth(Optional.ofNullable(solarDate).map(Month::from).orElse(null));
                setSolarDayOfMonth(Optional.ofNullable(solarDate).map(LocalDate::getDayOfMonth).orElse(null));
                setSolarLeapYear(Optional.ofNullable(solarDate).map(LocalDate::isLeapYear).orElse(null));
                setSolarDayOfWeek(Optional.ofNullable(solarDate).map(DayOfWeek::from).orElse(null));
                setSolarJulianDay(
                        Optional.ofNullable(solarDate).map(v -> v.getLong(JulianFields.JULIAN_DAY)).orElse(null));
            }

            // ----------------------------------------------------------------------------- solLeapyear / solarLeapYear
            @AssertTrue
            private boolean isSolLeapyearValid() {
                return getSolarDate().isLeapYear() == getSolarLeapYear();
            }

            @JsonbProperty
            @JsonProperty
            public Boolean getSolarLeapYear() {
                return Optional.ofNullable(getSolLeapyear()).map(v -> v.equals(LEAP)).orElse(null);
            }

            public void setSolarLeapYear(final Boolean solarLeapYear) {
                setSolLeapyear(
                        Optional.ofNullable(solarLeapYear)
                                .map(v -> Boolean.TRUE.equals(v) ? LEAP : NORMAL)
                                .orElse(null)
                );
            }

            // -------------------------------------------------------------------------------- solWeek / solarDayOfWeek
            @JsonbProperty
            @JsonProperty
            public DayOfWeek getSolarDayOfWeek() {
                return Optional.ofNullable(getSolWeek()).map(WEEK_FORMATTER::parse).map(DayOfWeek::from).orElse(null);
            }

            void setSolarDayOfWeek(final DayOfWeek solarDayOfWeek) {
                setSolWeek(Optional.ofNullable(solarDayOfWeek).map(WEEK_FORMATTER::format).orElse(null));
            }

            // ---------------------------------------------------------------------------------- solJd / solarJulianDay
            @AssertTrue
            private boolean isSolJdValid() {
                return solJd == getSolarDate().getLong(JulianFields.JULIAN_DAY);
            }

            @JsonbProperty
            @JsonProperty
            public Long getSolarJulianDay() {
                return getSolJd();
            }

            void setSolarJulianDay(final Long julianDay) {
                setSolJd(julianDay);
            }

            // ---------------------------------------------------------------------------------------------------------
            @JsonbProperty
            @JsonProperty
            @NotBlank
            @XmlElement
            private String lunYear;

            @JsonbProperty
            @JsonProperty
            @NotBlank
            @XmlElement
            private String lunMonth;

            @JsonbProperty
            @JsonProperty
            @NotBlank
            @XmlElement
            private String lunDay;

            @JsonbProperty
            @JsonProperty
            @Pattern(regexp = PATTERN_REGEXP_NORMAL_OR_LEAP)
            @NotNull
            @XmlElement
            private String lunLeapmonth;

            @JsonbProperty
            @JsonProperty
            @XmlElement
            private int lunNday;

            @JsonbProperty
            @JsonProperty
            @NotBlank
            @XmlElement
            private String lunSecha;

            @JsonbProperty
            @JsonProperty
            @Nullable
            @XmlElement(required = false)
            private String lunWolgeon;

            @JsonbProperty
            @JsonProperty
            @NotBlank
            @XmlElement
            private String lunIljin;

            // ---------------------------------------------------------------------------------------------------------
            @JsonbProperty
            @JsonProperty
            @NotBlank
            @XmlElement
            private String solYear;

            @JsonbProperty
            @JsonProperty
            @NotBlank
            @XmlElement
            private String solMonth;

            @JsonbProperty
            @JsonProperty
            @NotBlank
            @XmlElement
            private String solDay;

            @JsonbProperty
            @JsonProperty
            @Pattern(regexp = PATTERN_REGEXP_NORMAL_OR_LEAP)
            @NotNull
            @XmlElement
            private String solLeapyear;

            @JsonbProperty
            @JsonProperty
            @Pattern(regexp = "[\uc6d4\ud654\uc218\ubaa9\uae08\ud1a0\uc77c]")
            @NotNull
            @XmlElement
            private String solWeek;

            @JsonbProperty
            @JsonProperty
            @Positive
            @NotNull
            @XmlElement
            private Long solJd; // julian day, 율리우스일
        }

        // -------------------------------------------------------------------------------------------------------------

        @Override
        public String toString() {
            return super.toString() + '{'
                   + "items=" + items
                   + ",numOfRows=" + numOfRows
                   + ",pageNo=" + pageNo
                   + ",totalCount=" + totalCount
                   + '}';
        }

        // -------------------------------------------------------------------------------------------------------------
        @Override
        public boolean equals(final Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            final Body cast = (Body) obj;
            return numOfRows == cast.numOfRows
                   && pageNo == cast.pageNo
                   && totalCount == cast.totalCount
                   && Objects.equals(items, cast.items);
        }

        @Override
        public int hashCode() {
            return Objects.hash(items, numOfRows, pageNo, totalCount);
        }

        // ------------------------------------------------------------------------------------------------------- items
        public List<Item> getItems() {
            if (items == null) {
                items = new ArrayList<>();
            }
            return items;
        }

        // -------------------------------------------------------------------------------------------------------------
        @JsonbTransient
        @JsonIgnore
        @XmlTransient
        @Transient
        public boolean isLastPage() {
            return numOfRows * pageNo >= totalCount;
        }

        // -------------------------------------------------------------------------------------------------------------
        @JsonbProperty
        @JsonProperty
        @XmlElementWrapper
        @XmlElement(name = "item")
        private List<@Valid @NotNull Item> items;

        @JsonbProperty
        @JsonProperty
        @Positive
        @XmlElement(required = true)
        private int numOfRows;

        @JsonbProperty
        @JsonProperty
        @Positive
        @XmlElement(required = true)
        private int pageNo;

        @JsonbProperty
        @JsonProperty
        @PositiveOrZero
        @XmlElement(required = true)
        private int totalCount;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + '{'
               + "header=" + header
               + ",body=" + body
               + '}';
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Response casted = (Response) obj;
        return Objects.equals(header, casted.header)
               && Objects.equals(body, casted.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, body);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @JsonbProperty
    @JsonProperty
    @Valid
    @NotNull
    @XmlElement(required = true)
    private Header header;

    @JsonbProperty
    @JsonProperty
    @Valid
    @NotNull
    @XmlElement(required = true)
    private Body body;
}
