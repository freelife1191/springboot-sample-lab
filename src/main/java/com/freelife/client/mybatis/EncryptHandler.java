package com.freelife.client.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

/**
 * Created by mskwon on 2024. 10. 8..
 */
@Slf4j
public class EncryptHandler implements TypeHandler<String> {
    public String encrypt(String value) {
        String encode = Base64.getEncoder().encodeToString(value.getBytes());
        log.debug("stringToBase64 : {}", encode);
        return encode;
    }

    public String decrypt(String value) {
        byte[] decode = Base64.getDecoder().decode(value);
        String decodeStr = new String(decode);
        log.debug("base64ToString : {}", decodeStr);
        return decodeStr;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        if ( StringUtils.isNotEmpty(parameter) )
            parameter = encrypt(parameter);
        ps.setString(i, parameter);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        return decrypt(rs.getString(columnName));
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        return decrypt(rs.getString(columnIndex));
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return decrypt(cs.getString(columnIndex));
    }
}
