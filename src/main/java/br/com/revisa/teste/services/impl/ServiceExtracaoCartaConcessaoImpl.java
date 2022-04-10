/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.revisa.teste.services.impl;

import br.com.revisa.teste.services.ServiceExtracaoCartaConcessao;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.rendering.PDFRenderer;

/**
 *
 * @author renan
 */


public class ServiceExtracaoCartaConcessaoImpl implements ServiceExtracaoCartaConcessao {

    // objetos do PdfBox para auxiliar
    private PDFParser parser;
    private PDDocument document;
    private PDFTextStripper PDFTextStripper;
    private COSDocument cosDoc;
    private String Text;
    private String filePath;
    private File file;

    private int MediaSalarios;
    private int QuantidadeSalarios;


    public ServiceExtracaoCartaConcessaoImpl() {
    }

    @Override
    public ResultadoExtracaoCartaConcessao onExtrairCartaConcessao(byte[] pdf) throws ServiceExtracaoCartaConcessaoException {

        ResultadoExtracaoCartaConcessao nome = new ResultadoExtracaoCartaConcessao();
        ResultadoExtracaoCartaConcessao dataConcessao = new ResultadoExtracaoCartaConcessao();

        //Carregando variavel:
          this.document = null;;
          this.PDFTextStripper = null;
          this.cosDoc = null;

          file = new File(filePath);
          parser = new PDFParser(new RandomAccessFile(file, "r"));
          parser.parse();
          cosDoc = parser.getDocument();
          pdfStripper = new PDFTextStripper();
          document = new PDDocument(cosDoc);        

        /*
            Aqui vc vai precisar extrair as informações do PDF em String usando a lib PDFBox
            e conseguir manipular ela de alguma forma para extrair o conteudo e preencher e retornar a classe ResultadoExtracaoCartaConcessao. 
         */
        ResultadoExtracaoCartaConcessao retorno = new ResultadoExtracaoCartaConcessao();
        retorno.setDataConcessao(dataConcessao.getDataConcessao());
        retorno.setNome(nome.getNome());
        retorno.setMediaSalarios(BigDecimal.ZERO);
        retorno.setQuantidadeSalarios(0);

        return retorno;

    }

       public void setFilePath(String filePath){
        this.filePath = filePath;
        }

         public PDDocument getPdDoc(){
            return document;
        }

       public static void QuantidadeSalarios(String[] args) {
  
        List<String> list = Arrays.asList("Salário");  
        int total = (int) list.stream().distinct().count();
        System.out.println(total);

        MediaSalarios() = QuantidadeSalarios % total;     
    }
        
    

}


