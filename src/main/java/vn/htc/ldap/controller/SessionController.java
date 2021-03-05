/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htc.ldap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.htc.ldap.common.HttpUtil;
import vn.htc.ldap.config.MyConfig;
import vn.htc.ldap.config.MyContext;
import vn.htc.ldap.ext.AngularModel;
import vn.htc.ldap.ext.ResponResult;
import vn.htc.ldap.model.Account;

/**
 *
 * @author Private
 */
@Controller
public class SessionController extends AbstractBackEnConst {

    private final String TABLE = "ACCOUNT";

    @InitBinder
    @Override
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringtrimmer);
    }

    @GetMapping({"/index", "/"})
    public String index(ModelMap model, HttpServletRequest request) {
        model.put(TITLE, "Trang chủ");
        return "home";
    }

    @GetMapping("/sessionExpire")
    public ResponseEntity<AngularModel<Account>> sessionExpire(HttpServletRequest request) {
        AngularModel<Account> ngModel = new AngularModel<>();
        ngModel.setResult(new ResponResult(RESULT.NO_LOGIN, "Session Expire..."));
        return new ResponseEntity<>(ngModel, HttpStatus.OK);
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, ModelMap model) {
        Account account = accountService.getAccountLogin(request);
        model.put(TITLE, LANG.get("generic.login"));
        if (account != null) {
            return GUI_INDEX_PAGE;
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(ModelMap model, HttpServletRequest request) {
        String username = HttpUtil.getString(request, "username");
        String password = HttpUtil.getString(request, "password");
        HttpSession session = request.getSession(false);
        
        Account account = accountService.findByUsernameAndPassword(username, password);
        
        if (account != null) {
            if (account.getStatus() == STATUS.LOCK.val) {
                //---- chưa ghi log đăng nhập thất bại vì bị khóa
                model.addAttribute("error", "Tài khoản của bạn đang bị khóa, vui lòng liên hệ quản trị!");
                return "login";
            }
            session.setAttribute(MyConfig.USER_SESSION_NAME, account);
            MyContext.putSessionOnline(username, session);
            //---- chưa ghi log đăng nhập thành công
            return GUI_INDEX_PAGE;
        } else {
            // --- chưa ghi log đăng nhập thất bại
            model.addAttribute("error", "Đăng nhập thất bại vui lòng kiểm tra lại! ");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Account acc = accountService.getAccountLogin(request);
        if (acc != null) {
            //---- ghi log đăng xuất tài khoản
            MyContext.logOutSession(acc.getUsername());
        }
        if (session != null) {
            session.removeAttribute(MyConfig.USER_SESSION_NAME);
            session.invalidate();
        }
        return "redirect:/login";
    }

    @Override
    public String list(ModelMap modelMap, HttpServletRequest request, RedirectAttributes redrAtt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseEntity getData(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String createView(ModelMap model, HttpServletRequest request, RedirectAttributes redrAtt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String createProcess(ModelMap model, HttpServletRequest request, RedirectAttributes redrAtt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String editView(ModelMap model, HttpServletRequest request, RedirectAttributes redrAtt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String editProcess(ModelMap model, HttpServletRequest request, RedirectAttributes redrAtt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseEntity<AngularModel<ResponResult>> delete(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
