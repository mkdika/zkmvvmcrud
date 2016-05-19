package com.mkdika.zkmvvmcrud.web;

import com.mkdika.zkmvvmcrud.entity.TbPerson;
import com.mkdika.zkmvvmcrud.helper.AppUtil;
import java.util.HashMap;
import java.util.Map;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public class BrowseData {

    private ListModelList<TbPerson> persons;
    private TbPerson personSelected;

    @Init
    public void init() {
        setPersons(new ListModelList<>(AppUtil.svcRepo().findAllByOrderByFirstnameAsc()));
    }

    @Command
    public void listboxSelected(@BindingParam("window") Window window) {
        if (personSelected != null) {
            Map returnArgs = new HashMap();
            returnArgs.put("personSelected", personSelected);
            BindUtils.postGlobalCommand(null, null, "Index$browseSelected", returnArgs);
            window.onClose();
        }
    }

    public ListModelList<TbPerson> getPersons() {
        return persons;
    }

    public void setPersons(ListModelList<TbPerson> persons) {
        this.persons = persons;
    }

    public TbPerson getPersonSelected() {
        return personSelected;
    }

    public void setPersonSelected(TbPerson personSelected) {
        this.personSelected = personSelected;
    }

}
