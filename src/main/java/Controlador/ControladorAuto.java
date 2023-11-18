package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassCrudAuto;
import model.TblAuto;

/**
 * Servlet implementation class ControladorAuto
 */
public class ControladorAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorAuto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//intanciamos la respectiva clase..
		
		String accion=request.getParameter("accion");
		if(accion!=null){
			switch(accion){
			case "registrar":
				//redireccionamos al frmregistrar
				request.getRequestDispatcher("FrmRegistra.jsp").forward(request,response);
			}
		}
	
		ClassCrudAuto cruauto=new ClassCrudAuto();
		TblAuto tblauto=new TblAuto();
		//enviamos a la vista
		List<TblAuto> listado=cruauto.Listado();
		request.setAttribute("listado",listado);
		request.getRequestDispatcher("/ListadoAutos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
