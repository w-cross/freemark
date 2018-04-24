package test.mybatis.typehandler.enumtype;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EnumTypeHandler implements TypeHandler {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
    }

    @Override
    public Object getResult(ResultSet resultSet, String s) throws SQLException {
        Student student = Student.getStudentByName(s);
        return student;
    }

    @Override
    public Object getResult(ResultSet resultSet, int i) throws SQLException {
        String s = resultSet.getString(i);
        return Student.getStudentByName(s);
    }

    @Override
    public Object getResult(CallableStatement callableStatement, int i) throws SQLException {
        String name = callableStatement.getString(i);
        return Student.getStudentByName(name);
    }
}
