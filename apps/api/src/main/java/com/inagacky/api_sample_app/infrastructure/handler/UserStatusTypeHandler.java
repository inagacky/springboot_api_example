package com.inagacky.api_sample_app.infrastructure.handler;

import com.inagacky.api_sample_app.domain.entity.sample.User;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserStatusクラスの変換ハンドラ
 */
public class UserStatusTypeHandler extends BaseTypeHandler<User.Status> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, User.Status parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setInt(i, parameter.getInt());
    }

    @Override
    public User.Status getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return User.Status.fromId(rs.getInt(columnName));
    }

    @Override
    public User.Status getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return User.Status.fromId(rs.getInt(columnIndex));
    }

    @Override
    public User.Status getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return User.Status.fromId(cs.getInt(columnIndex));
    }
}
