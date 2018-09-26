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
 * 罗列商品种类
 */
@WebServlet("/goods/listGoodsCategories.do")
public class ListGoodsCategoryServlet extends HttpServlet {
    private GoodsService goodsService;
    private static final int COMPUTER_CATEGORY_OFFSET=1, BOOKS_CATEGORY_OFFSET =4,MAIN_ID=161;

    public ListGoodsCategoryServlet() {
        this.goodsService = new GoodsServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        if(Objects.isNull(session.getAttribute("computerCategories"))){
            session.setAttribute("computerCategories",goodsService.getCategories(MAIN_ID,COMPUTER_CATEGORY_OFFSET));
            System.out.println("set computerCategories");
        }
        if(Objects.isNull(session.getAttribute("booksCategories"))){
            session.setAttribute("booksCategories",goodsService.getCategories(MAIN_ID,BOOKS_CATEGORY_OFFSET));
            System.out.println("set booksCategories");
        }
    }
}
