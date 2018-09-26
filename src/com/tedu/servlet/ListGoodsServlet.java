package com.tedu.servlet;

import com.tedu.service.GoodsService;
import com.tedu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/***
 * 罗列商品
 */
@WebServlet("/goods/listGoods.do")
public class ListGoodsServlet extends HttpServlet {
    private GoodsService goodsService;
    private static final int COMPUTERS_ID=238,BOOKS_ID=241,COUNT=3,OFFSET=1;

    public ListGoodsServlet() {
        this.goodsService = new GoodsServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        if(Objects.isNull(session.getAttribute("computers"))){
            session.setAttribute("computers",goodsService.listGoods(COMPUTERS_ID,OFFSET,COUNT));
            System.out.println("set computers");
        }
        if(Objects.isNull(session.getAttribute("books"))){
            session.setAttribute("books",goodsService.listGoods(BOOKS_ID,OFFSET,COUNT));
            System.out.println("set books");
        }
    }
}
