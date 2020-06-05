package controllers.play;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Dealer;
import classes.Player;

/**
 * Servlet implementation class ChangeResultServlet
 */
@WebServlet("/play/change_result")
public class ChangeResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        //選択した配列を受け取る
        String[] select_s = (String[]) request.getAttribute("select");

        //booleanの配列に変換
        boolean[] select = new boolean[5];
        for (int i = 0; i < 5; i++) {
            select[i] = Boolean.valueOf(select_s[i]);
        }

        Player p = (Player) request.getSession().getAttribute("player");
        Dealer d = (Dealer) request.getSession().getAttribute("dealer");

        //カードを交換
        int[] changes = p.getChangeHandArray(select);
        p.changeHand(changes, d.getCards(changes.length));

        //役を判定
        p.updateRole();

        //プレイデータを更新
        request.getSession().setAttribute("player", p);
        request.getSession().setAttribute("dealer", d);

        if(p.getRole() != null){
            request.setAttribute("double_up_flag", true);
        }else{
            request.setAttribute("double_up_flag", false);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/play/change_result.jsp");
        rd.forward(request, response);
    }

}
