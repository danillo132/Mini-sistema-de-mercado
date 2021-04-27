package servelts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
import dao.DaoUsuario;
import service.RelatorioService;

/**
 * Servlet implementation class ServletDownloadFile
 */
@WebServlet("/ServletDownloadFile")
public class ServletDownloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	private RelatorioService relatorioService = new RelatorioService();
	
	private DaoUsuario daoUsuario = new DaoUsuario();
	
    public ServletDownloadFile() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			ServletContext context = request.getServletContext();
			
			String tipoExportar = request.getParameter("tipoExportar");
			List<BeanCursoJsp> usuarios = daoUsuario.listar();
			
			List dados = new ArrayList();
			dados.add(usuarios);
			
			
			String fileUrl = relatorioService.gerarRelatorio(dados, new HashMap(), "Rel_usuario", "Rel_usuario", 
					context);
			
			//CONSTRUIR O CAMINHO COMPLETO E ABSOLUTO DO RELATORIO
			
			File downloadFile = new File(fileUrl);
			FileInputStream inputStream = new FileInputStream(downloadFile);
			//Obter o tipo MIME do arquivo
			String mimeType = context.getMimeType(fileUrl);
			
			if(mimeType == null) {
				//define como tipo binário se o mapeamento mime nao for encontrado
				
				mimeType = "application/octet-stream";
				
			}
			
			response.setContentType(mimeType);
			response.setContentLength((int) downloadFile.length());
			
			//definir cabeçalhos para resposta
			
			String headerKey = "content-disposition";
			String headerValue = String.format("attachment; filename =\"%s\"", downloadFile.getName());
			
			
			response.setHeader(headerKey, headerValue);
			
			//Obter um fluxo de saída da resposta
			
			OutputStream stream = response.getOutputStream();
			
			byte[] buffer = new byte[4096];
			int bytesReadar = -1;
			
			//Escrever bytes lindos a partir do fluxo de entrada para o fluxo de saida
			
			while((bytesReadar  = inputStream.read(buffer)) != -1) {
				stream.write(buffer, 0, bytesReadar);
				
			}
			
			inputStream.close();
			stream.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
