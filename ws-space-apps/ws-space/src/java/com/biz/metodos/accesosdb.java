/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biz.metodos;

import com.biz.metodos.generales.cls_public;
//import com.biz.objetos.EmpresaServ;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.jtc.Obj_Resp;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import com.biz.objetos.ObjConAnulacionResponse;
//import com.biz.objetos.obj_detalle_principal;
//import com.biz.objetos.obj_principal;
import java.sql.PreparedStatement;
import java.util.Iterator;

/**
 *
 * @author proyecto12
 */
public class accesosdb extends com.jtc.JTC {

    private ResultSet rs = null;
    private final Connection cn = getConection("SSE3ncript1");
    Obj_Resp objJtc = new Obj_Resp();
    cls_public pl = new cls_public();
//    ObjConAnulacionResponse objConResponse = new ObjConAnulacionResponse();
//    EmpresaServ empserv = new EmpresaServ();

    public List consultaAnulacion(String i_mo_fch_movimiento, int i_mo_ordenante, int i_mo_producto,
            String i_mo_serviciovariable, String i_mo_oficina_pagcob, int i_mo_unico_movimiento,
            int i_mo_orden_empresa_ori, String i_estacion, String i_estacion_caja, int row_in, int row_out) throws SQLException {

        String w_fch_proceso = pl.formatfecha(FechaProceso());

        List lista = new ArrayList();
        String sqlConsultaAnula = "SELECT\n";
        sqlConsultaAnula += "ROWNUMBER AS columna, mo_unico_movimiento as movimiento, mo_oficina_pagcob as oficina,\n";
        sqlConsultaAnula += "nom_oficina as nombre_ofic, mo_orden_empresa,mo_orden_banco,mo_secuencial,\n";
        sqlConsultaAnula += "mo_fch_movimiento, mo_frm_pagcob, mo_canal_pagcob, mo_tipo_cta,mo_numero_cuenta,\n";
        sqlConsultaAnula += "beneficiario, mo_nombre_beneficiario,mo_tipo_pagcob,mo_num_transaccion,mo_num_causal,mo_tipo_afectacion,\n";
        sqlConsultaAnula += "mo_id_afeccta, mo_sib_moneda, mo_valor_movimiento, mo_est_proceso, mo_cod_error, mo_valor_comision,\n";
        sqlConsultaAnula += "mo_usuario_mov, desc_est, mo_nem_ordenante, mo_nombre_cuenta,mo_nut, mo_cod_tercero_empresa, mo_fch_anulacion, mo_estacion_act\n";
        sqlConsultaAnula += "FROM\n";
        sqlConsultaAnula += "(SELECT ROW_NUMBER() OVER (ORDER BY mo_nut) ROWNUMBER,\n";
        sqlConsultaAnula += "mo_unico_movimiento,  mo_oficina_pagcob,\n";
        sqlConsultaAnula += "( SELECT ct_nom_catalogo FROM db_biz_administracion..ad_tabla, db_biz_administracion..ad_catalogo\n";
        sqlConsultaAnula += "WHERE tb_nom_tabla = 'bza_localidad'\n";
        sqlConsultaAnula += "AND tb_cod_tabla = ct_cod_tabla\n";
        sqlConsultaAnula += "AND ct_cod_catalogo = mo_oficina_pagcob\n";
        sqlConsultaAnula += ") AS nom_oficina,\n";
        sqlConsultaAnula += "mo_orden_empresa,mo_orden_banco,mo_secuencial,mo_fch_movimiento\n";
        sqlConsultaAnula += "mo_fch_movimiento, mo_frm_pagcob, mo_canal_pagcob, mo_tipo_cta,\n";
        sqlConsultaAnula += "mo_numero_cuenta, (mo_tipo_nuc_beneficiario + mo_nuc_beneficiario) as  beneficiario,\n";
        sqlConsultaAnula += "mo_nombre_beneficiario as mo_nombre_beneficiario,mo_tipo_pagcob,mo_num_transaccion,\n";
        sqlConsultaAnula += "mo_num_causal,mo_tipo_afectacion, mo_id_afeccta as mo_id_afeccta, mo_moneda_movimiento as mo_sib_moneda,\n";
        sqlConsultaAnula += "mo_valor_movimiento, mo_est_proceso, mo_cod_error, mo_valor_comision, mo_usuario_mov as mo_usuario_mov,\n";
        sqlConsultaAnula += "CASE mo_est_proceso WHEN 'P' THEN 'Procesado' WHEN 'R' THEN 'Reversado' WHEN 'X' THEN 'Error'END as desc_est,\n";
        sqlConsultaAnula += "mo_nem_ordenante, mo_nombre_cuenta,mo_nut, mo_cod_tercero_empresa, mo_fch_anulacion as mo_fch_anulacion, mo_estacion_act\n";
        sqlConsultaAnula += "FROM db_biz_pagos..bp_movimiento\n";
        sqlConsultaAnula += "WHERE mo_fch_movimiento >= ? \n";
        sqlConsultaAnula += "and   mo_fch_movimiento <= '" + w_fch_proceso + "'\n";

        sqlConsultaAnula += "and (mo_ordenante = ?  or  ? = 0)\n";
        sqlConsultaAnula += "and   mo_producto = ? \n";
        sqlConsultaAnula += "and   mo_est_proceso = 'P'\n";

        sqlConsultaAnula += "and  (mo_servicio	 = ? or  ? = 'T' )\n";
        sqlConsultaAnula += "and   mo_oficina_pagcob = ? \n";
       
        sqlConsultaAnula += "and   mo_canal_pagcob = 'BCA'\n";
        sqlConsultaAnula += "and (( ? = 0 and mo_nut > ?)\n";
        sqlConsultaAnula += " or ( ?  > 0 and mo_nut = ?)\n";
        sqlConsultaAnula += " or ( ? = 0 and mo_nut > ?)\n) ";
        sqlConsultaAnula += "and (mo_usuario_mov  = ?  or  ? ='T')\n";
        sqlConsultaAnula += "and (mo_estacion_act = ?  or  ? = 'T'\n";
        sqlConsultaAnula += ")\n";
        sqlConsultaAnula += ") AS TABLEWITHRPWNUMBER\n";
        sqlConsultaAnula += "WHERE\n";
        sqlConsultaAnula += "ROWNUMBER BETWEEN ? AND ?\n";

        
            PreparedStatement ps = cn.prepareStatement(sqlConsultaAnula);
            ps.setString(1, pl.formatfecha(i_mo_fch_movimiento));
            ps.setInt(2, i_mo_ordenante);
            ps.setInt(3, i_mo_ordenante);
            ps.setInt(4, i_mo_producto);
            ps.setString(5, i_mo_serviciovariable.trim());
            ps.setString(6, i_mo_serviciovariable.trim());
            ps.setString(7, i_mo_oficina_pagcob);
            ps.setInt(8, i_mo_unico_movimiento);
            ps.setInt(9, i_mo_unico_movimiento);
            ps.setInt(10, i_mo_unico_movimiento);
            ps.setInt(11, i_mo_unico_movimiento);
            ps.setInt(12, i_mo_orden_empresa_ori);
            ps.setInt(13, i_mo_unico_movimiento);
            ps.setString(14, i_estacion.trim());
            ps.setString(15, i_estacion.trim());
            ps.setString(16, i_estacion_caja.trim());
            ps.setString(17, i_estacion_caja.trim());
            ps.setInt(18, row_in);
            ps.setInt(19, row_out);
                    
            rs = ps.executeQuery();
            if (rs != null) {
                try {
                    while (rs.next()) {
//                        objConResponse = new ObjConAnulacionResponse(
//                                rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
//                                rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9),
//                                rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
//                                rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
//                                rs.getString(18), rs.getInt(19), rs.getString(20), rs.getString(21), rs.getString(22),
//                                rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27),
//                                rs.getString(28), rs.getString(29), rs.getString(30), rs.getString(31), rs.getString(32));
//                        lista.add(objConResponse);

                    }
                } catch (SQLException ex) {
                    cn.close();
                    Logger.getLogger(accesosdb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        cn.close();
        return lista;
    }

    public List CuadVentDetalles(String i_oficina, int i_producto, String i_estacion, String i_servicio,
            String i_forma_pago, String i_cajera) throws SQLException {
        List listaDetalle = new ArrayList();
        String sqlCuadreCajaVentD = "select mo_servicio, mo_usuario_mov, mo_frm_pagcob, count(*) cant_reg, sum(total) total \n";
        sqlCuadreCajaVentD += "from(\n";
        sqlCuadreCajaVentD += "select b.ct_nom_catalogo,mo_estacion_act as mo_usuario_mov,mov.mo_tipo_proceso,mov.mo_producto as mo_producto,sv.ps_nom_servicio as mo_servicio, c.ct_cod_catalogo  as mo_frm_pagcob,\n";
        sqlCuadreCajaVentD += "CASE mov.mo_est_proceso WHEN 'P' THEN 'Procesado' WHEN 'R' THEN 'Reversado' WHEN 'X' THEN 'Error' END as desc_est,\n";
        sqlCuadreCajaVentD += "mov.mo_moneda_movimiento, FP.FP_VALOR as total\n";
        sqlCuadreCajaVentD += "from db_biz_pagos..bp_movimiento mov, db_biz_pagos..bp_forma_pagcob fp,\n";
        sqlCuadreCajaVentD += "db_biz_administracion..ad_tabla t ,db_biz_administracion..ad_catalogo b,\n";
        sqlCuadreCajaVentD += "db_biz_administracion..ad_tabla tf, db_biz_administracion..ad_catalogo c,\n";
        sqlCuadreCajaVentD += "db_biz_administracion..ad_servicio sv\n";
        sqlCuadreCajaVentD += "WHERE  mov.MO_FCH_MOVIMIENTO = '" + pl.OptenerFechaSistema("dd/MM/yyyy") + "'\n";
        sqlCuadreCajaVentD += "and mov.mo_oficina_pagcob = ? \n";
        sqlCuadreCajaVentD += " and mov.mo_producto = ? \n";
        sqlCuadreCajaVentD += "and ( mov.mo_estacion_act = ? or ? = 'T' )\n";
        sqlCuadreCajaVentD += "and ( sv.ps_cod_servicio = ? or ? = 'T' )\n";
        sqlCuadreCajaVentD += "and mov.mo_tipo_afectacion = 2\n";
        sqlCuadreCajaVentD += "and mov.mo_canal_pagcob ='BCA'\n";
        sqlCuadreCajaVentD += "and fp.fp_unico_movimiento = mov.mo_unico_movimiento\n";
        sqlCuadreCajaVentD += "and t.tb_nom_tabla = 'bza_localidad'\n";
        sqlCuadreCajaVentD += "and t.tb_cod_tabla = b.ct_cod_tabla\n";
        sqlCuadreCajaVentD += "and b.ct_cod_catalogo = mov.mo_oficina_pagcob\n";
        sqlCuadreCajaVentD += "and b.ct_est_catalogo = 'A'\n";
        sqlCuadreCajaVentD += "and fp.fp_frm_pagcob =+ c.ct_cod_catalogo\n";
        sqlCuadreCajaVentD += "and tf.tb_nom_tabla = 'ad_forma_pago_for'\n";
        sqlCuadreCajaVentD += "and tf.tb_cod_tabla = c.ct_cod_tabla\n";
        sqlCuadreCajaVentD += "and sv.ps_cod_producto =  mov.mo_producto\n";
        sqlCuadreCajaVentD += "and sv.ps_cod_servicio = mov.mo_servicio\n";
        sqlCuadreCajaVentD += "and mov.mo_est_proceso = 'P'\n";
        sqlCuadreCajaVentD += ")t group by mo_usuario_mov, mo_servicio, mo_frm_pagcob\n";
        sqlCuadreCajaVentD += "UNION\n";
        
        sqlCuadreCajaVentD += "select * from(";
        sqlCuadreCajaVentD += "select '' as mo_servicio, '' as mo_usuario_mov, 'Totales' as mo_frm_pagcob, count(*) cant_reg, sum(total) total\n";
        sqlCuadreCajaVentD += "from(";
        
        sqlCuadreCajaVentD += "select b.ct_nom_catalogo,mo_estacion_act as mo_usuario_mov, mov.mo_tipo_proceso,mov.mo_producto as mo_producto,sv.ps_nom_servicio as mo_servicio, c.ct_nom_catalogo  as mo_frm_pagcob,\n";
        sqlCuadreCajaVentD += "CASE mov.mo_est_proceso WHEN 'P' THEN 'Procesado' WHEN 'R' THEN 'Reversado' WHEN 'X' THEN 'Error' END as desc_est,";           
        sqlCuadreCajaVentD += "mov.mo_moneda_movimiento,FP.FP_VALOR as total\n";
        sqlCuadreCajaVentD += "from db_biz_pagos..bp_movimiento mov, db_biz_pagos..bp_forma_pagcob fp,\n";
        sqlCuadreCajaVentD += "db_biz_administracion..ad_tabla t,db_biz_administracion..ad_catalogo b,\n";
        sqlCuadreCajaVentD += "db_biz_administracion..ad_tabla tf, db_biz_administracion..ad_catalogo c,\n";
        sqlCuadreCajaVentD += "db_biz_administracion..ad_servicio sv\n";
        sqlCuadreCajaVentD += "WHERE mov.MO_FCH_MOVIMIENTO = '" + pl.OptenerFechaSistema("dd/MM/yyyy") + "'\n";
        sqlCuadreCajaVentD += "AND mov.mo_oficina_pagcob = ? \n";
        sqlCuadreCajaVentD += "and mov.mo_producto = ? \n";
        sqlCuadreCajaVentD += "and ( mov.mo_estacion_act = ? or ? = 'T' )\n";
        sqlCuadreCajaVentD += "and ( sv.ps_cod_servicio = ? or ? = 'T' )\n";
        sqlCuadreCajaVentD += "and mov.mo_tipo_afectacion = 2\n";
        sqlCuadreCajaVentD += "and mov.mo_canal_pagcob ='BCA'\n";
        sqlCuadreCajaVentD += "and fp.fp_unico_movimiento = mov.mo_unico_movimiento\n";
        sqlCuadreCajaVentD += "and t.tb_nom_tabla = 'bza_localidad'\n";
        sqlCuadreCajaVentD += "and t.tb_cod_tabla = b.ct_cod_tabla\n";
        sqlCuadreCajaVentD += "and b.ct_cod_catalogo = mov.mo_oficina_pagcob\n";
        sqlCuadreCajaVentD += "and b.ct_est_catalogo = 'A'\n";
        sqlCuadreCajaVentD += "and fp.fp_frm_pagcob =+ c.ct_cod_catalogo\n";
        sqlCuadreCajaVentD += "and tf.tb_nom_tabla = 'ad_forma_pago_for'\n";
        sqlCuadreCajaVentD += "and tf.tb_cod_tabla = c.ct_cod_tabla\n";
        sqlCuadreCajaVentD += "and sv.ps_cod_producto =  mov.mo_producto\n";
        sqlCuadreCajaVentD += "and sv.ps_cod_servicio = mov.mo_servicio\n";
        sqlCuadreCajaVentD += "and mov.mo_est_proceso = 'P'\n";
        sqlCuadreCajaVentD += ")t)t1 where cant_reg > 0;\n";

              PreparedStatement ps = cn.prepareStatement(sqlCuadreCajaVentD);
              ps.setString(1, i_oficina);
              ps.setInt(2, i_producto);
              ps.setString(3, i_estacion);
              ps.setString(4, i_cajera);
              ps.setString(5, i_servicio);
              ps.setString(6, i_servicio);
              ps.setString(7, i_oficina);
              ps.setInt(8, i_producto);
              ps.setString(9, i_estacion);
              ps.setString(10, i_cajera);
              ps.setString(11, i_servicio);
              ps.setString(12, i_servicio);
              
              rs = ps.executeQuery();

            if (rs != null) {
                try {
                    while (rs.next()) {
//                        objConResponse =  new ObjConAnulacionResponse(rs.getInt(4), rs.getString(3),rs.getString(2), rs.getString(1), rs.getString(5));
//                        
//                        listaDetalle.add(objConResponse);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(accesosdb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return listaDetalle;
    }
    
        public List  Con_servFormaPago(String producto) {
        String resp = "", sql = "";
        sql = "exec sp_con_parametros_servicio " + producto + "";
        int aux = 1;
        List datos = new ArrayList();
        try {
        rs = execComand(cn, sql);
            
            if (rs != null) {
                while (rs.next()) {
//                    empserv = new EmpresaServ(rs.getInt("fr_empresa"), rs.getString("em_nom_empresa"), rs.getInt("Pa_Cod_Producto"), 
//                            rs.getString("pa_cod_servicio"), rs.getString("ps_nom_servicio"), rs.getString("forma_pago"),
//                            rs.getInt("fr_cod_tramite"), rs.getString("fr_nom_formulario"), rs.getString("fr_tip_formulario"), 
//                            rs.getString("fr_multi_seleccion"), rs.getInt("fr_num_registro"), rs.getString("fr_nom_sp_con"), 
//                            rs.getString("fr_base_datos"), rs.getString("fr_canal"),rs.getString("nemonico"), rs.getString("nombre"), 
//                            rs.getString("tipDato"), rs.getInt("longCampo"),rs.getString("dimAncho"), rs.getString("alineacion"), 
//                            rs.getString("estReq"), rs.getString("visible"), rs.getString("editable"),  rs.getString("grabable"), 
//                            rs.getString("sumatoria"), rs.getString("pagineo"), rs.getString("valOmision"),  rs.getString("tipControl"), 
//                            rs.getString("tooltip"), rs.getString("imprimible"), rs.getString("frmayuda"), rs.getString("funcEjec")                            
//                    );
//                    datos.add(empserv);
                }
            } else {
                resp = "error" ;
            }
        } catch (SQLException ex) {
            resp = ex.getMessage();
        }
        return datos;
    }
       
        
    public List recorreJson(List lista) {
        
        
        boolean inc = false;
//
//        obj_detalle_principal objdet = new obj_detalle_principal();
//        obj_principal objpri = new obj_principal();
//        EmpresaServ emp = null;
//
        List listaDetalles = new ArrayList();
        List listacompleta = new ArrayList();
//        Iterator iter = lista.iterator();
//            for (int i = 0; i < lista.size(); i++) {
//                emp =  (EmpresaServ) lista.get(i);
//
//                if (objpri.getEmpresa() != 0) {
//                    if ((objpri.getEmpresa() == emp.getEmpresa()) && (objpri.getProducto() == emp.getProducto())
//                            && (objpri.getServicio().equals(emp.getServicio()))) {
//
//                        objdet = new obj_detalle_principal(emp.getNombre(), emp.getNemonico(), emp.getTp_dato(),
//                                emp.getLong_campo(), emp.getAncho(), emp.getAlineacion(),
//                                emp.getEstReq(), emp.getVisible(), emp.getEditable(),
//                                emp.getEditable(), emp.getSumatoria(), emp.getPagineo(),
//                                emp.getValOmision(), emp.getTpcontrol(), emp.getTooltip(),
//                                emp.getImprimible(), emp.getFrmayuda());
//
//                        listaDetalles.add(objdet);
//
//                    } else {
//                        listacompleta.add(objpri);
//                        objpri = new obj_principal();
//                        objdet = new obj_detalle_principal();
//                        listaDetalles = new ArrayList();
//                        inc = true;
//                        i--;
//
//                    }
//                } else {
//                    objdet = new obj_detalle_principal(emp.getNombre(), emp.getNemonico(), emp.getTp_dato(),
//                                emp.getLong_campo(), emp.getAncho(), emp.getAlineacion(),
//                                emp.getEstReq(), emp.getVisible(), emp.getEditable(),
//                                emp.getEditable(), emp.getSumatoria(), emp.getPagineo(),
//                                emp.getValOmision(), emp.getTpcontrol(), emp.getTooltip(),
//                                emp.getImprimible(), emp.getFrmayuda());
//
//                    listaDetalles.add(objdet);
//                    objpri = new obj_principal(emp.getEmpresa(), emp.getProducto(), emp.getServicio(),
//                            emp.getCod_tramite(), emp.getNom_empresa(), emp.getCanal(),
//                            emp.getBase_datos(), emp.getFunejec(), emp.getNombre_formulario(),
//                            emp.getForma_pago(), emp.getTp_formulario(), emp.getNum_registros(),
//                            emp.getNom_sp(), emp.getNom_servicio(), emp.getMulti_seleccion(),
//                            listaDetalles);
//                    
//                    inc = false;
//                }
//
//            }
//            
//            if(!inc){
//                listacompleta.add(objpri);
//            }

        return listacompleta;
    }
        

    public String FechaProceso() {
        String sqlConsulFechPro = "SELECT fe_fch_contable  FROM   db_biz_administracion..ad_fechas WHERE  fe_localidad = '107';";
        String fecha = "";
        try {
            objJtc = execComandSql(cn, sqlConsulFechPro);
            rs = objJtc.getRespSet();
            if (rs != null) {
                try {
                    while (rs.next()) {
                        fecha = rs.getString(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(accesosdb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(accesosdb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fecha;
    }
    
    public boolean autentication(String user, String password){
        
        boolean resp = false;
        
        
        return resp = true;
        
    }
}
