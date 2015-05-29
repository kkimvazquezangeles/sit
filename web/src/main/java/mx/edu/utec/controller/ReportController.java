package mx.edu.utec.controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kkimvazquezangeles on 15/04/15.
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    public DataSource dataSource;

    @RequestMapping(value = "/tutor", method = RequestMethod.GET)
    @ResponseBody
    public void getRpt1(
            HttpServletResponse response,
            @RequestParam(value = "periodo") Long idPeriodo,
            @RequestParam(value = "carrera") Long idCarrera) throws JRException, IOException, SQLException {
        InputStream jasperStream = new ClassPathResource("tutor.jasper").getInputStream();
        Map<String,Object> params = new HashMap<>();
        params.put("carreraid", idCarrera);
        params.put("periodoid", idPeriodo);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource.getConnection());

        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=AsignacionDeTutores.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }

    @RequestMapping(value = "/programaGrupal", method = RequestMethod.GET)
    @ResponseBody
    public void getRpt2(
            HttpServletResponse response,
            @RequestParam(value = "periodo") Long idPeriodo,
            @RequestParam(value = "carrera") Long idCarrera,
            @RequestParam(value = "cuatrimestre") Long idCuatrimestre,
            @RequestParam(value = "grupo") Long idGrupo) throws JRException, IOException, SQLException {
        InputStream jasperStream = new ClassPathResource("programaGrupal.jasper").getInputStream();
        Map<String,Object> params = new HashMap<>();
        params.put("carreraid", idCarrera);
        params.put("periodoid", idPeriodo);
        params.put("cuatrimestreid", idCuatrimestre);
        params.put("grupoid", idGrupo);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource.getConnection());

        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=ProgramaGrupalDeTutoria.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }

    @RequestMapping(value = "/bitacoraAlumno", method = RequestMethod.GET)
    @ResponseBody
    public void getRpt3(
            HttpServletResponse response,
            @RequestParam(value = "periodo") Long idPeriodo,
            @RequestParam(value = "matricula") String matricula) throws JRException, IOException, SQLException {
        InputStream jasperStream = new ClassPathResource("bitacoraAlumno.jasper").getInputStream();
        Map<String,Object> params = new HashMap<>();
        params.put("periodoid", idPeriodo);
        params.put("matricula", matricula);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource.getConnection());

        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=BitacoraTutoriaAlumno.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }

    @RequestMapping(value = "/notaInformativa", method = RequestMethod.GET)
    @ResponseBody
    public void getRpt4(
            HttpServletResponse response,
            @RequestParam(value = "periodo") Long idPeriodo,
            @RequestParam(value = "tutoria") Long idTutoria,
            @RequestParam(value = "matricula") String matricula) throws JRException, IOException, SQLException {
        InputStream jasperStream = new ClassPathResource("notaInformativa.jasper").getInputStream();
        Map<String,Object> params = new HashMap<>();
        params.put("periodoid", idPeriodo);
        params.put("idtutoria", idTutoria);
        params.put("matricula", matricula);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource.getConnection());

        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=Nota-Tutoria.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }

}
