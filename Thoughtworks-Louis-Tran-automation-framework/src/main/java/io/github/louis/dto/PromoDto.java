package io.github.louis.dto;

import com.univocity.parsers.annotations.Parsed;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public final class PromoDto extends BaseDto {

    @Parsed(field = "ValidPromoCode", defaultNullRead = "")
    private String validPromoCode;

    @Parsed(field = "InvalidPromoCode", defaultNullRead = "")
    private String invalidPromoCode;
}

