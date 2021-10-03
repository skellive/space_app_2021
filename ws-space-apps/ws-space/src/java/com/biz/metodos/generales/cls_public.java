/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biz.metodos.generales;

import com.biz.metodos.accesosdb;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author proyecto12
 */
public class cls_public {

    //@Inject
    //SimpleKeyGenerator keys = new SimpleKeyGenerator();
//    public void GeneraXlsx(String lista, String ruta, String usuario, String idempresa, String establecimiento, String tipo_documento) throws FileNotFoundException, IOException {
//
//        JsonArray responset = ConverArrayJson(lista);
//        
//        metodos_local mlo = new metodos_local();
//        
//        int cantiregistros =  responset.size();
//        //obtenemos nombre del archivo
//        File archivodown = new File(ruta);
//        String fileName = archivodown.getName().replace(".xlsx", "").trim();
//        
//        
//        /// La hoja donde pondremos los datos
//        try (Workbook workbook = new XSSFWorkbook()) {
//            //Workbook workbook = new XSSFWorkbook();
//            /// La hoja donde pondremos los datos
//            Sheet pagina = workbook.createSheet("Establecimiento " + establecimiento);
//            // Creamos el estilo paga las celdas del encabezado
//            CellStyle style = workbook.createCellStyle();
//            CellStyle stylebody = workbook.createCellStyle();
//            CellStyle styletitle = workbook.createCellStyle();
//            //Map<String, CellStyle> styles = createStyles(wb);
//            //title row
//            Row titleRow = pagina.createRow(0);
//            titleRow.setHeightInPoints(40);
//            Cell titleCell = titleRow.createCell(0);
//            titleCell.setCellValue("Reporte de Autorizados");
//            pagina.setHorizontallyCenter(true);
//            titleCell.setCellStyle(styletitle);
//            //creamos estilo para los fuentes del titulo
//            XSSFFont font = (XSSFFont) workbook.createFont();
//            font.setFontHeightInPoints((short) 20);
//            font.setFontName("IMPACT");
//            font.setItalic(false);
//            font.setColor(HSSFColor.BLACK.index);
//            //creamos estilo para los fuentes para la cabecera
//            XSSFFont fontcabecera = (XSSFFont) workbook.createFont();
//            fontcabecera.setFontHeightInPoints((short) 10);
//            fontcabecera.setFontName("IMPACT");
//            fontcabecera.setItalic(false);
//            fontcabecera.setColor(HSSFColor.WHITE.index);
//            // Indicamos que tendra un fondo azul aqua
//            // con patron solido del color indicado
//            style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
//            style.setFont(fontcabecera);
//            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//            styletitle.setAlignment(HorizontalAlignment.CENTER);
//            styletitle.setFont(font);
//            stylebody.setShrinkToFit(true);
//            List titulos = new ArrayList();
//            //if(estado.trim().equals("=")){
//            pagina.addMergedRegion(CellRangeAddress.valueOf("$A$1:$M$1"));
//            titulos.add("Fecha Emisión");
//            titulos.add("Referencia");
//            titulos.add("Tipo Documento");
//            titulos.add("Clave Acceso / Autorización");
//            titulos.add("Fecha Autorización");
//            titulos.add("Nº Documento");
//            titulos.add("Correo");
//            titulos.add("Identificación");
//            titulos.add("Contribuyente");
//            titulos.add("Sub Total");
//            titulos.add("Total Descuento");
//            titulos.add("Importe Total");
//            titulos.add("Estado");
//            // Creamos una fila en la hoja en la posicion 0
//            Row fila = pagina.createRow(1);
//            fila.setHeightInPoints(20);
//            // Creamos el encabezado
//            for (int i = 0; i < titulos.size(); i++) {
//                // Creamos una celda en esa fila, en la posicion
//                // indicada por el contador del ciclo
//                Cell celda = fila.createCell(i);
//                
//                // Indicamos el estilo que deseamos
//                // usar en la celda, en este caso el unico
//                // que hemos creado
//                celda.setCellStyle(style);
//                celda.setCellValue(titulos.get(i).toString());
//            }   // Ahora creamos una fila en la posicion 1
//            int count = 2;
//            int temporcenta = 0;
//            // Y colocamos los datos en esa fila
//            JsonObject objson = null;
//            Iterator iter = responset.iterator();
//            while (iter.hasNext()) {
//                
//                fila = pagina.createRow(count);
//                //colunmnas ajustables
//                pagina.autoSizeColumn(0, true);
//                pagina.autoSizeColumn(1, true);
//                pagina.autoSizeColumn(2, true);
//                pagina.autoSizeColumn(3, true);
//                pagina.autoSizeColumn(4, true);
//                pagina.autoSizeColumn(5, true);
//                pagina.autoSizeColumn(6, true);
//                pagina.autoSizeColumn(7, true);
//                pagina.autoSizeColumn(8, true);
//                pagina.autoSizeColumn(9, true);
//                pagina.autoSizeColumn(10, true);
//                pagina.autoSizeColumn(11, true);
//                pagina.autoSizeColumn(12, true);
//                
//                objson = (JsonObject) iter.next();
//                
//                // Creamos una celda en esa fila, en la
//                // posicion indicada por el contador del ciclo
//                Cell celda = fila.createCell(0);
//                celda.setCellStyle(stylebody);
//                celda.setCellValue(objson.getString("fechaEmision"));
//                
//                Cell celda2 = fila.createCell(1);
//                celda2.setCellStyle(stylebody);
//                celda2.setCellValue(objson.getString("co_cci_referencia"));
//                
//                Cell celda3 = null;
//                switch (tipo_documento) {
//                    case "01":
//                        celda3 = fila.createCell(2);
//                        celda3.setCellStyle(stylebody);
//                        celda3.setCellValue("FACTURA");
//                        break;
//                    case "07":
//                        celda3 = fila.createCell(2);
//                        celda3.setCellStyle(stylebody);
//                        celda3.setCellValue("RETENCION");
//                        break;
//                    case "04":
//                        celda3 = fila.createCell(2);
//                        celda3.setCellStyle(stylebody);
//                        celda3.setCellValue("NOTA CREDITO");
//                        break;
//                    case "05":
//                        celda3 = fila.createCell(2);
//                        celda3.setCellStyle(stylebody);
//                        celda3.setCellValue("NOTA DEBITO");
//                        break;
//                    case "06":
//                        celda3 = fila.createCell(2);
//                        celda3.setCellStyle(stylebody);
//                        celda3.setCellValue("GUIA REMISION");
//                        break;
//                    default:
//                        break;
//                }
//                
//                Cell celda4= fila.createCell(3);
//                celda4.setCellStyle(stylebody);
//                celda4.setCellValue(objson.getString("claveacceso"));
//                
//                Cell celda5= fila.createCell(4);
//                celda5.setCellStyle(stylebody);
//                celda5.setCellValue(objson.getString("dfm_proceso"));
//                
//                Cell celda6= fila.createCell(5);
//                celda6.setCellStyle(stylebody);
//                celda6.setCellValue(objson.getString("numero"));
//                
//                Cell celda7= fila.createCell(6);
//                celda7.setCellStyle(stylebody);
//                celda7.setCellValue(objson.getString("co_cdi_env_aut"));
//                
//                Cell celda8= fila.createCell(7);
//                celda8.setCellStyle(stylebody);
//                celda8.setCellValue(objson.getString("cci_contri"));
//                
//                Cell celda9= fila.createCell(8);
//                celda9.setCellStyle(stylebody);
//                celda9.setCellValue(objson.getString("cno_contri_ori"));
//                
//                Cell celda10= fila.createCell(9);
//                celda10.setCellStyle(stylebody);
//                celda10.setCellValue(objson.getString("co_subtotal"));
//                
//                Cell celda11= fila.createCell(10);
//                celda11.setCellStyle(stylebody);
//                celda11.setCellValue(objson.getString("co_totaldescuento"));
//                
//                Cell celda12= fila.createCell(11);
//                celda12.setCellStyle(stylebody);
//                celda12.setCellValue(objson.getString("co_importetotal"));
//                
//                Cell celda13= fila.createCell(12);
//                celda13.setCellStyle(stylebody);
//                celda13.setCellValue("AUTORIZADO");
//                
//                //obtenemos el porcentaje 
//                //porcentaje 100%
//                //cantidad de registros procesados   Ej: Total:235 -> actual 200  formula 200*100/235 = 85%
//                
//                int porcentaje = (count*100)/cantiregistros;
//                //temporcenta =  porcentaje;
//                if(temporcenta != porcentaje){
//                    temporcenta =  porcentaje;
//                    //actualizamos el evento de descarga en la tabla 
//                    mlo.updateEventoDescarga(idempresa, usuario, ruta, fileName, Integer.toString(porcentaje));
//                } 
//                count++;
//            } //fin del while
//            File archivo = new File(ruta);
//            FileOutputStream salida = new FileOutputStream(archivo);
//            // Almacenamos el libro de
//            // Excel via ese
//            // flujo de datos
//            workbook.write(salida);
//            // Cerramos el libro para concluir operaciones
//        }
//
//    }
//
    public JsonArray ConverArrayJson(String data) {
        JsonReader jsonReader = Json.createReader(new StringReader(data));
        JsonArray arrayjson = jsonReader.readArray();
        return arrayjson;
    }

    public String OptenerFechaSistema(String formato) {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(formato);
        dateFormat.format(date);
        return dateFormat.format(date);
    }

    public String formatfecha(String fecha) {
        // el que parsea
        SimpleDateFormat parseador = new SimpleDateFormat("yyyy-MM-dd");
        // el que formatea
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

        Date date = null;
        try {
            date = parseador.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(accesosdb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (formateador.format(date));
    }
     public static String convert(String json, String root) throws JSONException {
         System.out.println("json: "+json);
         JSONArray jsonObject = new JSONArray(json);
        

      String xml = "<"+root+">" + XML.toString(jsonObject) + "</"+root+">";
      return xml;
   }
     
     
    

//    public String issueToken(String login, String urlProceso) {
//        Key key = keys.generateKey();
//        String jwtToken = Jwts.builder()
//                .setSubject(login)
//                .setIssuer(urlProceso)
//                .setIssuedAt(new Date())
//                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
//                .signWith(SignatureAlgorithm.HS256, key)
//                .compact();
//        return jwtToken;
//    }
//    private Date toDate(LocalDateTime localDateTime) {
//        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
//    }

//    public ObjRespuesta  validaToken(String token){
//        
//        ObjRespuesta respuesta = new ObjRespuesta();
//        List listResp = new ArrayList();
//        
//        if (token != null) {
//            try {
//                Key key = keys.generateKey();
//                Jwts.parser().setSigningKey(key).parseClaimsJws(token);
//
//                respuesta = new ObjRespuesta(1, "Autorizacion Exitoza");
//
//            } catch (ExpiredJwtException e) {
//                respuesta = new ObjRespuesta(0, "Token Expirado : " + e.getMessage());
//            } catch (MalformedJwtException | IllegalArgumentException e){
//                 respuesta = new ObjRespuesta(0, "La estructura del token es incorrecta :" + e.getMessage());
//            } catch (SignatureException e){
//                 respuesta = new ObjRespuesta(0, "No se puede afirmar la validez del token :" + e.getMessage());
//            }catch (UnsupportedJwtException e){
//                 respuesta = new ObjRespuesta(0, "Token ingresado sin firma :" + e.getMessage());
//            }        
//        }else{
//            respuesta = new ObjRespuesta(0, "El token es necesario para tranzacionar :" + "El parametro ingreso null");
//        }        
//      return respuesta;
//    }
}
