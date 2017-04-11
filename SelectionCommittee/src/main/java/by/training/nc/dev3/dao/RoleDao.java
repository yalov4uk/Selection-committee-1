package by.training.nc.dev3.dao;

import by.training.nc.dev3.abstracts.BaseDao;
import by.training.nc.dev3.entities.Role;
import by.training.nc.dev3.iterfaces.dao.RoleDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/10/2017.
 */
public class RoleDao extends BaseDao<Role> implements RoleDaoImpl {
    @Override
    public String getCreateQuery() {
        return "insert into roles (name) values (?);";
    }

    @Override
    protected String getSelectQuery() {
        return "select * from roles";
    }

    @Override
    protected String getUpdateQuery() {
        return "update roles set name = ? where id = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "delete from roles where id = ?;";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Role object) throws SQLException {
        prepareStatement(statement, object);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Role object) throws SQLException {
        prepareStatement(statement, object);
        statement.setInt(2, object.getId());
    }

    @Override
    protected List<Role> parseResultSet(ResultSet rs) throws SQLException {
        List<Role> result = new LinkedList<>();
        while (rs.next()) {
            result.add(new Role(rs.getInt("id"), rs.getString("name")));
        }
        return result;
    }

    public RoleDao(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, Role object) throws SQLException {
        statement.setString(1, object.getName());
    }
}
