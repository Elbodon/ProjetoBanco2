package br.com.ifpb.cantinaonline.listener;

import br.com.ifpb.cantinaonline.view.mbeans.LoginBean;

import javax.faces.application.NavigationHandler;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import java.util.Arrays;

public class AuthListener implements PhaseListener {

    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println("Antes da RESTORE VIEW");
    }

    @Override
    public void afterPhase(PhaseEvent event) {

        String[] paginasRestritas = {"usuario.xhtml", "sucesso.xhtml", "listagemProdutos.xhtml" };

        LoginBean loginBean = (LoginBean)event.getFacesContext()
                .getExternalContext().getSessionMap().get("loginBean");

        String currentView = event.getFacesContext().getViewRoot().getViewId();

        boolean usuarioLogado = (loginBean != null && loginBean.getUsuarioLogado() != null);
        if (!currentView.equals("login.xhtml")
                && Arrays.asList(paginasRestritas).contains(currentView)
                && !usuarioLogado) {
            NavigationHandler nh = event.getFacesContext().getApplication().getNavigationHandler();
            nh.handleNavigation(event.getFacesContext(), currentView, "goToLogin");
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
