package web_study_03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResearchServlet")
public class ResearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name").trim();
        String gender = request.getParameter("gender");
        String[] season = request.getParameterValues("season");
        
        gender = gender.equals("male")?"남자":"여자";
        /*        if (gender.equals("male")) {
            gender = "남자";
        } else {
            gender = "여자";
        }*/
        
        String seasonRes = "";
        for(String s : season) {
            switch(s) {
                case "1": seasonRes += "봄 ";break;
                case "2": seasonRes += "여름 ";break;
                case "3": seasonRes += "가을 ";break;
                case "4": seasonRes += "겨울 ";break;
            }
        }
        
        request.setAttribute("name", name);
        request.setAttribute("gender", gender);
        request.setAttribute("season", seasonRes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("researchResult.jsp"); 
        dispatcher.forward(request, response);
    }

}
