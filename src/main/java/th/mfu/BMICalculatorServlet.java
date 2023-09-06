package th.mfu;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String weightstr = request.getParameter("weight");
        String heightstr = request.getParameter("height");

        double weight = Double.parseDouble(weightstr);
        double height = Double.parseDouble(heightstr);
        
        //TODO: calculate bmi
        double bmi = Math.round(weight/(height*height));

        //TODO: determine the built from BMI
        String builtType;

        if(bmi<18.5){
            builtType = "underweight";
        }
        else if(bmi >= 18.5 && bmi < 25){
            builtType = "normal";
        }
        else if(bmi >= 25 && bmi < 30){
            builtType = "overweight";
        }
        else if(bmi >= 30 && bmi < 35){
            builtType = "obese";
        }
        else{
            builtType = "extremely obese";
        }
      
        //TODO: add bmi and built to the request's attribute

        request.setAttribute("bmi",bmi);
        request.setAttribute("builtType",builtType);

        //TODO: forward to jsp

        request.getRequestDispatcher("bmi_result.jsp").forward(request,response);
           
    }
    
}
