package servlets;

import com.parking.parkinglot.common.UsersDto;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.parking.parkinglot.ejb.CarsBean;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Cars", value = "/Cars")
public class Cars extends HttpServlet {

    @Inject
    CarsBean  CarsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        List<UsersDto.CarDto>cars=CarsBean.findAllCars();
        request.setAttribute("cars",cars);
        request.setAttribute("numberOfFreeParkingSpots", 10);
        request.getRequestDispatcher("/WEB-INF/pages/cars.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
    }

}
