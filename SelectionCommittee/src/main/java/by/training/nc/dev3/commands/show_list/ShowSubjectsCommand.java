package by.training.nc.dev3.commands.show_list;

import by.training.nc.dev3.dao.SubjectDaoImpl;
import by.training.nc.dev3.entities.Subject;
import by.training.nc.dev3.factories.DaoFactoryImpl;
import by.training.nc.dev3.iterfaces.dao.SubjectDao;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;
import by.training.nc.dev3.iterfaces.factories.commands.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Valera Yalov4uk on 4/18/2017.
 */
public class ShowSubjectsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = "/jsps/show_list/subjects.jsp";
        DaoFactory daoFactory = DaoFactoryImpl.getInstance();
        SubjectDao subjectDao = (SubjectDaoImpl) daoFactory.getDao(Subject.class);
        List<Subject> subjects = subjectDao.getAll();
        request.setAttribute("subjects", subjects);
        subjectDao.close();

        return page;
    }
}
