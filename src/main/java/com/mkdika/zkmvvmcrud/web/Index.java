package com.mkdika.zkmvvmcrud.web;

import com.mkdika.zkmvvmcrud.entity.TbExperience;
import com.mkdika.zkmvvmcrud.entity.TbPerson;
import com.mkdika.zkmvvmcrud.helper.AppUtil;
import com.mkdika.zkmvvmcrud.helper.wrapper.ToolbarWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public class Index {

    private final String appInfo = "Zk MVVM CRUD - Head Detail (OneToMany) Example v0.1_17-05-2016";
    private final String[] genderData = {"FEMALE", "MALE"};
    private final String[] idTypeData = {"KTP", "SIM", "PASPOR", "KITAS"};
    private final String[] sectorData = {"Trading", "Manufacture", "Education", "Service", "Banking"};

    private TbPerson selected;
    private List<String> genderList;
    private List<String> idTypeList;
    private List<String> sectorList;
    private ListModelList<TbExperience> experiences;
    
    private ToolbarWrapper addState;
    private ToolbarWrapper delState;
    private ToolbarWrapper saveState;
    private ToolbarWrapper cancelState;
    private ToolbarWrapper browseState;
    private ToolbarWrapper infoState; 
    
    private String gridId;

    @Init
    public void init(@BindingParam("gridId") String gridId) {
        this.gridId = gridId;        
        
        // Init toolbar
        setAddState(new ToolbarWrapper(false, false));
        setDelState(new ToolbarWrapper(false, false));
        setSaveState(new ToolbarWrapper(false, false));
        setCancelState(new ToolbarWrapper(false, false));
        setBrowseState(new ToolbarWrapper(false, false));        
        setInfoState(new ToolbarWrapper(true, false));

        setGenderList(new ArrayList<>(Arrays.asList(genderData)));
        setIdTypeList(new ArrayList<>(Arrays.asList(idTypeData)));
        setSectorList(new ArrayList<>(Arrays.asList(sectorData)));
        setExperiences(new ListModelList<>(new ArrayList<TbExperience>()));

        btnStateNormal();
    }

    private void btnStateNormal() {
        getAddState().setState(true, false);
        getDelState().setState(false, true);
        getSaveState().setState(false, true);
        getCancelState().setState(false, true);
        getBrowseState().setState(true, false);        
        getInfoState().setState(true, false);
        notifyToolbar();
    }

    private void btnStateNew() {
        getAddState().setState(false, true);
        getDelState().setState(false, true);
        getSaveState().setState(true, false);
        getCancelState().setState(true, false);
        getBrowseState().setState(false, true);        
        getInfoState().setState(true, false);
        notifyToolbar();
    }

    private void btnStateEdit() {
        getAddState().setState(false, true);
        getDelState().setState(true, false);
        getSaveState().setState(true, false);
        getCancelState().setState(true, false);
        getBrowseState().setState(false, true);        
        getInfoState().setState(true, false);
        notifyToolbar();
    }

    private void notifyToolbar() {
        BindUtils.postNotifyChange(null, null, this, "addState");
        BindUtils.postNotifyChange(null, null, this, "delState");
        BindUtils.postNotifyChange(null, null, this, "saveState");
        BindUtils.postNotifyChange(null, null, this, "cancelState");
        BindUtils.postNotifyChange(null, null, this, "browseState");
        BindUtils.postNotifyChange(null, null, this, "refreshState");
        BindUtils.postNotifyChange(null, null, this, "infoState");
    }

    @Command
    @NotifyChange({"selected", "experiences"})
    public void addClick() {
        setSelected(new TbPerson());
        getSelected().setExperiences(new ArrayList<TbExperience>());
        setExperiences(new ListModelList<>(getSelected().getExperiences()));
        btnStateNew();
        initScrollBar(gridId);
    }

    @Command
    @NotifyChange({"selected", "experiences"})
    public void delClick() {
        if (getSelected() != null) {
            try {
                AppUtil.svcRepo().delete(getSelected());
                setSelected(null);
                setExperiences(null);
                btnStateNormal();
                Clients.showNotification("Delete successful.");
            } catch (Exception e) {
                Clients.showNotification("Delete failed.\n"+ e.getLocalizedMessage());                
            }
        } else {
            Clients.showNotification("Record not found.");
            btnStateEdit();
        }
    }

    @Command
    @NotifyChange({"selected", "experiences"})
    public void saveClick() {
        try {
            getSelected().setExperiences(getExperiences());
            AppUtil.svcRepo().save(getSelected());
            setSelected(null);
            setExperiences(null);
            btnStateNormal();
            Clients.showNotification("Save successful.");
        } catch (Exception e) {
            Clients.showNotification("Save failed.\n" + e.getLocalizedMessage());
        }       
    }

    @Command
    @NotifyChange({"selected", "experiences"})
    public void cancelClick() {
        setSelected(null);
        setExperiences(null);
        btnStateNormal();
    }

    @Command
    public void browseClick() {           
        Executions.createComponents("/browsedata.zul", null, null);        
    }
    
    @GlobalCommand
    @NotifyChange({"selected", "experiences"})
    public void Index$browseSelected(@BindingParam("personSelected") TbPerson personSelected) {
        if (personSelected != null) {
            setSelected(personSelected);
            setExperiences(new ListModelList<>(personSelected.getExperiences()));
            btnStateEdit();
            initScrollBar(gridId);
        }                
    }
    
    @Command
    public void infoClick() {
        Clients.showNotification(appInfo+"<br/>"+"First version writen by:<br/>Maikel Chandika (mkdika@gmail.com)");
    }

    @Command
    public void delExpItem(@BindingParam("data") TbExperience data) {
        int index = experiences.indexOf(data);
        if (index != -1) {
            experiences.remove(data);
        }
    }

    @Command
    public void addExpItem() {
        TbExperience t = new TbExperience(getSelected());
        experiences.add(t);
        scrollToBottom(gridId);
    }

    public String getAppInfo() {
        return appInfo;
    }

    public TbPerson getSelected() {
        return selected;
    }

    public void setSelected(TbPerson selected) {
        this.selected = selected;
    }   

    public ToolbarWrapper getAddState() {
        return addState;
    }

    public void setAddState(ToolbarWrapper addState) {
        this.addState = addState;
    }

    public ToolbarWrapper getDelState() {
        return delState;
    }

    public void setDelState(ToolbarWrapper delState) {
        this.delState = delState;
    }

    public ToolbarWrapper getSaveState() {
        return saveState;
    }

    public void setSaveState(ToolbarWrapper saveState) {
        this.saveState = saveState;
    }

    public ToolbarWrapper getCancelState() {
        return cancelState;
    }

    public void setCancelState(ToolbarWrapper cancelState) {
        this.cancelState = cancelState;
    }

    public ToolbarWrapper getBrowseState() {
        return browseState;
    }

    public void setBrowseState(ToolbarWrapper browseState) {
        this.browseState = browseState;
    }   

    public ToolbarWrapper getInfoState() {
        return infoState;
    }

    public void setInfoState(ToolbarWrapper infoState) {
        this.infoState = infoState;
    }

    public List<String> getGenderList() {
        return genderList;
    }

    public void setGenderList(List<String> genderList) {
        this.genderList = genderList;
    }

    public List<String> getIdTypeList() {
        return idTypeList;
    }

    public void setIdTypeList(List<String> idTypeList) {
        this.idTypeList = idTypeList;
    }

    public List<String> getSectorList() {
        return sectorList;
    }

    public void setSectorList(List<String> sectorList) {
        this.sectorList = sectorList;
    }

    public ListModelList<TbExperience> getExperiences() {
        return experiences;
    }

    public void setExperiences(ListModelList<TbExperience> experiences) {
        this.experiences = experiences;
    }

    public void scrollToBottom(String gridId) {
        Clients.evalJavaScript("$(zk.Widget.$('$" + gridId + "').ebody).scrollTop(zk.Widget.$('$" + gridId + "').ebodyrows.scrollHeight);setTimeout(function(){$(zk.Widget.$('$" + gridId + "').ebody).scrollTop(zk.Widget.$('$" + gridId + "').ebodyrows.scrollHeight);},1000)");

    }
    
    public void initScrollBar(String gridId) {
        Clients.evalJavaScript("var index = 1; var interval = setInterval(function(){if(zk.Widget.$('$" +gridId+ "')!=null){for(var i = 0;i<zk.Widget.$('$" +gridId+ "').ebodyrows.scrollHeight;i+=10){$(zk.Widget.$('$" +gridId+ "').ebody).scrollTop(i);}clearInterval(interval);$(zk.Widget.$('$" +gridId+ "').ebody).scrollTop(0);}},1)");
    }
}