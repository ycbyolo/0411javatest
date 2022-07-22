package com.offcn.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.offcn.bean.City;
import com.offcn.service.CityService;
import com.offcn.service.impl.CityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cityServlet")
public class cityServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String countryId = req.getParameter("countryId");

        CityService cs = new CityServiceImpl();
        List<City> list = cs.selectCity(Integer.parseInt(countryId));
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);

        resp.getWriter().println(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
