package by.training.nc.dev3.filters;

import by.training.nc.dev3.dao.UserDaoImpl;
import by.training.nc.dev3.entities.User;
import by.training.nc.dev3.factories.DaoFactoryImpl;
import by.training.nc.dev3.iterfaces.dao.UserDao;
import by.training.nc.dev3.iterfaces.factories.DaoFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Valera Yalov4uk on 4/19/2017.
 */
@WebFilter(urlPatterns = {"/jsps/show_list/*", "/jsps/error/*", "/jsps/functions/*", "/jsps/index.jsp"},
initParams = { @WebInitParam(name = "INDEX_PATH", value = "/jsps/login_signup/login.jsp") })
public class AuthenticationFilter implements Filter {
    private String indexPath;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        indexPath = fConfig.getInitParameter("INDEX_PATH");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        DaoFactory daoFactory = DaoFactoryImpl.getInstance();
        UserDao userDao = (UserDaoImpl) daoFactory.getDao(User.class);

        User curUser = (User) req.getSession().getAttribute("user");
        if (curUser == null || userDao.find((curUser).getId()) == null) {
            userDao.close();
            res.sendRedirect(indexPath);
        } else{
            userDao.close();
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
