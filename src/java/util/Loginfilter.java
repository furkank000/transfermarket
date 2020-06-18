/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.*;
import entity.*;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mehmet
 */
@WebFilter("/*")
public class Loginfilter implements Filter{
    private KullaniciDAO kullaniciDAO;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String url = req.getRequestURI();
        Kullanici kullanici = (Kullanici) req.getSession().getAttribute("gelen_kullanici");
        if (kullanici == null) {
            if (url.equals("secret")||url.equals("admin")) {
            res.sendRedirect(req.getContextPath()+"/module/kullanicigirisi.xhtml");
            } else {
                chain.doFilter(request, response);
            }
            }
        else {
if(url.equals("kullanicikayit")||url.equals("kullanicigirisi")){
                res.sendRedirect(req.getContextPath()+"/secret/secret.xhtml");
}
else if(url.contains("Cikisyap")){
    getKullaniciDAO().setLogin(false);
    getKullaniciDAO().setAdmin(false);
    req.getSession().invalidate();
    res.sendRedirect(req.getContextPath()+"/faces/module/index.xhtml");
}
else{
chain.doFilter(request, response);
}
        }
    }

    public KullaniciDAO getKullaniciDAO() {
        if(this.kullaniciDAO==null)
            this.kullaniciDAO=new KullaniciDAO();
        return kullaniciDAO;
    }
    
}
