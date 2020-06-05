package controllers.play;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Dealer;
import classes.Player;
import models.Player_m;
import models.Role_m;
import utils.DBUtil;

/**
 * Servlet implementation class BetServlet
 */
@WebServlet("/play/bet")
public class BetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //プレイヤーのコインを取得してプレイヤークラスへJSPへ送る
        Player_m p_m = (Player_m)request.getSession().getAttribute("login_player");

        Player p = (Player)request.getSession().getAttribute("player");
        Dealer d = (Dealer)request.getSession().getAttribute("dealer");

        if(p == null){
            //新しくプレイヤーデータを作成
             p = new Player(p_m.getCoin());
             d = new Dealer();
             d.shuffle();
             request.getSession().setAttribute("player", p);
             request.getSession().setAttribute("dealer", d);
        }
        EntityManager em = DBUtil.createEntityManager();

        List<Role_m> roles = em.createNamedQuery("getAllRole",Role_m.class)
                .getResultList();
        request.setAttribute("roles", roles);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/play/bet.jsp");
        rd.forward(request, response);
    }

}
