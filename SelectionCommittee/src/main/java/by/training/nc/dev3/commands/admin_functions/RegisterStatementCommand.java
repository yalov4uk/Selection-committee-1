package by.training.nc.dev3.commands.admin_functions;

import by.training.nc.dev3.dao.RegisteredUserDaoImpl;
import by.training.nc.dev3.dao.StatementDaoImpl;
import by.training.nc.dev3.entities.RegisteredUser;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.factories.DaoFactoryImpl;
import by.training.nc.dev3.iterfaces.dao.RegisteredUserDao;
import by.training.nc.dev3.iterfaces.dao.StatementDao;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;
import by.training.nc.dev3.iterfaces.factories.commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Valera Yalov4uk on 4/19/2017.
 */
public class RegisterStatementCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/jsps/index.jsp";
        DaoFactory daoFactory = DaoFactoryImpl.getInstance();

        RegisteredUserDao registeredUserDao = (RegisteredUserDaoImpl) daoFactory.getDao(RegisteredUser.class);
        StatementDao statementDao = (StatementDaoImpl) daoFactory.getDao(Statement.class);

        int id = Integer.parseInt(request.getParameter("id"));
        RegisteredUser registeredUser = registeredUserDao.find(id);
        if (registeredUser != null) {
            statementDao.persist(new Statement(registeredUser.getUserId(), registeredUser.getFacultyId()));
        }
        registeredUserDao.delete(registeredUser.getId());

        registeredUserDao.close();
        statementDao.close();
        return page;
    }
}
