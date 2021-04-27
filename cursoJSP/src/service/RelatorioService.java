package service;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class RelatorioService  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private static final String FOLDER_RELATORIOS = "/relatorios";
	private static final String SUBREPORT_DIR = "SUBREPORT_DIR";
	private static  String SEPARATOR = File.separator;
	private static  String caminhoArquivoRelatorio = null;
	private JRExporter exporter = null;
	private String caminhoSubReport_Dir = "";
	private File arquivoGerado = null;
	
	
	public String gerarRelatorio(List<?> listaDataBeanColletion, HashMap parametrosRelatorio, 
			String nomeRelatorioJasper, String nomeRelatorioSaida, ServletContext servletContext) throws Exception {
		
		//CRIA A LISTA DE COLLECTIONSDATASOURCE QUE CARREGAM OS DADOS PARA O RELATORIO
		JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(listaDataBeanColletion);
		
		
		//FOrnece o caminho fisico até a pasta que contem os relatorios .jasper
		String caminhoRelatorio = servletContext.getRealPath(FOLDER_RELATORIOS);
		
		File file = new File(caminhoRelatorio +  SEPARATOR  + nomeRelatorioJasper + ".jasper");
		
			if(caminhoRelatorio == null || (caminhoRelatorio != null && caminhoRelatorio.isEmpty()) || !file.exists()) {
				
				caminhoRelatorio = this.getClass().getResource(FOLDER_RELATORIOS).getPath();
				SEPARATOR  = "";
				
			}
			
			//caminho para as imagens
			
			parametrosRelatorio.put("REPORT_PARAMETERS_IMG", caminhoRelatorio);
			
			//caminho completo até o relatório compilado indicado
			
			String caminhoArquivosJasper = caminhoRelatorio +  SEPARATOR  + nomeRelatorioJasper + ".jasper";
			
			
			//FAZ o carregamento do relatorio 
			
			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(caminhoArquivosJasper);
			
			//PARAMENTROS SUBREPORT_DIR COM O CAMINHO FISICO PARA SUBREPORT
			
			caminhoSubReport_Dir = caminhoRelatorio + SEPARATOR;
			parametrosRelatorio.put(SUBREPORT_DIR, caminhoSubReport_Dir);
			
			
			//CARREGA O ARQUIVO
			
			JasperPrint print = JasperFillManager.fillReport(report, parametrosRelatorio, jrbcds);
			
			JRPdfExporter exporter = new JRPdfExporter();
			
			caminhoArquivoRelatorio =  caminhoRelatorio + SEPARATOR + nomeRelatorioSaida + ".pdf";
			
			
			
			//CRIAR NOVO ARQUIVO EXPORTADO
			
			arquivoGerado = new File(caminhoArquivoRelatorio);
			
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print );

			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, arquivoGerado);
			
			//EXECUTA A EXPORTACAO 
			
			exporter.exportReport();
			
			//REMOVE O ARQUIVO DO SERVIDOR APOS SER FEITO O DOWNLOAD
			
			arquivoGerado.deleteOnExit();
			
			
			
			
			
		return caminhoArquivoRelatorio;
	}


	
}
