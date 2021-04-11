package servelts;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import beans.BeanCursoJsp;
import dao.DaoUsuario;

@WebServlet("/salvarUsuario")
@MultipartConfig
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DaoUsuario daoUsuario = new DaoUsuario();

	public Usuario() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String acao = request.getParameter("acao");
			String user = request.getParameter("user");

			if ( acao != null && acao.equalsIgnoreCase("delete") && user != null) {
				daoUsuario.deletar(user);

				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			} else if (acao != null && acao.equalsIgnoreCase("editar")) {

				BeanCursoJsp beanCursoJsp = daoUsuario.consultar(user);

				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("user", beanCursoJsp);
				view.forward(request, response);

			} else if (acao != null && acao.equalsIgnoreCase("listartodos")) {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			}else if(acao != null && acao.equalsIgnoreCase("voltarlogin")) {
				RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
				
				view.forward(request, response);
			}else if( acao != null && acao.equalsIgnoreCase("download")) {
				BeanCursoJsp usuario = daoUsuario.consultar(user);
				if(user != null) {
					String contentType = "";
					byte[] fileBytes = null;
					
					String tipo = request.getParameter("tipo");
					
					if(tipo.equalsIgnoreCase("imagem")) {
						contentType = usuario.getContentType();
						
						
						//converte a base64 da imagem do banco para byte[]
						 fileBytes = new Base64().decodeBase64(usuario.getFotoBase64());
					}else if(tipo.equalsIgnoreCase("curriculo")) {
						contentType = usuario.getContentTypeCurriculo();
						
						fileBytes = new Base64().decodeBase64(usuario.getCurriculoBase64());
					}
					
					
					response.setHeader("content-disposition", "attachment;filename=arquivo." + contentType.split("\\/")[1]);
				
					
					
					
					
					
					//coloca os bytes em um objeto de entrada para processar
					InputStream is = new ByteArrayInputStream(fileBytes);
					
					//início da resposta para o navegador
					
					int read = 0;
					
					byte[] bytes = new byte[1024];
					OutputStream os = response.getOutputStream();
					
					while((read = is.read(bytes)) != -1) {
						os.write(bytes, 0, read);
					}
					
					os.flush();os.close();
					
				}
				
			}else  {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao != null && acao.equalsIgnoreCase("reset")) {
			try {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			String id = request.getParameter("id");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			
			String cep = request.getParameter("cep");
			String rua = request.getParameter("rua");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String ibge = request.getParameter("ibge");
			String sexo = request.getParameter("sexo");
			String perfil = request.getParameter("perfil");
		
			
			
			BeanCursoJsp usuario = new BeanCursoJsp();
			usuario.setLogin(login);
			usuario.setSenha(senha);
			usuario.setNome(nome);
			usuario.setTelefone(telefone);
			usuario.setId(!id.isEmpty() ? Long.parseLong(id) : null);
			usuario.setCep(cep);
			usuario.setRua(rua);
			usuario.setBairro(bairro);
			usuario.setCidade(cidade);
			usuario.setEstado(estado);
			usuario.setIbge(ibge);
			usuario.setSexo(sexo);
			usuario.setPerfil(perfil);
			
			if(request.getParameter("ativo") != null && request.getParameter("ativo").equalsIgnoreCase("on")) {
				usuario.setAtivo(true);
			}else {
				usuario.setAtivo(false);
			}
			
			try {
				
				/* File upload de imagens e PDFs */
				
				if(ServletFileUpload.isMultipartContent(request)) {
					
					Part imagemFoto = request.getPart("foto");
					
					
						if( imagemFoto != null && imagemFoto.getInputStream().available() > 0) {
							
							
							
						String fotoBase64 = new Base64()
								.encodeBase64String(converteStreamParaByte(imagemFoto.getInputStream()));
						
						usuario.setFotoBase64(fotoBase64);
						usuario.setContentType(imagemFoto.getContentType());
						
						//Início da miniatura da Imagem
						
						//Transforma emum em BufferedImage
						
						byte[] imageByteDecode = new Base64().decodeBase64(fotoBase64);
						
						BufferedImage bufferImage = ImageIO.read(new ByteArrayInputStream(imageByteDecode)); 
						
						
						//Pega o tipo da imagem
						
						int type = bufferImage.getType() == 0 ? bufferImage.TYPE_INT_ARGB : bufferImage.getType();
						
						
						//Cria miniatura da imagem
						
						BufferedImage  resizedImage  = new BufferedImage(100, 100, type);
						Graphics2D g = resizedImage.createGraphics();
						g.drawImage(bufferImage, 0, 0,100,100,null);
						g.dispose();
						//Escrever imagem novamente
						
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						ImageIO.write(resizedImage, "png", baos);
						
						
						String miniaturaBase64 = "data:image/png;base64," + DatatypeConverter.printBase64Binary(baos.toByteArray()); 
						
						usuario.setFotoBase64Miniatura(miniaturaBase64);
						//Fim miniatura imagem
						
						}else {
							
							usuario.setAtualizarImage(false);
						}
					
					
					// PROCESSAR PDF
					Part curriculoPDF = request.getPart("curriculo");
					
					
						if(curriculoPDF != null && curriculoPDF.getInputStream().available() > 0) {
						String curriculoBase64 = new Base64()
								.encodeBase64String(converteStreamParaByte(curriculoPDF.getInputStream()));
						
						usuario.setCurriculoBase64(curriculoBase64);
						usuario.setContentTypeCurriculo(curriculoPDF.getContentType());
						}else {
							
							usuario.setAtualizarPdf(false);
						}
					
				}
				
				
				/* Fim File upload de imagens e PDFs */
				
				boolean podeInserir = true;
				
				if(sexo == null || sexo.isEmpty()) {
					request.setAttribute("msg", "informe seu sexo!");
					
				}
				
				else if(id == null || id.isEmpty() && daoUsuario.validarLogin(login) && daoUsuario.validarSenha(senha) && podeInserir) {
					 daoUsuario.salvarUsuario(usuario);
					request.setAttribute("msg", "cadastrado com sucesso!");
					
					
				}else if(id == null || id.isEmpty() && !daoUsuario.validarLogin(login)) {
					  podeInserir = false;
					request.setAttribute("msg", "Login ja cadastrado no sistema!!");
				  }

			
					
				else  if(id == null && id.isEmpty() || !daoUsuario.validarSenha(senha)) {
					  podeInserir = false;
					request.setAttribute("msg", "Senha ja cadastrada no sistema!!");
				  }
				
				
				
				if( id != null && !id.isEmpty() && daoUsuario.validarLogin(login) && daoUsuario.validarLoginUpdate(login, id)  ) {
					podeInserir = true;
					request.setAttribute("msg", "Atualizado");
					 daoUsuario.atualizar(usuario);
					 
				}else if(id != null && !id.isEmpty() && !daoUsuario.validarLogin(login) && !daoUsuario.validarLoginUpdate(login, id)  ) { 
					
					podeInserir = false;
					request.setAttribute("msg", "Login ja cadastrado no sistema!!");
				}
				
				
				 if( id != null && !id.isEmpty() &&  daoUsuario.validarSenhaUpdate(senha, id)  ) {
						podeInserir = true;
						request.setAttribute("msg", "Atualizado");
						 daoUsuario.atualizar(usuario);
						 
					}else if(id != null && !id.isEmpty() && !daoUsuario.validarSenhaUpdate(senha, id)  ) { 
						
						podeInserir = false;
						request.setAttribute("msg", "Senha ja cadastrada no sistema!!");
					}
				 
				 

				
				
				
				
				
				if (!podeInserir){
					request.setAttribute("user", usuario);
				}

				RequestDispatcher view = request.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// CONVERTE A ENTRADA DE FLUXOS DE DADOS DA IMAGEM PARA UM ARRAY DE BYTES
		private  byte[] converteStreamParaByte(InputStream imagem) throws Exception {
			
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int reads = imagem.read();
		
		while(reads != -1) {
			baos.write(reads);
			
			reads = imagem.read();
			
		}
		return baos.toByteArray();
		}
}
