package by.training.nc.dev3.dao;

import by.training.nc.dev3.abstracts.BaseDaoImpl;
import by.training.nc.dev3.entities.Role;
import by.training.nc.dev3.exceptions.DaoUncheckedException;
import by.training.nc.dev3.iterfaces.dao.RoleDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/10/2017.
 */
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
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
        return "delete from roles";
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Role object) {
        prepareStatement(statement, object);
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Role object) {
        prepareStatement(statement, object);
        try {
            statement.setInt(2, object.getId());
        } catch (SQLException e) {
            throw new DaoUncheckedException("Role dao prepare for update error");
        }
    }

    @Override
    protected List<Role> parseResultSet(ResultSet rs) {
        List<Role> result = new LinkedList<>();
        try {
            while (rs.next()) {
                result.add(new Role(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            throw new DaoUncheckedException("Role dao prepare parse result set error");
        }
        return result;
    }

    public RoleDaoImpl(Connection connection) {
        super(connection);
    }

    private void prepareStatement(PreparedStatement statement, Role object) {
        try {
            statement.setString(1, object.getName());
        } catch (SQLException e) {
            throw new DaoUncheckedException("Role dao prepare statement error");
        }
    }
}
