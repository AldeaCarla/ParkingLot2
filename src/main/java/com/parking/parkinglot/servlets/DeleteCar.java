package com.parking.parkinglot.servlets;

import com.parking.parkinglot.ejb.CarsBean;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteCar", value = "/DeleteCar")
public class DeleteCar extends HttpServlet {

    @Inject
    CarsBean carsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long carId = Long.parseLong(request.getParameter("id"));

        carsBean.deleteCar(carId);

        response.sendRedirect(request.getContextPath() + "/Cars");
    }
}
