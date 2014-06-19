@TypeDefs({
        @TypeDef(name = "localDateType",
                defaultForType = LocalDate.class,
                typeClass = LocalDateUserType.class),
        @TypeDef(name = "localDateTimeType",
                defaultForType = LocalDateTime.class,
                typeClass = LocalDateTimeUserType.class),
        @TypeDef(name = "localTimeType",
                defaultForType = LocalTime.class,
                typeClass = LocalTimeUserType.class)
})
package com.mediaserver.domain;

import com.mediaserver.utils.hibernate.wrappers.LocalDateTimeUserType;
import com.mediaserver.utils.hibernate.wrappers.LocalDateUserType;
import com.mediaserver.utils.hibernate.wrappers.LocalTimeUserType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;