package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Message;

@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // CSRF対策＝セッションIDを利用してサイト外からのPOST送信された投稿を拒否
        request.setAttribute("_token", request.getSession().getId());

        // おまじないとしてのインスタンスを生成＝画面表示時鰓０回避のためにとりあえず文字数０のデータをフォームに送信
        request.setAttribute("message", new Message());

        var rd = request.getRequestDispatcher("/WEB-INF/views/messages/new.jsp");
        rd.forward(request, response);

    }

}