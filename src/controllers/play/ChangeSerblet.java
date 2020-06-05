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
import models.Role_m;
import utils.DBUtil;

/**
 * Servlet implementation class ChangeSerblet
 */
@WebServlet("/play/change")
public class ChangeSerblet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeSerblet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        //賭け金を取得
        int bet = Integer.parseInt(request.getParameter("bet"));

        EntityManager em = DBUtil.createEntityManager();

        List<Role_m> roles = em.createNamedQuery("getAllRole", Role_m.class)
                .getResultList();

        em.close();

        //賭け金をもとに倍率を獲得コインで上書きする
        for (int i = 0; i < roles.size(); i++) {
            roles.get(i).setMagnification(roles.get(i).getMagnification() * bet);
        }

        Player p = (Player) request.getSession().getAttribute("player");
        p.setBet(bet);
        p.setCoin(p.getCoin() - bet);
        Dealer d = (Dealer) request.getSession().getAttribute("dealer");
        p.setHand(d.getCards(5));

        request.getSession().setAttribute("player", p);
        request.getSession().setAttribute("dealer", d);

        request.setAttribute("hand", p.getHand());
        request.setAttribute("roles", roles);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/play/change.jsp");
        rd.forward(request, response);
    }

}
