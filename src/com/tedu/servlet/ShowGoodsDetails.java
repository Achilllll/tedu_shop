package com.tedu.servlet;

import com.tedu.entity.Goods;
import com.tedu.service.GoodsService;
import com.tedu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/goods/showProductDetails.do")
public class ShowGoodsDetails extends HttpServlet {
    private GoodsService goodsService;

    public ShowGoodsDetails() {
        this.goodsService = new GoodsServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.parseInt(req.getParameter("id"));
        //如果能找到，就重定向到product_details.jsp

        if(Objects.nonNull(req.getParameter("id"))){
            Goods goods=goodsService.goodsDetail(id);
            if(Objects.nonNull(goods)){
                req.setAttribute("goods",goods);
                req.getRequestDispatcher("../web/product_details.jsp").forward(req,resp);
            }
        }else {
            req.getRequestDispatcher("web/404.html").forward(req,resp);
        }
    }
}
