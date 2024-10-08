package com.freelife.client.jpa.converter;

import ch.qos.logback.core.util.StringUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * String 데이터를 Base64로 변환하여 DB에 저장
 * Created by mskwon on 2024. 10. 8..
 */
@Slf4j
@Converter
public class EncryptConverter implements AttributeConverter<String, String> {

    /**
     * 엔티티 -> DB 시 데이터 변환
     * Base64 인코딩
     * @param value
     * @return
     */
    @Override
    public String convertToDatabaseColumn(String value) {
        if (StringUtils.isEmpty(value)) return value;
        String encode = Base64.getEncoder().encodeToString(value.getBytes());
        log.debug("stringToBase64 : {}", encode);
        return encode;
    }

    /**
     * DB -> 엔티티 시 데이터 변환
     * @param value
     * @return
     */
    @Override
    public String convertToEntityAttribute(String value) {
        if (StringUtils.isEmpty(value)) return value;
        byte[] decode = Base64.getDecoder().decode(value);
        String decodeStr = new String(decode, StandardCharsets.UTF_8);
        log.debug("base64ToString : {}", decodeStr);
        return decodeStr;
    }

}