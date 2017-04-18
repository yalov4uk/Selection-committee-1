package by.training.nc.dev3.commands;

import by.training.nc.dev3.dao.StatementDaoImpl;
import by.training.nc.dev3.dao.UserDaoImpl;
import by.training.nc.dev3.entities.Statement;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.factories.DaoFactoryImpl;
import by.training.nc.dev3.iterfaces.dao.StatementDao;
import by.training.nc.dev3.iterfaces.dao.UserDao;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;
import by.training.nc.dev3.iterfaces.factories.commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/18/2017.
 */
public class ShowStatementsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/jsps/statements.jsp";
        DaoFactory daoFactory = DaoFactoryImpl.getInstance();
        UserDao userDao = (UserDaoImpl) daoFactory.getDao(User.class);

        User curUser = (User) request.getSession().getAttribute("user");
        if (curUser == null || userDao.find((curUser).getId()) == null) {
            page = "/jsps/login.jsp";
        } else {
            StatementDao statementDao = (StatementDaoImpl) daoFactory.getDao(Statement.class);
            List<Statement> statements = statementDao.getAll();
            request.setAttribute("statements", statements);
            statementDao.close();
        }

        userDao.close();
        return page;
    }
}
