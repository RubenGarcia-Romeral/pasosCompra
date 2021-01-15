

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="compra", urlPatterns={"/compra"})
public class compra extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String siguientePaso = null;
            Cookie cookies[] = request.getCookies();
                if(siguientePaso == null){
                    if(cookies !=null){
                        for(int i=0; i<cookies.length; i++){
                            if(cookies[i].getName().equals("siguientePaso")){
                                response.sendRedirect(cookies[i].getValue());
                            }
                        }
                    }else{
                        Cookie sig = new Cookie("siguientePaso", "1");
                        paso.setMaxAge(86400);
                    }
                }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet compra</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet compra at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    } 


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
