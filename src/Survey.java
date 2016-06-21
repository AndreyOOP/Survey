import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Survey extends HttpServlet {

    private Statistic statistic;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Statistic.setPathToDataBase( "C:\\Users\\AS\\Desktop\\Java\\Courses\\Corse DZ\\Survey\\Survey\\web\\database.txt");
        statistic = Statistic.getInstance();

        try {

            int age = Integer.parseInt( request.getParameter("textAge"));

            String name = request.getParameter("textName");

            Boolean cbJava = false, cbRuby = false, cbCSh = false, cbCpp = false, cbPyton = false;

            if( request.getParameter("checkBoxJava")   != null) cbJava  = true;
            if( request.getParameter("checkBoxRuby")   != null) cbRuby  = true;
            if( request.getParameter("checkBoxC")      != null) cbCSh   = true;
            if( request.getParameter("checkBoxCpp")    != null) cbCpp   = true;
            if( request.getParameter("checkBoxPython") != null) cbPyton = true;

            Record record = new Record( age, name, cbJava, cbRuby, cbCSh, cbCpp, cbPyton);
            statistic.add( record);

            ServletContext servletContext = getServletContext();
            setAttribute(servletContext, statistic);
            servletContext.getRequestDispatcher("/statistic.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendRedirect("error.html");
            e.printStackTrace();
        }
    }
    
    private void setAttribute(ServletContext servletContext, Statistic statistic){
        
        servletContext.setAttribute("averageAge",    statistic.getAverageAge());
        
        servletContext.setAttribute("javaCounter",   statistic.getJavaCounter());
        servletContext.setAttribute("cppCounter",    statistic.getCppCounter());
        servletContext.setAttribute("cSharpCounter", statistic.getcSharpCounter());
        servletContext.setAttribute("pythonCounter", statistic.getPythonCounter());
        servletContext.setAttribute("rubyCounter",   statistic.getRubyCounter());

        servletContext.setAttribute("javaPercent",   statistic.getJavaPercent());
        servletContext.setAttribute("cppPercent",    statistic.getCppPercent());
        servletContext.setAttribute("cSharpPercent", statistic.getcSharpPercent());
        servletContext.setAttribute("pythonPercent", statistic.getPythonPercent());
        servletContext.setAttribute("rubyPercent",   statistic.getRubyPercent());
    }
}

