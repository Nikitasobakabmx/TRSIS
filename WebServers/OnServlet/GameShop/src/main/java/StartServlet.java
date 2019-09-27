import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;


@WebServlet(name = "ExampleServlet", urlPatterns = {"/example"})
public class StartServlet extends HttpServlet {

    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // try{
        //     request.getRequestDispatcher("/jsp/home.jsp").forward(request,response);
        // }catch(IOException e)
        // {
            
        // }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h2>Hello</h2>");
    }
}
